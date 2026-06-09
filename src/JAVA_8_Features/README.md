# Java 8 Features - Interview Guide (For Experienced Developers)

Java 8 brought a massive paradigm shift by introducing functional programming concepts to Java. For experienced developers, interviews heavily focus on not just knowing *what* these features are, but *why* they are used, their internal workings, and practical use cases.

Here is a comprehensive list of the most frequently asked Java 8 interview topics and questions.

---

## 1. Lambda Expressions
**Core Concept:** A way to provide a clear and concise way to represent a method interface using an expression. It provides the implementation of a functional interface.
**Key Interview Focus:**
- How do Lambda expressions work internally? (Invokedynamic byte code instruction)
- Scope of variables in Lambda expressions (Effectively final requirement).
- Differences between Anonymous Inner Classes and Lambda Expressions.

## 2. Functional Interfaces (`@FunctionalInterface`)
**Core Concept:** An interface with exactly one abstract method (Single Abstract Method - SAM).
**Key Interview Focus:**
- Why use `@FunctionalInterface` annotation? Is it mandatory?
- Can a functional interface extend another interface?
- Can a functional interface have default and static methods?
- **Built-in Functional Interfaces (Crucial!):**
  - `Predicate<T>`: Takes an argument, returns a boolean (`test()`).
  - `Function<T, R>`: Takes an argument, returns a result (`apply()`).
  - `Consumer<T>`: Takes an argument, returns nothing (`accept()`).
  - `Supplier<T>`: Takes no argument, returns a result (`get()`).
  - *Bi-variants:* `BiPredicate`, `BiFunction`, `BiConsumer`.

## 3. Stream API (`java.util.stream`)
**Core Concept:** A sequence of elements supporting sequential and parallel aggregate operations. It's used to process collections of objects in a functional style.
**Key Interview Focus:**
- **Intermediate vs. Terminal Operations:**
  - *Intermediate:* `filter`, `map`, `flatMap`, `sorted`, `distinct` (Lazy evaluation).
  - *Terminal:* `collect`, `forEach`, `reduce`, `count`, `min`, `max`, `anyMatch`, `findFirst`.
- How does `map()` differ from `flatMap()`? (1-to-1 vs. 1-to-N mapping & flattening).
- Statefulness in Streams (e.g., `distinct`, `sorted` vs. `filter`, `map`).
- **Parallel Streams:** How do they work? (`ForkJoinPool`). When should you avoid parallel streams? (Thread overhead, stateful operations).
- **Collectors:** `Collectors.toList()`, `Collectors.groupingBy()`, `Collectors.partitioningBy()`, `Collectors.toMap()`.
- Short-circuiting operations in streams.

## 4. Default and Static Methods in Interfaces
**Core Concept:** Interfaces can now have method bodies. `default` for instance methods, `static` for utility methods.
**Key Interview Focus:**
- Why were default methods introduced? (To support backward compatibility for Collection API to support Lambda/Streams).
- **The Diamond Problem (Multiple Inheritance Issue):** What happens if a class implements two interfaces that have the same default method signature? How do you resolve it?
- Differences between an abstract class and an interface in Java 8.

## 5. Optional Class (`java.util.Optional`)
**Core Concept:** A container object which may or may not contain a non-null value, designed to prevent `NullPointerException`.
**Key Interview Focus:**
- When to use and when NOT to use `Optional` (e.g., avoid using it as a class field or method parameter; best used as a return type).
- `Optional.of()` vs `Optional.ofNullable()`.
- `orElse()` vs `orElseGet()` (Eager vs. Lazy evaluation).
- Chaining with `map()`, `flatMap()`, and `ifPresent()`.

## 6. Method References (`::` Operator)
**Core Concept:** Shorthand notation of a lambda expression to call a method.
**Key Interview Focus:**
- Types of Method References:
  1. Static method reference (`ClassName::methodName`)
  2. Instance method reference of a particular object (`instanceRef::methodName`)
  3. Instance method reference of an arbitrary object of a particular type (`ClassName::methodName`)
  4. Constructor reference (`ClassName::new`)

## 7. Date and Time API (`java.time` package)
**Core Concept:** A new, immutable, and thread-safe Date and Time API replacing the old `java.util.Date` and `Calendar`.
**Key Interview Focus:**
- Why was the old Date API replaced? (Mutable, not thread-safe, poor design).
- Usage of `LocalDate`, `LocalTime`, `LocalDateTime`, and `ZonedDateTime`.
- Differences between `Instant`, `Duration`, and `Period`.
- Formatting dates using `DateTimeFormatter`.

## 8. CompletableFuture (Concurrency API)
**Core Concept:** An extension to the `Future` API to support dependent functions and actions that trigger upon its completion.
**Key Interview Focus:**
- Differences between `Future` and `CompletableFuture`.
- Chaining async operations (`thenApply`, `thenAccept`, `thenRun`, `thenCompose`, `thenCombine`).
- Exception handling in CompletableFuture (`exceptionally`, `handle`).
- Which thread pool does `CompletableFuture.supplyAsync()` use by default? (ForkJoinPool.commonPool).

## 9. Miscellaneous / Other Features
- **StringJoiner:** How is it different from `StringBuilder`? (Convenient for adding prefixes, suffixes, and delimiters).
- **Collection API Improvements:** `forEach`, `removeIf`, `replace`, `replaceAll`, `Map.computeIfAbsent`, `Map.merge`.
- **Base64 Encoding/Decoding:** Now built into the standard library (`java.util.Base64`).
- **PermGen space removed:** Replaced by Metaspace.

---

## 💡 Top Coding Questions on Streams (Highly Asked)
1. Find the highest/second-highest salary of an employee from a list using Streams.
2. Group a list of objects by a specific property (e.g., group employees by department using `Collectors.groupingBy`).
3. Count the frequency of characters in a String using Streams.
4. Find duplicate elements in a List using Streams.
5. Sort a `Map` by its values.
6. Flatten a `List<List<Integer>>` using `flatMap`.
