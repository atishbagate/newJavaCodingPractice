# Java Classes and Objects: Deep Dive (3-4 YoE Interview Prep)

For a developer with 3-4 years of experience, interviewers look beyond the basic "a class is a blueprint" definition. They expect you to understand memory management, object lifecycle, contracts, and design principles.

## 1. JVM Memory Model for Objects

* **Heap:** Where all class instances (Objects) and arrays are allocated at runtime.
* **Stack:** Where local variables and method call frames are stored. If you write `Employee emp = new Employee();`, the reference variable `emp` is on the Stack, but the actual `Employee` object data is on the Heap.
* **Metaspace (formerly PermGen):** Where Class metadata (the blueprint itself), static variables, and constant pools are loaded by the ClassLoader.

## 2. Five Ways to Create an Object

Interviewers often ask: "Besides the `new` keyword, how else can you create an object?"

1. **Using the `new` keyword:** Calls the constructor.
2. **Using `Class.forName(...).newInstance()` (Reflection):** Creates an object dynamically at runtime (Calls no-arg constructor).
3. **Using `Constructor.newInstance()` (Reflection):** Similar to above, but supports parameterized constructors.
4. **Using `clone()` method:** Creates a copy of an existing object. Does *not* invoke any constructor.
5. **Using Deserialization:** Reconstructs an object from a byte stream. Does *not* invoke any constructor.

## 3. The `equals()` and `hashCode()` Contract

This is a critical interview topic, especially regarding Collections (like `HashMap`).

* If you override `equals()`, you **must** override `hashCode()`.
* **Rule 1:** If `obj1.equals(obj2)` is true, then `obj1.hashCode() == obj2.hashCode()` must be true.
* **Rule 2:** If two objects have the same `hashCode()`, they are *not* necessarily equal (this is called a Hash Collision).
* **Why?** Data structures like `HashMap` use the hash code to find the bucket location. If equal objects have different hash codes, the `HashMap` will lose your object!

## 4. Immutability

String is immutable, but how do you create your own? An immutable object's state cannot change after it is constructed.
**Rules for creating a strict Immutable Class:**

1. Declare the class as `final` so it cannot be extended (prevents subclasses from overriding methods to change behavior).
2. Make all fields `private` and `final`.
3. Do not provide "setter" methods.
4. **Crucial for 3+ YoE:** If the class contains mutable objects (like `Date`, `List`, or `HashMap`), you must perform **Deep Copying** in the constructor and getter methods to prevent the internal state from being modified externally.

## 5. Order of Initialization

Interviewers love giving snippets and asking for the exact output order. The standard execution order is:

1. **Static Variables and Static Initializer Blocks** (Execute once, when the class is loaded by the ClassLoader, in the order they appear).
2. **Instance Variables and Instance Initializer Blocks** (Execute every time an object is instantiated, before the constructor, in the order they appear).
3. **Constructor** (Executes last during object creation).
