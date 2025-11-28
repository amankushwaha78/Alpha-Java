// File: _1_ArrayBasics.java
// Topic: Core Array Concepts (Beginner → Interview Level)
// 🧠 Only CONCEPTS, no utility methods here

public class _2_ArrayConcepts {

    public static void main(String[] args) {

        // =====================================================
        // 🧩 1️⃣ What is an Array?
        // =====================================================
        /*
           ✔ Array is a NON-PRIMITIVE data structure
           ✔ It stores MULTIPLE values of SAME type
           ✔ Memory is CONTIGUOUS (continuous)
           ✔ Size is FIXED after creation
           ✔ Index starts from 0
        */

        int[] arr = {10, 20, 30};
        System.out.println(arr[0]); // 10


        // =====================================================
        // 🧩 2️⃣ Array Declaration vs Initialization
        // =====================================================
        /*
           ✅ Declaration → only reference created
           ✅ Initialization → memory allocated
        */

        int[] a;          // declaration only
        a = new int[3];   // initialization

        System.out.println(a[0]); // 0 (default value)


        // =====================================================
        // 🧩 3️⃣ Default Values in Arrays
        // =====================================================
        /*
           int     → 0
           double  → 0.0
           boolean → false
           char    → '\u0000'
           Object  → null
        */

        boolean[] flags = new boolean[2];
        System.out.println(flags[0]); // false


        // =====================================================
        // 🧩 4️⃣ Fixed Size Nature of Array
        // =====================================================
        /*
           ❌ Size CANNOT be changed once created
           ✅ If you want dynamic → use ArrayList
        */

        int[] fixed = new int[3];
        // fixed[3] = 100; // ❌ ArrayIndexOutOfBoundsException


        // =====================================================
        // 🧩 5️⃣ length vs length()
        // =====================================================
        /*
           ✅ Array → length (PROPERTY)
           ✅ String → length() (METHOD)
        */

        int[] nums = {1, 2, 3, 4};
        System.out.println(nums.length); // 4


        // =====================================================
        // 🧩 6️⃣ Reference Copy vs Real Copy
        // =====================================================
        /*
           ✅ Reference copy → both variables point to SAME array
           ✅ Real copy → new independent array
        */

        int[] x = {10, 20};
        int[] y = x;          // reference copy
        y[0] = 99;

        System.out.println(x[0]); // 99 (changed!)

        int[] z = x.clone(); // real copy
        z[0] = 100;

        System.out.println(x[0]); // 99 (unchanged now)
        System.out.println(z[0]); // 100


        // =====================================================
        // 🧩 7️⃣ 2D Array Concept
        // =====================================================
        /*
           ✅ 2D array = array of arrays
           ✅ Can be JAGGED (rows of different length)
        */

        int[][] matrix = new int[2][];
        matrix[0] = new int[3]; // row 1 has 3 cols
        matrix[1] = new int[1]; // row 2 has 1 col

        System.out.println(matrix[0].length); // 3
        System.out.println(matrix[1].length); // 1


        // =====================================================
        // 🧩 8️⃣ for-each Loop Limitation
        // =====================================================
        /*
           ❌ You CANNOT modify actual values using for-each
           ✅ It is READ-ONLY for primitives
        */

        int[] data = {1, 2, 3};
        for (int v : data) {
            v = 100; // ❌ does NOT change original array
        }

        System.out.println(data[0]); // 1 (unchanged)


        // =====================================================
        // 🧩 9️⃣ Common Array Exceptions
        // =====================================================
        /*
           ❌ ArrayIndexOutOfBoundsException → wrong index
           ❌ NullPointerException → array reference is null
        */

        // int[] bad = null;
        // System.out.println(bad.length); // ❌ NPE


        // =====================================================
        // 🧠 Quick Revision (Concepts)
        // =====================================================
        /*
           🔹 Array = fixed size
           🔹 Contiguous memory
           🔹 Default values exist
           🔹 length is property
           🔹 2D arrays can be jagged
           🔹 for-each is read-only
        */
    }
}
