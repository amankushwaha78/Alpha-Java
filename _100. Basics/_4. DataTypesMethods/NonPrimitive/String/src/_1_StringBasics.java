// File: _1_StringBasics.java
// Topic: Basic & essential String concepts for beginners
// 🧠 Simple, clean, easy-to-remember notes for fast revision

public class _1_StringBasics {
    public static void main(String[] args) {

        // =====================================================
        // 🧩 1️⃣ What is String?
        // =====================================================
        /*
           ✔ String is a CLASS (non-primitive)
           ✔ Stored in HEAP as an object (like any other class)
           ✔ BUT string literals are stored separately in SCP ( String Constant Pool )
           ✔ String is IMMUTABLE → once created, cannot be changed

           📌 IMMUTABLE means:
              If we modify a String, a NEW object is created.
        */

        String name = "Aman"; // literal → stored in SCP
        System.out.println(name); // Aman


        // =====================================================
        // 🧩 2️⃣ SCP vs HEAP (Beginner-friendly)
        // =====================================================
        /*
           🔸 SCP (String Constant Pool)
              → Special memory area inside HEAP
              → Stores only literal strings
              → Reuses existing literals to save memory

           🔸 Heap
              → All objects are created here
              → new String("X") ALWAYS creates a NEW object

           📌 Comparison Rules:
              s1 == s2   → compares memory address (reference comparison)
              s1.equals(s2) → compares characters (content comparison)
        */

        String s1 = "Java";            // stored in SCP
        String s2 = "Java";            // reused from SCP
        String s3 = new String("Java"); // NEW object created in HEAP

        System.out.println(s1 == s2);      // true   (same SCP)
        System.out.println(s1 == s3);      // false  (SCP vs heap)
        System.out.println(s1.equals(s3)); // true   (same content)

        // =====================================================
        // 🧩 3️⃣ Why String is immutable?
        // =====================================================
        /*
           1) ✔ Security
                 Strings store file paths, DB URLs, class names.
                 If mutable → hackers can change values.

           2) ✔ SCP sharing
                 Many variables point to same object in SCP.
                 If string was mutable → all would change.

           3) ✔ Thread-safety
                 Immutable objects are automatically thread-safe.

           4) ✔ HashMap benefit
                 Since Strings are used as keys,
                 immutability ensures hashCode is stable.
        */

        String x = "Hello";
        x.concat(" World");       // creates NEW string "Hello World"
        System.out.println(x);     // Hello (old string unchanged)


        // =====================================================
        // 🧩 4️⃣ Basic Useful Methods
        // =====================================================
        /*
           length()         → total number of characters
           charAt(index)    → returns char at given index
           substring(start) → from index to end
           substring(s,e)   → from s to e-1
           trim()           → removes starting & ending spaces
           contains()       → checks if substring exists
        */

        String str = "  Aman Kushwaha  ";
        System.out.println(str.length());       // 16 (because of spaces)
        System.out.println(str.charAt(2));      // 'A' (3rd character)

        // ⭐ substring examples
        System.out.println("Java".substring(1));     // "ava"
        System.out.println("Java".substring(1, 3));           // "av"
        // Explanation:
        // substring(1,3) → characters at index 1 and 2 (3 excluded)

        System.out.println(str.trim());            // "Aman Kushwaha"
        System.out.println(str.contains("Aman"));  // true


        // =====================================================
        // 🧩 5️⃣ String concatenation (+)
        // =====================================================
        /*
           ✔ "+" creates a NEW String because String is immutable

           📌 Case 1 — compile-time:
               "A" + "B"
               Compiler combines into "AB" → added directly to SCP

           📌 Case 2 — runtime:
               String p2 = "A";
               p2 + "B" → happens at runtime → object created in HEAP
        */

        String p1 = "A" + "B";  // compile-time → "AB" in SCP
        String p2 = "A";        // SCP
        String p3 = p2 + "B";   // runtime → HEAP object created

        System.out.println(p1); // AB
        System.out.println(p3); // AB


        // =====================================================
        // 🧩 6️⃣ intern() — Beginner Overview
        // =====================================================
        /*
           ✔ intern() moves string to SCP from HEAP if not present
           ✔ returns the SCP reference

           📌 Why useful?
              To make two same strings share same reference.
        */

        String h = new String("HI");  // HEAP
        String i = h.intern();        // moves to/returns from SCP
        String j = "HI";              // SCP literal

        System.out.println(i == j);   // true  (same SCP object)
        System.out.println(h == j);   // false (heap vs SCP)


        // =====================================================
        // 🧩 7️⃣ Null concatenation (beginner trap)
        // =====================================================
        /*
           👉 null + "A" → "nullA"
           Because JVM converts null → "null"

           BUT:
               null.length() → NullPointerException (NPE)
        */

        String z = null;
        System.out.println(z + "A");  // nullA


        // =====================================================
        // 🧠 Quick Revision (Beginner)
        // =====================================================
        /*
           🔹 String literal → SCP
           🔹 new String() → Heap
           🔹 String immutable
           🔹 “+” creates NEW string
           🔹 == compares memory
           🔹 equals() compares content
           🔹 substring(), charAt(), trim(), length()
           🔹 intern() → moves to SCP
        */
    }
}
