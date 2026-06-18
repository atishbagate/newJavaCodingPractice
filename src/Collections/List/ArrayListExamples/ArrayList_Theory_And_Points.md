# ArrayList in Java: Theory and Key Points

An `ArrayList` in Java is one of the most widely used data structures. It is a part of the Java Collections Framework (introduced in Java 1.2) and implements the `List` interface.

---

## Theory & Internal Working

An `ArrayList` is essentially a **resizable array** (also called a dynamic array).

**1. Internal Array:**
Under the hood, an `ArrayList` uses a standard primitive array (e.g., `Object[] elementData`) to store its elements.

**2. Dynamic Resizing (The Magic):**
Standard Java arrays have a fixed size. `ArrayList` solves this by automatically managing its size.
* When you create an `ArrayList` (without specifying a capacity), it typically starts with an initial capacity of `10`.
* As you add elements, it keeps track of its `size` (how many elements are actually in it) versus its `capacity` (the length of the underlying array).
* **When it gets full:** If you try to add an element and the internal array is full, the `ArrayList` will:
   1. Create a **new, larger array** (typically 1.5x the size of the old one in modern Java: `oldCapacity + (oldCapacity >> 1)`).
   2. **Copy** all elements from the old array to the new array (using `Arrays.copyOf()`).
   3. Add the new element.
   4. The old array is eventually garbage collected.

**3. Performance (Time Complexity):**
* **Access (Get): `O(1)`** - Because it uses an array internally, it has direct index-based access. Fetching the 100th element is just as fast as fetching the 1st.
* **Add (End of list): `O(1)` amortized** - Usually, adding is instant. But occasionally, it triggers a resize, which takes `O(n)`. On average (amortized), it's considered `O(1)`.
* **Insert/Delete (Middle of list): `O(n)`** - If you insert or remove an element in the middle (or beginning), all subsequent elements must be shifted one position to the right (for insertion) or left (for deletion). This is slow.

---

## Important Points to Remember

**1. It is NOT Thread-Safe**
* `ArrayList` is not synchronized. If multiple threads access an `ArrayList` concurrently, and at least one modifies it, you will likely get unpredictable behavior or a `ConcurrentModificationException`.
* *Solution:* If you need thread safety, use `Collections.synchronizedList(new ArrayList<>())` or (better yet) `CopyOnWriteArrayList`.

**2. It Allows Duplicates & Nulls**
* You can add the exact same object multiple times.
* You can add `null` values as many times as you want.

**3. It Maintains Insertion Order**
* Elements are always kept in the exact order you added them. It does not sort them automatically.

**4. It only stores Objects (References)**
* An `ArrayList` cannot store primitives like `int`, `double`, or `char`.
* Instead, it uses their Wrapper classes (`Integer`, `Double`, `Character`). Java's Autoboxing/Unboxing handles the conversion automatically, but be aware that this adds a slight performance/memory overhead compared to primitive arrays.

**5. Fail-Fast Iterators**
* The iterators returned by `ArrayList` (via `.iterator()` or enhanced for-loops) are **fail-fast**.
* This means if you structurally modify the list (add or remove elements) *while* iterating over it (unless you use the `Iterator.remove()` method itself), it will immediately throw a `ConcurrentModificationException`.

**6. The `trimToSize()` method**
* If you have a massive `ArrayList` that you've removed many items from, the underlying array might still be huge, wasting memory. You can call `myList.trimToSize()` to shrink the capacity of the underlying array to exactly match the current number of elements.

---

## When to use `ArrayList` vs `LinkedList`?

* **Use `ArrayList` when:** You do a lot of data retrieval/reading (`get(index)`) and most of your additions are at the end of the list.
* **Use `LinkedList` when:** You rarely read via index, but you do a massive amount of inserting or deleting in the *middle* or *beginning* of the list (since LinkedLists don't require shifting elements).