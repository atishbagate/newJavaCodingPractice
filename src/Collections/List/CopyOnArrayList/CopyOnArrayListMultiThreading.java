package Collections.List.CopyOnArrayList;

import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnArrayListMultiThreading {
    public static void main(String[] args) {
        // Create a shared CopyOnWriteArrayList
        CopyOnWriteArrayList<String> sharedList = new CopyOnWriteArrayList<>();
        sharedList.add("Item 1");
        sharedList.add("Item 2");
        sharedList.add("Item 3");

        // Thread 1: Reader Thread
        // This thread will iterate over the list and print elements.
        Thread readerThread = new Thread(() -> {
            try {
                while (true) {
                    System.out.println("Reader Thread: Iterating list...");
                    for (String item : sharedList) {
                        System.out.println("Reader Thread: Reading " + item);
                        Thread.sleep(500); // Simulate some processing time
                    }
                    System.out.println("Reader Thread: Finished iteration.");
                    Thread.sleep(1000); // Wait before next iteration
                }
            } catch (InterruptedException e) {
                System.out.println("Reader Thread interrupted.");
            }
        });

        // Thread 2: Writer Thread
        // This thread will modify the list concurrently while the reader is reading.
        Thread writerThread = new Thread(() -> {
            try {
                Thread.sleep(1000); // Wait a bit before starting modifications

                System.out.println("Writer Thread: Adding 'Item 4'");
                sharedList.add("Item 4");

                Thread.sleep(2000);

                System.out.println("Writer Thread: Removing 'Item 1'");
                sharedList.remove("Item 1");

                Thread.sleep(2000);

                System.out.println("Writer Thread: Adding 'Item 5'");
                sharedList.add("Item 5");

            } catch (InterruptedException e) {
                System.out.println("Writer Thread interrupted.");
            }
        });

        // Start both threads
        readerThread.start();
        writerThread.start();

        // Let the threads run for a while then stop them
        try {
            Thread.sleep(10000);
            readerThread.interrupt();
            writerThread.interrupt();
            readerThread.join();
            writerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final List: " + sharedList);
    }
}
