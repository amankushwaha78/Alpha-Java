// File: _2_StringAdvanced_Core.java
// Topic: String Pool + Reference/Concat Rules (Context grouped)
// 🧠 Covers together: SCP vs Heap deep, compile-time vs runtime concat,
//                    final-variable optimization, intern(), == vs equals,
//                    reference-based interview traps.

public class _2_StringAdvanced_Core {
    public static void main(String[] args) {

        // =====================================================
        // 🧩 4️⃣ Compile-time vs Runtime Concatenation
        // =====================================================
        /*
           ✅ Compile-time (SCP):
              "Ja" + "va"  → compiler makes "Java" directly in SCP.

           ✅ Runtime (Heap):
              String a = "Ja";
              a + "va" → happens at runtime → new heap object.

           💡 So "same text" doesn't mean "same reference".
        */

        String c1 = "Java";
        String c2 = "Ja" + "va";       // compile-time
        String part = "Ja";
        String c3 = part + "va";       // runtime

        System.out.println(c1 == c2);          // true
        System.out.println(c1 == c3);          // false
        System.out.println(c1.equals(c3));     // true


        // =====================================================
        // 🧩 1️⃣ SCP (String Constant Pool) Deep Rules
        // =====================================================
        /*
           ✅ SCP stores ONLY:
              1) String literals
              2) intern() strings

           ✅ Same literal text → same SCP object reused.
           ✅ new String("X") always creates HEAP object.
        */

        String a1 = "Hello";          // SCP
        String a2 = "Hello";          // same SCP
        System.out.println(a1 == a2); // true

        String a3 = new String("Hello");  // HEAP new object
        System.out.println(a1 == a3);     // false
        System.out.println(a1.equals(a3));// true


        // =====================================================
        // 🧩 2️⃣ intern() — connect Heap to SCP
        // =====================================================
        /*
           ✅ intern() returns SCP reference of same content.
           ✅ If not present, it adds to SCP first.

           After intern():
              heapString.intern() == literal → true
        */

        String h = new String("HI");  // HEAP
        String i = h.intern();        // SCP
        String j = "HI";              // SCP literal

        System.out.println(i == j);   // true
        System.out.println(h == j);   // false


        // =====================================================
        // 🧩 4️⃣ final VARIABLE CONCAT OPTIMIZATION (kept with concat)
        // =====================================================
        /*
           ✅ If a variable is final + its value is known at compile time,
              compiler treats it like literal.

           So:
              final String fx = "Ja";
              fx + "va"
              → becomes compile-time concat → SCP.
        */

        final String fx = "Ja";
        String fy = fx + "va";          // compile-time because fx is final
        String fz = "Java";
        System.out.println(fy == fz);   // true


        // =====================================================
        // 🧩 5️⃣ == vs equals() (Reference vs Content)
        // =====================================================
        /*
           ✅ '==' → compares reference (address)
           ✅ equals() → compares content (characters)

           Always use equals() for value comparison.
        */

        String e1 = "Cat";                 // SCP
        String e2 = new String("Cat");     // HEAP

        System.out.println(e1 == e2);       // false
        System.out.println(e1.equals(e2));  // true


        // =====================================================
        // 🧩 6️⃣ Reference-based Interview Traps
        // =====================================================
        /*
           Trap A (compile-time):
              String t1 = "Java";
              String t2 = "Ja" + "va";
              t1 == t2 → true

           Trap B (runtime):
              String t3 = "Ja";
              String t4 = t3 + "va";
              t1 == t4 → false

           Fix:
              t1 == t4.intern() → true
        */

        String t1 = "Java";
        String t2 = "Ja" + "va";
        String t3 = "Ja";
        String t4 = t3 + "va";

        System.out.println(t1 == t2);          // true
        System.out.println(t1 == t4);          // false
        System.out.println(t1 == t4.intern()); // true


        // =====================================================
        // 🧠 QUICK REVISION (Core Context)
        // =====================================================
        /*
           🔹 SCP has literals + interned strings only.
           🔹 new String() always makes heap object.
           🔹 intern() returns SCP reference.
           🔹 Compile-time concat → SCP; runtime concat → HEAP.
           🔹 final literals enable compile-time concat.
           🔹 '==' reference compare; equals() content compare.
        */
    }
}
