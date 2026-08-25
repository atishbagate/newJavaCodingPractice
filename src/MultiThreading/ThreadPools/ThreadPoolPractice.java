package MultiThreading.ThreadPools;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

//1. Basic Example: Runnable (Fire-and-Forget)
//Use executor.execute(...) when your task performs an action and does not return a value.

public class ThreadPoolPractice {
    public static void main(String[] args) throws InterruptedException {

        ArrayBlockingQueue<Runnable> queue = new ArrayBlockingQueue<Runnable>(2);

        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                1,
                2,
                30L,
                TimeUnit.SECONDS,
                queue,
                new ThreadPoolExecutor.CallerRunsPolicy()
        );

        for (int i = 0; i <= 5; i++) {
            final int taskID = i;
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Task " + taskID + " running on thread : "
                            + Thread.currentThread().getName());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            });
        }
        executor.shutdown();

    }
}
