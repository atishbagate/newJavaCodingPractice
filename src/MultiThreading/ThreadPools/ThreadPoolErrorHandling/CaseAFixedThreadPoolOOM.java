package MultiThreading.ThreadPools.ThreadPoolErrorHandling;

//Case A: Unbounded Queue (Executors.newFixedThreadPool)
//This demonstrates how tasks pile up in the unbounded LinkedBlockingQueue
// when the submission rate exceeds thread processing speed.

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CaseAFixedThreadPoolOOM {
    public static void main(String[] args) {
// Fixed 2 threads backed by an unbounded LinkedBlockingQueue (Integer.MAX_VALUE)
        ExecutorService executor = Executors.newFixedThreadPool(2);
        System.out.println("--- Starting Case A: newFixedThreadPool ---");

        // producer : submit tasks much faster than 2 threads can process
        for (int i = 0; i < 20; i++) {
            final int taskId = i;
            System.out.println("--- Starting Case A: " + taskId);
            executor.execute(new Runnable() {
                // Holding a 1MB buffer inside each task object
                private final byte[] memoryPayload = new byte[1024 * 1024];

                @Override
                public void run() {
                    try {
                        System.out.println(" -> [Worker] Processing task " + taskId);
                        Thread.sleep(2000); // simulate slow processing ( 2 sec )
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            });

            try {
                Thread.sleep(100); // 10 task/sec incoming vs 1 task/sec throughput
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        executor.shutdown();
    }

}
