## Types of HashMaps in Java

Here's an explanation of the different types of `HashMap` implementations in Java, focusing on their characteristics and use cases.

### 1. `java.util.HashMap`

This is the most commonly used implementation of the `Map` interface.

*   **Underlying Data Structure**: It's based on a hash table.
*   **Ordering**: The elements are **not** ordered. The iteration order can change over time as new elements are added.
*   **Keys and Values**: It allows one `null` key and multiple `null` values.
*   **Performance**: It offers constant-time performance, O(1), for basic operations like `get` and `put`, assuming the hash function disperses the elements properly among the buckets.
*   **Synchronization**: It is **not** synchronized. If multiple threads access a `HashMap` concurrently and at least one of them modifies the map structurally, it must be synchronized externally.

### 2. `java.util.LinkedHashMap`

This implementation extends `HashMap` and maintains a predictable iteration order.

*   **Underlying Data Structure**: It uses a hash table and a linked list running through all of its entries.
*   **Ordering**: It maintains the **insertion order** of the elements. When you iterate over a `LinkedHashMap`, the elements are returned in the order in which they were inserted.
*   **Keys and Values**: It also allows one `null` key and multiple `null` values.
*   **Performance**: It has slightly lower performance than `HashMap` for adding and removing elements due to the overhead of maintaining the linked list. However, iteration over a `LinkedHashMap` is faster than over a `HashMap`.
*   **Use Case**: It's useful when you need a map that preserves the order of insertion, such as for building caches with a "first-in, first-out" (FIFO) eviction policy.

### 3. `java.util.IdentityHashMap`

This is a more specialized implementation that violates the general contract of the `Map` interface by using reference equality instead of object equality when comparing keys.

*   **Underlying Data Structure**: It's also based on a hash table.
*   **Key Comparison**: It uses the `==` operator to compare keys, not the `.equals()` method. This means that two keys, `k1` and `k2`, are considered equal only if `(k1 == k2)`.
*   **Use Case**: It's useful when you need to distinguish between objects that are equal according to `.equals()` but are distinct instances. This is often used in scenarios like serialization, deep copying, or graph traversal where you need to keep track of object references.
*   **Performance**: It has similar performance characteristics to `HashMap`.

### 4. `java.util.WeakHashMap`

This implementation is designed to hold "weak" references to its keys.

*   **Underlying Data Structure**: It's a hash table where the keys are stored as `WeakReference` objects.
*   **Garbage Collection**: If a key in a `WeakHashMap` is no longer referenced anywhere else in the program, it becomes eligible for garbage collection. When the garbage collector reclaims the key, the entry in the `WeakHashMap` is removed.
*   **Use Case**: It's primarily used for building caches or registries where you don't want the map to prevent the keys from being garbage collected. This is useful for associating data with objects without creating memory leaks. For example, you can store metadata about an object in a `WeakHashMap`, and when the object is no longer in use, the metadata will be automatically removed.
*   **Key Comparison**: It uses the `.equals()` method to compare keys.
*   **Performance**: It has similar performance characteristics to `HashMap`.
