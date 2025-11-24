// File: _2_StringAdvanced_Full.java
// Topic: Advanced Full Version (ADD-ON only)
// ✅ This file EXCLUDES everything already covered in _2_StringAdvanced (medium).
// 🧠 Covers ONLY new advanced points: deep SCP rules, interning nuances,
//     hashCode caching, UTF-16/Unicode notes, advanced methods, tricky traps,
//     conversions (char[], bytes), String.format/join/repeat/strip, edge cases.

public class _3_StringAdvanced_Full {
    public static void main(String[] args) {

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

        // =====================================================
        // 🧩 3️⃣ hashCode() Caching Concept
        // =====================================================
        /*
           ✅ String caches its hashCode after first calculation.
           ✅ Works ONLY because String is immutable.
           ✅ Important for HashMap / HashSet performance.

           Once computed -> stored inside String object.
        */

        String hs = "Samsung";
        int h1 = hs.hashCode();          // calculates & caches
        int h2 = hs.hashCode();          // returns cached value
        System.out.println(h1 == h2);    // true


        // =====================================================
        // 🧩 4️⃣ Conversions: toCharArray(), getBytes(), valueOf()
        // =====================================================
        /*
           ✅ toCharArray() → String → char[]
           ✅ getBytes() → String → byte[] (platform charset by default)
           ✅ String.valueOf(char[]) → char[] → String
        */

        String conv = "Aman";
        char[] ch = conv.toCharArray();
        System.out.println(ch[0]);              // 'A'

        byte[] bytes = conv.getBytes();
        System.out.println(bytes.length);      // 4  (A m a n)

        String fromChars = String.valueOf(ch);
        System.out.println(fromChars);         // Aman


        // =====================================================
        // 🧩 5️⃣ Advanced Whitespace Methods (Java 11+)
        // =====================================================
        /*
           ✅ strip() / stripLeading() / stripTrailing()
              → Unicode-aware trimming (better than trim()).

           ✅ trim() removes only <= U+0020 spaces.
        */

        String ws = "\u2003  Aman  \u2003"; // includes em-space (Unicode)
        System.out.println(ws.trim());   // may still keep Unicode spaces
        System.out.println(ws.strip());  // "Aman" (removes all Unicode spaces)


        // =====================================================
        // 🧩 6️⃣ repeat(), join(), format()
        // =====================================================
        /*
           repeat(n) → repeats string n times
           join(delim, parts...) → joins multiple strings
           format() → printf style formatting returning String
        */

        System.out.println("ha".repeat(3));                    // hahaha
        System.out.println(String.join("-", "A", "B", "C"));   // A-B-C

        String formatted = String.format("Name=%s Age=%d", "Aman", 24);
        System.out.println(formatted);                         // Name=Aman Age=24


        // =====================================================
        // 🧩 7️⃣ regionMatches() and startsWith(offset)
        // =====================================================
        /*
           ✅ regionMatches(start1, other, start2, len)
              → compare partial regions safely.

           ✅ startsWith(prefix, offset)
              → check prefix from specific index.
        */

        String rm = "JavaScript";
        System.out.println(rm.regionMatches(0, "Java", 0, 4));      // true
        System.out.println(rm.startsWith("Script", 4));             // true


        // =====================================================
        // 🧩 8️⃣ contentEquals() (String vs StringBuilder)
        // =====================================================
        /*
           ✅ contentEquals(CharSequence) compares content with builders too.
           ✅ Useful because equals() only accepts String.
        */

        String ce1 = "Hello";
        StringBuilder ce2 = new StringBuilder("Hello");
        System.out.println(ce1.equals(ce2));           // false (different types)
        System.out.println(ce1.contentEquals(ce2));   // true  (same content)


        // =====================================================
        // 🧩 9️⃣ UTF-16 / Unicode Note (Interview)
        // =====================================================
        /*
           ✅ Java String uses UTF-16 internally.
           ✅ Some Unicode characters need 2 chars (surrogate pair).
              So length() may NOT equal "number of visible characters".

           Example: emoji 😄 takes 2 UTF-16 units.
        */

        String emoji = "😄";
        System.out.println(emoji.length());     // 2  (surrogate pair)


        // =====================================================
        // 🧩 🔟 substring() Edge Cases
        // =====================================================
        /*
           ✅ substring(start, end):
              - end is exclusive.
              - substring(0,0) returns empty string.
        */

        String sub = "ABCDE";
        System.out.println(sub.substring(0, 0));  // "" (empty)
        System.out.println(sub.substring(2, 5));  // CDE


        // =====================================================
        // 🧩 1️⃣1️⃣ split() Regex Traps (MOST ASKED)
        // =====================================================
        /*
           ✅ split() takes REGEX, not plain char.

           Trap:
              "." in regex means "any character".
              So split(".") splits EVERYTHING.

           Correct:
              split("\\.") to split by dot.
        */

        String ip = "1.2.3";
        System.out.println(ip.split(".").length);     // 0  (because regex any-char)
        System.out.println(ip.split("\\.").length);   // 3  (correct)


        // =====================================================
        // 🧩 1️⃣2️⃣ + Operator Tricky Outputs
        // =====================================================
        /*
           ✅ If any operand is String → whole expression becomes String concat.
           ✅ Evaluation LEFT → RIGHT.

           Example:
              10 + 20 + "Java" → "30Java"
              "Java" + 10 + 20 → "Java1020"
        */

        System.out.println(10 + 20 + "Java");   // 30Java
        System.out.println("Java" + 10 + 20);   // Java1020


        // =====================================================
        // 🧩 1️⃣3️⃣ Null String Traps
        // =====================================================
        /*
           ✅ null + "X" → "nullX"
           ✅ But method call on null → NPE.
        */

        String n = null;
        System.out.println(n + "X");  // nullX
        // n.length();                // ❌ NPE


        // =====================================================
        // 🧩 1️⃣4️⃣ isEmpty() vs isBlank()
        // =====================================================
        /*
           isEmpty() → length == 0
           isBlank() → only whitespace (Java 11+)
        */

        System.out.println("".isEmpty());     // true
        System.out.println("   ".isEmpty());  // false
        System.out.println("   ".isBlank());  // true


        // =====================================================
        // 🧩 1️⃣5️⃣ Performance Tip: Loop Concatenation Trap
        // =====================================================
        /*
           ⚠️ Using '+' inside loop creates MANY heap objects.

           Example:
              for(...) s += i;
           → O(n^2) time due to repeated copying.

           ✅ Use StringBuilder for loops.
        */

        String slow = "";
        for (int k = 0; k < 3; k++) {
            slow += k;                 // creates new String each time
        }
        System.out.println(slow);      // 012


        // =====================================================
        // 🧠 ADVANCED QUICK REVISION (ONLY NEW POINTS)
        // =====================================================
        /*
           🔹 SCP holds literals + interned strings, reuses references.
           🔹 final variables can enable compile-time concat → SCP.
           🔹 String hashCode cached due to immutability.
           🔹 strip() is Unicode-aware (better than trim()).
           🔹 repeat(), join(), format() are powerful utilities.
           🔹 regionMatches(), startsWith(offset), contentEquals() are advanced compare tools.
           🔹 Java Strings are UTF-16; emoji length may be 2.
           🔹 split() uses regex → "." must be "\\.".
           🔹 + evaluation left→right causes "30Java" vs "Java1020".
           🔹 '+' in loops is slow; prefer StringBuilder.
        */
    }
}
