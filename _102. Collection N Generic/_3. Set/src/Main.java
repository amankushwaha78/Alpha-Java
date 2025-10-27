// 📁 File: SetTypes.java
import java.util.*;

/**
 * 🧠 WHAT YOU’LL LEARN
 * ---------------------
 * 1️⃣ Difference between HashSet, LinkedHashSet, and TreeSet
 * 2️⃣ How they handle order and uniqueness
 * 3️⃣ When to use which one
 */

public class Main {
    public static void main(String[] args) {

        /**
         * ✅ 1️⃣ HASHSET
         * ---------------
         * ✔️ No duplicate elements
         * ✔️ Does NOT maintain any order
         * ✔️ Fastest among all (uses HashMap internally)
         */
        Set<String> hashSet = new HashSet<>();
        hashSet.add("Banana");
        hashSet.add("Apple");
        hashSet.add("Mango");
        hashSet.add("Apple"); // duplicate ignored

        System.out.println("HashSet: " + hashSet);

        /**
         * 💬 OUTPUT (order may vary):
         * HashSet: [Mango, Apple, Banana]
         *
         * 🧠 EXPLANATION:
         * - Elements are stored using hash codes.
         * - Order of elements is unpredictable.
         * - Duplicates automatically removed.
         */


        /**
         * ✅ 2️⃣ LINKEDHASHSET
         * ---------------------
         * ✔️ No duplicate elements
         * ✔️ Maintains insertion order
         * ✔️ Slightly slower than HashSet (maintains linked list)
         */
        Set<String> linkedSet = new LinkedHashSet<>();
        linkedSet.add("Banana");
        linkedSet.add("Apple");
        linkedSet.add("Mango");
        linkedSet.add("Apple"); // duplicate ignored

        System.out.println("LinkedHashSet: " + linkedSet);

        /**
         * 💬 OUTPUT:
         * LinkedHashSet: [Banana, Apple, Mango]
         *
         * 🧠 EXPLANATION:
         * - Keeps elements in the same order you added them.
         * - Still removes duplicates.
         */


        /**
         * ✅ 3️⃣ TREESET
         * ---------------
         * ✔️ No duplicate elements
         * ✔️ Automatically sorts elements (natural order)
         * ✔️ Slowest (uses TreeMap internally)
         */
        Set<String> treeSet = new TreeSet<>();
        treeSet.add("Banana");
        treeSet.add("Apple");
        treeSet.add("Mango");
        treeSet.add("Apple"); // duplicate ignored

        System.out.println("TreeSet: " + treeSet);

        /**
         * 💬 OUTPUT:
         * TreeSet: [Apple, Banana, Mango]
         *
         * 🧠 EXPLANATION:
         * - Automatically sorts alphabetically.
         * - Duplicates not allowed.
         */


        /**
         * 🧠 QUICK SUMMARY
         * ----------------
         * ✅ HashSet → No order, fastest.
         * ✅ LinkedHashSet → Maintains insertion order.
         * ✅ TreeSet → Sorted order.
         */
    }
}


/**
 * 💡 COMPARISON TABLE
 * --------------------
 * | Feature              | HashSet                     | LinkedHashSet              | TreeSet                    |
 * |----------------------|-----------------------------|-----------------------------|-----------------------------|
 * | Order Maintained?    | ❌ No                       | ✅ Insertion Order          | ✅ Sorted (Ascending)       |
 * | Duplicates Allowed?  | ❌ No                       | ❌ No                       | ❌ No                       |
 * | Underlying Structure | HashMap                     | LinkedHashMap              | TreeMap                    |
 * | Speed                | ⚡ Fastest                  | ⚡ Slightly Slower          | 🐢 Slowest (Sorting)        |
 * | Null Allowed?        | ✅ Yes (one null)           | ✅ Yes (one null)           | ❌ No (throws NullPointer)  |
 * | Best Use Case        | Quick lookup                | Preserve insertion order    | Keep elements sorted        |
 */
