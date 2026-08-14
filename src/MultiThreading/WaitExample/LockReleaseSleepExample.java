package MultiThreading.WaitExample;

public class LockReleaseSleepExample {
    public synchronized void sleepExample(){
        System.out.println("entering sleepExample "+Thread.currentThread().getName());
        try {
            System.out.println("sleeping for 1 sec "+Thread.currentThread().getName());
            Thread.sleep(1000);
            System.out.println("waking up from sleep "+Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
      final LockReleaseSleepExample LR = new LockReleaseSleepExample();
      Thread sleep1 = new Thread(()->LR.sleepExample(),"Thread 1");
      Thread sleep2 = new Thread(()->LR.sleepExample(),"Thread 2");
      sleep1.start();
      sleep2.start();
    }
}
