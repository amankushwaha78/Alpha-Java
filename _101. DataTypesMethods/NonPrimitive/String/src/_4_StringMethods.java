// File: _4_StringMethods_Explained.java
// Topic: All String Methods (Clean Explanation + Example + Output)

public class _4_StringMethods {

    public static void main(String[] args) {

        // =====================================================
        // 1) LENGTH / ACCESS METHODS
        // =====================================================

        // ➤ (1) length()
        // Meaning: Used to count how many characters are present in a String.
        // Syntax:
        //     int len = string.length();
        //
        // Example:
        String name = "Aman";
        System.out.println(name.length());
        // Output:
        // 4


        // ➤ (2) charAt(index)
        // Meaning: Returns the character present at the given index (index starts from 0).
        // Syntax:
        //     char c = string.charAt(index);
        //
        // Example:
        System.out.println(name.charAt(2));
        // Output:
        // n


        // ➤ (3) toCharArray()
        // Meaning: Converts the string into an array of characters.
        // Syntax:
        //     char[] arr = string.toCharArray();
        //
        // Example:
        char[] cArr = name.toCharArray();
        System.out.println(cArr[1]);
        // Output:
        // m



        // =====================================================
        // 2) SUBSTRING / SLICE METHODS
        // =====================================================

        // ➤ (4) substring(startIndex)
        // Meaning: Returns the substring from the given index till the end.
        // Syntax:
        //     string.substring(startIndex);
        //
        // Example:
        String text = "ABCDEFG";
        System.out.println(text.substring(3));
        // Output:
        // DEFG


        // ➤ (5) substring(startIndex, endIndex)
        // Meaning: Returns substring from startIndex (inclusive) to endIndex (exclusive).
        // Syntax:
        //     string.substring(startIndex, endIndex);
        //
        // Example:
        System.out.println(text.substring(1, 4));
        // Output:
        // BCD



        // =====================================================
        // 3) CASE CONVERSION METHODS
        // =====================================================

        // ➤ (6) toUpperCase()
        // Meaning: Converts the entire string into uppercase letters.
        // Syntax:
        //     string.toUpperCase();
        //
        // Example:
        String str1 = "java";
        System.out.println(str1.toUpperCase());
        // Output:
        // JAVA


        // ➤ (7) toLowerCase()
        // Meaning: Converts the entire string into lowercase letters.
        // Syntax:
        //     string.toLowerCase();
        //
        // Example:
        String str2 = "HELLO";
        System.out.println(str2.toLowerCase());
        // Output:
        // hello


        // =====================================================
        // 4) TRIMMING / WHITESPACE METHODS
        // =====================================================

        // ➤ (8) trim()
        // Meaning: Removes ONLY leading and trailing **ASCII spaces** (not Unicode).
        // Syntax:
        //     string.trim();
        //
        // Example:
        String t1 = "   Hello   ";
        System.out.println(t1.trim());
        // Output:
        // Hello


        // ➤ (9) strip()  (Java 11+)
        // Meaning: Removes leading and trailing whitespace including **Unicode spaces**.
        // Syntax:
        //     string.strip();
        //
        // Example:
        String t2 = "\u2003  Hi  \u2003"; // contains Unicode whitespace
        System.out.println(t2.strip());
        // Output:
        // Hi


        // ➤ (10) isEmpty()
        // Meaning: Returns true if string length is 0.
        // Syntax:
        //     boolean result = string.isEmpty();
        //
        // Example:
        String t3 = "";
        System.out.println(t3.isEmpty());
        // Output:
        // true


        // ➤ (11) isBlank() (Java 11+)
        // Meaning: Returns true if the string contains only whitespace (including Unicode).
        // Syntax:
        //     boolean result = string.isBlank();
        //
        // Example:
        String t4 = "   ";
        System.out.println(t4.isBlank());
        // Output:
        // true



        // =====================================================
        // 5) SEARCHING / CHECKING METHODS
        // =====================================================

        // ➤ (12) contains(value)
        // Meaning: Checks if given substring exists inside the string.
        // Syntax:
        //     boolean result = string.contains(substring);
        //
        // Example:
        String search = "JavaScript";
        System.out.println(search.contains("Script"));
        // Output:
        // true


        // ➤ (13) startsWith(prefix)
        // Meaning: Checks if string starts with given prefix.
        // Syntax:
        //     string.startsWith(prefix);
        //
        // Example:
        System.out.println(search.startsWith("Java"));
        // Output:
        // true


        // ➤ (14) startsWith(prefix, offset)
        // Meaning: Checks if string contains the prefix starting from given index.
        // Syntax:
        //     string.startsWith(prefix, index);
        //
        // Example:
        System.out.println(search.startsWith("Script", 4));
        // Output:
        // true


        // ➤ (15) endsWith(suffix)
        // Meaning: Checks if string ends with given suffix.
        // Syntax:
        //     string.endsWith(suffix);
        //
        // Example:
        System.out.println(search.endsWith("pt"));
        // Output:
        // true


        // ➤ (16) indexOf(value)
        // Meaning: Returns index of first occurrence of given substring.
        // Syntax:
        //     string.indexOf(substring);
        //
        // Example:
        System.out.println(search.indexOf("a"));
        // Output:
        // 1


        // ➤ (17) lastIndexOf(value)
        // Meaning: Returns index of last occurrence of substring.
        // Syntax:
        //     string.lastIndexOf(substring);
        //
        // Example:
        System.out.println(search.lastIndexOf("a"));
        // Output:
        // 3



        // =====================================================
        // 6) REPLACE METHODS
        // =====================================================

        // ➤ (18) replace(oldValue, newValue)
        // Meaning: Simple text replacement (NOT regex).
        // Syntax:
        //     string.replace(old, new);
        //
        // Example:
        String r1 = "ha ha ha";
        System.out.println(r1.replace("ha", "ho"));
        // Output:
        // ho ho ho


        // ➤ (19) replaceAll(regex, newValue)
        // Meaning: Replaces matching text using REGEX.
        // Syntax:
        //     string.replaceAll(regex, replacement);
        //
        // Example:
        String r2 = "A1B2C3";
        System.out.println(r2.replaceAll("\\d", "_"));
        // Output:
        // A_B_C_


        // ➤ (20) replaceFirst(regex, newValue)
        // Meaning: Replaces only the first match using REGEX.
        // Syntax:
        //     string.replaceFirst(regex, replacement);
        //
        // Example:
        System.out.println(r2.replaceFirst("\\d", "_"));
        // Output:
        // A_B2C3



        // =====================================================
        // 7) SPLIT / JOIN METHODS
        // =====================================================

        // ➤ (21) split(regex)
        // Meaning: Breaks the string into an array using regex delimiter.
        // Syntax:
        //     String[] arr = string.split(regex);
        //
        // Example:
        String data = "A,B,C";
        String[] parts = data.split(",");
        System.out.println(parts[1]);
        // Output:
        // B


        // ➤ (22) join(delimiter, values...)
        // Meaning: Joins multiple values with a delimiter.
        // Syntax:
        //     String.join(delimiter, values...);
        //
        // Example:
        System.out.println(String.join("-", "A", "B", "C"));
        // Output:
        // A-B-C

        // =====================================================
        // 8) STRING COMPARISON METHODS
        // =====================================================

        // ➤ (23) equals(value)
        // Meaning: Compares two strings for EXACT match (case-sensitive).
        // Syntax:
        //     boolean result = string.equals(value);
        //
        // Example:
        String s1 = "Java";
        String s2 = "java";
        System.out.println(s1.equals(s2));
        // Output:
        // false


        // ➤ (24) equalsIgnoreCase(value)
        // Meaning: Compares two strings ignoring case.
        // Syntax:
        //     boolean result = string.equalsIgnoreCase(value);
        //
        // Example:
        System.out.println(s1.equalsIgnoreCase(s2));
        // Output:
        // true


        // ➤ (25) compareTo(value)
        // Meaning: Compares two strings lexicographically (ASCII based).
        // Returns:
        //     0      → both strings equal
        //    <0      → current string is smaller
        //    >0      → current string is larger
        //
        // Syntax:
        //     string.compareTo(value);
        //
        // Example:
        System.out.println("Apple".compareTo("Banana"));
        // Output:
        // -1  (because A < B)


        // ➤ (26) compareToIgnoreCase(value)
        // Meaning: Same as compareTo() but ignores case.
        // Syntax:
        //     string.compareToIgnoreCase(value);
        //
        // Example:
        System.out.println("abc".compareToIgnoreCase("ABC"));
        // Output:
        // 0



        // =====================================================
        // 9) PREFIX / SUFFIX REMOVAL METHODS (Java 11+)
        // =====================================================

        // ➤ (27) stripLeading()
        // Meaning: Removes whitespace only from START (including Unicode).
        // Syntax:
        //     string.stripLeading();
        //
        // Example:
        String p1 = "   Hello";
        System.out.println(p1.stripLeading());
        // Output:
        // Hello


        // ➤ (28) stripTrailing()
        // Meaning: Removes whitespace only from END (including Unicode).
        // Syntax:
        //     string.stripTrailing();
        //
        // Example:
        String p2 = "Hello   ";
        System.out.println(p2.stripTrailing());
        // Output:
        // Hello



        // =====================================================
        // 10) STRING JOIN + FORMAT FEATURES
        // =====================================================

        // ➤ (29) format(formatPattern, values...)
        // Meaning: Used for formatted output like printf, placeholders (%s, %d).
        // Syntax:
        //     String.format(pattern, values...)
        //
        // Example:
        String formatted = String.format("Name: %s, Age: %d", "Aman", 25);
        System.out.println(formatted);
        // Output:
        // Name: Aman, Age: 25


        // ➤ (30) repeat(count) (Java 11+)
        // Meaning: Repeats the string 'count' number of times.
        // Syntax:
        //     string.repeat(count);
        //
        // Example:
        System.out.println("Hi".repeat(3));
        // Output:
        // HiHiHi



        // =====================================================
        // 11) TYPE CONVERSION METHODS
        // =====================================================

        // ➤ (31) valueOf(data)
        // Meaning: Converts any data (int, boolean, array, object) into String.
        // Syntax:
        //     String.valueOf(anyData);
        //
        // Example:
        System.out.println(String.valueOf(100));
        // Output:
        // 100


        // ➤ (32) toString()
        // Meaning: Converts an object to string representation (used with classes).
        // Syntax:
        //     object.toString();
        //
        // Example:
        Integer num = 50;
        System.out.println(num.toString());
        // Output:
        // 50



        // =====================================================
        // 12) OTHER UTIL METHODS
        // =====================================================

        // ➤ (33) concat(value)
        // Meaning: Joins two strings (same as + operator).
        // Syntax:
        //     string.concat(value);
        //
        // Example:
        System.out.println("Hello".concat(" World"));
        // Output:
        // Hello World


        // ➤ (34) hashCode()
        // Meaning: Returns the hash value of the string (used in hashing).
        // Syntax:
        //     string.hashCode();
        //
        // Example:
        System.out.println("Java".hashCode());
        // Output:
        // (varies)



        // ➤ (35) matches(regex)
        // Meaning: Checks if string fully matches the regex pattern.
        // Syntax:
        //     string.matches(regex);
        //
        // Example:
        System.out.println("12345".matches("\\d+"));
        // Output:
        // true

    }
}
