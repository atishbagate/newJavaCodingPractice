Here is the breakdown of all 7 constructor parameters of `ThreadPoolExecutor`:

```java
ThreadPoolExecutor executor = new ThreadPoolExecutor(
    int corePoolSize,
    int maximumPoolSize,
    long keepAliveTime,
    TimeUnit unit,
    BlockingQueue<Runnable> workQueue,
    ThreadFactory threadFactory,          // Optional (default provided)
    RejectedExecutionHandler handler       // Optional (default provided)
);

```

---

**1. `corePoolSize` (e.g., `2`)**

* **What it is:** The baseline number of core worker threads kept alive in the pool.
* **Behavior:** When a new task arrives, the pool creates a new thread up to this count, even if existing core threads are currently idle. Core threads are never destroyed by default, even during zero-traffic periods (unless `allowCoreThreadTimeOut(true)` is explicitly enabled).

---

**2. `maximumPoolSize` (e.g., `4`)**

* **What it is:** The hard ceiling on the total number of simultaneous worker threads allowed in the pool.
* **Behavior:** If all core threads are busy and the `workQueue` becomes completely full, the pool creates extra (non-core) worker threads up to this limit to handle incoming bursts.

---

**3. `keepAliveTime` (e.g., `20L` / `60L`)**

* **What it is:** The duration that idle excess (non-core) threads will wait for new tasks before terminating.
* **Behavior:** When the active thread count is greater than `corePoolSize`, any non-core worker thread that remains idle longer than this duration will be destroyed and reclaimed by the JVM.

---

**4. `unit` / `TimeUnit` (e.g., `TimeUnit.SECONDS`)**

* **What it is:** The time unit for the `keepAliveTime` argument.
* **Options:** `TimeUnit.MILLISECONDS`, `TimeUnit.SECONDS`, `TimeUnit.MINUTES`, `TimeUnit.HOURS`, etc.
* **Example:** `20L, TimeUnit.SECONDS` instructs the pool to terminate non-core idle threads after 20 seconds of inactivity.

---

**5. `workQueue` (e.g., `new ArrayBlockingQueue<>(5)`)**

* **What it is:** The blocking queue used to hold submitted tasks while all core worker threads are busy.
* **Key Types:**
* `ArrayBlockingQueue(N)`: Bounded queue with a fixed capacity limit $N$.
* `LinkedBlockingQueue(N)`: Optionally bounded queue; unbounded if initialized without a capacity.
* `SynchronousQueue`: Zero-capacity direct handoff queue (forces immediate thread creation).



---

**6. `threadFactory` (e.g., `Executors.defaultThreadFactory()`)**

* **What it is:** The factory responsible for creating new threads.
* **Why customize it:** By default, it creates non-daemon threads named `pool-N-thread-M`. In production, you pass a custom factory to assign meaningful thread names (e.g., `order-processor-1`), set custom thread priorities, or configure custom `UncaughtExceptionHandler`s.

---

**7. `handler` (e.g., `new ThreadPoolExecutor.AbortPolicy()`)**

* **What it is:** The rejection strategy executed when a task cannot be accepted because the queue is full and active threads have reached `maximumPoolSize` (or after `shutdown()` has been called).
* **The 4 Standard Policies:**
* `AbortPolicy`: Throws `RejectedExecutionException` (fail-fast default).
* `CallerRunsPolicy`: Forces the calling thread (e.g., `main`) to execute the task itself, applying natural backpressure.
* `DiscardPolicy`: Silently ignores and drops the task.
* `DiscardOldestPolicy`: Drops the oldest unprocessed task from the head of the queue and retries task submission.