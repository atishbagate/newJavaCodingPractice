# Deep Dive: Abstraction in Java — Interview Guide

## 1. Abstract Class vs. Interface — The Modern View

The traditional answers changed with **Java 8** and **Java 9**. Saying that *"interfaces only have abstract methods"* is outdated.


| Feature              | Abstract Class                                                                            | Interface                                                                                                                |
| -------------------- | ----------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------ |
| **Variables**        | Can have instance variables (`final`, non-final, `static`, non-static).                   | Variables are always`public static final` by default.                                                                    |
| **Constructors**     | Yes. It can have constructors to initialize its state.                                    | No. Interfaces cannot have constructors.                                                                                 |
| **Methods**          | Can have abstract, concrete,`static`, and `final` methods.                                | Can have abstract,`default`, `static`, and since Java 9, `private` methods.                                              |
| **Inheritance**      | A class can`extend` only one abstract class.                                              | A class can`implement` multiple interfaces.                                                                              |
| **Access Modifiers** | Fields and methods can use`public`, `protected`, and `private`.                           | Interface methods are`public` by default. Variables are `public static final`.                                           |
| **Typical Use**      | Used for an**"is-a"** relationship when sharing code and state. Example: `Animal → Dog`. | Used to define a**contract/capability** that can be implemented by unrelated classes. Example: `Runnable`, `Comparable`. |

> **Interview Tip:**
> An interface is not limited to abstract methods anymore. Since Java 8, it can contain `default` and `static` methods, and since Java 9, it can also contain `private` methods.

---

## 2. Tricky Interview Questions

### Q1. If we cannot instantiate an abstract class, why does it have a constructor?

**Answer:**

An abstract class can have a constructor because its constructor is used to initialize the **state inherited by its subclasses**.

You cannot directly create an object of an abstract class:

```java
Animal animal = new Animal(); // ❌ Compilation error
```

However, when you create an object of a concrete subclass, the abstract class constructor is executed first.

```java
abstract class Animal {

    String name;

    Animal(String name) {
        this.name = name;
        System.out.println("Animal constructor");
    }
}

class Dog extends Animal {

    Dog(String name) {
        super(name);
        System.out.println("Dog constructor");
    }
}

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog("Bruno");
    }
}
```

Output:

```text
Animal constructor
Dog constructor
```

The initialization flow is:

```text
new Dog("Bruno")
       ↓
Dog constructor
       ↓
super(name)
       ↓
Animal constructor
       ↓
Animal state initialized
       ↓
Dog constructor continues
```

> **Key point:**
> You cannot instantiate the abstract class directly, but its constructor runs as part of constructing a subclass object.

---

### Q2. Can we declare an abstract class or interface as `final`?

**Answer: No.**

This results in a compilation error.

```java
final abstract class Animal {
}
```

Why?

The two keywords express contradictory requirements:

* `abstract` → the class is designed to be inherited.
* `final` → the class cannot be inherited.

Therefore, Java does not allow:

```java
abstract + final
```

The same concept applies to an interface. An interface is inherently designed to be implemented, so it cannot be declared `final`.

> **Interview answer:**
> "`abstract` requires inheritance, while `final` prevents inheritance. Therefore, an abstract type cannot be final."

---

### Q3. Abstraction vs. Encapsulation — Don't Mix These Up

These two concepts are related but solve different problems.

#### Abstraction

**Abstraction hides implementation complexity.**

It focuses on:

> **What should the object do?**

For example, when you use a remote control, you press the **Power** button without needing to understand the internal electronic circuitry.

In Java, abstraction is commonly achieved using:

* Abstract classes
* Interfaces

Example:

```java
interface Payment {

    void pay();
}
```

The interface tells the caller **what operation is available**, without exposing how the payment is processed internally.

---

#### Encapsulation

**Encapsulation protects and controls access to an object's internal state.**

It focuses on:

> **How should the object's data be protected?**

For example:

