======================================================================
                  JAVA GENERICS: COMPLETE MASTER INDEX
======================================================================

1. Fundamentals of Generics
----------------------------------------------------------------------
  1.1 Motivation & History
      - Pre-Java 5 Collections (Object-based design)
      - The ClassCastException problem
      - Compile-time Type Safety vs. Runtime Casting
  1.2 Generic Classes & Interfaces
      - Syntax & standard Naming Conventions (T, E, K, V, N)
      - Creating custom Generic Classes
      - Implementing Generic Interfaces
  1.3 Generic Methods
      - Declaring type parameters on methods
      - Type Inference in generic methods
      - Static vs. Instance generic methods

2. Type Restrictions & Bounds
----------------------------------------------------------------------
  2.1 Primitive Types Restriction
      - Why primitives (int, char, double) aren't supported
      - Auto-boxing/unboxing with Wrapper Classes (Integer, Double)
  2.2 Upper Bounded Types (extends)
      - Restricting types with <T extends SuperClass>
      - Accessing superclass methods on bounded variables
  2.3 Multiple Bounds
      - Syntax: <T extends ClassA & InterfaceB & InterfaceC>
      - Rule: Class bound order priority over interfaces

3. Wildcards (?) & Subtyping
----------------------------------------------------------------------
  3.1 Subtyping in Generics (Invariance)
      - Why List<Integer> is NOT a List<Number>
  3.2 Unbounded Wildcards (<?>)
      - When to use <?> over raw types
      - Read/Write limitations with unbounded wildcards
  3.3 Upper Bounded Wildcards (? extends T)
      - Covariance in Java
      - Reading data safely (Producer pattern)
  3.4 Lower Bounded Wildcards (? super T)
      - Contravariance in Java
      - Writing/Adding data safely (Consumer pattern)
  3.5 The PECS Principle
      - Producer Extends, Consumer Super rule
  3.6 Wildcard Capture & Helper Methods
      - Understanding "Wildcard Capture"
      - Solving helper method compile errors with <?>

4. Compiler Internals: Type Erasure & Bytecode
----------------------------------------------------------------------
  4.1 How Type Erasure Works
      - Compile-time checks vs. Runtime bytecode representation
      - Type parameter erasure to Object vs. Upper Bound
  4.2 Compiler-Generated Bridge Methods
      - Synthetic methods created to preserve polymorphism after erasure
  4.3 Non-Reifiable Types & Reification
      - What makes a type "reifiable"
      - Why generic type information is lost at runtime
  4.4 Limitations Imposed by Erasure
      - Cannot instantiate generic types (new T())
      - Cannot instantiate generic arrays (new T[10] / new List<String>[10])
      - instanceof checks with generic types
      - Overloading conflicts due to identical erased signatures

5. Legacy Code Interoperability & Annotations
----------------------------------------------------------------------
  5.1 Raw Types
      - Using generics without type arguments (List vs. List<String>)
      - Backward compatibility with Java 1.4 code
      - Compiler warnings (-Xlint:unchecked)
  5.2 Heap Pollution & Varargs
      - What is Heap Pollution?
      - Combining generic varargs (T... args)
      - Using @SafeVarargs annotation
      - @SuppressWarnings("unchecked") vs @SafeVarargs

6. Advanced Patterns & Reflection
----------------------------------------------------------------------
  6.1 Generic Exceptions
      - Why generic exception classes (class MyException<T>) are illegal
      - Catching and throwing generic types
  6.2 Recursive Type Bounds
      - Self-referential bounds: <T extends Comparable<T>>
      - Understanding Enum<E extends Enum<E>>
  6.3 Type Tokens & Reflection
      - Class<T> as a runtime type token
      - Super Type Tokens / TypeToken<T> pattern (Guava/Gson approach)
      - Inspecting ParameterizedType via Reflection