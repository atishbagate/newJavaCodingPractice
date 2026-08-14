package MultiThreading.ThreadLifecycle;
//In this flow, a background worker process handles an order payment, navigating all 6 Java thread states through different operational triggers.

//The Problem Scenario: Payment Worker Flow
//You are building a PaymentTask thread that:
//Starts processing an order (RUNNABLE).
//Contacts the Bank Gateway via a network call, which takes time (TIMED_WAITING).
//Tries to update the central Account Ledger guarded by a lock (BLOCKED).
//Waits for Fraud Detection clearance before finalizing (WAITING).
//Completes the transaction and exits (TERMINATED).

public class LifeCycleExampleThree {
    private static final Object Ledger_Lock = new Object();
    private static final Object Fraud_Check_Lock = new Object();

    public static void main(String[] args) throws InterruptedException {
       Thread paymentWorker = new Thread(() -> {
            try{
                // STAGE 2: RUNNABLE -> Active CPU execution
                System.out.println("[Worker]: payment worker thread started for order # ");
                // STAGE 3: TIMED_WAITING -> Contacting payment gateway over the network
                System.out.println("[Worker]: Contacting Bank Gateway (network call)...");
                Thread.sleep(1000);
                // STAGE 4: BLOCKED -> Trying to access shared ledger
                System.out.println("[Worker]: Gateway responded. Requesting access to Account Ledger....");
                synchronized (Ledger_Lock) {
                    // STAGE 5: WAITING -> Waiting for fraud detection system approval
                    System.out.println("[Worker]: Ledger locked! Waiting for Fraud Detection clearance...");
                    synchronized (Fraud_Check_Lock){
                        Fraud_Check_Lock.wait(); // release fraud check lock and waits.
                    }
                    System.out.println("[Worker]: Fraud clearance received! Updating ledger balance...");
                }
                System.out.println("[Worker]: Payment processed successfully!");
            } catch (Exception e) {
                 Thread.currentThread().interrupt();
            }
        });

        // 1. NEW - Instance created, start() not invoked
        System.out.println("1. Initial State: " + paymentWorker.getState());

        // Lock the ledger early so the worker gets BLOCKED later
        synchronized (Ledger_Lock) {
            paymentWorker.start();
            System.out.println("2. State after start(): " + paymentWorker.getState());

          // 3. TIMED_WAITING - Wait 300 ms so worker enters Gateway Thread.sleep(1000)
            Thread.sleep(300);
            System.out.println("3. State while contacting gateway: " + paymentWorker.getState());

            // 4. BLOCKED - Wait 2000 ms total.
            // Worker wakes up from gateway sleep at 1000 ms, tries to enter LEDGER_LOCK,
            // and spends >1 second sitting in BLOCKED waiting for Main to release it.
            Thread.sleep(2000);
            System.out.println("4. State while ledger is locked by Main: " + paymentWorker.getState());
        } // <--- Main releases LEDGER_LOCK here!

        // 5. WAITING - Give worker a huge 2000 ms window to grab LEDGER_LOCK,
        // grab FRAUD_CHECK_LOCK, and park inside FRAUD_CHECK_LOCK.wait()
        Thread.sleep(2000);
        System.out.println("5. State waiting for Fraud Clearance: " + paymentWorker.getState());

        // Send notification signal to clear fraud check
        synchronized (Fraud_Check_Lock){
            System.out.println("\n[Main]: Fraud check passed! Signaling worker...");
            Fraud_Check_Lock.notify();
        }

        // Wait for worker to finish execution cleanly
        paymentWorker.join();

        // 6. TERMINATED - Worker completed run() method
        System.out.println("6. Final State after join(): " + paymentWorker.getState());
    }
}
//1. Initial State: NEW
//2. State after start(): RUNNABLE
//[Worker]: payment worker thread started for order #
//        [Worker]: Contacting Bank Gateway (network call)...
//        3. State while contacting gateway: TIMED_WAITING
//[Worker]: Gateway responded. Requesting access to Account Ledger....
//        4. State while ledger is locked by Main: BLOCKED
//[Worker]: Ledger locked! Waiting for Fraud Detection clearance...
//        5. State waiting for Fraud Clearance: WAITING
//
//[Main]: Fraud check passed! Signaling worker...
//        [Worker]: Fraud clearance received! Updating ledger balance...
//        [Worker]: Payment processed successfully!
//        6. Final State after join(): TERMINATED