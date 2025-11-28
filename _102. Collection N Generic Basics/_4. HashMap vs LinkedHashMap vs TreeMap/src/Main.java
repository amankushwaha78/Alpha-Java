// 📁 File: MapTypes.java
import java.util.*;

/**
 * 🧠 WHAT YOU’LL LEARN
 * ---------------------
 * 1️⃣ Difference between HashMap, LinkedHashMap, and TreeMap
 * 2️⃣ How they store and order key-value pairs
 * 3️⃣ When to use which one
 */

public class Main {
    public static void main(String[] args) {

        /**
         * ✅ 1️⃣ HASHMAP
         * ---------------
         * ✔️ Stores key-value pairs.
         * ✔️ Does NOT maintain any order.
         * ✔️ Fastest (based on hashing).
         * ✔️ Allows one null key and multiple null values.
         */
        Map<Integer, String> hashMap = new HashMap<>();
        hashMap.put(3, "Banana");
        hashMap.put(1, "Apple");
        hashMap.put(2, "Mango");
        hashMap.put(1, "Updated Apple"); // duplicate key → value replaced
        hashMap.put(null, "Null Key Allowed");

        System.out.println("HashMap: " + hashMap);

        /**
         * 💬 OUTPUT (order may vary):
         * HashMap: {null=Null Key Allowed, 1=Updated Apple, 2=Mango, 3=Banana}
         *
         * 🧠 EXPLANATION:
         * - No ordering (random arrangement).
         * - Duplicate keys not allowed (latest value replaces old one).
         * - One null key allowed.
         */


        /**
         * ✅ 2️⃣ LINKEDHASHMAP
         * ---------------------
         * ✔️ Maintains insertion order.
         * ✔️ Slightly slower than HashMap.
         * ✔️ Also allows one null key.
         */
        Map<Integer, String> linkedMap = new LinkedHashMap<>();
        linkedMap.put(3, "Banana");
        linkedMap.put(1, "Apple");
        linkedMap.put(2, "Mango");
        linkedMap.put(1, "Updated Apple");
        linkedMap.put(null, "Null Key Allowed");

        System.out.println("LinkedHashMap: " + linkedMap);

        /**
         * 💬 OUTPUT:
         * LinkedHashMap: {3=Banana, 1=Updated Apple, 2=Mango, null=Null Key Allowed}
         *
         * 🧠 EXPLANATION:
         * - Keeps the same order as inserted.
         * - Duplicate keys overwrite previous value.
         * - One null key allowed.
         */


        /**
         * ✅ 3️⃣ TREEMAP
         * ---------------
         * ✔️ Stores entries in sorted order (by key).
         * ✔️ Does NOT allow null keys (throws NullPointerException).
         * ✔️ Slower because it uses a Red-Black tree internally.
         */
        Map<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(3, "Banana");
        treeMap.put(1, "Apple");
        treeMap.put(2, "Mango");
        treeMap.put(4, "Orange");
        // treeMap.put(null, "Error"); ❌ Null key not allowed

        System.out.println("TreeMap: " + treeMap);

        /**
         * 💬 OUTPUT:
         * TreeMap: {1=Apple, 2=Mango, 3=Banana, 4=Orange}
         *
         * 🧠 EXPLANATION:
         * - Automatically sorts by key (ascending order).
         * - Null keys not allowed.
         * - Great for sorted key-value pairs.
         */


        /**
         * 🧠 QUICK SUMMARY
         * ----------------
         * ✅ HashMap → No order, fastest lookup.
         * ✅ LinkedHashMap → Maintains insertion order.
         * ✅ TreeMap → Sorted by key.
         */
    }
}


/**
 * 💡 COMPARISON TABLE
 * --------------------
 * | Feature              | HashMap                      | LinkedHashMap                 | TreeMap                     |
 * |----------------------|------------------------------|-------------------------------|------------------------------|
 * | Order Maintained?    | ❌ No order                  | ✅ Insertion order             | ✅ Sorted by key (ascending) |
 * | Duplicates (Keys)?   | ❌ No (replaces old value)   | ❌ No (replaces old value)     | ❌ No (replaces old value)   |
 * | Null Key Allowed?    | ✅ Yes (one)                 | ✅ Yes (one)                   | ❌ No                        |
 * | Null Values Allowed? | ✅ Yes                       | ✅ Yes                         | ✅ Yes                       |
 * | Underlying Structure | HashTable (Hashing)          | Linked HashTable              | Red-Black Tree              |
 * | Speed                | ⚡ Fastest                   | ⚡ Slightly Slower             | 🐢 Slow (Sorting overhead)   |
 * | Best Use Case        | Quick lookup                 | Keep insertion order          | Sorted key-value pairs       |
 */
