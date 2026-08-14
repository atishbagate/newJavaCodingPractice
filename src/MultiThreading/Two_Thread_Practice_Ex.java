package MultiThreading;

public  class Two_Thread_Practice_Ex extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Thread " + i + " is running - "+ Thread.currentThread().getId());

            try{
               Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        Two_Thread_Practice_Ex T1 = new Two_Thread_Practice_Ex();
        Two_Thread_Practice_Ex T2 = new Two_Thread_Practice_Ex();

        T1.start();
        T2.start();
    }
}

