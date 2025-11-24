// File: _1_StringAndWrapperNotes.java
// Topic: String (non-primitive) + memory (SCP/Heap) + immutability + inbuilt methods + intern() + tricky interview cases
// 🧠 String is the MOST asked non-primitive topic in Java interviews.

public class _0_StringAndWrapperNotes {
    public static void main(String[] args) {

        // =====================================================
        // 🧩 1️⃣ What is String?
        // =====================================================
        /*
           ✅ String is a CLASS in java.lang package.
           ✅ Non-primitive, stored as an object in HEAP memory.
           ✅ But String literals are stored in a special pool called:
              👉 String Constant Pool (SCP) / String Intern Pool
           ✅ String is IMMUTABLE (cannot be changed after creation).
        */

        // Example (literal)
        String s1 = "Aman";         // goes to SCP
        String s2 = "Aman";         // reuses same SCP object
        System.out.println(s1);     // Aman
        System.out.println(s2);     // Aman


        // =====================================================
        // 🧩 2️⃣ String Memory: SCP vs Heap
        // =====================================================
        /*
           🔹 Case A: Literal
              String a = "Java";
              → "Java" stored in SCP.
              → If already in SCP, reference reused.

           🔹 Case B: new String()
              String b = new String("Java");
              → creates a NEW object in HEAP ALWAYS.
              → even if SCP has "Java", heap object is separate.

           🧠 Diagram:
              SCP:  ["Java"]  <--- a , c
              HEAP: [new "Java"] <--- b
        */

        String a = "Java";                 // SCP
        String c = "Java";                 // same SCP object
        String b = new String("Java");     // HEAP new object

        System.out.println(a == c);        // true  (same SCP reference)
        System.out.println(a == b);        // false (SCP vs HEAP)
        System.out.println(a.equals(b));   // true  (same content)


        // =====================================================
        // 🧩 3️⃣ Why String is IMMUTABLE?
        // =====================================================
        /*
           ✅ Security:
              String is used in class loading, file paths, URLs.
              If mutable, hackers could change paths at runtime.

           ✅ SCP Sharing:
              Many references share same SCP object.
              If one changes it, all will change → bug.
              Immutability prevents this.

           ✅ Thread-safe by default:
              Multiple threads can read same String safely.

           ✅ Hashing / Map keys:
              HashCode of String is cached.
              If value changed, hash breaks map.
        */

        String x = "Hello";
        x.concat(" World"); // creates NEW string, doesn't change x
        System.out.println(x); // Hello


        // =====================================================
        // 🧩 4️⃣ Concatenation Rules (+)
        // =====================================================
        /*
           ✔ Because String is immutable, '+' always creates NEW object.

           🔹 Compile-time optimization:
              "A" + "B" + "C"
              → compiler makes it "ABC" directly in SCP.

           🔹 Runtime concatenation:
              String p = "A";
              String q = p + "B"; // happens at runtime → new heap object

           ⚠️ For loops → use StringBuilder for performance.
        */

        String p1 = "A" + "B";      // compile-time → "AB" in SCP
        String p2 = "A";
        String p3 = p2 + "B";       // runtime → new heap object
        System.out.println(p1);     // AB
        System.out.println(p3);     // AB


        // =====================================================
        // 🧩 5️⃣ intern() — VERY IMPORTANT
        // =====================================================
        /*
           ✔ intern() returns SCP reference.
           ✔ If SCP doesn't contain the string, it gets added.

           Example:
              String h = new String("HI"); // heap object
              String i = h.intern();       // SCP
              String j = "HI";             // SCP

              i == j → true
              h == j → false
        */

        String h = new String("HI");    // HEAP
        String i = h.intern();          // SCP
        String j = "HI";                // SCP

        System.out.println(i == j);    // true
        System.out.println(h == j);    // false


        // =====================================================
        // 🧩 6️⃣ == vs equals()
        // =====================================================
        /*
           ✔ '==' compares memory reference (SCP vs heap)
           ✔ equals() compares character CONTENT
        */

        String e1 = "Cat";
        String e2 = new String("Cat");

        System.out.println(e1 == e2);       // false
        System.out.println(e1.equals(e2));  // true


        // =====================================================
        // 🧩 7️⃣ Common Inbuilt Methods
        // =====================================================
        /*
           length()      → count
           charAt(i)     → char
           substring()   → slice
           indexOf()     → search
           trim()        → remove spaces
           replace()     → replace chars
           split()       → break by regex
           toLowerCase() / toUpperCase()
           startsWith() / endsWith()
        */

        String m = "  Aman Kushwaha  ";
        System.out.println(m.length());            // includes spaces
        System.out.println(m.trim());              // "Aman Kushwaha"
        System.out.println(m.trim().length());     // without spaces
        System.out.println(m.charAt(2));           // 'A'
        System.out.println(m.contains("Aman"));    // true


        // =====================================================
        // 🧩 8️⃣ StringBuilder — Mutable Alternative
        // =====================================================
        /*
           ✔ StringBuilder is MUTABLE (faster for repeated changes).
        */

        StringBuilder sb = new StringBuilder("Aman");
        sb.append(" Kushwaha");
        System.out.println(sb.toString()); // Aman Kushwaha


        // =====================================================
        // 🧩 9️⃣ Tricky Interview Outputs
        // =====================================================
        /*
           Case 1:
               String t1 = "Java";
               String t2 = "Ja" + "va";
               t1 == t2 → true  (compile-time)

           Case 2:
               String t3 = "Ja";
               String t4 = t3 + "va";
               t1 == t4 → false (runtime)

           ✔ Fix:
               t1 == t4.intern() → true
        */

        String t1 = "Java";
        String t2 = "Ja" + "va";
        String t3 = "Ja";
        String t4 = t3 + "va";

        System.out.println(t1 == t2);           // true
        System.out.println(t1 == t4);           // false
        System.out.println(t1 == t4.intern());  // true


        // =====================================================
        // 🧩 🔟 Null + String Concatenation
        // =====================================================
        /*
           ✔ null + "A" → "nullA"
           ✔ But null.length() → NullPointerException
        */

        String z = null;
        System.out.println(z + "A");  // nullA
        // System.out.println(z.length()); // ❌ NPE


        // =====================================================
        // 🧠 FINAL QUICK REVISION
        // =====================================================
        /*
           🔹 String literal → SCP
           🔹 new String() → heap
           🔹 String is immutable
           🔹 '+' creates new String
           🔹 intern() returns SCP object
           🔹 '==' compares reference
           🔹 equals() compares content
           🔹 StringBuilder = mutable & fast
        */
    }
}
