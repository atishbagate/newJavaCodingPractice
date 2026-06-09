# Deep Dive: Encapsulation in Java (Interview Guide)

## 1. What is Encapsulation?
Encapsulation is the mechanism of **wrapping the data (variables)** and **code acting on the data (methods)** together as a single unit (like a class).

In encapsulation, the variables of a class are hidden from other classes and can be accessed only through the methods of their current class. Therefore, it is also known as **data hiding**.

**Real-World Analogy:** A medical capsule. The medicine (data) is hidden and protected inside the outer shell (class/methods).

### How to achieve Encapsulation?
1. Declare the variables of a class as `private`.
2. Provide `public` setter and getter methods to modify and view the variables' values.

## 2. Advantages of Encapsulation
* **Data Hiding:** The user will have no idea about the inner implementation of the class. They only know that passing values to a setter updates the variable.
* **Control Over Data:** You can write logic inside the setter to validate data before assigning it (e.g., checking if `age > 0`).
* **Flexibility & Read-Only/Write-Only:** You can make a class strictly **read-only** (by providing only getters) or **write-only** (by providing only setters).
* **Reusability & Maintainability:** Encapsulated code is loosely coupled, making it easier to change and test.

## 3. Tricky Interview Questions

### Q1: Is Encapsulation just about adding getters and setters?
**Answer:** **No.** While getters and setters are the mechanical way to achieve it, true encapsulation is about **protecting invariants** (business rules).
If a class has a `private List<String> items`, generating a getter that simply returns the list `return this.items;` breaks encapsulation! Why? Because the caller can modify the list directly: `obj.getItems().add("Hacked!")`.
**Best Practice:** Return a defensive copy (`return new ArrayList<>(this.items);`) or an unmodifiable view (`Collections.unmodifiableList(this.items);`).

### Q2: What is the difference between Abstraction and Encapsulation?
*   **Abstraction** is about **hiding complexity**. It shows *what* an object does (its behavior) while hiding the internal details of *how* it does it. (e.g., Pressing the brake pedal).
*   **Encapsulation** is about **hiding data**. It protects the internal state (variables) of an object from unauthorized access or modification. (e.g., The brake fluid level cannot be changed directly from outside the car; it must go through a proper mechanism).
*   **Summary:** Abstraction is applied at the **Design level**, whereas Encapsulation is applied at the **Implementation level**.

### Q3: How do you make a class completely encapsulated?
**Answer:** By making all the data members of the class `private`. Any access to these members must go through `public` methods (getters/setters). If a class has even one `public` or default field, it is not 100% encapsulated.

### Q4: Can we achieve encapsulation without getters and setters?
**Answer:** Yes! Getters and setters are just a convention (JavaBeans standard). Encapsulation simply means bundling data and methods. You can expose meaningful business methods like `deposit(amount)` or `withdraw(amount)` instead of `setBalance(balance)`, which is actually a much better object-oriented design!

### Q5: What is Data Leakage in Encapsulation?
**Answer:** Data leakage happens when you return a reference to a mutable private object (like an array, Date, or Collection) from a getter method. To fix this, you should use **Defensive Copying** (returning a clone or copy of the object instead of the original reference).

```java
public class Employee {
    private Date joinDate;

    // BAD: Breaks encapsulation (data leakage)
    // public Date getJoinDate() { return joinDate; }

    // GOOD: Defensive copying
    public Date getJoinDate() {
        return new Date(joinDate.getTime());
    }
}
```