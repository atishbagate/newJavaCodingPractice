package DesignPatterns.CreationalPatterns;

public class SingletonPattern {

    // 1. Private static variable of the same class that holds the single instance.
    private static SingletonPattern instance;

    // 2. Private constructor prevents instantiation from other classes.
    private SingletonPattern() {
        // Initialization code can go here
    }

    // 3. Public static method to provide a global point of access to the instance.
    public static SingletonPattern getInstance() {
        // Lazy initialization: we only create the object when it's first requested.
        if (instance == null) {
            instance = new SingletonPattern();
        }
        return instance;
    }

    // Example method to demonstrate the singleton in action
    public void showMessage() {
        System.out.println("Hello from the Singleton instance!");
    }

    public static void main(String[] args) {
        // You CANNOT do this:
        // SingletonPattern obj = new SingletonPattern(); // Compile-time error

        // You must get the instance like this:
        SingletonPattern singleton1 = SingletonPattern.getInstance();
        singleton1.showMessage();

        SingletonPattern singleton2 = SingletonPattern.getInstance();

        // Proving that both variables point to the exact same object in memory
        System.out.println("Are both instances the same object? " + (singleton1 == singleton2));
    }
}
