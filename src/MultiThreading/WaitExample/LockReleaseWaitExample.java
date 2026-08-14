package MultiThreading.WaitExample;

public class LockReleaseWaitExample {

    synchronized void waitExample() {
        System.out.println(Thread.currentThread().getName()+" is waiting...");
            try {
                wait();
            } catch (InterruptedException e) {
                 e.printStackTrace();
            }
        System.out.println(Thread.currentThread().getName()+" Resumed after notify. ");
    }
    synchronized void notifyExample() {
        System.out.println(" notifyExample... ");
        notify();
    }

    public static void main(String[] args) {
        LockReleaseWaitExample waitExample = new LockReleaseWaitExample();
        Thread t1 = new Thread(waitExample::waitExample,"Thread 1");
        Thread t2 = new Thread(()-> {
            try{
                Thread.sleep(2000);
                waitExample.notifyExample();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"Thread 2");

        t1.start();
        t2.start();
    }
}
