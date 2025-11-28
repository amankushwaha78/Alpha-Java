public class _Q2_QA {
// File: _7_String_Interview_QA_Scenario.java
// Topic: Java String - Interview Questions (Conceptual / Scenario Based)

        // =====================================================
        // Q1: Difference between == and equals() for Strings
        // =====================================================
        // Answer:
        // - '==' checks reference equality (same memory object)
        // - 'equals()' checks content equality
        // - String literals may be same in SCP, but new String() creates new object


        // =====================================================
        // Q2: Why Strings are immutable in Java?
        // =====================================================
        // Answer:
        // - String objects cannot be changed after creation
        // - Provides security, thread-safety, SCP caching, and performance in HashMap keys


        // =====================================================
        // Q3: What is String Pool (SCP)?
        // =====================================================
        // Answer:
        // - String literals are stored in String Constant Pool (SCP) in heap
        // - Avoids duplicate objects, saves memory
        // - Only literal strings go to SCP; new String() objects go to heap


        // =====================================================
        // Q4: Difference between String, StringBuilder, StringBuffer
        // =====================================================
        // Answer:
        // - String: Immutable, slow in loops
        // - StringBuilder: Mutable, fast, not synchronized
        // - StringBuffer: Mutable, synchronized, thread-safe, slower


        // =====================================================
        // Q5: How is hashCode() computed for Strings?
        // =====================================================
        // Answer:
        // - hashCode() is cached because String is immutable
        // - Improves performance in hash-based collections like HashMap


        // =====================================================
        // Q6: What happens when we do null + "something"?
        // =====================================================
        // Answer:
        // - 'null + "X"' becomes "nullX"
        // - Calling any method on null (e.g., null.length()) throws NullPointerException


        // =====================================================
        // Q7: compareTo() vs equals()
        // =====================================================
        // Answer:
        // - equals(): checks exact content equality
        // - compareTo(): lexicographic comparison, returns 0, <0, or >0


        // =====================================================
        // Q8: equalsIgnoreCase() scenario
        // =====================================================
        // Answer:
        // - Compares content ignoring case
        // - Useful when user input can have different case but should match


        // =====================================================
        // Q9: Why split(".") does not work as expected?
        // =====================================================
        // Answer:
        // - '.' is a regex meta-character (matches any character)
        // - Correct way: split("\\.") for splitting by dot


        // =====================================================
        // Q10: '+' operator trap with Strings
        // =====================================================
        // Answer:
        // - Expression evaluated left to right
        // - int + int + String → addition first, then concatenation
        // - String + int + int → concatenation left to right


        // =====================================================
        // Q11: UTF-16 / Emoji length trap
        // =====================================================
        // Answer:
        // - Some characters (like emojis) take 2 chars in UTF-16
        // - length() may not match visible characters


        // =====================================================
        // Q12: substring edge cases
        // =====================================================
        // Answer:
        // - substring(start, end): start inclusive, end exclusive
        // - substring(0,0) returns empty string
        // - Useful in parsing and splitting strings manually


        // =====================================================
        // Q13: Loop concatenation performance trap
        // =====================================================
        // Answer:
        // - Strings are immutable → every '+' creates new object
        // - Use StringBuilder in loops for efficiency


        // =====================================================
        // Q14: contentEquals() scenario
        // =====================================================
        // Answer:
        // - Compares a String with any CharSequence (e.g., StringBuilder)
        // - equals() only compares String objects


        // =====================================================
        // Q15: regionMatches() / startsWith(offset)
        // =====================================================
        // Answer:
        // - regionMatches() compares substring portion without creating new object
        // - startsWith(prefix, offset) checks prefix at a particular index


        // =====================================================
        // Q16: Replace / replaceAll / replaceFirst scenarios
        // =====================================================
        // Answer:
        // - replace(): simple text replacement (no regex)
        // - replaceAll(): regex replacement
        // - replaceFirst(): regex replacement for first match only


        // =====================================================
        // Q17: String and Wrapper conversion scenarios
        // =====================================================
        // Answer:
        // - String.valueOf(primitive) → convert primitive → String
        // - Integer.parseInt(String) → convert String → primitive
        // - Safe conversions are key when reading user input or parsing files

    }

