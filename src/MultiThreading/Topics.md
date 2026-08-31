# Java Multithreading & Concurrency Master Guide

A comprehensive, structured reference guide covering core threading concepts, memory models, locks, thread pools, asynchronous patterns, and modern concurrency features in Java 21+.

---

## Module 1: Core Fundamentals

### 1.1 Process vs. Thread
* **Process**: An executing instance of a program with its own dedicated memory space, resources, and execution environment provided by the Operating System. Communication between processes requires Inter-Process Communication (IPC).
* **Thread**: The smallest unit of CPU execution inside a process (a lightweight sub-process).
* **Memory Model**:
  * **Heap Memory**: Shared among all threads within the same JVM process.
  * **Thread Stack**: Private to each individual thread. Holds local variables, primitive call arguments, and method invocation frames.
* **Context Switching Overhead**:
  * Saving the CPU state (registers, program counter) of the running thread and loading the state of the scheduled thread.
  * Incurs CPU cache invalidation and kernel/user space transition overhead.

### 1.2 Thread Lifecycle (States in `java.lang.Thread.State`)
1. **NEW**: Thread instance created (`Thread t = new Thread()`), but `start()` has not yet been invoked.
2. **RUNNABLE**: Thread is executing in the JVM or waiting for resource allocation (CPU time-slice) from the OS scheduler.
3. **BLOCKED**: Thread is waiting to acquire an intrinsic monitor lock to enter/re-enter a `synchronized` block/method.
4. **WAITING**: Thread is waiting indefinitely for another thread to perform a specific action (e.g., via `Object.wait()`, `Thread.join()`, `LockSupport.park()`).
5. **TIMED_WAITING**: Thread is waiting for another thread for a specified waiting time (e.g., `Thread.sleep(ms)`, `Object.wait(timeout)`, `Thread.join(timeout)`).
6. **TERMINATED**: Thread has completed execution of its `run()` method or terminated due to an uncaught exception.

### 1.3 Thread Creation Mechanisms
* **Extending `Thread` Class**:
  * Subclasses `java.lang.Thread` and overrides `run()`.
  * Limitation: Java does not support multiple class inheritance.
* **Implementing `Runnable` Interface**:
  * Functional interface with `void run()`.
  * Decouples the task definition from the execution mechanism.
  * Allows extending another base class.
* **Implementing `Callable<V>` Interface**:
  * Functional interface with `V call() throws Exception`.
  * Capable of returning a computed value and throwing checked exceptions.
  * Used with `Future<V>` or `ExecutorService`.

### 1.4 Thread Control & Utility Methods
* **`Thread.sleep(millis)`**: Pauses the current thread's execution for a specified duration without releasing acquired locks/monitors. Throws `InterruptedException`.
* **`Thread.join()` / `Thread.join(millis)`**: Causes the current thread to pause execution until the target thread on which `join()` was called completes its execution.
* **`Thread.yield()`**: A hint to the thread scheduler that the current thread is willing to yield its current use of a processor. The scheduler is free to ignore this hint.
* **Daemon Threads (`setDaemon(true)`)**:
  * Background service threads (e.g., Garbage Collector).
  * Must be marked as daemon *before* starting the thread.
  * The JVM exits immediately when all remaining active threads are daemon threads.
* **Thread Priorities**: Ranging from `Thread.MIN_PRIORITY` (1) to `Thread.MAX_PRIORITY` (10), default `Thread.NORM_PRIORITY` (5). Highly dependent on underlying OS mapping.

---

## Module 2: Memory Model & Synchronization

### 2.1 Java Memory Model (JMM)
* **Architecture**: Defines how the JVM and CPU work with computer hardware memory (Main Memory vs. L1/L2/L3 CPU Caches and registers).
* **Core Tenets**:
  * **Atomicity**: Operations that complete as a single indivisible unit.
  * **Visibility**: Changes made by one thread to shared variables must be visible to other threads immediately.
  * **Ordering / Instruction Reordering**: Compilers and processors reorder instructions for optimization, provided single-threaded program correctness is maintained.
