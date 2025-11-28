// File: _4_ArrayList_Interview_QA.java
// Topic: ArrayList Interview-Based Questions & Answers (Conceptual)
// 🧠 Pure theory + explanations for strong interview answers

import java.util.ArrayList;

public class _4_ArrayList_Interview_QA {

    public static void main(String[] args) {

        // =====================================================
        // 🧩 Q1️⃣ What is ArrayList?
        // =====================================================
        /*
           ✅ ArrayList is a part of the Java Collections Framework.
           ✅ It implements the List interface.
           ✅ It is a RESIZABLE (dynamic) array.
           ✅ It maintains insertion order.
           ✅ It allows duplicate values.
        */


        // =====================================================
        // 🧩 Q2️⃣ Is ArrayList part of the Collection interface?
        // =====================================================
        /*
           ✅ YES.
           ✅ ArrayList implements List.
           ✅ List extends Collection.
           ✅ So ArrayList IS-A Collection.
        */


        // =====================================================
        // 🧩 Q3️⃣ Difference between Array and ArrayList?
        // =====================================================
        /*
           ✅ Array:
              - Fixed size
              - Stores primitives & objects
              - Faster
              - NOT part of Collections

           ✅ ArrayList:
              - Dynamic size
              - Stores only objects
              - Slower than array
              - Part of Collections
        */


        // =====================================================
        // 🧩 Q4️⃣ Why does ArrayList store only Objects?
        // =====================================================
        /*
           ✅ Java Collections Framework is designed to work with OBJECTS.
           ✅ Primitive data types are converted using WRAPPER classes.

           Example:
              int    → Integer
              double → Double
              char   → Character
        */


        // =====================================================
        // 🧩 Q5️⃣ Does ArrayList allow duplicate values?
        // =====================================================
        /*
           ✅ YES.
           ✅ ArrayList allows duplicates because it follows List rules.
        */


        // =====================================================
        // 🧩 Q6️⃣ Does ArrayList allow null values?
        // =====================================================
        /*
           ✅ YES.
           ✅ It allows MULTIPLE null values.
        */


        // =====================================================
        // 🧩 Q7️⃣ Does ArrayList maintain insertion order?
        // =====================================================
        /*
           ✅ YES.
           ✅ It stores elements in the same order in which they are added.
        */


        // =====================================================
        // 🧩 Q8️⃣ Is ArrayList synchronized or thread-safe?
        // =====================================================
        /*
           ❌ NO.
           ✅ ArrayList is NOT thread-safe.

           ✅ For thread safety, use:
              - Collections.synchronizedList()
              - CopyOnWriteArrayList
        */


        // =====================================================
        // 🧩 Q9️⃣ What is the default capacity of ArrayList?
        // =====================================================
        /*
           ✅ Default initial capacity = 10.
           ✅ When capacity is full, it grows automatically.

           Growth formula (approximately):
              newCapacity = oldCapacity * 1.5
        */


        // =====================================================
        // 🧩 Q1️⃣0️⃣ Difference between size() and capacity?
        // =====================================================
        /*
           ✅ size()     → Number of elements present.
           ✅ capacity() → Internal storage size.

           ❌ capacity() method is NOT directly available.
        */


        // =====================================================
        // 🧩 Q1️⃣1️⃣ Difference between get() and set()?
        // =====================================================
        /*
           ✅ get(index) → Used to READ element.
           ✅ set(index,value) → Used to REPLACE element.
        */


        // =====================================================
        // 🧩 Q1️⃣2️⃣ Difference between add() and set()?
        // =====================================================
        /*
           ✅ add() → Inserts a new element.
           ✅ set() → Replaces an existing element.
        */


        // =====================================================
        // 🧩 Q1️⃣3️⃣ Difference between remove(index) and remove(Object)?
        // =====================================================
        /*
           ✅ remove(index)       → Removes by POSITION.
           ✅ remove(Object)      → Removes by VALUE.

           ❗ Very important trap in ArrayList<Integer>.
        */


        // =====================================================
        // 🧩 Q1️⃣4️⃣ What is ConcurrentModificationException?
        // =====================================================
        /*
           ❌ Occurs when:
              - We modify an ArrayList while iterating using for-each loop.

           ✅ How to avoid:
              - Use Iterator.remove()
              - Use normal for-loop
        */


        // =====================================================
        // 🧩 Q1️⃣5️⃣ Why ArrayList delete operation is slow?
        // =====================================================
        /*
           ✅ Internally, ArrayList uses a DYNAMIC ARRAY.
           ✅ When an element is deleted:
              - All right-side elements are SHIFTED LEFT.
           ❌ This shifting makes delete slow in middle.
        */


        // =====================================================
        // 🧩 Q1️⃣6️⃣ Can we store mixed data types in ArrayList?
        // =====================================================
        /*
           ✅ YES, using ArrayList<Object>.
           ❌ But NOT recommended in real projects.
        */


        // =====================================================
        // 🧩 Q1️⃣7️⃣ Difference between ArrayList and Vector?
        // =====================================================
        /*
           ✅ ArrayList:
              - NOT thread-safe
              - Faster
              - Modern class

           ✅ Vector:
              - Thread-safe (synchronized)
              - Slower
              - Legacy class
        */


        // =====================================================
        // 🧩 Q1️⃣8️⃣ Difference between ArrayList and LinkedList?
        // =====================================================
        /*
           ✅ ArrayList:
              - Uses dynamic array
              - Fast random access
              - Slow insert/delete in middle

           ✅ LinkedList:
              - Uses doubly linked list
              - Slow random access
              - Fast insert/delete in middle
        */


        // =====================================================
        // 🧩 Q1️⃣9️⃣ Can ArrayList store primitives?
        // =====================================================
        /*
           ❌ NO.
           ✅ Only OBJECTS are allowed.
           ✅ Primitives are auto-boxed into wrapper classes.
        */


        // =====================================================
        // 🧩 Q2️⃣0️⃣ When should you prefer ArrayList?
        // =====================================================
        /*
           ✅ When:
              - You need dynamic size
              - You need index-based access
              - You need ordered data
              - You have frequent read operations
        */


        // =====================================================
        // 🧠 FINAL INTERVIEW REVISION (ArrayList)
        // =====================================================
        /*
           🔹 ArrayList is part of Collections (List)
           🔹 Dynamic size
           🔹 Allows duplicates & nulls
           🔹 Maintains insertion order
           🔹 Stores only objects
           🔹 Not thread-safe
           🔹 remove(index) vs remove(Object) is a BIG trap
           🔹 Delete in middle is slow due to shifting
           🔹 For dynamic + indexed data → use ArrayList
        */

    }
}
