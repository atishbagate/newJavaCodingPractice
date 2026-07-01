package JAVA_8_Features.One_Functional_Interface;

//defination  : A Functional Interface is an interface that contains exactly one abstract method

public class One_Functional_Interface {

    @FunctionalInterface
    public interface Functional{
        // only one abstract method
        // it is by default public and abstract
        // an abstract method is deliberately left unimplemented
        // so that it can be implemented by an object instance
        // (like a lambda expression)

        void function();

        // we can add other methods like Default,
        // static methods and methods inherited from the class object.
        default void defaultFunction(){}
        static void staticFunction(){}
        String toString();

    }

        // points to note :
        //The single abstract method of a functional interface is always implicitly
        // public abstract. If it were static, you wouldn't be able to map a lambda
        // expression to execute dynamic instance behavior!


   static class FunctionalImplementation implements Functional{

        @Override
        public void function() {
            System.out.println("functionalImplementation");
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello World");

        FunctionalImplementation fI = new FunctionalImplementation();
        fI.function();
    }
}
