// File: _4_StringMethods.java
// Topic: Most-used Java String Methods (Interview + Beginner friendly)
// 🧠 Only methods + crisp examples + outputs
// ✅ Categorized so you remember fast

public class _5_StringMethods {
    public static void main(String[] args) {

        // =====================================================
        // 🧩 1️⃣ LENGTH / ACCESS METHODS
        // =====================================================
        /*
           length()     → total number of characters
           charAt(i)    → char at index i
           toCharArray()→ convert to char[]
        */
        String s = "Aman";
        System.out.println(s.length());      // 4
        System.out.println(s.charAt(1));     // m

        char[] ch = s.toCharArray();
        System.out.println(ch[0]);          // A


        // =====================================================
        // 🧩 2️⃣ SUBSTRING / SLICING
        // =====================================================
        /*
           substring(start)       → from start index to end
           substring(start, end)  → start inclusive, end exclusive
        */
        String sub = "ABCDE";
        System.out.println(sub.substring(2));     // CDE
        System.out.println(sub.substring(1, 4));  // BCD
        System.out.println(sub.substring(0, 0));  // "" (empty)


        // =====================================================
        // 🧩 3️⃣ CASE CONVERSION
        // =====================================================
        /*
           toUpperCase() → all caps
           toLowerCase() → all small
        */
        String c = "JaVa";
        System.out.println(c.toUpperCase()); // JAVA
        System.out.println(c.toLowerCase()); // java


        // =====================================================
        // 🧩 4️⃣ TRIMMING / WHITESPACE
        // =====================================================
        /*
           trim()  → removes leading/trailing ASCII spaces
           strip() → removes Unicode whitespace (Java 11+)
           isEmpty() → length == 0
           isBlank() → only whitespace (Java 11+)
        */
        String ws = "   Aman   ";
        System.out.println(ws.trim());    // Aman

        String uni = "\u2003  Aman  \u2003";
        System.out.println(uni.strip()); // Aman

        System.out.println("".isEmpty());   // true
        System.out.println("   ".isEmpty());// false
        System.out.println("   ".isBlank());// true


        // =====================================================
        // 🧩 5️⃣ SEARCHING / CHECKING
        // =====================================================
        /*
           contains(x)     → substring exists?
           startsWith(x)   → prefix check
           startsWith(x,o) → prefix check from offset
           endsWith(x)     → suffix check
           indexOf(x)      → first index
           lastIndexOf(x)  → last index
        */
        String t = "JavaScript";
        System.out.println(t.contains("Script"));     // true
        System.out.println(t.startsWith("Java"));     // true
        System.out.println(t.startsWith("Script", 4));// true
        System.out.println(t.endsWith("pt"));         // true
        System.out.println(t.indexOf("a"));           // 1
        System.out.println(t.lastIndexOf("a"));       // 3


        // =====================================================
        // 🧩 6️⃣ REPLACE METHODS
        // =====================================================
        /*
           replace(old,new)     → simple replace (no regex)
           replaceAll(regex,new)→ regex replace
           replaceFirst(regex,new)→ only first match
        */
        String r = "ha ha ha";
        System.out.println(r.replace("ha", "ho")); // ho ho ho

        String r2 = "A1B2C3";
        System.out.println(r2.replaceAll("\\d", "_")); // A_B_C_
        System.out.println(r2.replaceFirst("\\d", "_"));// A_B2C3


        // =====================================================
        // 🧩 7️⃣ SPLIT / JOIN
        // =====================================================
        /*
           split(regex) → breaks into array (regex based)
           join(delim, parts...) → joins multiple strings
        */
        String line = "a,b,c";
        String[] arr = line.split(",");
        System.out.println(arr.length); // 3
        System.out.println(arr[1]);     // b

        System.out.println(String.join("-", "A", "B", "C")); // A-B-C


        // =====================================================
        // 🧩 8️⃣ COMPARISON METHODS
        // =====================================================
        /*
           equals(x)            → content compare
           equalsIgnoreCase(x)  → ignore case
           compareTo(x)         → lexicographic (0, <0, >0)
           contentEquals(builder) → compare with StringBuilder
           regionMatches(...)   → compare portion
        */
        String a = "Java";
        String b = "java";
        System.out.println(a.equals(b));            // false
        System.out.println(a.equalsIgnoreCase(b));  // true
        System.out.println("abc".compareTo("abd")); // -1

        StringBuilder sb = new StringBuilder("Java");
        System.out.println(a.contentEquals(sb));    // true

        System.out.println("JavaScript".regionMatches(0, "Java", 0, 4)); // true


        // =====================================================
        // 🧩 9️⃣ CONVERSION METHODS
        // =====================================================
        /*
           valueOf(x) → primitive → String
           getBytes() → String → byte[]
           toString() → already string, returns same
        */
        System.out.println(String.valueOf(10));   // "10"
        System.out.println(String.valueOf(true)); // "true"

        byte[] by = "Aman".getBytes();
        System.out.println(by.length);           // 4


        // =====================================================
        // 🧩 🔟 EXTRA USEFUL METHODS
        // =====================================================
        /*
           repeat(n)      → repeats string n times
           format(...)    → returns formatted string
           concat(x)      → joins (same as +)
        */
        System.out.println("ha".repeat(3));              // hahaha
        System.out.println(String.format("%s-%d", "Aman", 24)); // Aman-24
        System.out.println("Java".concat(" Dev"));       // Java Dev


        // =====================================================
        // 🧠 QUICK REVISION
        // =====================================================
        /*
           🔹 length, charAt, substring, split, replace, trim/strip
           🔹 equals/compareTo/equalsIgnoreCase/contentEquals
           🔹 contains, startsWith, endsWith, indexOf
           🔹 join, repeat, format, valueOf, getBytes
        */
    }
}
