// Topic: char (primitive) + Character (wrapper) + inbuilt methods + Unicode + comparison
// 🧠 char = 2 bytes (stores a single Unicode character, range: 0–65535)

public class _5_CharAndWrapperNotes {
    public static void main(String[] args) {

        // --------------------------------------
        // 🧩 1️⃣ char — Primitive Basics
        // --------------------------------------
        char letter = 'A';                     // stores one character
        char digit = '7';                      // stores '7' character (not numeric 7)
        char symbol = '#';                     // symbol character
        char unicodeChar = '\u0042';           // Unicode escape = 'B'

        System.out.println("Letter: " + letter);          // -> Letter: A
        System.out.println("Digit: " + digit);            // -> Digit: 7
        System.out.println("Symbol: " + symbol);          // -> Symbol: #
        System.out.println("Unicode: " + unicodeChar);    // -> Unicode: B

        // --------------------------------------
        // 🧩 2️⃣ char as numeric (ASCII/Unicode)
        // --------------------------------------
        // 👉 Internally, char is a 16-bit unsigned number (0–65535)
        int ascii = letter;                    // implicit promotion to int
        System.out.println("ASCII of 'A': " + ascii);     // -> ASCII of 'A': 65

        char next = (char) (letter + 1);       // arithmetic works via integer promotion
        System.out.println("Next char: " + next);         // -> Next char: B

        // --------------------------------------
        // 🧩 3️⃣ Character — Wrapper Class
        // --------------------------------------
        Character boxed = Character.valueOf(letter); // Boxing
        char unboxed = boxed.charValue();            // Unboxing
        System.out.println("Boxed: " + boxed);       // -> Boxed: A
        System.out.println("Unboxed: " + unboxed);   // -> Unboxed: A

        // Auto-boxing / unboxing
        Character autoBox = 'Z';
        char autoUnbox = autoBox;
        System.out.println("AutoBox: " + autoBox);             // -> AutoBox: Z
        System.out.println("AutoUnbox: " + autoUnbox);         // -> AutoUnbox: Z

        // --------------------------------------
        // 🧩 4️⃣ Inbuilt Methods (Character class)
        // --------------------------------------
        System.out.println(Character.isDigit('9'));            // -> true
        System.out.println(Character.isLetter('A'));           // -> true
        System.out.println(Character.isLetterOrDigit('#'));    // -> false
        System.out.println(Character.isUpperCase('A'));        // -> true
        System.out.println(Character.isLowerCase('a'));        // -> true
        System.out.println(Character.toUpperCase('b'));        // -> B
        System.out.println(Character.toLowerCase('G'));        // -> g
        System.out.println(Character.isWhitespace(' '));       // -> true
        System.out.println(Character.getNumericValue('7'));    // -> 7  (char → int)
        System.out.println(Character.getType('A'));            // -> 1  (UPPERCASE_LETTER) | LOWERCASE_LETTER -> 2
        System.out.println(Character.forDigit(10, 16));        // -> a  (digit→char, base16)
        // 💡 Great for input validation & conversions in interviews.

        // --------------------------------------
        // 🧩 5️⃣ Comparison & Equality
        // --------------------------------------
        char c1 = 'A', c2 = 'A', c3 = 'B';
        System.out.println(c1 == c2);               // -> true  (primitive comparison)
        System.out.println(c1 == c3);               // -> false
        System.out.println(Character.valueOf('A').equals(Character.valueOf('A'))); // -> true
        // 💡 For primitives, == compares value directly; for wrappers, use equals().

        // --------------------------------------
        // 🧩 6️⃣ Range & Unicode Demonstration
        // --------------------------------------
        System.out.println("MIN_VALUE: " + (int) Character.MIN_VALUE); // -> 0
        System.out.println("MAX_VALUE: " + (int) Character.MAX_VALUE); // -> 65535
        System.out.println("Unicode for '❤': " + (int) '❤');           // -> 10084
        // 💡 char holds one UTF-16 code unit; emojis may need two chars (surrogate pair).
    }
}
