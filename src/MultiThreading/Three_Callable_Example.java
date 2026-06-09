package MultiThreading;

import java.util.concurrent.*;

class myCallable implements Callable<String> {
    private final String name;

    public myCallable(String name) {
        this.name = name;
    }

    @Override
    public String call() throws Exception {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            result.append("Callable ").append(name).append(" is running: ").append(i).append("\n");
            Thread.sleep(500);
        }
        return result.toString();
    }
}

public class Three_Callable_Example {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // create callable instance
        Callable<String> callable1 = new myCallable("task 1");
        Callable<String> callable2 = new myCallable("task 2");

        try {
            Future<String> future1 = executor.submit(callable1);
            Future<String> future2 = executor.submit(callable2);

            System.out.println("Result from First Task : ");
            System.out.println(future1.get());
            System.out.println("Result from Secont Task : ");
            System.out.println(future2.get());

        } catch (InterruptedException | ExecutionException e) {
            System.out.println("exception " + e.getMessage());
        }
    }
}
