package MultiThreading.ThreadLifecycle;

//Here is a hands-on exercise designed for practice. It is a Download Manager simulation where a background thread moves through distinct states while processing a file download.

//The Problem Scenario

//You need to build a DownloadTask thread that:
//Starts downloading a file (entering RUNNABLE).
//Pauses to simulate network latency (TIMED_WAITING).
//Tries to save the file to a shared disk location guarded by a lock (BLOCKED).
//Waits for user authorization before finalizing (WAITING).
//Finishes the download and exits (TERMINATED).

public class LifeCycleExampleTwo {

    private static final Object disk_lock = new Object();
    private static final Object Auth_lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        // Worker Thread: Simulates the file download task
        Thread downloader = new Thread(() -> {
            try {
                // Stage 2 : RUNNABLE -> Simulating active work
                System.out.println("Downloader: Starting file download...");
                // Stage 3 : TIMED_WAITING -> internet latency delay
                System.out.println("Downloader: simulate network latency : (Sleeping)...");
                Thread.sleep(1000);
//                Stage 4 : BLOCKED -> Trying to acquire Disk_Lock
                System.out.println("Downloader:  Req for access to write to disk...");
                synchronized (disk_lock) {

//                    Stage 5 : WAITING -> waiting for user permission
                    System.out.println("Downloader: Disk access granted. waiting for user authentication...");
                    synchronized (Auth_lock) {
                        Auth_lock.wait();
                    }
                    System.out.println("Downloader: Auth received. waiting for file to disk...");
                }
                System.out.println("Downloader: Downloading file...");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        //check the state before starting:
        System.out.println("Initial state : " + downloader.getState()); // Initial state : NEW
        synchronized (disk_lock) {
//            start the downloader
            downloader.start();
            System.out.println("State after start : " + downloader.getState()); //State after start : RUNNABLE

//            waiting for network to hit the network sleep
            // --- MAIN-SLEEP 1: 300 ms ---
            // Gives Downloader time to enter Thread.sleep(1000)
            Thread.sleep(300);
            System.out.println("State during network latency : " + downloader.getState()); // State during network latency : TIMED_WAITING

            // Wait for downloader to finish sleeping and attempt disk access
            // --- MAIN-SLEEP 2: 2000 ms ---
            // Total time = 2300 ms. Downloader woke up at 1000 ms and got BLOCKED waiting for disk_lock.
            // Downloader has been sitting in BLOCKED for over 1 second now!
            Thread.sleep(2000);
            System.out.println("4. State while disk is locked by main : " + downloader.getState()); // State while disk is locked by main : BLOCKED

        } // Release DISK_LOCK here

        // Give downloader time to enter AUTHORIZATION_LOCK.wait()
        // --- MAIN-SLEEP 3: 2000 ms ---
        // Downloader now has a huge 2-SECOND window to grab locks, print statements,
        // and call Auth_lock.wait(). It is 100% guaranteed to be WAITING when Main wakes up.
        Thread.sleep(2000);
        System.out.println("5. State waiting for user authorization: " + downloader.getState());
        synchronized (Auth_lock) {
            Auth_lock.notify();
        }
//        wait for downloader thread to finish execution completely
        downloader.join();

        // 6. checking the state after completion
        System.out.println("6. final state after join() : "+downloader.getState());
    }
}

//Initial state : NEW
//State after start : RUNNABLE
//Downloader: Starting file download...
//Downloader: simulate network latency : (Sleeping)...
//State during network latency : TIMED_WAITING
//Downloader:  Req for access to write to disk...
// 4. State while disk is locked by main : BLOCKED
//Downloader: Disk access granted. waiting for user authentication...
// 5. State waiting for user authorization: WAITING
//Downloader: Auth received. waiting for file to disk...
//Downloader: Downloading file...
// 6. final state after join() : TERMINATED

