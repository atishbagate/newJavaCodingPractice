package OOPS.One_class_and_object;

public class ConstructorExecution {
    public ConstructorExecution() {
        System.out.println("Constructor Execution");
    }

    public static class StaticInnerClass {
        public StaticInnerClass() {
            System.out.println("StaticInnerClass");
        }

    }
    public class NonStaticInnerClass {
        public NonStaticInnerClass() {
            System.out.println("NonStaticInnerClass");
        }
    }

    public static void main(String[] args) {
        System.out.println("main method");

        new ConstructorExecution.StaticInnerClass();

//        when we direcly try to execute non static class it gives error -
//        'OOPS.One_class_and_object.ConstructorExecution.this' cannot be referenced from a static context

        // We first need an instance of the outer class, which runs its constructor,
        // and then the inner class constructor runs
      ConstructorExecution CE =  new ConstructorExecution();
      ConstructorExecution.NonStaticInnerClass inner =  CE. new NonStaticInnerClass();

    }
}
