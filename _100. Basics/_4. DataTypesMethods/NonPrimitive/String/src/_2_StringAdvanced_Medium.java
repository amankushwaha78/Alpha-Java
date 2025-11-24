// File: _2_StringAdvanced.java
// Topic: Medium-level String Advanced Notes (Interview-ready)
// 🧠 Covers: StringBuilder vs String, StringBuffer, capacity, common methods,
//            compareTo, equalsIgnoreCase, split/replace/trim, valueOf,
//            compile-time vs runtime concatenation.

public class _2_StringAdvanced_Medium {
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


        // =====================================================
        // 🧩 5️⃣ compareTo() (Lexicographic Compare)
        // =====================================================
        /*
           compareTo():
              returns 0  → equal
              returns <0 → this string smaller
              returns >0 → this string bigger
           ✅ Comparison is based on Unicode values character by character.
        */

        System.out.println("abc".compareTo("abc"));  // 0
        System.out.println("abc".compareTo("abd"));  // -1  (c < d)
        System.out.println("abd".compareTo("abc"));  // 1   (d > c)


        // =====================================================
        // 🧩 6️⃣ equalsIgnoreCase()
        // =====================================================
        /*
           equalsIgnoreCase() compares content ignoring case.
        */

        System.out.println("Java".equalsIgnoreCase("java")); // true
        System.out.println("Java".equals("java"));           // false


        // =====================================================
        // 🧩 7️⃣ split() and replace()
        // =====================================================
        /*
           split(regex):
              breaks string by delimiter into array.

           replace(old, new):
              replaces all occurrences (no regex)

           replaceAll(regex, new):
              regex-based replacement
        */

        String line = "a,b,c";
        String[] arr = line.split(",");
        System.out.println(arr.length);     // 3
        System.out.println(arr[0]);         // a
        System.out.println(arr[1]);         // b
        System.out.println(arr[2]);         // c

        String r1 = "ha ha ha".replace("ha", "ho");
        System.out.println(r1);            // ho ho ho

        String r2 = "A1B2C3".replaceAll("\\d", "_");
        System.out.println(r2);            // A_B_C_


        // =====================================================
        // 🧩 8️⃣ trim(), isEmpty(), isBlank()
        // =====================================================
        /*
           trim() → removes leading/trailing spaces only.

           isEmpty() → true if length == 0
           isBlank() (Java 11+) → true if only whitespace
        */

        String sp = "   Aman   ";
        System.out.println(sp.trim());          // "Aman"

        System.out.println("".isEmpty());       // true
        System.out.println("   ".isEmpty());    // false
        System.out.println("   ".isBlank());    // true


        // =====================================================
        // 🧩 9️⃣ valueOf() (Convert primitives to String)
        // =====================================================
        /*
           String.valueOf(x) converts any primitive to String.
           ✅ safe alternative to + "".
        */

        int num = 10;
        boolean flag = true;
        float f = 2.5f;

        System.out.println(String.valueOf(num));   // "10"
        System.out.println(String.valueOf(flag));  // "true"
        System.out.println(String.valueOf(f));     // "2.5"


        // =====================================================
        // 🧠 QUICK MEDIUM-LEVEL REVISION
        // =====================================================
        /*
           🔹 String = immutable, literals in SCP.
           🔹 StringBuilder = mutable, fast, single-thread use.
           🔹 StringBuffer  = mutable, thread-safe, slower.
           🔹 capacity() default 16 (+length if initialized with text).
           🔹 append/insert/delete/reverse are key builder ops.
           🔹 "A"+"B" compile-time → SCP; var+"B" runtime → heap.
           🔹 compareTo() lexicographic, equalsIgnoreCase() ignores case.
           🔹 split() uses regex delimiter; replaceAll() is regex-based.
           🔹 trim() removes outer spaces; isBlank() checks whitespace-only.
           🔹 String.valueOf() converts primitives to String safely.
        */
    }
}
