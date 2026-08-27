package MultiThreading.ThreadPools.ThreadPoolErrorHandling;

import java.util.concurrent.*;

public class CaseBCachedThreadPoolOOM {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        System.out.println("--- Starting Case B: Triggering Native Thread OOM ---");

        int taskCount = 0;
        try {
            while (true) {
                taskCount++;
                final int id = taskCount;

                executor.execute(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            // Hold the thread active indefinitely
                            Thread.sleep(Long.MAX_VALUE);
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                });

                if (id % 100 == 0) {
                    System.out.println("[Pool Monitor] Created " + id + " concurrent native OS threads...");
                }
            }
        } finally {
            executor.shutdown();
        }
    }
}