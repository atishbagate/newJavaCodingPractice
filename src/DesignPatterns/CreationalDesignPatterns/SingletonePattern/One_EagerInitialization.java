package DesignPatterns.CreationalDesignPatterns.SingletonePattern;

//In this approach, the instance is created at the time of class loading.
//Pros: Very simple, thread-safe (because class loading is thread-safe).
//Cons: The instance is created even if the client application might not use it,
// potentially wasting memory.


public class One_EagerInitialization {
    // Private static instance created at the time of class loading
    private static final One_EagerInitialization instance = new One_EagerInitialization();


    // Private constructor to prevent instantiation from other classes
    private One_EagerInitialization() {
    }

    // Global access point to get the instance
    public static One_EagerInitialization getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        One_EagerInitialization singleton = One_EagerInitialization.getInstance();
        singleton.showMessage();
    }

    public void showMessage() {
        System.out.println("Eager Initialization Singleton Instance accessed.");
    }

}
