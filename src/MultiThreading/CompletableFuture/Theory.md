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
subtopics :
# 6.1 Creation

1. Creating Async Tasks: runAsync vs supplyAsync

a. runAsync(Runnable): Runs a background task that does not return a value.
b. supplyAsync(Supplier<T>): Runs a background task and returns a value.


Method,                 Accepts,                Returns,                        Typical Use Case
thenApply(Function),    Takes previous result,  New transformed value,          Converting raw data / calculating values
thenAccept(Consumer),   Takes previous result,  Void (no return),               "Printing, saving to DB, sending notifications"
thenRun(Runnable),      Takes nothing,          Void (no return),               Triggering a side cleanup step

2. Quick Breakdown of the Chaining Pipeline

supplyAsync(() -> R): Starts the async stage and produces a starting value (150).
thenApply(T -> R): Transforms the value. Changes type or modifies data (150 $\rightarrow$ 1875.0).
thenAccept(T -> void): Consumes the value. Performs terminal operations like logging or printing (1875.0 $\rightarrow$ print).
thenRun(() -> void): Runs a side action when the previous stage completes, without needing any input data.


3. Combining Two Independent Tasks: thenCombine
When you need to run two independent background operations simultaneously and merge their results once both finish:

Core Takeaways for thenCombine
Parallel Execution: patientTask and labTask run simultaneously on separate background threads.

Non-blocking Wait: thenCombine waits for both futures to complete before executing the combining lambda (patient, lab) -> ....

Signature: Accepts a second CompletionStage and a BiFunction<T, U, V> that returns a new combined CompletableFuture<V>.

4. Exception Handling: exceptionally and handle :
exceptionally: Acts like a catch block; returns a fallback value if an error occurs.
handle: Executes regardless of success or failure, receiving both the result and the throwable.

5. Running Multiple Tasks in Parallel: CompletableFuture.allOf
When you have a batch of independent tasks and need to wait for all of them to complete:

CompletableFuture.allOf Example :

allOf executes multiple independent background tasks in parallel and waits until all of them finish.
    Return Type: CompletableFuture.allOf(...) returns CompletableFuture<Void>.
    Execution: All passed tasks run concurrently on background threads.
    Retrieving Data: Call .join() on individual tasks after allOf.join() finishes to safely extract their results without waiting sequentially.
