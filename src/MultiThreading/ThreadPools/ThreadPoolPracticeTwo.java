package MultiThreading.ThreadPools;

//2. Callable Example: Fetching Return Values with Future
//Use executor.submit(...) with a Callable<T> when your task
// produces a result or throws a checked exception.

import java.util.concurrent.*;

public class ThreadPoolPracticeTwo {
    public static void main(String[] args) {

        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                2, 4, 60L, TimeUnit.SECONDS, new ArrayBlockingQueue<>(5)
        );

        // submit a callable task returning a string
        Future<String> futureResult = executor.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(2000);
                return "Task success done.";
            }
        });

        try {
            // blocks until the task completes and returns the result
            String result = futureResult.get();
            System.out.println("result: " + result);
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            executor.shutdown();
        }
    }
}
