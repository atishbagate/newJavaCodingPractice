# Java Streams: Core Concepts for Interviews

This guide provides a concise overview of the Java Stream API, focusing on the foundational knowledge needed for technical interviews.

---

### 1. What is a Stream?

A Stream is a **sequence of elements** from a source that supports **aggregate operations**. It is not a data structure that stores data;
 instead, it carries values from a source (like a `Collection`, an array, or an I/O channel) through a pipeline of computational steps.

**Key Characteristics:**
- **Not a Data Structure:** A stream doesn't store its elements.
- **Doesn't Modify the Source:** Performing operations on a stream does not modify its source data (e.g., filtering a `List` creates
a new stream without changing the original `List`).
- **Lazy Evaluation:** Intermediate operations are not executed until a terminal operation is invoked. This allows for significant performance optimizations.
- **Single-Use:** A stream can only be traversed once. After a terminal operation is called, the stream is considered "consumed" and cannot be reused.

---

### 2. The Stream Pipeline

A stream pipeline consists of three parts:

1.  **Source:** Where the stream originates from (e.g., `List.stream()`, `Arrays.stream()`).
2.  **Intermediate Operations (0 or more):** These are operations that transform a stream into another stream. They are always lazy.
3.  **Terminal Operation (1):** This operation produces a result or a side-effect. It triggers the processing of the stream.

```java
List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

List<String> filteredNames = names.stream() // 1. Source
    .filter(name -> name.startsWith("A"))    // 2. Intermediate Operation
    .map(String::toUpperCase)                // 2. Intermediate Operation
    .collect(Collectors.toList());           // 3. Terminal Operation
```

---

### 3. Intermediate Operations

These operations return a `Stream`, allowing them to be chained together.

| Operation | Description | Example |
|-----------|-------------|---------|
| `filter(Predicate)` | Returns a stream consisting of elements that match the given predicate. | `s.filter(n -> n > 10)` |
| `map(Function)` | Returns a stream consisting of the results of applying the given function to the elements. (Transforms each element). | `s.map(String::toUpperCase)` |
| `flatMap(Function)` | Transforms each element into a stream of other objects and then "flattens" all the generated streams into a single stream. Useful for nested lists. | `s.flatMap(list -> list.stream())` |
| `distinct()` | Returns a stream with unique elements (according to `equals()`). | `s.distinct()` |
| `sorted()` | Returns a stream with elements sorted in natural order. | `s.sorted()` |
| `sorted(Comparator)` | Returns a stream with elements sorted according to the provided `Comparator`. | `s.sorted(Comparator.reverseOrder())` |
| `skip(n)` | Discards the first `n` elements of the stream. | `s.skip(2)` |
| `limit(n)` | Truncates the stream to be no longer than `n` in length. | `s.limit(5)` |

---

### 4. Terminal Operations

These operations produce a final result and close the stream.

| Operation | Description | Return Type |
|-----------|-------------|-------------|
| `forEach(Consumer)` | Performs an action for each element. | `void` |
| `collect(Collector)` | Performs a mutable reduction to accumulate elements into a `Collection`, `Map`, etc. Extremely versatile. | Varies (`List`, `Map`, etc.) |
| `reduce()` | Performs a reduction on the elements, using an associative accumulation function, and returns an `Optional` result. | `Optional<T>` or `T` |
| `count()` | Returns the count of elements in the stream. | `long` |
| `anyMatch(Predicate)` | Checks if at least one element matches the predicate. | `boolean` |
| `allMatch(Predicate)` | Checks if all elements match the predicate. | `boolean` |
| `noneMatch(Predicate)`| Checks if no elements match the predicate. | `boolean` |
| `findFirst()` | Returns the first element of the stream. | `Optional<T>` |
| `findAny()` | Returns any element of the stream (useful in parallel streams). | `Optional<T>` |

---

### 5. The `Collectors` Utility Class

The `Collectors` class provides a wide range of static factory methods for creating `Collector` instances, which are used with the `collect()` terminal operation.

**Common Collectors:**
- `toList()`: Collects elements into a `List`.
- `toSet()`: Collects elements into a `Set`.
- `toMap(keyMapper, valueMapper)`: Collects elements into a `Map`.
- `joining(delimiter)`: Joins `String` elements into a single string.
- `counting()`: Counts the number of elements.
- `groupingBy(classifier)`: Groups elements into a `Map` based on a classification function. This is one of the most powerful collectors.
- `groupingBy(classifier, downstream)`: Groups elements and then performs a downstream collection on the values in each group (e.g., counting, summing, or finding the max in each group).
- `partitioningBy(predicate)`: A special case of `groupingBy` that splits elements into a `Map<Boolean, List<T>>` based on a predicate.

---

### 6. A Note on Parallel Streams

You can process a stream in parallel by calling the `.parallelStream()` method on a source or `.parallel()` on an existing stream.

- **When to use:** Use parallel streams for very large datasets where the processing of each element is independent and computationally expensive.
- **Caveats:** Be cautious with shared state. Parallel streams are not always faster due to the overhead of thread management. Always measure performance before and after.

```java
long count = myList.parallelStream()
                   .filter(e -> e.getSalary() > 100000)
                   .count();
```
