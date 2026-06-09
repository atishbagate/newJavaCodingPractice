package DesignPatterns.CreationalDesignPatterns.SingletonePattern;

//This is widely considered the best approach for standard Java classes. It uses a static inner helper class.
//Pros: Lazy initialization, completely thread-safe without requiring the synchronized keyword
//        (relying on the JVM's class-loading mechanism instead), clean and easy to read.

public class Three_billPughSingleton {
    private Three_billPughSingleton() {
    }

    public static Three_billPughSingleton getInstance() {
        return SingletonHelper.INSTANCE;
    }

    public static void main(String[] args) {
        SingletonHelper.INSTANCE.showMessage();
    }

    public void showMessage() {
        System.out.println("BillPughSingleton Singleton Instance accessed.");
    }

    // Inner static class is only loaded when getInstance() is called
    private static class SingletonHelper {
        private static final Three_billPughSingleton INSTANCE = new Three_billPughSingleton();
    }
}
