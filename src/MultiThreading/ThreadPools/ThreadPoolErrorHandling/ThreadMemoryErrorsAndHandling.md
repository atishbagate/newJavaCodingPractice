### Step-by-Step Mathematical Breakdown and Root-Cause Analysis

---

### Case A: `Executors.newFixedThreadPool(10)`

#### 1. Mathematical Breakdown

* **Thread Capacity & Throughput:**
* Number of threads = $10$
* Execution time per task = $2\text{ seconds}$
* Maximum processing rate per thread = $\frac{1}{2}\text{ tasks/second} = 0.5\text{ tasks/second}$
* Maximum pool throughput = $10 \times 0.5 = 5\text{ tasks/second}$


* **Queue Accumulation Rate:**
* Incoming rate = $1,000\text{ tasks/second}$
* Outgoing rate = $5\text{ tasks/second}$
* Net accumulation rate = $1,000 - 5 = 995\text{ tasks/second}$


* **Memory Accumulation:**
* In 60 seconds, the queue accumulates $60 \times 995 = 59,700\text{ task objects}$.
* In 10 minutes, the queue holds $\approx 597,000\text{ tasks}$ along with their attached stack frames, closures, and object references.



#### 2. Root-Cause Analysis

* `Executors.newFixedThreadPool(10)` creates a pool backed by an unbounded `LinkedBlockingQueue` (`Integer.MAX_VALUE` $\approx 2.14\times 10^9$ capacity).
* Because the incoming rate ($1,000\text{ tasks/s}$) vastly exceeds the pool's throughput ($5\text{ tasks/s}$), task nodes fill the heap memory.
* **Error Thrown:** `java.lang.OutOfMemoryError: Java heap space`
* **Failed Memory Region:** The **JVM Heap** (Eden/Tenured generations) exhausts its `-Xmx` limit.

---

### Case B: `Executors.newCachedThreadPool()`

#### 1. Mathematical Breakdown

* **Thread Creation Demand:**
* Incoming rate = $1,000\text{ tasks/second}$
* Duration per task = $2\text{ seconds}$
* Required concurrent threads to sustain zero queueing = $\text{Rate} \times \text{Duration} = 1,000 \times 2 = 2,000\text{ active threads}$
* By second 2, the pool attempts to maintain $2,000$ active OS threads.
* If the downstream database slows from $2\text{s}$ to $5\text{s}$, the pool immediately attempts to spawn $1,000 \times 5 = 5,000\text{ threads}$.


* **Memory Footprint per Thread:**
* Default JVM stack size (`-Xss`) = $1\text{ MB}$ per thread.
* $2,000\text{ threads} \approx 2\text{ GB}$ of off-heap memory strictly for thread stacks, excluding OS native thread control structures (TCBs) and kernel memory.



#### 2. Root-Cause Analysis

* `Executors.newCachedThreadPool()` uses a zero-capacity `SynchronousQueue` and an unbounded `maximumPoolSize` (`Integer.MAX_VALUE`).
* Because the queue cannot buffer tasks, every incoming request forces the executor to spawn a brand new OS thread if all existing threads are busy.
* High thread counts cause CPU thrashing due to severe context-switching overhead, worsening execution time beyond $2\text{s}$ and accelerating thread creation.
* **Error Thrown:** `java.lang.OutOfMemoryError: unable to create new native thread`
* **Failed Memory Region:** **Native OS / Off-Heap Memory** (OS process limit `max_user_processes` or virtual memory address space exhaustion).

---

### Case C: The Production-Grade Configuration (The Fix)

To prevent both heap exhaustion and native thread starvation, configure a bounded `ThreadPoolExecutor` with backpressure:

```java
int corePoolSize = 32;
int maxPoolSize = 64;
long keepAliveTime = 30L;
int queueCapacity = 500;

ThreadPoolExecutor resilientExecutor = new ThreadPoolExecutor(
    corePoolSize,
    maxPoolSize,
    keepAliveTime,
    TimeUnit.SECONDS,
    new ArrayBlockingQueue<>(queueCapacity),
    new CustomThreadFactory("db-worker-"),
    new ThreadPoolExecutor.CallerRunsPolicy() // Provides natural backpressure
);

```

#### Why This Prevents Failure:

* **Bounded Resource Ceiling:** Maximum memory is strictly bounded ($\le 64\text{ threads} \times 1\text{MB}$ stack + $500\text{ task references}$ on heap).
* **Backpressure via `CallerRunsPolicy`:** When the $500$-capacity queue and $64$ threads saturate, incoming tasks run directly on the submitting caller/HTTP threads. This slows down request acceptance at the edge, protecting both the JVM and the downstream database from collapse.