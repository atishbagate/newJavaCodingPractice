package MultiThreading;

class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Child Thread");
        }
    }
}

public class one_Multithread_with_runnable {
    public static void main(String[] args) {
        MyRunnable r = new MyRunnable();
        Thread t = new Thread();
        t.start();

        for (int i = 0; i < 10; i++) {
            System.out.println("Main Thread");
        }
    }
}