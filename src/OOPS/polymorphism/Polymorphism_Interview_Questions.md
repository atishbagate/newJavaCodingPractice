# Deep Dive: Polymorphism in Java (Interview Guide)

## 1. What is Polymorphism?
Polymorphism comes from two Greek words: *poly* (many) and *morphs* (forms). It means "many forms."
In Java, Polymorphism allows us to perform a single action in different ways. It allows an object to take on many forms. The most common use of polymorphism in OOP occurs when a parent class reference is used to refer to a child class object.

## 2. Types of Polymorphism in Java

### A. Compile-Time Polymorphism (Static Binding / Early Binding)
*   **Mechanism:** Achieved through **Method Overloading**.
*   **How it works:** The compiler determines which method to call based on the method signature (number, type, and order of parameters) at compile time.
*   **Example:** `Math.max(int, int)` vs `Math.max(double, double)`.

### B. Run-Time Polymorphism (Dynamic Binding / Late Binding)
*   **Mechanism:** Achieved through **Method Overriding**.
*   **How it works:** The JVM determines which method to call at runtime based on the **actual object type**, not the reference variable type. This is also known as Dynamic Method Dispatch.
*   **Example:** A parent reference `Animal a = new Dog();` calling `a.sound()` will execute the `Dog`'s sound method.

## 3. Tricky Interview Questions

### Q1: Can we Overload or Override a `static` method?
*   **Overload:** **Yes.** We can have multiple static methods with the same name but different parameters.
*   **Override:** **No.** Static methods belong to the class, not the object. If a subclass defines a static method with the same signature as the parent, it **hides** the parent's method (Method Hiding), but it does not override it. The method executed depends on the reference type at compile time.

### Q2: Can we Overload or Override the `main` method?
*   **Overload:** **Yes.** You can have `public static void main(int[] args)`, but the JVM will only call `public static void main(String[] args)` as the entry point.
*   **Override:** **No.** Because the `main` method is `static`.

### Q3: Can we Override `private` or `final` methods?
*   **Private Methods:** **No.** Private methods are not visible to subclasses, so they cannot be overridden. If you define a method with the same signature in the subclass, it is considered a brand-new method.
*   **Final Methods:** **No.** The `final` keyword explicitly prevents a method from being overridden. It guarantees that the method's behavior remains unchanged in subclasses.

### Q4: What is Covariant Return Type?
**Answer:** Before Java 5, when overriding a method, the return type had to be exactly the same. Since Java 5, it is possible to override a method and change its return type, **provided the new return type is a subclass (subtype) of the original return type**.
For example, if the parent method returns `Animal`, the overridden method in the subclass can return `Dog`.

### Q5: Overloading vs Overriding
| Feature | Method Overloading | Method Overriding |
| :--- | :--- | :--- |
| **Where it happens** | Same class | Two classes with IS-A relationship (Parent/Child) |
| **Method Signature** | Name must be same, Parameters must be **different** | Name and Parameters must be **exactly the same** |
| **Return Type** | Can be different | Must be same or a Covariant (subtype) |
| **Binding** | Compile-time (Static Binding) | Run-time (Dynamic Binding) |
| **Private/Static/Final** | Can be overloaded | Cannot be overridden |

### Q6: Does Java support Operator Overloading?
**Answer:** **No.** Unlike C++, Java does not allow developers to overload operators (like `+`, `-`, `*`) for custom objects to keep the language simple and avoid confusion.
*Exception:* The `+` operator is inherently overloaded by Java for String concatenation.