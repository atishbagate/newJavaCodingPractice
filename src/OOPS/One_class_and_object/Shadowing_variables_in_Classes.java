package OOPS.One_class_and_object;
//Topic 2: Shadowing and the Outer.this Memory Reference
// In a production environment, you might encounter situations where an
// inner class method has parameters or local variables with the exact same name as fields in the outer class. This is called Variable Shadowing.

//1. The Interview Question
//"If an inner class method has a local variable named x, the inner class itself has an
// instance variable named x, and the outer class also has a field named x,
// how does the JVM distinguish between them in memory? How do you access each one?"

// 2. The Core Concept
// Local Variable: Stored on the Stack frame of the currently executing method.
// It is accessed simply by its name (x).

// Inner Class Field: Stored on the Heap inside the inner class object instance.
// It is accessed using this.x.

// Outer Class Field: Stored on the Heap inside the outer class object instance.
// Because the non-static inner class holds a secret reference to its creator,
// it uses a special syntax to jump out to the outer instance: OuterClass.this.x.


public class Shadowing_variables_in_Classes {
    // Layer 3: Outer Class Instance Field (Heap)
    private int value = 10;

    public class InnerClass{
        // Layer 2: Inner Class Instance Field (Heap)
        private int value = 20;
        public void printValues(int value) {
            // Layer 1: Method Parameter / Local Variable (Stack)
            // Passed in as 30

            System.out.println("1. Local Method Value: " + value);

            System.out.println("2. Inner Class Field: " + this.value);

            System.out.println("3. Outer Class Field: " + Shadowing_variables_in_Classes.this.value);
        }
    }

    public static void main(String[] args) {
        Shadowing_variables_in_Classes outer = new Shadowing_variables_in_Classes();
        Shadowing_variables_in_Classes.InnerClass inner = outer.new InnerClass();

        // Pass 30 into the method
        inner.printValues(30);
    }
}
