// File: _3_StringAdvanced_Full.java
// Topic: Full Advanced String Concepts (Clean & Structured Notes)
// 🧠 Covers: compareTo, equalsIgnoreCase, split/replace, trim/blank,
//            valueOf, hashCode cache, conversions, whitespace methods,
//            format/join/repeat, regionMatches, contentEquals,
//            UTF-16 traps, substring edge cases, regex traps, plus-operator traps,
//            null traps, loop concat performance.

// -------------------------------------------------------------
// ⚠️ NOTE: This file contains ONLY ADVANCED concepts.
// Basic & medium concepts exist in earlier files.
// -------------------------------------------------------------

public class _4_StringAdvanced_Full {
    public static void main(String[] args) {

        // =====================================================
        // 🧩 1️⃣ compareTo() — Lexicographic Comparison
        // =====================================================
        /*
           compareTo():
               0  → equal
              <0 → this < other
              >0 → this > other

           🔹 Compares character-by-character using Unicode values.
           🔹 Used in sorting (TreeSet, Collections.sort, etc.)
        */
        System.out.println("abc".compareTo("abc")); // 0
        System.out.println("abc".compareTo("abd")); // -1 (c < d)
        System.out.println("abd".compareTo("abc")); // 1  (d > c)



        // =====================================================
        // 🧩 2️⃣ equalsIgnoreCase()
        // =====================================================
        /*
           Compares TEXT ignoring case.
        */
        System.out.println("Java".equalsIgnoreCase("java")); // true
        System.out.println("Java".equals("java"));           // false



        // =====================================================
        // 🧩 3️⃣ split() / replace() / replaceAll()
        // =====================================================
        /*
           split(regex) → breaks string into array (REGEX based)
           replace(old,new) → simple replace (NOT regex)
           replaceAll(regex,new) → regex replace
        */

        String line = "a,b,c";
        String[] arr = line.split(",");
        System.out.println(arr[0]); // a

        System.out.println("ha ha ha".replace("ha", "ho"));          // ho ho ho
        System.out.println("A1B2C3".replaceAll("\\d", "_"));         // A_B_C_



        // =====================================================
        // 🧩 4️⃣ trim(), isEmpty(), isBlank()
        // =====================================================
        /*
           trim(): removes normal ASCII spaces (<= U+0020)
           isEmpty(): length == 0
           isBlank(): true if only whitespace characters
        */

        String sp = "   Aman   ";
        System.out.println(sp.trim());     // "Aman"
        System.out.println("".isEmpty());  // true
        System.out.println("   ".isBlank()); // true



        // =====================================================
        // 🧩 5️⃣ valueOf() — Convert primitives to String
        // =====================================================
        /*
           Safer than + "" because:
           - Handles null safely for objects
           - Cleaner for primitives
        */
        System.out.println(String.valueOf(10));
        System.out.println(String.valueOf(true));
        System.out.println(String.valueOf(2.5f));



        // =====================================================
        // 🧩 6️⃣ hashCode() Caching (Important for HashMap)
        // =====================================================
        /*
           🔹 String computes hashCode ONCE.
           🔹 Stores it internally for performance.
           🔹 Works because String is immutable.
        */
        String hs = "Samsung";
        int h1 = hs.hashCode();
        int h2 = hs.hashCode();
        System.out.println(h1 == h2);  // true (cached value reused)



        // =====================================================
        // 🧩 7️⃣ Conversions — toCharArray(), getBytes(), valueOf(char[])
        // =====================================================
        /*
           toCharArray() → String → char[]
           getBytes() → String → byte[]
           valueOf(char[]) → char[] → String
        */

        String conv = "Aman";

        char[] ch = conv.toCharArray();
        System.out.println(ch[0]); // A

        byte[] bytes = conv.getBytes();
        System.out.println(bytes.length); // 4

        String fromChars = String.valueOf(ch);
        System.out.println(fromChars); // Aman



        // =====================================================
        // 🧩 8️⃣ Advanced Whitespace Methods (Java 11+)
        // =====================================================
        /*
           strip() → Unicode-aware remove
           stripLeading(), stripTrailing()
           trim() → OLD, ASCII only
        */
        String ws = "\u2003  Aman  \u2003"; // has Unicode em-space
        System.out.println(ws.trim());   // may still show unicode spaces
        System.out.println(ws.strip());  // removes ALL whitespace



        // =====================================================
        // 🧩 9️⃣ repeat(), join(), format()
        // =====================================================
        /*
           repeat(n) → "ha".repeat(3) → hahaha
           join(delim, vals...) → joins strings with delimiter
           format() → like printf but returns String
        */

        System.out.println("ha".repeat(3));                 // hahaha
        System.out.println(String.join("-", "A", "B", "C"));// A-B-C

        String formatted = String.format("Name=%s Age=%d", "Aman", 24);
        System.out.println(formatted);



        // =====================================================
        // 🧩 🔟 regionMatches(), startsWith(offset)
        // =====================================================
        /*
           regionMatches() → compare substring without making new string
           startsWith(prefix, offset) → check prefix starting at index
        */

        String rm = "JavaScript";
        System.out.println(rm.regionMatches(0, "Java", 0, 4)); // true
        System.out.println(rm.startsWith("Script", 4));        // true



        // =====================================================
        // 🧩 1️⃣1️⃣ contentEquals() — Builder-safe comparison
        // =====================================================
        /*
           equals() can only compare String.
           contentEquals() compares ANY CharSequence (StringBuilder, etc.)
        */
        String ce1 = "Hello";
        StringBuilder ce2 = new StringBuilder("Hello");

        System.out.println(ce1.equals(ce2));        // false (type mismatch)
        System.out.println(ce1.contentEquals(ce2)); // true



        // =====================================================
        // 🧩 1️⃣2️⃣ UTF-16 Trap — Emoji length
        // =====================================================
        /*
           🔹 Java uses UTF-16 internally.
           🔹 Some characters (emoji) require 2 chars.
           So length() may not match visible characters.
        */
        String emoji = "😄";
        System.out.println(emoji.length()); // 2



        // =====================================================
        // 🧩 1️⃣3️⃣ substring() Edge Cases
        // =====================================================
        /*
           substring(start, end):
               start inclusive
               end exclusive
           Special cases:
               substring(0,0) → empty string
        */
        String sub = "ABCDE";
        System.out.println(sub.substring(0, 0)); // ""
        System.out.println(sub.substring(2, 5)); // CDE



        // =====================================================
        // 🧩 1️⃣4️⃣ REGEX Trap in split() (Most Asked)
        // =====================================================
        /*
           "." in REGEX means "any character".
           So split(".") breaks EVERYTHING.

           Correct way:
               split("\\.")
        */
        String ip = "1.2.3";
        System.out.println(ip.split(".").length);     // 0
        System.out.println(ip.split("\\.").length);   // 3



        // =====================================================
        // 🧩 1️⃣5️⃣ '+' Operator Trap (LEFT → RIGHT)
        // =====================================================
        /*
           Expression is evaluated left-to-right:

           10 + 20 + "Java" → 30Java
           "Java" + 10 + 20 → Java1020
        */
        System.out.println(10 + 20 + "Java");  // 30Java
        System.out.println("Java" + 10 + 20);  // Java1020



        // =====================================================
        // 🧩 1️⃣6️⃣ Null Handling Traps
        // =====================================================
        /*
           null + "X" → "nullX"
           null.method() → NullPointerException
        */
        String n = null;
        System.out.println(n + "X"); // nullX
        // n.length();               // ❌ NPE



        // =====================================================
        // 🧩 1️⃣7️⃣ Loop Concatenation Performance Trap
        // =====================================================
        /*
           String is IMMUTABLE → every + makes NEW String → O(n²)
           Use StringBuilder for loops.
        */

        String slow = "";
        for (int k = 0; k < 3; k++) slow += k;  // inefficient
        System.out.println(slow);               // 012



        // =====================================================
        // 🧠 QUICK ADVANCED REVISION
        // =====================================================
        /*
           🔹 compareTo → lexicographic
           🔹 split(regex) → "." is REGEX (danger)
           🔹 strip() > trim() (unicode aware)
           🔹 join(), repeat(), format() → utilities
           🔹 regionMatches(), startsWith(offset)
           🔹 contentEquals() → builder-safe compare
           🔹 UTF-16: emoji length = 2
           🔹 hashCode cached in String
           🔹 null + "X" = "nullX"
           🔹 '+' left → right trap
           🔹 Avoid String + inside loops
        */
    }
}
