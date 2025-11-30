// File: _5_StringBuilder_StringBuffer_Interview_QA.java
// Topic: StringBuilder & StringBuffer Interview-Based Questions & Answers
// 🧠 Pure CONCEPTUAL file for interviews (No output guessing)

public class _8_StringBuilder_StringBuffer_Interview_QA {

    public static void main(String[] args) {

        // =====================================================
        // 🧩 Q1️⃣ Difference between String and StringBuilder?
        // =====================================================
        /*
           ✅ String:
              - IMMUTABLE
              - Every modification creates a NEW object
              - Slower for frequent changes

           ✅ StringBuilder:
              - MUTABLE
              - Modifies SAME object
              - Faster for frequent changes
        */


        // =====================================================
        // 🧩 Q2️⃣ Difference between StringBuilder and StringBuffer?
        // =====================================================
        /*
           ✅ StringBuilder:
              - NOT synchronized
              - NOT thread-safe
              - Faster
              - Used in single-threaded environment

           ✅ StringBuffer:
              - Synchronized
              - Thread-safe
              - Slower
              - Used in multi-threaded environment
        */


        // =====================================================
        // 🧩 Q3️⃣ Why is String immutable but StringBuilder mutable?
        // =====================================================
        /*
           ✅ String is immutable for:
              - Security
              - Thread safety
              - String Constant Pool (SCP) sharing
              - Hashing stability

           ✅ StringBuilder is mutable to:
              - Improve performance
              - Allow fast modifications in loops
        */


        // =====================================================
        // 🧩 Q4️⃣ Which is faster: StringBuilder or StringBuffer? Why?
        // =====================================================
        /*
           ✅ StringBuilder is FASTER
           Because:
              - It is NOT synchronized
              - No thread-safety overhead

           ✅ StringBuffer is SLOWER
           Because:
              - It uses synchronization (locks)
        */


        // =====================================================
        // 🧩 Q5️⃣ Is StringBuilder thread-safe?
        // =====================================================
        /*
           ❌ NO, StringBuilder is NOT thread-safe.
           ✅ If multiple threads modify same string → use StringBuffer.
        */


        // =====================================================
        // 🧩 Q6️⃣ What is synchronization in StringBuffer?
        // =====================================================
        /*
           ✅ Synchronization means:
              - Only ONE thread can access a method at a time.
              - Prevents data corruption in multi-threaded programs.
        */


        // =====================================================
        // 🧩 Q7️⃣ What is the default capacity of StringBuilder?
        // =====================================================
        /*
           ✅ Default capacity = 16

           If created using:
              new StringBuilder("Aman")
           Then capacity = 16 + length("Aman") = 20
        */


        // =====================================================
        // 🧩 Q8️⃣ What happens when StringBuilder capacity is full?
        // =====================================================
        /*
           ✅ A NEW bigger array is created.
           ✅ Old data is copied.
           ✅ New capacity formula:
              newCapacity = oldCapacity * 2 + 2
        */


        // =====================================================
        // 🧩 Q9️⃣ Difference between length() and capacity()?
        // =====================================================
        /*
           ✅ length()   → Number of characters currently stored
           ✅ capacity() → Internal storage limit before resizing
        */


        // =====================================================
        // 🧩 Q1️⃣0️⃣ Why StringBuilder is preferred inside loops?
        // =====================================================
        /*
           ✅ Because:
              - String → creates NEW object every time
              - StringBuilder → modifies SAME object
              - Avoids O(n²) performance problem
        */


        // =====================================================
        // 🧩 Q1️⃣1️⃣ Can StringBuilder be converted to String?
        // =====================================================
        /*
           ✅ YES.
           ✅ Using toString() method.
        */


        // =====================================================
        // 🧩 Q1️⃣2️⃣ Can String be converted to StringBuilder?
        // =====================================================
        /*
           ✅ YES.
           ✅ Using constructor:
              new StringBuilder("text")
        */


        // =====================================================
        // 🧩 Q1️⃣3️⃣ Does StringBuilder allow duplicate characters?
        // =====================================================
        /*
           ✅ YES.
           ✅ There is NO restriction on duplicate characters.
        */


        // =====================================================
        // 🧩 Q1️⃣4️⃣ Does StringBuilder allow null values?
        // =====================================================
        /*
           ✅ append(null) → Allowed
           ✅ It appends the STRING "null"
        */


        // =====================================================
        // 🧩 Q1️⃣5️⃣ Is StringBuilder faster than String concatenation?
        // =====================================================
        /*
           ✅ YES.
           ✅ Especially inside loops.
           ✅ Because:
              - No new objects are created repeatedly.
        */


        // =====================================================
        // 🧩 Q1️⃣6️⃣ Difference between append() and concat()?
        // =====================================================
        /*
           ✅ append() → Used with StringBuilder / StringBuffer
                         Modifies same object.

           ✅ concat() → Used with String
                         Creates NEW String object.
        */


        // =====================================================
        // 🧩 Q1️⃣7️⃣ Why StringBuffer is called legacy?
        // =====================================================
        /*
           ✅ Because:
              - It existed before StringBuilder.
              - It is slower due to synchronization.
              - Now mostly replaced by StringBuilder + explicit synchronization.
        */


        // =====================================================
        // 🧩 Q1️⃣8️⃣ Can we use StringBuilder as a key in HashMap?
        // =====================================================
        /*
           ❌ NOT recommended.
           Because:
              - StringBuilder is MUTABLE
              - Hashing requires IMMUTABLE keys
        */


        // =====================================================
        // 🧩 Q1️⃣9️⃣ Difference between replace() in String and StringBuilder?
        // =====================================================
        /*
           ✅ String.replace():
              - Returns a NEW String

           ✅ StringBuilder.replace():
              - Modifies SAME object
        */


        // =====================================================
        // 🧩 Q2️⃣0️⃣ When should you use:
        //           String vs StringBuilder vs StringBuffer?
        // =====================================================
        /*
           ✅ Use String when:
              - Data is fixed
              - Few modifications needed

           ✅ Use StringBuilder when:
              - Many modifications
              - Single-threaded environment

           ✅ Use StringBuffer when:
              - Many modifications
              - Multi-threaded environment
        */


        // =====================================================
        // 🧠 FINAL INTERVIEW REVISION
        // =====================================================
        /*
           🔹 String is immutable, StringBuilder & StringBuffer are mutable
           🔹 StringBuilder is faster than StringBuffer
           🔹 StringBuffer is thread-safe
           🔹 StringBuilder is NOT thread-safe
           🔹 capacity grows as (old * 2 + 2)
           🔹 StringBuilder is best choice for loops
           🔹 StringBuilder should NOT be used as HashMap key
        */

    }
}
