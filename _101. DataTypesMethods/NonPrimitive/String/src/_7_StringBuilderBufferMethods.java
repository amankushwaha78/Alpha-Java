// File: _4_StringBuilderBufferMethods.java
// Topic: All Important StringBuilder & StringBuffer Methods
// 🧠 Meaning + Syntax + Example + Output (Interview + Practice friendly)

public class _7_StringBuilderBufferMethods {

    public static void main(String[] args) {

        // =====================================================
        // 1) BASIC INFO (APPLIES TO BOTH)
        // =====================================================
        /*
           ✅ StringBuilder  → NOT synchronized → NOT thread-safe → faster
           ✅ StringBuffer   → synchronized → thread-safe → slower

           ✅ Almost ALL methods are SAME in both.
           ✅ We will use StringBuilder in examples,
              but you can replace with StringBuffer directly.
        */


        // =====================================================
        // 2) LENGTH / CAPACITY METHODS
        // =====================================================

        // ➤ (1) length()
        // Meaning: Returns number of characters currently stored.
        // Syntax:
        //     int len = sb.length();
        //
        // Example:
        StringBuilder sb1 = new StringBuilder("Java");
        System.out.println(sb1.length());
        // Output:
        // 4


        // ➤ (2) capacity()
        // Meaning: Returns total internal storage (how many chars it can hold
        //          before resizing).
        // Syntax:
        //     int cap = sb.capacity();
        //
        // Example:
        StringBuilder sb2 = new StringBuilder(); // default
        System.out.println(sb2.capacity());
        // Output:
        // 16  (default capacity)

        StringBuilder sb3 = new StringBuilder("Aman");
        System.out.println(sb3.capacity());
        // Output:
        // 20  (16 + length("Aman") = 20)


        // ➤ (3) ensureCapacity(minCapacity)
        // Meaning: Increases capacity if current capacity is less than minCapacity.
        // Syntax:
        //     sb.ensureCapacity(minCapacity);
        //
        // Example:
        StringBuilder sb4 = new StringBuilder();
        System.out.println(sb4.capacity()); // 16 by default
        sb4.ensureCapacity(50);
        System.out.println(sb4.capacity());
        // Output:
        // (>= 50, formula: old*2+2 if needed)


        // ➤ (4) setLength(newLength)
        // Meaning: Changes the length of builder.
        //          - If newLength < old → content is truncated.
        //          - If newLength > old → extra chars filled with '\u0000'.
        // Syntax:
        //     sb.setLength(newLength);
        //
        // Example:
        StringBuilder sb5 = new StringBuilder("HelloWorld");
        sb5.setLength(5);
        System.out.println(sb5);
        // Output:
        // Hello



        // =====================================================
        // 3) APPEND / INSERT METHODS
        // =====================================================

        // ➤ (5) append(x)
        // Meaning: Adds value at end (supports many types: int, String, boolean, etc.).
        // Syntax:
        //     sb.append(value);
        //
        // Example:
        StringBuilder sb6 = new StringBuilder("Hello");
        sb6.append(" World");
        sb6.append("!");
        System.out.println(sb6);
        // Output:
        // Hello World!


        // ➤ (6) insert(index, value)
        // Meaning: Inserts given value at specific position.
        // Syntax:
        //     sb.insert(index, value);
        //
        // Example:
        StringBuilder sb7 = new StringBuilder("JavaDev");
        sb7.insert(4, " Script");
        System.out.println(sb7);
        // Output:
        // Java ScriptDev



        // =====================================================
        // 4) DELETE / REPLACE / REVERSE
        // =====================================================

        // ➤ (7) delete(start, end)
        // Meaning: Deletes characters from start (inclusive) to end (exclusive).
        // Syntax:
        //     sb.delete(start, end);
        //
        // Example:
        StringBuilder sb8 = new StringBuilder("JavaScript");
        sb8.delete(4, 10); // delete "Script"
        System.out.println(sb8);
        // Output:
        // Java


        // ➤ (8) deleteCharAt(index)
        // Meaning: Deletes a single character at given index.
        // Syntax:
        //     sb.deleteCharAt(index);
        //
        // Example:
        StringBuilder sb9 = new StringBuilder("Hello");
        sb9.deleteCharAt(1); // remove 'e'
        System.out.println(sb9);
        // Output:
        // Hllo


        // ➤ (9) replace(start, end, String)
        // Meaning: Replaces characters from start (inclusive) to end (exclusive)
        //          with new String.
        // Syntax:
        //     sb.replace(start, end, "newText");
        //
        // Example:
        StringBuilder sb10 = new StringBuilder("I like Java");
        sb10.replace(7, 11, "Spring");
        System.out.println(sb10);
        // Output:
        // I like Spring


        // ➤ (10) reverse()
        // Meaning: Reverses the entire sequence in place.
        // Syntax:
        //     sb.reverse();
        //
        // Example:
        StringBuilder sb11 = new StringBuilder("ABCDE");
        sb11.reverse();
        System.out.println(sb11);
        // Output:
        // EDCBA



        // =====================================================
        // 5) CHAR ACCESS / UPDATE / SEARCH
        // =====================================================

        // ➤ (11) charAt(index)
        // Meaning: Returns character at given index.
        // Syntax:
        //     char ch = sb.charAt(index);
        //
        // Example:
        StringBuilder sb12 = new StringBuilder("Aman");
        System.out.println(sb12.charAt(1));
        // Output:
        // m


        // ➤ (12) setCharAt(index, ch)
        // Meaning: Changes the character at a given index.
        // Syntax:
        //     sb.setCharAt(index, newChar);
        //
        // Example:
        StringBuilder sb13 = new StringBuilder("Java");
        sb13.setCharAt(0, 'K');
        System.out.println(sb13);
        // Output:
        // Kava


        // ➤ (13) indexOf(String)
        // Meaning: Returns index of first occurrence of substring, or -1 if not found.
        // Syntax:
        //     int idx = sb.indexOf("text");
        //
        // Example:
        StringBuilder sb14 = new StringBuilder("Hello Java World");
        int idx1 = sb14.indexOf("Java");
        System.out.println(idx1);
        // Output:
        // 6


        // ➤ (14) indexOf(String, fromIndex)
        // Meaning: Search substring starting from given index.
        // Syntax:
        //     int idx = sb.indexOf("text", fromIndex);
        //
        // Example:
        StringBuilder sb15 = new StringBuilder("ababa");
        int idx2 = sb15.indexOf("ba", 2);
        System.out.println(idx2);
        // Output:
        // 3


        // ➤ (15) lastIndexOf(String)
        // Meaning: Returns index of last occurrence of substring.
        // Syntax:
        //     int idx = sb.lastIndexOf("text");
        //
        // Example:
        StringBuilder sb16 = new StringBuilder("Java-Dev-Java");
        int idx3 = sb16.lastIndexOf("Java");
        System.out.println(idx3);
        // Output:
        // 9



        // =====================================================
        // 6) SUBSTRING / CONVERSION
        // =====================================================

        // ➤ (16) substring(start)
        // Meaning: Returns String from start index to end.
        // Syntax:
        //     String sub = sb.substring(start);
        //
        // Example:
        StringBuilder sb17 = new StringBuilder("ABCDEFGHI");
        String sub1 = sb17.substring(3);
        System.out.println(sub1);
        // Output:
        // DEFGHI


        // ➤ (17) substring(start, end)
        // Meaning: Returns String from start (inclusive) to end (exclusive).
        // Syntax:
        //     String sub = sb.substring(start, end);
        //
        // Example:
        String sub2 = sb17.substring(2, 5);
        System.out.println(sub2);
        // Output:
        // CDE


        // ➤ (18) toString()
        // Meaning: Converts StringBuilder/StringBuffer object to normal String.
        // Syntax:
        //     String result = sb.toString();
        //
        // Example:
        StringBuilder sb18 = new StringBuilder("Hello Builder");
        String normal = sb18.toString();
        System.out.println(normal);
        // Output:
        // Hello Builder



        // =====================================================
        // 7) CONSTRUCTORS (HOW TO CREATE)
        // =====================================================

        // ➤ (19) new StringBuilder()
        // Meaning: Creates empty builder with default capacity (16).
        // Syntax:
        //     StringBuilder sb = new StringBuilder();
        //
        // Example:
        StringBuilder c1 = new StringBuilder();
        System.out.println(c1.capacity());
        // Output:
        // 16


        // ➤ (20) new StringBuilder(int capacity)
        // Meaning: Creates builder with given capacity (manual control).
        // Syntax:
        //     StringBuilder sb = new StringBuilder(initialCapacity);
        //
        // Example:
        StringBuilder c2 = new StringBuilder(100);
        System.out.println(c2.capacity());
        // Output:
        // 100


        // ➤ (21) new StringBuilder(String str)
        // Meaning: Creates builder with content copied from given String.
        //          Capacity = 16 + str.length()
        // Syntax:
        //     StringBuilder sb = new StringBuilder("text");
        //
        // Example:
        StringBuilder c3 = new StringBuilder("Aman");
        System.out.println(c3.toString());
        // Output:
        // Aman



        // =====================================================
        // 8) SAME METHODS FOR STRINGBUFFER
        // =====================================================
        /*
           ✅ All methods shown ABOVE exist in StringBuffer too.
           ✅ Only difference → StringBuffer methods are synchronized.

           Example:
              StringBuffer buf = new StringBuffer("Hello");
              buf.append(" World");
              buf.reverse();
              buf.delete(0, 3);
        */

        StringBuffer buf = new StringBuffer("Hello");
        buf.append(" World");
        System.out.println(buf);
        // Output:
        // Hello World


        // =====================================================
        // 🧠 QUICK REVISION (StringBuilder & StringBuffer)
        // =====================================================
        /*
           🔹 length(), capacity(), ensureCapacity(), setLength()
           🔹 append(), insert()
           🔹 delete(), deleteCharAt(), replace(), reverse()
           🔹 charAt(), setCharAt(), indexOf(), lastIndexOf()
           🔹 substring(), toString()
           🔹 Constructors: (), (int capacity), (String str)
           🔹 StringBuilder → not thread-safe, faster
           🔹 StringBuffer  → thread-safe, slower
        */

    }
}
