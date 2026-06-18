# Deep Dive: Inheritance in Java (Interview Guide)

## 1. What is Inheritance?
Inheritance is a mechanism in Java by which one class acquires the properties (fields) and behaviors (methods) of another class.
It represents an **IS-A relationship** (e.g., a Dog IS-A Animal, a Car IS-A Vehicle).

The class whose properties are inherited is called the **Superclass** (or Parent/Base class).
The class that inherits the properties is called the **Subclass** (or Child/Derived class).

### Why use Inheritance?
1. **Code Reusability**: You don't have to write the same code again and again.
2. **Method Overriding**: It is required to achieve Runtime Polymorphism (Dynamic Method Dispatch).

## 2. Types of Inheritance in Java
1. **Single Inheritance:** Class B extends Class A.
2. **Multilevel Inheritance:** Class C extends Class B, and Class B extends Class A.
3. **Hierarchical Inheritance:** Class B and Class C both extend Class A.

*Note: Java **does not** support Multiple Inheritance (Class C extends Class A and Class B) through classes to avoid complexity and ambiguity.*

## 3. Tricky Interview Questions

### Q1: Why doesn't Java support Multiple Inheritance through classes?
**Answer:** To prevent the **Diamond Problem** (Ambiguity). If Class C extends both Class A and Class B, and both A and B have a method `print()`, the compiler won't know which `print()` method to call when invoked on a Class C object. Java simplifies this by disallowing multiple inheritance of state (classes). However, multiple inheritance of type is allowed through Interfaces (since Java 8, we use `default` methods and must resolve conflicts manually).

### Q2: What is the `super` keyword used for?
**Answer:** The `super` keyword is a reference variable used to refer to the immediate parent class object.
1. `super()` is used to invoke the parent class constructor (must be the first line in the subclass constructor).
2. `super.methodName()` is used to invoke a parent class method (useful if the subclass has overridden it).
3. `super.variableName` is used to access a parent class field if it is hidden by a subclass field.

### Q3: Are constructors inherited in Java?
**Answer:** **No.** A subclass inherits fields and methods, but **not constructors**. However, the subclass constructor must (and automatically does, if not explicitly written) invoke the parent class constructor using `super()` to initialize the inherited state.

### Q4: Can we inherit `private` members of a class?
**Answer:** **No.** `private` fields and methods are not inherited by the subclass. However, if the parent class provides `public` or `protected` getters and setters, the subclass can access and modify the private data through those methods.

### Q5: What is the difference between IS-A and HAS-A relationships?
*   **IS-A (Inheritance):** Achieved using the `extends` or `implements` keyword. Used for code reusability and polymorphism. (e.g., `Car extends Vehicle`).
*   **HAS-A (Composition/Aggregation):** Achieved by using instance variables that are references to other objects. It represents a stronger design choice in many cases ("Favor Composition over Inheritance"). (e.g., `Car` has an `Engine`).

### Q6: What is "Method Hiding"?
**Answer:** When a parent class and a child class both have a `static` method with the same signature, it is not considered Method Overriding. It is called **Method Hiding**. The method that gets executed depends on the **reference type** at compile-time, not the actual object type at run-time (because static methods are resolved at compile-time).



# Create a markdown file containing the structured technical interview questions for Java Inheritance.
md_content = """# Java Inheritance Interview Guide (2-3 Years Experience)

This comprehensive guide compiles advanced Java inheritance interview questions, core mechanics, edge cases, and architectural considerations frequently tested by top-tier MNCs.

---

## 1. Core Mechanics & Polymorphism

### Q1. Variable Shadowing vs. Method Overriding
**Question:** What happens when a subclass defines an instance variable with the exact same name as an instance variable in its superclass? How does this differ from method overriding?

**Code Snippet:**