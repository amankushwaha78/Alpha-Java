// 📁 File: ListSetMap.java
import java.util.*;

/**
 * 🧠 WHAT YOU’LL LEARN
 * ---------------------
 * 1️⃣ Difference between List, Set, and Map
 * 2️⃣ When to use each one
 * 3️⃣ Simple examples with outputs
 */

public class Main {
    public static void main(String[] args) {

        /**
         * ✅ 1️⃣ LIST
         * ------------
         * ✔️ Allows duplicate elements
         * ✔️ Maintains insertion order
         * ✔️ Access elements by index
         * Common classes: ArrayList, LinkedList
         */
        List<String> list = new ArrayList<>();
        list.add("Aman");
        list.add("Kushwaha");
        list.add("Aman"); // duplicate allowed

        System.out.println("List: " + list);

        /**
         * 💬 OUTPUT:
         * List: [Aman, Kushwaha, Aman]
         *
         * 🧠 EXPLANATION:
         * - Duplicates are allowed.
         * - Elements are stored in order of insertion.
         */


        /**
         * ✅ 2️⃣ SET
         * -----------
         * ✔️ Does NOT allow duplicate elements
         * ✔️ No index-based access
         * ✔️ May or may not maintain order (depends on implementation)
         * Common classes: HashSet, LinkedHashSet, TreeSet
         */
        Set<String> set = new HashSet<>();
        set.add("Aman");
        set.add("Kushwaha");
        set.add("Aman"); // duplicate ignored

        System.out.println("Set: " + set);

        /**
         * 💬 OUTPUT (order may vary):
         * Set: [Kushwaha, Aman]
         *
         * 🧠 EXPLANATION:
         * - Only unique elements stored.
         * - No duplicates.
         * - HashSet does not guarantee order.
         */


        /**
         * ✅ 3️⃣ MAP
         * -----------
         * ✔️ Stores data as key-value pairs
         * ✔️ Keys are unique; values can repeat
         * ✔️ No index; you use keys to access values
         * Common classes: HashMap, LinkedHashMap, TreeMap
         */
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Aman");
        map.put(2, "Kushwaha");
        map.put(1, "Updated Aman"); // duplicate key → replaces value

        System.out.println("Map: " + map);

        /**
         * 💬 OUTPUT:
         * Map: {1=Updated Aman, 2=Kushwaha}
         *
         * 🧠 EXPLANATION:
         * - Keys must be unique.
         * - If a key already exists, its value is replaced.
         * - Values can be duplicated.
         */


        /**
         * 🧠 QUICK SUMMARY
         * ----------------
         * ✅ List → ordered, allows duplicates, index-based.
         * ✅ Set  → unique elements, no index.
         * ✅ Map  → key-value pairs, keys unique.
         */
    }
}


/**
 * 💡 COMPARISON TABLE
 * --------------------
 * | Feature             | List                        | Set                        | Map (Key-Value)             |
 * |---------------------|-----------------------------|-----------------------------|-----------------------------|
 * | Duplicates Allowed? | ✅ Yes                      | ❌ No                       | ❌ Keys No, ✅ Values Yes    |
 * | Order Maintained?   | ✅ Yes                      | Depends on type             | Depends on type             |
 * | Access Method       | Index-based                | Iterator                   | Key-based                   |
 * | Example Class       | ArrayList, LinkedList       | HashSet, TreeSet            | HashMap, LinkedHashMap      |
 * | Best For            | Ordered data with duplicates | Unique items               | Pairing key → value         |
 */
