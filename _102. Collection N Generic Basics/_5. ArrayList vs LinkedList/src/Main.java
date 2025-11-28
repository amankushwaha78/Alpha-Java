// 📁 File: ArrayListVsLinkedList.java
import java.util.*;

/**
 * 🧠 WHAT YOU’LL LEARN
 * ---------------------
 * 1️⃣ Difference between ArrayList and LinkedList
 * 2️⃣ How they store data internally
 * 3️⃣ When to use which one
 */

public class Main {
    public static void main(String[] args) {

        /**
         * ✅ 1️⃣ ARRAYLIST
         * -----------------
         * ✔️ Backed by a **dynamic array**.
         * ✔️ Fast random access (index-based).
         * ✔️ Slower at insertion/removal in the middle.
         * ✔️ Best for "read-heavy" operations.
         */
        List<String> arrayList = new ArrayList<>();
        arrayList.add("Aman");
        arrayList.add("Kushwaha");
        arrayList.add("Frontend Engineer");

        System.out.println("ArrayList: " + arrayList);

        /**
         * 💬 OUTPUT:
         * ArrayList: [Aman, Kushwaha, Frontend Engineer]
         *
         * 🧠 EXPLANATION:
         * - Uses a resizable array.
         * - When full, it creates a new bigger array and copies data.
         * - Access by index is very fast (O(1)).
         * - Removing or inserting in middle is slower (O(n)).
         */


        /**
         * ✅ 2️⃣ LINKEDLIST
         * -----------------
         * ✔️ Backed by a **doubly linked list**.
         * ✔️ Fast insertion/removal (especially at start/middle).
         * ✔️ Slower random access (no index-based storage).
         * ✔️ Best for "insert/delete-heavy" operations.
         */
        List<String> linkedList = new LinkedList<>();
        linkedList.add("Aman");
        linkedList.add("Kushwaha");
        linkedList.add("Backend Enthusiast");

        System.out.println("LinkedList: " + linkedList);

        /**
         * 💬 OUTPUT:
         * LinkedList: [Aman, Kushwaha, Backend Enthusiast]
         *
         * 🧠 EXPLANATION:
         * - Uses nodes connected by links.
         * - Each node stores data + address of next/previous node.
         * - Insertion/removal in middle is fast (no shifting).
         * - Access by index is slow (must traverse nodes).
         */


        /**
         * 🧠 QUICK PERFORMANCE NOTES
         * --------------------------
         * ✅ ArrayList → Fast lookup, slow insertion/removal.
         * ✅ LinkedList → Fast insertion/removal, slow lookup.
         *
         * Example Time Complexities:
         * | Operation           | ArrayList | LinkedList |
         * |---------------------|------------|-------------|
         * | get(index)          | O(1)       | O(n)        |
         * | add(element) end    | O(1)*      | O(1)        |
         * | add/remove middle   | O(n)       | O(1)*       |
         * | search element      | O(n)       | O(n)        |
         * (* = amortized / depends on position)
         */
    }
}


/**
 * 💡 COMPARISON TABLE
 * --------------------
 * | Feature                | ArrayList                      | LinkedList                     |
 * |------------------------|--------------------------------|--------------------------------|
 * | Data Structure Used    | Dynamic Array                  | Doubly Linked List             |
 * | Index Access Speed     | ⚡ Fast (O(1))                 | 🐢 Slow (O(n))                 |
 * | Insertion/Removal      | 🐢 Slow (needs shifting)       | ⚡ Fast (just re-link nodes)   |
 * | Memory Usage           | 🔸 Less                        | 🔸 More (extra node pointers)  |
 * | Best For               | Frequent reading/accessing     | Frequent insertion/deletion    |
 * | Maintains Order?       | ✅ Yes                         | ✅ Yes                         |
 * | Allows Duplicates?     | ✅ Yes                         | ✅ Yes                         |
 */