```java
class BankAccount {

    private double balance;

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }
}
```

Here, `balance` is `private`, so external code cannot directly modify it.

Instead, access is controlled through methods such as `deposit()`.

### Quick Difference


| Concept           | Main Purpose                      | Think                              |
| ----------------- | --------------------------------- | ---------------------------------- |
| **Abstraction**   | Hide implementation complexity    | **What it does**                   |
| **Encapsulation** | Protect and control internal data | **How data is accessed/protected** |

> **Easy rule to remember:**
> **Abstraction = Hiding complexity**
> **Encapsulation = Protecting data**

---

## 3. The Diamond Problem — Multiple Inheritance with Interfaces

Since Java 8 introduced `default` methods, interfaces can contain methods with implementations.

This creates a potential conflict when a class implements two interfaces that contain `default` methods with the **same signature**.

Consider:

```java
interface CloudDrive {

    default void sync() {
        System.out.println("Syncing CloudDrive...");
    }
}

interface LocalDrive {

    default void sync() {
        System.out.println("Syncing LocalDrive...");
    }
}
```

Now suppose a class implements both:

```java
class HybridDrive implements CloudDrive, LocalDrive {
}
```

Which `sync()` method should Java use?

```text
CloudDrive.sync()
       OR
LocalDrive.sync()
```

Java cannot automatically choose between them.

Therefore, the code produces a **compilation error**.

---

### How to Resolve the Conflict

The implementing class must override the conflicting method.

```java
class HybridDrive implements CloudDrive, LocalDrive {

    @Override
    public void sync() {
        CloudDrive.super.sync();
    }
}
```

Now the class explicitly chooses the implementation from `CloudDrive`.

Alternatively, you can provide your own implementation:

```java
class HybridDrive implements CloudDrive, LocalDrive {

    @Override
    public void sync() {
        System.out.println("Syncing HybridDrive...");
    }
}
```

You can also call both interface implementations:

```java
class HybridDrive implements CloudDrive, LocalDrive {

    @Override
    public void sync() {
        CloudDrive.super.sync();
        LocalDrive.super.sync();
    }
}
```

### Interview Rule

When two interfaces provide the same `default` method:

```text
Interface A
     │
     ├── default sync()
     │
     ↓
Interface B
     │
     ├── default sync()
     │
     ↓
   Class
implements A, B
     │
     ↓
Must override sync()
```

> **Key point:**
> Java supports multiple inheritance of **type** through interfaces, but when multiple inherited `default` methods conflict, the implementing class must explicitly resolve the conflict.

---

## 4. Quick Interview Revision


| Question                                                        | Short Answer                                                     |
| --------------------------------------------------------------- | ---------------------------------------------------------------- |
| Can an abstract class have a constructor?                       | **Yes.** It initializes state when a subclass object is created. |
| Can we instantiate an abstract class?                           | **No.**                                                          |
| Can an abstract class have concrete methods?                    | **Yes.**                                                         |
| Can an abstract class have`static` methods?                     | **Yes.**                                                         |
| Can an abstract class have`final` methods?                      | **Yes.**                                                         |
| Can an interface have method implementations?                   | **Yes.** Through `default`, `static`, and `private` methods.     |
| Can an interface have instance variables?                       | **No.** Its fields are `public static final`.                    |
| Can an interface have a constructor?                            | **No.**                                                          |
| Can a class implement multiple interfaces?                      | **Yes.**                                                         |
| Can a class extend multiple classes?                            | **No.**                                                          |
| Can an abstract class be`final`?                                | **No.**                                                          |
| Can an interface be`final`?                                     | **No.**                                                          |
| What happens when two interfaces have the same`default` method? | The implementing class must override it to resolve the conflict. |

### One-Line Memory Trick

```text
Abstract Class → shared state + shared behavior + abstraction

Interface → contract/capability + multiple implementation

Abstraction → hide complexity

Encapsulation → protect data
```
