📖 HashSet in Java: Theory and Internal Working
1. What is HashSet? A HashSet is a class in the Java Collections Framework that implements the Set interface. It is designed to store an unordered collection of unique elements, meaning no duplicates are allowed
.
Order: It does not maintain any insertion or sorting order. Elements are placed into "buckets" using a hashing technique, so they are returned in a random order when iterated
.
Null Values: It permits at most one null element
.
Performance: It provides constant-time O(1) performance for basic operations like add, remove, contains, and size, assuming the hash function distributes elements properly
.
Thread Safety: HashSet is not synchronized (not thread-safe). If it is modified concurrently by multiple threads, it will throw a ConcurrentModificationException because its iterators are "fail-fast"
.
Capacity: It has a default initial capacity of 16 and a default load factor of 0.75 (75%)
.
2. How HashSet Works Internally The most important thing to know about HashSet is that it internally uses a HashMap to store its elements
.
When you instantiate a HashSet, a backing HashMap instance is automatically created
. Because a HashMap stores data in key-value pairs and fundamentally prohibits duplicate keys, HashSet leverages this feature to maintain its own rule of uniqueness.
Here is the step-by-step breakdown of how it works:
The Dummy Value (PRESENT): Since a Map requires both a key and a value, HashSet uses the element you want to add as the "key". For the "value", it uses a constant, dummy Object called PRESENT
. It is defined internally like this: private static final Object PRESENT = new Object();
The add(E e) Method: When you call add("Java"), the HashSet internally calls the put() method on its backing HashMap: map.put("Java", PRESENT)
.
Handling Duplicates: The HashMap.put(key, value) method returns null if the key was not already in the map, or it returns the old value if the key already existed
. Therefore, the HashSet's add method simply checks: return map.put(e, PRESENT) == null;
. If this returns true, the element was successfully added. If it returns false, the element was a duplicate and was ignored
.
💼 Top HashSet Interview Questions
Based on the sources, here are the most important interview questions regarding HashSet:
Q1: What is the underlying data structure of a HashSet? Answer: The underlying data structure of a HashSet is a HashMap (which is internally backed by a Hash Table). When a HashSet is created, a HashMap object is instantiated to hold the data
.
Q2: How does HashSet guarantee that it only stores unique elements? Answer: A HashSet stores its elements as the "keys" in its internal HashMap, while using a constant dummy object named PRESENT as the "value"
. Because HashMap does not allow duplicate keys, any attempt to add a duplicate element simply overwrites the existing key with the same PRESENT value, effectively preventing duplicates in the HashSet
.
Q3: What happens if we attempt to add an element to a HashSet that already exists? Answer: The HashSet simply ignores the new element. The internal map.put(key, value) call will return the existing PRESENT object rather than null. Consequently, the add() method will return false, and no exception will be thrown
.
Q4: Why doesn't the HashSet class have a get(Object o) method? Answer: Because HashSet uses a HashMap internally where the elements are the keys, calling a traditional get(key) method would simply return the value associated with that key, which is just the dummy PRESENT object
. Therefore, retrieving specific objects directly isn't supported; you must iterate through the entire set using an Iterator or a for-each loop to access the elements
.
Q5: What are the initial default capacity and load factor of a HashSet? Answer: The initial default capacity is 16, and the default load factor is 0.75 (meaning the internal structure will resize itself when it is 75% full)
.
Q6: What happens if we try to remove an element from a Set that does not exist? Answer: The remove(Object o) method will simply return false. It does not throw an exception
.
Q7: Which is faster: HashSet, LinkedHashSet, or TreeSet? Answer: HashSet is the fastest among the three, providing O(1) constant-time performance for basic operations
. LinkedHashSet is slightly slower because it has to additionally maintain a doubly-linked list to preserve insertion order
. TreeSet is the slowest, with O(log n) time complexity, because it must continually sort elements using a Red-Black tree
.