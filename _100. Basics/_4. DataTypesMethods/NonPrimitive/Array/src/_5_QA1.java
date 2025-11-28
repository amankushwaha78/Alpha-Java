// File: _4_Array_Interview_QA.java
// Topic: Java Array Interview-Based Questions & Answers (Conceptual)
// 🧠 NO output-guessing. Only real interview logic with clear explanation.

public class _5_QA1 {

    public static void main(String[] args) {

        // =====================================================
        // 🧩 Q1️⃣ What is an Array in Java?
        // =====================================================
        /*
           ✅ An Array is a non-primitive data structure.
           ✅ It stores multiple values of the SAME data type.
           ✅ Memory is allocated CONTIGUOUSLY.
           ✅ Size is FIXED at creation.
        */

        int[] arr = {10, 20, 30}; // example


        // =====================================================
        // 🧩 Q2️⃣ Why are Arrays FIXED in size?
        // =====================================================
        /*
           ✅ Because:
              - Memory is allocated as ONE continuous block.
              - JVM cannot increase or shrink that block later.

           ✅ If dynamic size is needed → Use ArrayList.
        */


        // =====================================================
        // 🧩 Q3️⃣ Difference between Array and ArrayList?
        // =====================================================
        /*
           ✅ Array:
              - Fixed size
              - Fast
              - Can store primitives + objects
              - No insert/delete methods

           ✅ ArrayList:
              - Dynamic size
              - Slower than array
              - Stores only objects
              - Has add(), remove(), set()
        */


        // =====================================================
        // 🧩 Q4️⃣ What is the default value of array elements?
        // =====================================================
        /*
           int     → 0
           double  → 0.0
           boolean → false
           char    → '\u0000'
           Object  → null
        */

        int[] a = new int[3]; // all values are 0 by default


        // =====================================================
        // 🧩 Q5️⃣ Difference between length and length()?
        // =====================================================
        /*
           ✅ Array → length (PROPERTY)
           ✅ String → length() (METHOD)

           Example:
              arr.length      ✅
              str.length()    ✅
        */


        // =====================================================
        // 🧩 Q6️⃣ What is a Shallow Copy vs Deep Copy in Arrays?
        // =====================================================
        /*
           ✅ Shallow Copy:
              - Reference is copied
              - Both variables point to SAME array

           ✅ Deep Copy:
              - New array is created
              - Data is copied separately
              - Both arrays are independent
        */

        int[] x = {10, 20};
        int[] y = x;        // shallow copy
        int[] z = x.clone(); // deep copy


        // =====================================================
        // 🧩 Q7️⃣ Can we store different data types in one array?
        // =====================================================
        /*
           ❌ NO — Java arrays are TYPE SAFE.
           ✅ Only same data type is allowed.

           Example:
              int[] arr = {1, 2, 3}; ✅
              int[] arr = {1, "A"}; ❌
        */


        // =====================================================
        // 🧩 Q8️⃣ What is a 2D Array?
        // =====================================================
        /*
           ✅ A 2D array is an "array of arrays".
           ✅ Rows can have:
              - Same size (matrix)
              - Different size (jagged array)
        */

        int[][] matrix = {
                {1, 2, 3},
                {4, 5}
        }; // jagged array


        // =====================================================
        // 🧩 Q9️⃣ What is ArrayIndexOutOfBoundsException?
        // =====================================================
        /*
           ❌ Occurs when:
              - index < 0
              - index >= array.length

           ✅ Legal range:
              0 to length-1
        */


        // =====================================================
        // 🧩 Q🔟 What is NullPointerException with Arrays?
        // =====================================================
        /*
           ❌ Occurs when:
              - Array reference is null
              - We try to access length or elements
        */

        int[] bad = null;
        // bad.length → ❌ NPE


        // =====================================================
        // 🧩 Q1️⃣1️⃣ Can we change the size of an array?
        // =====================================================
        /*
           ❌ NO, size of an array is FIXED.
           ✅ Only way → Create a NEW array & copy data.
        */


        // =====================================================
        // 🧩 Q1️⃣2️⃣ Difference between for-loop and for-each in arrays?
        // =====================================================
        /*
           ✅ for-loop:
              - Index based
              - Can update values
              - More control

           ✅ for-each:
              - Value based
              - Read-only for primitives
              - Cleaner syntax
        */


        // =====================================================
        // 🧩 Q1️⃣3️⃣ Can we insert or delete elements in array?
        // =====================================================
        /*
           ❌ NO direct insert() or delete() methods.
           ✅ Must create a NEW array and shift elements manually.
           ✅ For dynamic operations → use ArrayList.
        */


        // =====================================================
        // 🧩 Q1️⃣4️⃣ Difference between == and equals() in arrays?
        // =====================================================
        /*
           ✅ == compares memory reference.
           ✅ Arrays.equals() compares CONTENT.
        */

        int[] p = {1, 2};
        int[] q = {1, 2};

        // p == q         → false
        // Arrays.equals(p, q) → true


        // =====================================================
        // 🧩 Q1️⃣5️⃣ Can arrays store objects?
        // =====================================================
        /*
           ✅ YES
           ✅ Example:
              String[] names = {"Aman", "Rahul"};
              Integer[] nums = {1, 2, 3};
        */


        // =====================================================
        // 🧠 FINAL INTERVIEW REVISION
        // =====================================================
        /*
           🔹 Arrays are fixed size
           🔹 length is a PROPERTY
           🔹 Default values exist
           🔹 No insert/delete methods
           🔹 2D arrays can be jagged
           🔹 == compares reference, Arrays.equals compares content
           🔹 Shallow copy vs Deep copy is VERY important
           🔹 For dynamic size → Use ArrayList
        */

    }
}
