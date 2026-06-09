# Deep Dive: Abstraction in Java (Interview Guide)

## 1. Abstract Class vs. Interface (The Modern View)
The traditional answers changed in Java 8 and Java 9. Saying "interfaces only have abstract methods" is considered outdated.

| Feature | Abstract Class | Interface |
| :--- | :--- | :--- |
| **Variables** | Can have instance variables, `final`, non-final, `static`, and non-static. | Variables are strictly **`public static final`** (constants) by default. |
| **Constructors** | **Yes**, it can have a constructor. | **No**, it cannot have a constructor. |
| **Methods** | Can have abstract methods and concrete methods. | Can have abstract methods, but since Java 8, also **`default`** and **`static`** methods with bodies. (Java 9 added **`private`** methods). |
| **Inheritance** | A class can `extend` only **one** abstract class. | A class can `implement` **multiple** interfaces. |
| **Access Modifiers** | Methods and fields can be `protected`, `private`, `public`. | Abstract methods are implicitly `public abstract`. |

## 2. Tricky Interview Questions

### Q1: If we cannot instantiate an Abstract Class, why does it have a constructor?
**Answer:** This is a favorite trick question! An abstract class has a constructor to initialize its **own instance variables**. When a subclass is instantiated, the subclass constructor automatically calls `super()` (the abstract class's constructor) to set up the inherited state before the subclass finishes its own initialization. *(You can't do `new AbstractClass()`, but the JVM does it during subclass creation).*

### Q2: Can we declare an abstract class or interface as `final`?
**Answer:** **No.** This is a compilation error. The `final` keyword prevents inheritance/overriding, while `abstract` *requires* inheritance/overriding. They are completely opposite concepts.

### Q3: Abstraction vs. Encapsulation? (Don't mix these up!)
*   **Abstraction** hides the **complexity** (implementation details). It operates at the *design level*. (e.g., A remote control has a Power button—you don't see the circuit board).
*   **Encapsulation** hides the **data** (internal state). It operates at the *implementation level*. (e.g., Making variables `private` and providing `public getter/setter` methods to protect the data from unauthorized access).
*   *Short rule:* Abstraction = "What it does." Encapsulation = "Protecting the data."

## 3. The "Diamond Problem" (Multiple Inheritance in Interfaces)
Since Java 8 introduced `default` methods (methods with a body inside an interface), interviewers often ask: *"What happens if a class implements two interfaces that have a default method with the exact same signature?"*

```java
interface CloudDrive {
    default void sync() { System.out.println("Syncing CloudDrive..."); }
}

interface LocalDrive {
    default void sync() { System.out.println("Syncing LocalDrive..."); }
}
```

**Answer:** The compiler will throw an error because it doesn't know which `sync()` to inherit. **To fix it**, the implementing class *must* override the method and explicitly choose which one to call (or write a completely new implementation):

```java
class HybridDrive implements CloudDrive, LocalDrive {
    @Override
    public void sync() {
        // Explicitly resolving the conflict
        CloudDrive.super.sync();
    }
}
```

## 4. Architecture Question: When to use which?
*   **Use an Interface** when you are defining a **Role** or a **Contract**.
    *   *Example:* `Runnable`, `Serializable`, `Comparable`. A `Car` and a `Person` are totally unrelated classes, but both could implement a `Movable` interface.
*   **Use an Abstract Class** when defining a **Core Identity** (an "is-a" relationship).
    *   *Example:* `Animal` (Abstract) -> `Dog` (Subclass). They share common state (like `int age`, `String name`) and common behavior (like `sleep()`).
