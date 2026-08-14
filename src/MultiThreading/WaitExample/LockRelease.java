package MultiThreading.WaitExample;

public class LockRelease {
    public synchronized void waitExample(){
        System.out.println("Waiting" + Thread.currentThread().getName());
        try {
            System.out.println("calling wait " + Thread.currentThread().getName());
            wait();
            System.out.println("Resuming after notify. " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public synchronized void notifyExample(){
        System.out.println("Notifying" + Thread.currentThread().getName());
        notify();
    }

    public static void main(String[] args) {
        final LockRelease LR = new LockRelease();
        Thread t1 = new Thread(()->LR.waitExample(),"Thread 1");
        Thread t2 = new Thread(()-> LR.waitExample(),"Thread 2");

        Thread notifier = new Thread(()->{
            try{
                    Thread.sleep(1000);
            }catch (InterruptedException e){
                    e.printStackTrace();
            }
            LR.notifyExample();

            try{
                    Thread.sleep(1000);
            }catch (InterruptedException e){
                    e.printStackTrace();
            }
            LR.notifyExample();
        },"Notifier");

        t1.start();
        t2.start();
        notifier.start();
    }
}
