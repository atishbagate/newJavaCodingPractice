package Collections.HashMapExamples;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ConcurrentHashMapExample {

    public static void main(String[] args) throws InterruptedException {
        // ConcurrentHashMap is thread-safe and optimized for high concurrency
        Map<Integer, String> concurrentMap = new ConcurrentHashMap<>();

        // Create a thread pool with 3 threads
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        // Thread 1: Writer (Adds keys 0-9)
        executorService.submit(() -> {
            for (int i = 0; i < 10; i++) {
                concurrentMap.put(i, "Thread1-Value" + i);
                System.out.println("Thread 1 added key: " + i);
                try { Thread.sleep(50); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
            }
        });

        // Thread 2: Writer (Adds keys 10-19)
        executorService.submit(() -> {
            for (int i = 10; i < 20; i++) {
                concurrentMap.put(i, "Thread2-Value" + i);
                System.out.println("Thread 2 added key: " + i);
                try { Thread.sleep(50); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
            }
        });

        // Thread 3: Reader (Iterates while others are writing)
        executorService.submit(() -> {
            for (int i = 0; i < 5; i++) {
                // Iterating over ConcurrentHashMap is safe; it reflects the state of the map at the time of iteration
                // It will NOT throw ConcurrentModificationException
                int size = concurrentMap.size();
                System.out.println("Thread 3 (Reader) sees map size: " + size);
                try { Thread.sleep(120); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
            }
        });

        // Initiate shutdown and wait for tasks to complete
        executorService.shutdown();
        boolean finished = executorService.awaitTermination(1, TimeUnit.MINUTES);

        if (finished) {
            System.out.println("Final Map Size: " + concurrentMap.size());
            System.out.println("Final Map Content: " + concurrentMap);
        }
    }
}