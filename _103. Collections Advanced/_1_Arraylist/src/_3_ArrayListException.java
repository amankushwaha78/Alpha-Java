// File: _3_ArrayListException.java
// Topic: ArrayList Exceptions, Traps & Internal Behavior
// 🧠 Insert/Delete errors, index errors, null traps, concurrent modification

import java.util.ArrayList;
import java.util.Iterator;

public class _3_ArrayListException {

    public static void main(String[] args) {

        // =====================================================
        // 🧩 1️⃣ IndexOutOfBoundsException in ArrayList
        // =====================================================
        /*
           ❌ Happens when:
              - index < 0
              - index >= list.size()

           ✅ Valid index range:
              0 to size-1
        */

        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);

        // System.out.println(list.get(5));   // ❌ IndexOutOfBoundsException
        // list.remove(3);                    // ❌ IndexOutOfBoundsException


        // =====================================================
        // 🧩 2️⃣ NullPointerException with ArrayList
        // =====================================================
        /*
           ❌ Happens when:
              - Reference itself is null
           ✅ Storing null inside list is allowed
        */

        ArrayList<String> names = null;
        // names.add("Aman");   // ❌ NullPointerException

        ArrayList<String> ok = new ArrayList<>();
        ok.add(null);          // ✅ allowed
        ok.add("Aman");
        System.out.println(ok);


        // =====================================================
        // 🧩 3️⃣ remove(index) vs remove(Object) Trap
        // =====================================================
        /*
           In ArrayList<Integer>:

           remove(1)        → removes index 1 ❗
           remove(Integer) → removes value 1 ✅

           This is a VERY COMMON interview trap.
        */

        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(10);
        nums.add(20);
        nums.add(30);

        nums.remove(1);  // removes ELEMENT at index 1 → removes 20
        System.out.println(nums); // [10, 30]

        nums.remove(Integer.valueOf(10)); // removes VALUE 10
        System.out.println(nums); // [30]


        // =====================================================
        // 🧩 4️⃣ ConcurrentModificationException
        // =====================================================
        /*
           ❌ Happens when:
              - We MODIFY the list while iterating using for-each loop.

           ✅ Solutions:
              - Use Iterator.remove()
              - Use a normal for-loop
        */

        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(2);
        list2.add(3);

        // ❌ This will throw ConcurrentModificationException
        /*
        for (Integer x : list2) {
            if (x == 2) {
                list2.remove(x);   // ❌ modifying while iterating
            }
        }
        */

        // ✅ Correct way using Iterator
        Iterator<Integer> it = list2.iterator();
        while (it.hasNext()) {
            Integer val = it.next();
            if (val == 2) {
                it.remove(); // ✅ safe removal
            }
        }

        System.out.println(list2); // [1, 3]


        // =====================================================
        // 🧩 5️⃣ Why remove() during loop shifts elements
        // =====================================================
        /*
           ✅ ArrayList internally uses ARRAY.
           ✅ When an element is removed:
              - All right-side elements are SHIFTED LEFT.
              - This makes remove from middle SLOW.
        */


        // =====================================================
        // 🧩 6️⃣ Heterogeneous Data Trap
        // =====================================================
        /*
           ✅ ArrayList<Object> allows mixed data.
           ❌ But causes ClassCastException if not handled properly.
        */

        ArrayList<Object> mixed = new ArrayList<>();
        mixed.add(10);
        mixed.add("Aman");

        // Integer v = (Integer) mixed.get(1); // ❌ ClassCastException


        // =====================================================
        // 🧩 7️⃣ Capacity vs Size
        // =====================================================
        /*
           ✅ size()     → number of elements
           ✅ capacity() → internal storage size (not directly accessible)

           Default capacity = 10
        */


        // =====================================================
        // 🧩 8️⃣ Why ArrayList is NOT Thread-Safe
        // =====================================================
        /*
           ✅ Multiple threads can modify it at same time.
           ❌ This may cause data inconsistency.
           ✅ For thread safety → use:
              - Collections.synchronizedList()
              - CopyOnWriteArrayList
        */


        // =====================================================
        // 🧠 FINAL QUICK REVISION
        // =====================================================
        /*
           🔹 IndexOutOfBoundsException for wrong index
           🔹 NullPointerException if reference is null
           🔹 remove(index) vs remove(Object) is a BIG trap
           🔹 ConcurrentModificationException during for-each delete
           🔹 ArrayList shifting makes delete slow
           🔹 ArrayList is NOT thread-safe
        */

    }
}
