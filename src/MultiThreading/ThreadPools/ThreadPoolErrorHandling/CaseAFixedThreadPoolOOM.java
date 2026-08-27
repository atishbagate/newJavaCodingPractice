package MultiThreading.ThreadPools.ThreadPoolErrorHandling;

import java.util.concurrent.*;

public class CaseAFixedThreadPoolOOM {
    public static void main(String[] args) {
        // Fixed 2 threads backed by unbounded LinkedBlockingQueue (Integer.MAX_VALUE)
        ExecutorService executor = Executors.newFixedThreadPool(2);

        System.out.println("--- Starting Case A: Triggering Heap OOM ---");

        int taskCounter = 0;
        try {
            while (true) {
                taskCounter++;
                final int taskId = taskCounter;

                executor.execute(new Runnable() {
                    // Holding a 1MB buffer inside each task object
                    private final byte[] memoryPayload = new byte[1024 * 1024];

                    @Override
                    public void run() {
                        try {
                            // Workers are blocked/slow, forcing all incoming tasks
                            // to stay in the queue
                            Thread.sleep(60_000);
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                });

                if (taskId % 10 == 0) {
                    System.out.println("[Producer] Pushed " +
                            taskId + " tasks into unbounded queue (~" +
                            taskId + " MB buffered)...");
                }
            }
        } finally {
            executor.shutdown();
        }
    }
}