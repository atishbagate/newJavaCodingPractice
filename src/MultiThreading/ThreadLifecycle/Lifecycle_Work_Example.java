package MultiThreading.ThreadLifecycle;

public class Lifecycle_Work_Example {
    // kitchen -
    private static final Object Kitchen = new Object();

    public static void main(String[] args) throws InterruptedException {

        // stage 1 - new ( hiring maid )
        // maid is hired but not started working yet.
        Thread maid = new Thread(() -> {
            try {
                // STAGE 3 : TIMED_WAITING ( lunch break )
                System.out.println("\n [maid] : Taking a lunch break : " + Thread.currentThread().getName());
                Thread.sleep(2000);

                // STAGE 4 : BLOCKED = KITCHEN IS LOCKED
                // maid tried to enter the kitchen, but the owner has key of kitchen.
                synchronized (Kitchen) {
                    // Stage 5 : WAITING to get signal
                    // once maid is inside kitchen, will wait for signal to which dish prepare.
                    System.out.println("[maid] : is inside the room : waiting for which dish to prepare ?  ..." + Thread.currentThread().getName());
                    Kitchen.wait();
                    System.out.println("[maid] : got the order for dish, now preparing idli wada sambar.");
                }
            } catch (Exception e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        });

        // verifying stage 1 : new
        System.out.println("1. [MAID]: Hired Thready. State = " + maid.getState()); // NEW
        // owner locks the kitchen - so that maid will get the blocking state later.
        synchronized (Kitchen) {
            // stage 2 : runnable
            // owner asked to start the work.
            maid.start();
            System.out.println("2. [MAID]: Hired Thready. State = " + maid.getState()); // RUNNABLE

            // pausing the main thread
            Thread.sleep(1000);

            // Verify STAGE 3: TIMED_WAITING
            System.out.println("3. [owner]: checking maid... State = " + maid.getState());

            // waiting for maid to finish sleep anf try to access kitchen
            Thread.sleep(3000);

            // Verify STAGE 4: BLOCKED
            // ownwer is stucked outside because maid is inside kitchen.
            System.out.println("4. [owner]: Owner is trying to enter kitchen : " + maid.getState()); // BLOCKED
        } // maid allow owner to enter the kitchen  ( maid exit synch block )

        //Paused briefly to let the owner enter the room and call wait()
        Thread.sleep(2000);

        // verify stage 5 : WAITING
        System.out.println("5. [MANAGER] : maid waiting for someone to order dish ... state " + maid.getState());

        // owner ordered to prepare idli wada sambar
        synchronized (Kitchen) {
            System.out.println("\n [ORDER]: Order given to prepare idli wada sambhar to Maid...");
            Kitchen.notify();
        }

        // wait for maid to complete this task and finish running
        maid.join();

//        stage 6 : TERMINATED (Clocked Out)
//        Maid completed food and return home
        System.out.println("6.  [Maid] : MAID FINISHED THE TASK .. State is.." + maid.getState());
    }

}
