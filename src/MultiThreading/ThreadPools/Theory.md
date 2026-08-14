When managing multi-threaded applications in production, creating a new Thread object for every task is expensive. Thread creation involves memory allocation, system calls, and operating system overhead.

To solve this, Java provides Thread Pools via the ExecutorService interface (part of java.util.concurrent). Instead of creating and destroying threads continuously, thread pools maintain a set of worker threads that are reused to execute multiple tasks.

1. Thread Pool Core Architecture
A Java Thread Pool consists of three core components:

Core & Maximum Threads: The pool of worker threads available to do work.

Task Work Queue: A blocking queue (BlockingQueue<Runnable>) where tasks sit while waiting for an available thread.

Thread Factory: Creates new threads when needed.

# Java Thread Pools & ExecutorService Lifecycle

When managing multi-threaded applications in production, creating a new `Thread` object for every task is expensive. Thread creation involves memory allocation, system calls, and operating system overhead.

To solve this, Java provides **Thread Pools** via the `ExecutorService` interface (part of `java.util.concurrent`). Instead of creating and destroying threads continuously, thread pools maintain a set of worker threads that are reused to execute multiple tasks.

---

## 1. Thread Pool Core Architecture

A Java Thread Pool consists of three core components:
1. **Core & Maximum Threads:** The pool of worker threads available to do work.
2. **Task Work Queue:** A blocking queue (`BlockingQueue<Runnable>`) where tasks sit while waiting for an available thread.
3. **Thread Factory:** Creates new threads when needed.

### Task Execution Workflow

When you submit a new task (`executor.submit(...)` or `executor.execute(...)`), the `ThreadPoolExecutor` processes it following a strict priority order:

 [ New Task Submitted ]
                             │
                             ▼
            ┌─────────────────────────────────┐
            │ Active Threads < corePoolSize?  │
            └────────────────┬────────────────┘
                   YES       │       NO
          ┌──────────────────┴──────────────────┐
          ▼                                     ▼
 [ Create Core Worker Thread ]        [ Offer Task to Work Queue ]
                                                │
                                      SUCCESS   │   QUEUE FULL
                                 ┌──────────────┴──────────────┐
                                 ▼                             ▼
                         [ Task Queued ]       ┌───────────────────────────────┐
                                               │ Active Threads < maximumSize? │
                                               └───────────────┬───────────────┘
                                                      YES      │      NO
                                             ┌─────────────────┴─────────────────┐
                                             ▼                                   ▼
                                 [ Create Extra Worker ]              [ Trigger Rejection ]
                                                                (RejectedExecutionHandler)



┌──────────┐
    │ RUNNING  │
    └────┬─────┘
         │ shutdown()
         ▼
    ┌──────────┐
    │ SHUTDOWN │
    └────┬─────┘
         │ shutdownNow() OR (Queue empty & Workers finished)
         ▼
    ┌───────────┐
    │ STOP /    │
    │ TIDYING   │
    └────┬──────┘
         │ terminated() hook finishes
         ▼
  ┌────────────┐
  │ TERMINATED │
  └────────────┘
RUNNING: Accepts new tasks and processes queued tasks.

SHUTDOWN: Triggered by shutdown(). Refuses new tasks, but processes tasks already sitting in the workQueue.

STOP: Triggered by shutdownNow(). Refuses new tasks, halts actively running tasks via Thread.interrupt(), and drains unexecuted queued tasks into a returned list.

TIDYING: All tasks have ended, worker count drops to zero, and the pool executes the terminated() lifecycle hook method.

TERMINATED: The terminated() hook has completed.

---
