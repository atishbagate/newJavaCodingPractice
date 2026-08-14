package MultiThreading.ThreadLifecycle;

public class Lifecycle {
    // The shared office resource (e.g., The Shared Files Room)
    private static final Object Shared_Files_lock = new Object();

    public static void main(String[] args) throws InterruptedException {

        // -------------------------------------------------------------
        // STAGE 1: NEW (The Hired Intern)
        // Thready is created with a task, but hasn't started yet.
        // -------------------------------------------------------------
       Thread thready = new Thread(()->{
            try{
                // STAGE 3: TIMED_WAITING (Coffee Break)
                // Thready takes a timed break for 200 ms.
                System.out.println("\n[Thready]: Taking a timed coffee break..."+Thread.currentThread().getName());
                Thread.sleep(200);

                // STAGE 4: BLOCKED (The Locked Office)
                // Thready tries to enter the Files Room, but Manager holds the lock.
                synchronized (Shared_Files_lock){
                    // STAGE 5: WAITING (Waiting for Data-Bot's Signal)
                    // Once inside, Thready waits indefinitely until notified.

                    System.out.println("[Thready]: Inside Files Room! Waiting for Data-Bot's signal...");
                    Shared_Files_lock.wait();
                    System.out.println("[Thready]: Got the signal! Finishing up final report...");

                }
            }catch (Exception e){
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        });


        // Verify STAGE 1: NEW
        System.out.println("1. [MANAGER]: Hired Thready. State = " + thready.getState()); // NEW

        // Manager locks the Shared Files Room early so Thready gets blocked later
        synchronized (Shared_Files_lock) {
            // -------------------------------------------------------------
            // STAGE 2: RUNNABLE (The Grind Begins)
            // Manager tells Thready to start working.
            // -------------------------------------------------------------
            thready.start();
            System.out.println("2. [MANAGER]: Said 'Start working!'. State = " + thready.getState()); // RUNNABLE


            // Pause main thread briefly so Thready enters Thread.sleep()
            Thread.sleep(50);

            // Verify STAGE 3: TIMED_WAITING
            System.out.println("3. [MANAGER]: Checking on Thready... State = " + thready.getState()); // TIMED_WAITING


            // Wait for Thready to finish sleeping and try accessing the Files Room
            Thread.sleep(250);

            // Verify STAGE 4: BLOCKED
            // Thready is stuck outside because Manager is inside synchronized(SHARED_FILES_ROOM)
            System.out.println("4. [MANAGER]: Thready trying to enter locked room... State = " + thready.getState()); // BLOCKED

        } // Manager exits synchronized block, unlocking the door for Thready

        // Pause briefly to let Thready enter the room and call wait()
        Thread.sleep(50);

        // Verify STAGE 5: WAITING
        System.out.println("5. [MANAGER]: Thready waiting for Data-Bot... State = " + thready.getState()); // WAITING

        // Manager sends notification simulating Data-Bot's signal
        synchronized (Shared_Files_lock) {
            System.out.println("\n[DATA-BOT]: Sending notification signal to Thready...");
            Shared_Files_lock.notify();
        }

        // Wait for Thready to complete his task and finish running
        thready.join();


        // -------------------------------------------------------------
        // STAGE 6: TERMINATED (Clocked Out)
        // Thready has completed his run() method and exited the building.
        // -------------------------------------------------------------
        System.out.println("6. [MANAGER]: Thready finished report and clocked out. State = " + thready.getState()); // TERMINATED
    }
}
