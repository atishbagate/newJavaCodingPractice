package MultiThreading.ThreadPools.ThreadPoolErrorHandling;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class CaseCProductionSolution {

    public static void main(String[] args) {
        int corePoolSize = 2;
        int maxPoolSize = 4;
        long keepAliveTime = 10L;
        int queueCapacity = 3;

        // 2. Production-safe ThreadPoolExecutor
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                corePoolSize,
                maxPoolSize,
                keepAliveTime,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(queueCapacity),      // Bounded heap usage
                new AppThreadFactory("worker-service-"),      // Named threads
                new ThreadPoolExecutor.CallerRunsPolicy()     // Natural backpressure
        );

        System.out.println("--- Starting Case C: Production Resilient Pool ---");

        // Submit 10 tasks in rapid succession
        for (int i = 1; i <= 10; i++) {
            final int taskId = i;
            System.out.println("[Submitter: " + Thread.currentThread().getName() + "] Submitting Task " + taskId);

            executor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("  -> [Worker: " + Thread.currentThread().getName() + "] Executing Task " + taskId);
                    try {
                        Thread.sleep(2000); // Simulate 2 seconds of work
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            });
        }

        // 3. Graceful shutdown sequence
        executor.shutdown();
        try {
            if (!executor.awaitTermination(20, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }

        System.out.println("--- All tasks executed safely without crashing JVM ---");
    }

    // 1. Custom ThreadFactory for identifiable thread names in logs & thread dumps
    static class AppThreadFactory implements ThreadFactory {
        private final AtomicInteger threadNumber = new AtomicInteger(1);
        private final String prefix;

        public AppThreadFactory(String prefix) {
            this.prefix = prefix;
        }

        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r, prefix + threadNumber.getAndIncrement());
            t.setDaemon(false);
            return t;
        }
    }
}