* **Happens-Before Relationship**: A formal specification ensuring that memory writes by one operation are guaranteed to be visible to another read operation.

### 2.2 Keywords & Intrinsic Locks
* **`volatile` Keyword**:
  * Guarantees **visibility** across threads by flushing/loading directly to/from main memory.
  * Establishes memory barriers (prevents compiler and CPU instruction reordering).
  * Does **not** guarantee atomicity for compound operations (e.g., `count++` consists of read, modify, write).
* **`synchronized` Keyword**:
  * Provides mutual exclusion and memory visibility via intrinsic monitor locks.
  * Synchronized Methods: Locks on `this` instance (for instance methods) or `Class` object (for static methods).
  * Synchronized Blocks: Preferred approach; locks only the necessary code block on a specified monitor object.

### 2.3 Inter-Thread Communication
* **`wait()`**: Causes the current thread to release the monitor lock and wait until another thread invokes `notify()` or `notifyAll()`. Must be called within a `synchronized` block on the locked monitor.
* **`notify()`**: Wakes up a single arbitrary thread waiting on the monitor.
* **`notifyAll()`**: Wakes up all threads waiting on the monitor (safer to avoid missed signals).
* **Spurious Wakeup Handling**: Always call `wait()` inside a `while` loop condition check, never inside an `if` statement:
  ```java
  synchronized (lock) {
      while (!conditionMet) {
          lock.wait();
      }
      // Execute post-condition logic
  }
  ```

---

## Module 3: Explicit Locks (`java.util.concurrent.locks`)

### 3.1 `ReentrantLock`
* Provides explicit lock acquisition and release with greater control than `synchronized`.
* Methods: `lock()`, `tryLock()`, `tryLock(timeout, unit)`, `lockInterruptibly()`, `unlock()`.
* **Standard Idiom**:
  ```java
  Lock lock = new ReentrantLock();
  lock.lock();
  try {
      // Critical Section
  } finally {
      lock.unlock(); // Ensure lock release even on exception
  }
  ```
* **Fairness Policy**: Supports fair locking (`new ReentrantLock(true)`) where the longest-waiting thread gets access next, reducing thread starvation at the expense of throughput.

### 3.2 `ReentrantReadWriteLock`
* Separates read access from write access:
  * **Read Lock (`ReadLock`)**: Multiple threads can acquire the lock concurrently if no thread holds the write lock.
  * **Write Lock (`WriteLock`)**: Exclusive lock; only one thread can acquire it, blocking all other readers and writers.
* Optimized for read-heavy workloads with infrequent updates.

### 3.3 `Condition` Interface
* Replaces `Object` wait/notify mechanisms with explicit condition variables bound to a `Lock` instance (`lock.newCondition()`).
* Provides `await()`, `signal()`, `signalAll()`.
* Allows multiple distinct wait-sets per lock (e.g., `notFull` and `notEmpty` conditions in a bounded buffer).

### 3.4 `StampedLock` (Java 8+)
* Lock with support for three modes: Writing, Reading, and Optimistic Reading.
* **Optimistic Read**: Acquires a numeric stamp (`tryOptimisticRead()`), reads data without blocking writers, and subsequently validates the stamp (`validate(stamp)`). If a write occurred, falls back to a standard read lock.
* Non-reentrant lock design to maximize throughput.

---

## Module 4: Concurrent Collections & Atomic Variables

### 4.1 Atomic Operations & CAS (`java.util.concurrent.atomic`)
* **Compare-And-Swap (CAS)**: Low-level hardware-supported atomic instruction (`CMPXCHG`) that compares variable contents to an expected value and updates it only if matched. Non-blocking and lock-free.
* **Classes**:
  * `AtomicInteger`, `AtomicLong`, `AtomicBoolean`, `AtomicReference<V>`.
  * `LongAdder` / `DoubleAdder`: Designed for high-concurrency counters. Reduces contention by maintaining a cell array of variables that are summed across threads.

