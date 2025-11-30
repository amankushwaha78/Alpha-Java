// File: _2_StringPool_Concat_Intern.java
// Topic: String Pool + Concatenation Rules + intern() + final optimization
// 🧠 All "reference / SCP based" interview logic lives here.

public class _2_StringAdvanced_Core {
    public static void main(String[] args) {
        // =====================================================
        // 🧩 1️⃣ SCP (String Constant Pool) Deep Rules
        // =====================================================
        /*
           ✅ SCP stores:
              1) String literals
              2) Strings returned by intern()

           ✅ SCP stores ONLY literals + interned strings.
           ✅ If literal already exists → SAME reference reused.
           ✅ Heap strings are NOT in SCP unless intern() called.
        */

        String a1 = "Hello";          // SCP
        String a2 = "Hello";          // same SCP
        System.out.println(a1 == a2); // true

        String a3 = new String("Hello");        // heap
        System.out.println(a1 == a3);          // false
        System.out.println(a1 == a3.intern()); // true (heap moved/linked to SCP)

        // =====================================================
        // 🧩 6️⃣ intern() — Beginner Overview
        // =====================================================
        /*
           ✔ intern() moves string to SCP from HEAP if not present
           ✔ returns the SCP reference

           📌 Why useful?
              To make two same strings share same reference.

           If SCP already has it → return same SCP ref.
           Else → add to SCP and return that.

           So heapString.intern() == literal → true
        */

        String h = new String("HI"); // heap
        String i = h.intern();       // SCP ref
        String j = "HI";             // SCP literal

        System.out.println(i == j);  // true
        System.out.println(h == j);  // false


        // =====================================================
        // 🧩 3️⃣ Compile-time vs Runtime Concatenation
        // =====================================================
        /*
           ✅ Compile-time concat:
              "Ja" + "va"
              → compiler merges at compile time
              → final result stored in SCP.

           ✅ Runtime concat:
              String part="Ja";
              part + "va"
              → happens during runtime
              → new heap object created.

           SAME text, but different references.
        */

        String c1 = "Java";
        String c2 = "Ja" + "va";      // compile-time → SCP
        String part = "Ja";
        String c3 = part + "va";      // runtime → heap

        System.out.println(c1 == c2);  // true
        System.out.println(c1 == c3);  // false
        System.out.println(c1.equals(c3)); // true


        // =====================================================
        // 🧩 2️⃣ Compile-time Optimization with final variables
        // =====================================================
        /*
           ✅ If variables are final and known at compile-time,
              concatenation may become compile-time and go to SCP.

           Example:
              final String x = "Ja";
              String y = x + "va";   → compiler makes "Java" in SCP
        */

        final String fx = "Ja";
        String fy = fx + "va";           // compile-time because fx is final
        String fz = "Java";
        System.out.println(fy == fz);    // true


        // =====================================================
        // 🧩 5️⃣ Classic Interview Trap Set
        // =====================================================
        /*
           Case A (compile-time):
              t1 == t2 → true

           Case B (runtime):
              t1 == t4 → false

           Fix:
              intern() to bring runtime string into SCP.
        */

        String t1 = "Java";
        String t2 = "Ja" + "va";     // compile-time (SCP)
        String t3 = "Ja";
        String t4 = t3 + "va";       // runtime ( HEAP )

        System.out.println(t1 == t2);          // true
        System.out.println(t1 == t4);          // false
        System.out.println(t1 == t4.intern()); // true
    }
}
