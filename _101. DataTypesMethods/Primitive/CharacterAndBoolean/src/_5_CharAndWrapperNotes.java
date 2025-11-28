// File: _5_CharAndWrapperNotes.java
// Topic: char (primitive) + Character (wrapper class) + inbuilt methods + Unicode + comparison
// 🧠 char = 2 bytes (unsigned, 0–65535). Stores one UTF-16 code unit — used for single letters, digits, or symbols.

public class _5_CharAndWrapperNotes {
    public static void main(String[] args) {

        // =====================================================
        // 🧩 1️⃣ char — Primitive Basics
        // =====================================================
        // 👉 A 'char' literally stores a single Unicode character (like 'A', '9', '#').
        // 👉 Internally stored as a 16-bit number (0–65535).

        char letter = 'A';
        char digit = '7';
        char symbol = '#';
        char unicodeChar = '\u0042'; // Unicode escape for 'B'

        System.out.println("Letter: " + letter);        // -> A
        System.out.println("Digit: " + digit);          // -> 7
        System.out.println("Symbol: " + symbol);        // -> #
        System.out.println("Unicode: " + unicodeChar);  // -> B

        // =====================================================
        // 🧩 2️⃣ char as Number (ASCII / Unicode)
        // =====================================================
        // 👉 Each char has a numeric value — its Unicode/ASCII code.
        int codeA = letter;  // int codeA = 'A';        // implicit widening to int
        System.out.println("ASCII of 'A': " + codeA);   // -> 65

        char next = (char) (letter + 1);     // char promotes to int → result cast back
        System.out.println("Next char: " + next);       // -> B

        /*
           💡 ASCII / Unicode Reference:
              'A'–'Z' → 65–90
              'a'–'z' → 97–122
              '0'–'9' → 48–57
              Space   → 32
              '#'     → 35
           These numeric codes are used heavily in pattern problems, encryption, etc.
        */

        // =====================================================
        // 🧩 3️⃣ Character — Wrapper Class
        // =====================================================
        // 👉 Lets you use char as an object (for collections, methods, etc.)
        Character boxed = Character.valueOf(letter);  // Boxing
        char unboxed = boxed.charValue();             // Unboxing
        System.out.println("Boxed: " + boxed);        // -> A
        System.out.println("Unboxed: " + unboxed);    // -> A

        // 🧠 Auto-boxing / Auto-unboxing
        Character autoBox = 'Z';
        char autoUnbox = autoBox;
        System.out.println("AutoBox: " + autoBox);     // -> Z
        System.out.println("AutoUnbox: " + autoUnbox); // -> Z

        // =====================================================
        // 🧩 4️⃣ Common Inbuilt Methods (Character class)
        // =====================================================
        System.out.println(Character.isDigit('9'));            // -> true
        System.out.println(Character.isLetter('A'));           // -> true
        System.out.println(Character.isLetterOrDigit('#'));    // -> false
        System.out.println(Character.isUpperCase('A'));        // -> true
        System.out.println(Character.isLowerCase('a'));        // -> true
        System.out.println(Character.toUpperCase('b'));        // -> B
        System.out.println(Character.toLowerCase('G'));        // -> g
        System.out.println(Character.isWhitespace(' '));       // -> true
        System.out.println(Character.getNumericValue('7'));    // -> 7 (char → int)
        System.out.println(Character.getType('A'));            // -> 1 (UPPERCASE_LETTER)
        System.out.println(Character.getType('a'));            // -> 2 (LOWERCASE_LETTER)
        System.out.println(Character.forDigit(10, 16));        // -> a (digit→char base16)

        /**
         * 📘 CHARACTER CLASS METHODS — EXPLANATION TABLE
         * -----------------------------------------------
         * | Method | Description | Example Output | Common Use |
         * |---------|-------------|----------------|-------------|
         * | isDigit('9') | Checks if char is numeric (0–9) | true | Validate numeric input |
         * | isLetter('A') | Checks if alphabetic | true | Detect letters in input |
         * | isLetterOrDigit('#') | Checks letter or digit | false | Filter alphanumeric chars |
         * | isUpperCase('A') | Is uppercase | true | Case handling / toggling |
         * | isLowerCase('a') | Is lowercase | true | Detect lowercase for conversion |
         * | toUpperCase('b') | Converts to uppercase | 'B' | Case normalization |
         * | toLowerCase('G') | Converts to lowercase | 'g' | Case normalization |
         * | isWhitespace(' ') | Detects space/tab/newline | true | Input cleaning |
         * | getNumericValue('7') | Char → numeric value | 7 | Convert '7' → 7 |
         * | getType('A') | Type code (1=Uppercase,2=Lowercase,9=Digit) | 1 | Classify char type |
         * | forDigit(10,16) | Converts number to char in base | 'a' | Base conversions (hex) |
         *
         * 💡 Summary:
         *   → Use isDigit/isLetter for validation.
         *   → Use toUpperCase/toLowerCase for transformations.
         *   → Use getNumericValue/forDigit for conversions in parsing.
         *   → Used frequently in LeetCode string & parsing problems.
         */
        /*
           💡 getType(c) returns numeric constants:
              1 → Uppercase Letter
              2 → Lowercase Letter
              9 → Decimal Digit Number
              12 → Space Separator
           💡 forDigit(digit, radix):
              Converts a number (0–15) to corresponding char.
              Example: forDigit(10,16) → 'a'
        */

        // =====================================================
        // 🧩 5️⃣ Comparison & Equality
        // =====================================================
        char c1 = 'A', c2 = 'A', c3 = 'B';
        System.out.println(c1 == c2); // -> true (primitive value comparison)
        System.out.println(c1 == c3); // -> false

        Character w1 = 'A', w2 = 'A';
        System.out.println("Wrapper == : " + (w1 == w2));   // -> true (cached range) || 65
        System.out.println("Wrapper equals(): " + w1.equals(w2)); // -> true (value match)
        /*
           💡 Why '==' returns true here:
           ---------------------------------
           Character, like Integer/Short/Byte/Long, **caches values from '\u0000' (0) to '\u007F' (127)**.
           That means when you autobox 'A' (which is 65 in Unicode),
           both w1 and w2 refer to the *same cached object*.

           So:
             w1 == w2 → true  ✅ (same memory reference)
             w1.equals(w2) → true ✅ (same character value)

           But outside that range:
        */

        Character x = 200, y = 200;
        System.out.println("Wrapper == (200): " + (x == y));      // -> false (not cached)
        System.out.println("Wrapper equals() (200): " + x.equals(y)); // -> true (same value
        /*
           🧠 Summary:
           ---------------------------------
           - For primitive `char`:  '==' compares actual numeric value.
           - For wrapper `Character`: '==' compares memory reference.
           - Cache range: 0 to 127 (like ASCII).
           - Always use equals() for safe character comparison.
        */


        // =====================================================
        // 🧩 6️⃣ Range & Unicode Demo
        // =====================================================
        System.out.println("MIN_VALUE: " + (int) Character.MIN_VALUE); // -> 0
        System.out.println("MAX_VALUE: " + (int) Character.MAX_VALUE); // -> 65535
        System.out.println("Unicode for '❤': " + (int) '❤');           // -> 10084
        /*
           💡 Explanation:
           char stores one UTF-16 code unit.
           Simple characters (A–Z, 0–9, etc.) fit in one char.
           Some emojis like '❤' or '😂' may use *two chars* (called surrogate pairs).
        */

        // =====================================================
        // 🧠 Interview Highlights
        // =====================================================
        /*
           🔹 char is *unsigned* — range 0–65535 (unlike byte/short which are signed).
           🔹 Supports direct arithmetic since internally it's numeric.
           🔹 Character methods are essential for:
               → input validation
               → conversions (digit↔char)
               → text-processing logic
           🔹 ASCII values are useful for pattern problems:
               e.g., next letter, character shifting, Caesar cipher, etc.

           💬 Interview quote:
           "A char in Java is a 16-bit unsigned integer that represents a Unicode character.
            It can participate in arithmetic and comparisons because it's numeric internally.
            The Character class provides helper methods like isLetter(), isDigit(), and
            toUpperCase(), which are widely used for parsing and validation."
        */
    }
}
