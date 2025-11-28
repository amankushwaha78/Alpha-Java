// File: _3_JavaArrayException.java
// Topic: Why Arrays Have No insert/delete + Manual Insert/Delete + Common Exceptions
// 🧠 Conceptual + Practical traps with proper explanation in comments

import java.util.Arrays;

public class _4_JavaArrayException {

    public static void main(String[] args) {

        // =====================================================
        // 🧩 1️⃣ Why Java Arrays DO NOT have insert() or delete()
        // =====================================================
        /*
           ✅ Arrays in Java are FIXED SIZE.
           ✅ Once created, size CANNOT be changed.

           That means:
           ❌ We cannot insert a new element.
           ❌ We cannot delete an existing element.
           ❌ We cannot grow or shrink the array.

           Because:
           ➤ Memory is allocated CONTIGUOUSLY.
           ➤ JVM cannot shift memory automatically after creation.

           ✅ This is why methods like:
              - insert()
              - delete()
              - remove()
           DO NOT EXIST for arrays.
        */


        // =====================================================
        // 🧩 2️⃣ UPDATE / REPLACE IS POSSIBLE IN ARRAY
        // =====================================================
        /*
           ✅ We CAN replace values using index.
           This is NOT insert or delete.
           It only MODIFIES existing element.
        */

        int[] updateArr = {10, 20, 30};
        updateArr[1] = 99;   // replace 20 with 99

        System.out.println(Arrays.toString(updateArr));
        // Output:
        // [10, 99, 30]


        // =====================================================
        // 🧩 3️⃣ MANUAL INSERT IN ARRAY (INTERVIEW LOGIC)
        // =====================================================
        /*
           Since array has no insert(),
           we create a NEW array with larger size,
           and SHIFT elements manually.
        */

        int[] original = {10, 20, 30};
        int insertIndex = 1;
        int insertValue = 99;

        int[] newArr = new int[original.length + 1];

        for (int i = 0, j = 0; i < newArr.length; i++) {
            if (i == insertIndex) {
                newArr[i] = insertValue;   // insert new value
            } else {
                newArr[i] = original[j++]; // shift old values
            }
        }

        System.out.println(Arrays.toString(newArr));
        // Output:
        // [10, 99, 20, 30]


        // =====================================================
        // 🧩 4️⃣ MANUAL DELETE IN ARRAY (INTERVIEW LOGIC)
        // =====================================================
        /*
           Since array has no delete(),
           we create a NEW array with smaller size,
           and SKIP the deleted index.
        */

        int[] deleteSource = {10, 20, 30, 40};
        int deleteIndex = 1;

        int[] deleteArr = new int[deleteSource.length - 1];

        for (int i = 0, j = 0; i < deleteSource.length; i++) {
            if (i != deleteIndex) {
                deleteArr[j++] = deleteSource[i];
            }
        }

        System.out.println(Arrays.toString(deleteArr));
        // Output:
        // [10, 30, 40]


        // =====================================================
        // 🧩 5️⃣ ArrayIndexOutOfBoundsException
        // =====================================================
        /*
           ❌ Happens when:
              index < 0
              OR
              index >= length

           JVM allows index range:
           0 → length-1 only
        */

        int[] bounds = {1, 2, 3};
        // System.out.println(bounds[5]); // ❌ Exception
        // ArrayIndexOutOfBoundsException


        // =====================================================
        // 🧩 6️⃣ NullPointerException with Arrays
        // =====================================================
        /*
           ❌ Happens when array reference is null
           and we try to access length or elements.
        */

        int[] nullArray = null;
        // System.out.println(nullArray.length); // ❌ Exception
        // NullPointerException


        // =====================================================
        // 🧩 7️⃣ Difference Between Array and ArrayList (Core Reason)
        // =====================================================
        /*
           ✅ Array:
              - Fixed size
              - Fast
              - No insert/delete
              - Stores primitives & objects

           ✅ ArrayList:
              - Dynamic size
              - Slower than array
              - Has insert(), delete(), remove()
              - Stores ONLY objects
        */


        // =====================================================
        // 🧠 FINAL QUICK REVISION
        // =====================================================
        /*
           🔹 Arrays are FIXED SIZE
           🔹 No insert(), no delete()
           🔹 Replace is allowed using index
           🔹 Insert/Delete require NEW array + loops
           🔹 Two main exceptions:
                - ArrayIndexOutOfBoundsException
                - NullPointerException
           🔹 Dynamic operations belong to ArrayList
        */

    }
}
