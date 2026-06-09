package DesignPatterns.CreationalDesignPatterns.SingletonePattern;

public class Four_EnumSingleton {
    // Enum singleton is the most robust way to implement Singleton in Java.
    // It provides implicit support for thread safety and guarantees against
    // serialization or reflection attacks.
    public enum Singleton {
        INSTANCE;

        public void showMessage() {
            System.out.println("Enum Singleton Instance accessed.");
        }
    }

    public static void main(String[] args) {
        // Accessing the singleton instance
        Singleton singleton = Singleton.INSTANCE;
        singleton.showMessage();
    }

}
