package MultiThreading.ThreadPools;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolsLifecycle {

    public static void main(String[] args) throws InterruptedException {

        ArrayBlockingQueue queue = new ArrayBlockingQueue<>(2);

        // Custom ThreadPoolExecutor Configuration :
       ThreadPoolExecutor executor =  new ThreadPoolExecutor(2,3,1,TimeUnit.SECONDS,queue,new ThreadPoolExecutor.AbortPolicy());

        System.out.println("--- 1. inital pool state ---");
        System.out.println("is shutdown? " + executor.isShutdown());
        System.out.println("is terminated? " + executor.isTerminated());

        for (int i = 0; i <= 5; i++) {
            final int taskId = i;
            System.out.println("\n submitting task : " + taskId + "...");

            try {
                executor.submit(() -> {
                    try {
                        System.out.println("[Executing Task: ] " + taskId);
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        System.out.println("Interrupted Task: " + taskId);
                        Thread.currentThread().interrupt();
                    }
                });

                System.out.println("Active Threads : " + executor.getActiveCount() +
                        " | Queue Size : " + queue.size() +
                        " | Pool size: " + executor.getPoolSize() +
                        " | Tasks : " + executor.getTaskCount());

            } catch (RejectedExecutionException e) {
                // FIXED: Catches rejection inside the loop when task 5 exceeds capacity
                System.out.println("  [REJECTED] Task " + taskId + " thrown via AbortPolicy!");
            }
        }

        // Allow task to Run
        Thread.sleep(500);
        System.out.println("\n=== 2. shutdown initiated ---");
        executor.shutdown();
        System.out.println("is  shutdown? " + executor.isShutdown());
        System.out.println("is  terminated? " + executor.isTerminated());

        System.out.println("\n 3. awaiting termination ---");
        boolean finishedCleanly = executor.awaitTermination(5, TimeUnit.SECONDS);
        System.out.println("is  terminated? " + finishedCleanly);
        System.out.println("is  terminated? " + executor.isTerminated());
    }
};
