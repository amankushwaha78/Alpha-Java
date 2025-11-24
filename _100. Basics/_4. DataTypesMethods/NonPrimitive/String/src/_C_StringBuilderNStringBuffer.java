// File: _2_StringAdvanced.java
// Topic: Medium-level String Advanced Notes (Interview-ready)
// 🧠 Covers: StringBuilder vs String, StringBuffer, capacity, common methods,
//            compareTo, equalsIgnoreCase, split/replace/trim, valueOf,
//            compile-time vs runtime concatenation.

public class _C_StringBuilderNStringBuffer {
    public static void main(String[] args) {

        // =====================================================
        // 🧩 1️⃣ String vs StringBuilder vs StringBuffer
        // =====================================================
        /*
           ✅ String  → IMMUTABLE (cannot change). Every modification creates new object.
           ✅ StringBuilder → MUTABLE, faster, Single Threaded, NOT thread-safe.
           ✅ StringBuffer  → MUTABLE, slower, Multi Threaded, thread-safe (synchronized).

           💡 Use:
              - String → fixed text, few changes.
              - StringBuilder → many changes in single-threaded code (loops).
              - StringBuffer → many changes in multi-threaded code.
        */

        String s = "Aman";
        s.concat(" Kushwaha");          // creates new string but NOT stored
        System.out.println(s);          // Aman (unchanged)

        StringBuilder sb = new StringBuilder("Aman");
        sb.append(" Kushwaha");         // modifies same object
        System.out.println(sb);         // Aman Kushwaha

        StringBuffer sf = new StringBuffer("Hi");
        sf.append(" Aman");
        System.out.println(sf);         // Hi Aman


        // =====================================================
        // 🧩 2️⃣ StringBuilder Capacity Concept
        // =====================================================
        /*
           ✅ capacity() = total storage available inside builder.
           ✅ default capacity:
                new StringBuilder() → 16
                new StringBuilder("Aman") → 16 + length("Aman") = 20

           ✅ When capacity is full:
              newCapacity = oldCapacity*2 + 2
        */

        StringBuilder cap1 = new StringBuilder();
        System.out.println(cap1.capacity());     // 16

        StringBuilder cap2 = new StringBuilder("Aman");
        System.out.println(cap2.capacity());     // 20


        // =====================================================
        // 🧩 3️⃣ Important StringBuilder Methods
        // =====================================================
        /*
           append(x)   → add at end
           insert(i,x) → insert at index
           delete(s,e) → delete range s to e-1
           reverse()   → reverse content
           toString()  → convert builder to String
        */

        StringBuilder t = new StringBuilder("Java");
        t.append(" Dev");
        System.out.println(t);                  // Java Dev

        t.insert(4, "Script");
        System.out.println(t);                  // JavaScript Dev

        t.delete(4, 10);
        System.out.println(t);                  // Java Dev

        t.reverse();
        System.out.println(t);                  // veD avaJ

        String backToString = t.toString();
        System.out.println(backToString);       // veD avaJ

    }
}
