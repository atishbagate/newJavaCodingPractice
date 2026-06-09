package DesignPatterns.CreationalDesignPatterns.SingletonePattern;

//If you want to delay creating the instance until it is actually needed (Lazy Initialization)
// but also ensure it is safe to use in a multi-threaded environment, you use Double-Checked Locking.
//Pros: Lazy initialization, high performance (synchronization happens only during the first call).
//Cons: Slightly complex syntax

public class Two_DoubleCheckSingleton {
    private static volatile Two_DoubleCheckSingleton instance;

    private Two_DoubleCheckSingleton() {
    }

    public static Two_DoubleCheckSingleton getInstance() {
        //first check ( no locking )
        if (instance == null) {
            //lock only if instance is null
            synchronized (Two_DoubleCheckSingleton.class) {
                //second check ( with locking )
                if (instance == null) {
                    instance = new Two_DoubleCheckSingleton();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        Two_DoubleCheckSingleton singleton = Two_DoubleCheckSingleton.getInstance();
        singleton.showMessage();
    }

    public void showMessage() {
        System.out.println("double check Singleton Instance accessed.");
    }
}