### 4.2 Thread-Safe Collections
* **`ConcurrentHashMap`**:
  * Lock-free reads and granular bucket/node-level synchronized locks for writes.
  * Significantly outperforms legacy synchronized collections (`Hashtable`, `Collections.synchronizedMap()`).
* **`CopyOnWriteArrayList` / `CopyOnWriteArraySet`**:
  * Creates a fresh copy of the underlying array whenever a mutating operation (`add`, `set`, `remove`) is performed.
  * Ideal for read-heavy, low-write scenarios (e.g., event listeners/observers).

### 4.3 Blocking Queues (`java.util.concurrent.BlockingQueue`)
* Thread-safe queues designed for Producer-Consumer patterns.
* Core blocking operations: `put(e)` (blocks if full) and `take()` (blocks if empty).
* Implementations:
  * `ArrayBlockingQueue`: Bounded, backed by an array.
  * `LinkedBlockingQueue`: Optionally bounded, backed by linked nodes.
  * `PriorityBlockingQueue`: Unbounded priority queue with natural or comparator ordering.
  * `SynchronousQueue`: Zero-capacity queue where each `put` must wait for a corresponding `take`.

---

## Module 5: Thread Pools & Executor Framework

### 5.1 `ThreadPoolExecutor` Core Parameters
1. **`corePoolSize`**: Base number of worker threads kept alive in the pool, even when idle.
2. **`maximumPoolSize`**: Maximum allowed number of threads in the pool when the work queue is saturated.
3. **`keepAliveTime` & `unit`**: Timeout duration for idle worker threads exceeding `corePoolSize` before termination.
4. **`workQueue`**: The queue holding tasks waiting to be executed (`BlockingQueue<Runnable>`).
5. **`threadFactory`**: Factory for creating custom threads (custom naming, daemon status, priorities).
6. **`handler` (`RejectedExecutionHandler`)**: Strategy applied when a task cannot be accepted because the queue is full and `maximumPoolSize` has been reached:
   * `AbortPolicy`: Throws `RejectedExecutionException` (default).
   * `CallerRunsPolicy`: Executes the task directly on the submitting caller thread.
   * `DiscardPolicy`: Silently drops the rejected task.
   * `DiscardOldestPolicy`: Drops the oldest unhandled task in the queue and retries submission.

### 5.2 Standard Executor Factories (`Executors`)
* `Executors.newFixedThreadPool(n)`: Pool with fixed thread count and unbounded `LinkedBlockingQueue`.
* `Executors.newCachedThreadPool()`: Elastic pool with `SynchronousQueue`, creates threads on demand and reclaims idle threads after 60s.
* `Executors.newSingleThreadExecutor()`: Single worker thread processing tasks sequentially.
* `Executors.newScheduledThreadPool(n)`: Supports delayed and periodic task execution.

### 5.3 Fork/Join Framework & Parallel Streams
* **`ForkJoinPool`**: Designed for recursive divide-and-conquer workloads.
* **Work-Stealing Algorithm**: Idle worker threads steal tasks from the deques of busy worker threads.
* **Classes**: `RecursiveTask<V>` (returns result) and `RecursiveAction` (void task).
* **Parallel Streams**: `.parallelStream()` internally leverages the shared common `ForkJoinPool` (`ForkJoinPool.commonPool()`).

---

## Module 6: Asynchronous Programming with `CompletableFuture`

### 6.1 Creation
* `CompletableFuture.supplyAsync(Supplier<U>, executor)`: Asynchronous computation returning a value.
* `CompletableFuture.runAsync(Runnable, executor)`: Asynchronous task without return value.

### 6.2 Chaining & Transformations
* `thenApply(Function<T, R>)`: Transforms the result synchronously when complete.
* `thenAccept(Consumer<T>)`: Consumes the result without returning a value.
* `thenRun(Runnable)`: Executes an action upon completion without accessing the result.
* Async variants: `thenApplyAsync()`, `thenAcceptAsync()`, `thenRunAsync()` (dispatches to an executor).

