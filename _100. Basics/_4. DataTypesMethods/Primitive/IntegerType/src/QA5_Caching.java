// File: _QA5_WrapperCachingAndComparison.java
// 🎯 Topic: Wrapper Class Caching (Integer/Long/Short/Byte) & Comparison Pitfalls
// 🧠 Key rules:
//   • Autoboxing uses value caches for small values.
//   • Integer/Long/Short/Byte cache by default for [-128, 127] (Character caches [0,127]).
//   • `==` compares object references; `equals()` compares numeric value.
//   • Always use equals() (or compare/compareTo) for wrapper value comparison.

public class QA5_Caching {
    public static void main(String[] args) {

        System.out.println("🚀 QA5 — Wrapper Caching & == vs equals()\n");

        // =====================================================
        // 🧩 1️⃣ Integer cache demo (default: -128..127)
        // =====================================================
        Integer i1 = 127, i2 = 127;                   // autoboxed, inside cache
        System.out.println("1) Integer 127 == 127 → " + (i1 == i2));   // true (same cached ref)

        Integer i3 = 128, i4 = 128;                   // autoboxed, outside cache
        System.out.println("2) Integer 128 == 128 → " + (i3 == i4));   // false (different objects)
        System.out.println("3) Integer 128 equals()  → " + i3.equals(i4)); // true (same numeric value)

        // 💡 Note: Integer cache range can be extended via JVM flag:
        //     -XX:AutoBoxCacheMax=VALUE
        // but don’t assume this in interviews—stick with [-128,127].

        // =====================================================
        // 🧩 2️⃣ Long / Short / Byte have similar caches
        //     (Long/Short: [-128,127], Byte: entire range is cached)
        // =====================================================
        Long l1 = 127L, l2 = 127L;                    // inside cache
        System.out.println("4) Long 127 == 127   → " + (l1 == l2));     // true

        Long l3 = 128L, l4 = 128L;                    // outside cache
        System.out.println("5) Long 128 == 128   → " + (l3 == l4));     // false
        System.out.println("6) Long 128 equals() → " + l3.equals(l4));  // true

        Short s1 = 127, s2 = 127;                     // inside cache
        System.out.println("7)  Short 127 == 127 → " + (s1 == s2));     // true

        Byte b1 = 127, b2 = 127;                      // Byte range is -128..127 and fully cached
        System.out.println("8)  Byte 127 == 127  → " + (b1 == b2));     // true

        // =====================================================
        // 🧩 3️⃣ The new-operator breaks caching (ALWAYS distinct objects)
        // =====================================================
        Integer ni1 = new Integer(127);   // ❌ never do this in real code; deprecated style
        Integer ni2 = new Integer(127);
        System.out.println("9)  new Integer(127) == new Integer(127) → " + (ni1 == ni2)); // false
        System.out.println("10) new Integer(127).equals(...)        → " + ni1.equals(ni2)); // true

        // =====================================================
        // 🧩 4️⃣ Mixed-type == promotes to primitives (can surprise you)
        // =====================================================
        Integer I = 128;      // object
        int     p = 128;      // primitive
        System.out.println("11) Integer(128) == 128 (primitive) → " + (I == p));
        // 💡 Here I is auto-unboxed to int → compares as ints → true

        // =====================================================
        // 🧩 5️⃣ Null-unboxing pitfall (classic interview gotcha)
        // =====================================================
        try {
            Integer maybeNull = null;
            // int k = maybeNull;  // ❌ NullPointerException on unboxing
            // Uncommenting above line will throw NPE. Safe way:
            int k = (maybeNull != null) ? maybeNull : 0;
            System.out.println("12) Safe unboxing with null guard → " + k);
        } catch (Exception e) {
            System.out.println("12) NPE during unboxing: " + e);
        }

        // =====================================================
        // 🧩 6️⃣ Always prefer equals()/compare() for wrappers
        // =====================================================
        Long L3 = 128L, L4 = 128L;
        System.out.println("13) Long.equals(128,128) → " + L3.equals(L4)); // true
        System.out.println("14) Long == (128,128)    → " + (L3 == L4));    // false

        // Also valid and handy in sorting/comparators:
        System.out.println("15) Integer.compare(5, 9)   → " + Integer.compare(5, 9));   // -1
        System.out.println("16) Long.compare(10L, 10L)  → " + Long.compare(10L, 10L));  // 0
        System.out.println("17) Short.compare((short)7, (short)2) → " + Short.compare((short)7, (short)2)); // 1

        // =====================================================
        // 🧾 Takeaways (talk-track)
        // =====================================================
        /*
           ✅ Autoboxing uses small-value caches: Integer/Long/Short in [-128..127], Byte entire range, Character [0..127].
           ✅ `==` compares references for wrappers. It’s only true within cache OR when the same object.
           ✅ `equals()` compares numeric values — always use for wrapper comparison.
           ✅ `new` always creates a new object (bypasses cache) → `==` is false.
           ✅ Watch for null-unboxing → can throw NPE.
           ✅ Mixed `wrapper == primitive` unboxes the wrapper → compares primitives.
        */

        System.out.println("\n🎯 QA5 complete — caching & comparison rules nailed!");
    }
}


// =====================================================
// 🧩 7️⃣ equals() vs '==' — VERY IMPORTANT INTERVIEW NOTE
// =====================================================
        /*
           ⚖️ Difference between '==' and equals() in Java

           🔹 '==' → Reference comparison (memory address)
               - Checks whether both references point to the *same object*.
               - Works for both primitives and objects, but behaves differently:

                 ➤ For primitives → compares actual value.
                      int a = 5, b = 5;
                      System.out.println(a == b); // true ✅

                 ➤ For objects (like Integer, String, etc.) → compares references.
                      Integer x = 128, y = 128;
                      System.out.println(x == y); // false ❌ (different objects) || outside cache
                      System.out.println(x.equals(y)); // true ✅ (same numeric value)

           🔹 equals() → Value comparison (content)
               - Defined in Object class and overridden in wrappers, Strings, etc.
               - Compares internal *data* rather than memory reference.

           💡 Wrapper Caching makes '==' tricky:
              Integer/Long/Short cache values from [-128, 127].
              So within that range:
                 Integer a = 127, b = 127;
                 System.out.println(a == b);     // true ✅ (same cached reference)
              But outside range:
                 Integer c = 128, d = 128;
                 System.out.println(c == d);     // false ❌ (new objects)
              Use equals() ALWAYS for numeric comparison of wrappers.

           💬 Interview talk-track:
              "In Java, '==' checks if two references point to the same object,
               while equals() checks if two objects have the same content.
               For primitives, '==' compares values directly; for objects, use equals()."
        */