### 6.3 Combining Futures
* `thenCompose(Function<T, CompletionStage<U>>)`: Monadic flatMap; chains dependent asynchronous tasks sequentially.
* `thenCombine(CompletionStage<U>, BiFunction<T, U, V>)`: Executes two independent futures in parallel and combines their results.

### 6.4 Multi-Future Coordination
* `CompletableFuture.allOf(cfs...)`: Returns a future completing when all input futures finish.
* `CompletableFuture.anyOf(cfs...)`: Returns a future completing as soon as any input future finishes.

### 6.5 Exception Handling
* `exceptionally(Function<Throwable, T>)`: Fallback handler on failure.
* `handle(BiFunction<T, Throwable, R>)`: Unified result or error transformer.
* `whenComplete(BiConsumer<T, Throwable>)`: Inspects outcome/error without modifying return value.

---

## Module 7: Modern Concurrency (Java 21+)

### 7.1 Virtual Threads (Project Loom - JEP 444)
* **Concept**: Lightweight user-mode threads managed entirely by the JVM, decoupled from OS platform threads.
* **Architecture**: Millions of virtual threads can be multiplexed onto a small pool of carrier platform threads.
* **Mounting / Unmounting**:
  * When a virtual thread executes blocking I/O (e.g., socket read/write, `Thread.sleep`), the JVM unmounts the virtual thread from its carrier thread.
  * The carrier thread is freed to execute other virtual tasks. When I/O completes, the virtual thread is remounted.
* **Creation**:
  ```java
  try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
      executor.submit(() -> {
          // Blocking I/O code executed efficiently
      });
  }
  ```
* **Thread Pinning**: Occurs when a virtual thread cannot be unmounted during blocking operations (e.g., executing inside a `synchronized` block or native method).
  * **Remedy**: Replace `synchronized` with `ReentrantLock`.

### 7.2 Structured Concurrency (JEP 453)
* Treats groups of related concurrent tasks running in different threads as a single unit of work.
* Simplifies error handling, cancellation propagation, and observability.
* Uses `StructuredTaskScope` (e.g., `ShutdownOnFailure`, `ShutdownOnSuccess`).

---

## Module 8: Common Concurrency Hazards & Debugging

### 8.1 Concurrency Hazards
* **Deadlock**: Two or more threads are permanently blocked, each waiting for a lock held by the other.
  * 4 Coffman Conditions: Mutual Exclusion, Hold and Wait, No Preemption, Circular Wait.
  * Prevention: Lock ordering, timeout locks (`tryLock`), avoiding nested synchronized blocks.
* **Livelock**: Threads actively change states in response to each other but make no forward progress.
* **Starvation**: A thread is perpetually denied access to resources or CPU time due to greedy/high-priority threads.
* **Race Conditions (Check-Then-Act / Read-Modify-Write)**: Defects where system behavior depends on unpredictable execution order.

### 8.2 Diagnostic & Debugging Tools
* **`jstack <PID>`**: Captures thread dumps to diagnose deadlocks, blocked threads, and stack traces.
* **JVM Profilers**: VisualVM, JProfiler, JDK Flight Recorder (JFR) & JDK Mission Control (JMC).
* **ThreadSanitizer (TSan)**: Data race detector integrated into HotSpot JVM.

---

## Recommended Learning Resources

1. **Official Guides & Documentation**:
   * Oracle Concurrency Trail: `https://docs.oracle.com/javase/tutorial/essential/concurrency/`
   * Dev.java Concurrency Portal: `https://dev.java/learn/api/concurrency/`
   * OpenJDK JEP 444 (Virtual Threads): `https://openjdk.org/jeps/444`

2. **In-Depth Technical References**:
   * *Java Concurrency in Practice* by Brian Goetz et al.
   * *Modern Java in Action* by Raoul-Gabriel Urma et al.
   * Jakob Jenkov Java Concurrency Series (`https://jenkov.com/tutorials/java-concurrency/index.html`)
   * Baeldung Java Concurrency Articles (`https://www.baeldung.com/java-concurrency`)
