// File: QA8_CharInterviewScenarios.java
// Topic: Output-based & tricky questions for char / Character
// 🧠 Covers: numeric nature of char, promotions, casting wrap, comparisons, caching, Character APIs, Unicode.

public class QA2_CharInterviewScenarios {
    public static void main(String[] args) {

        // =====================================================
        // 🧩 1️⃣ char is numeric (16-bit unsigned, 0..65535)
        // =====================================================
        char a = 'A'; // 65
        System.out.println("1️⃣ (int) 'A' → " + (int) a); // 65
        System.out.println("2️⃣ 'A' + 1 → " + ('A' + 1)); // 66 (promoted to int)
        System.out.println("3️⃣ (char)('A' + 1) → " + (char)('A' + 1)); // B

        /*
           💡 char participates in arithmetic by promoting to int.
              'A' (65) + 1 = 66; cast back to char → 'B'.
        */


        // =====================================================
        // 🧩 2️⃣ Range & wrap-around on cast (char is UNSIGNED)
        // =====================================================
        int neg = -1;
        char wrapped = (char) neg; // two's complement bits reinterpreted as unsigned 16-bit
        System.out.println("4️⃣ (char) -1 → code: " + (int) wrapped); // 65535
        // 🔎 Explanation: -1 has all bits 1; as 16-bit unsigned → 65535.


        // =====================================================
        // 🧩 3️⃣ char literals vs digits
        // =====================================================
        char d7 = '7';
        System.out.println("5️⃣ '7' == 7 → " + ('7' == 7)); // false
        System.out.println("6️⃣ '7' - '0' → " + ('7' - '0')); // 7
        /*
           💡 '7' is code 55. Subtract '0' (48) → 7 (numeric value).
        */


        // =====================================================
        // 🧩 4️⃣ Case math (classic): 'a' - 'A' = 32
        // =====================================================
        System.out.println("7️⃣ 'a' - 'A' → " + ('a' - 'A')); // 32
        System.out.println("8️⃣ to upper via math: (char)('g' - 32) → " + (char)('g' - 32)); // G
        // ✅ Works for ASCII letters; prefer Character.toUpperCase for general Unicode.


        // =====================================================
        // 🧩 5️⃣ Comparisons: primitives vs wrappers
        // =====================================================
        char c1 = 'A', c2 = 65, c3 = 'B';
        System.out.println("9️⃣ 'A' == 65 → " + (c1 == 65)); // true (char→int compare)
        System.out.println("🔟 'A' < 'B' → " + (c1 < c3));   // true

        Character w1 = 'A', w2 = 'A', w3 = 200, w4 = 200;
        System.out.println("1️⃣1️⃣ Character 'A' == 'A' → " + (w1 == w2)); // true (cached 0..127)
        System.out.println("1️⃣2️⃣ Character 200 == 200 → " + (w3 == w4)); // false (not cached)
        System.out.println("1️⃣3️⃣ Character 200 equals 200 → " + w3.equals(w4)); // true
        /*
           💡 Character caching: \u0000.. \u007F (0..127) may be same object → '==' can be true.
              Outside that range → different objects → use equals().
        */


        // =====================================================
        // 🧩 6️⃣ Character API essentials (output-based)
        // =====================================================
        System.out.println("1️⃣4️⃣ isDigit('9') → " + Character.isDigit('9'));        // true
        System.out.println("1️⃣5️⃣ isLetter('#') → " + Character.isLetter('#'));      // false
        System.out.println("1️⃣6️⃣ isLetterOrDigit('#') → " + Character.isLetterOrDigit('#')); // false
        System.out.println("1️⃣7️⃣ isUpperCase('A') → " + Character.isUpperCase('A')); // true
        System.out.println("1️⃣8️⃣ toLowerCase('Q') → " + Character.toLowerCase('Q')); // q
        System.out.println("1️⃣9️⃣ getNumericValue('7') → " + Character.getNumericValue('7')); // 7
        System.out.println("2️⃣0️⃣ forDigit(10, 16) → " + Character.forDigit(10,16)); // a

        /*
           💡 Interview notes:
             - getNumericValue('7') = 7; works beyond ASCII (e.g., some non-Latin digits).
             - forDigit(n, radix): n in [0, radix); radix <= 36 → digits 0-9 then a-z.
        */


        // =====================================================
        // 🧩 7️⃣ char + other small types ⇒ int promotion
        // =====================================================
        char ch = 'A';       // 65
        byte by = 2;         // 2
        short sh = 3;        // 3
        int mix = ch + by + sh; // all promoted to int
        System.out.println("2️⃣1️⃣ 'A'(65) + 2 + 3 → " + mix); // 70


        // =====================================================
        // 🧩 8️⃣ Post-increment on char
        // =====================================================
        char inc = 'x';
        System.out.println("2️⃣2️⃣ inc (before) → " + inc);   // x
        System.out.println("2️⃣3️⃣ inc++ (prints old) → " + (inc++)); // x
        System.out.println("2️⃣4️⃣ inc (after) → " + inc);     // y
        // 💡 ++ / -- work since char is numeric.


        // =====================================================
        // 🧩 9️⃣ Unicode beyond ASCII (surrogate pairs)
        // =====================================================
        char heart = '❤'; // U+2764 (fits in a single char)
        System.out.println("2️⃣5️⃣ '❤' code → " + (int) heart); // 10084

        // Some emojis need two chars (surrogate pair). Example: 😀 (U+1F600)
        String emoji = "😀";
        System.out.println("2️⃣6️⃣ \"😀\" length → " + emoji.length()); // 2
        System.out.println("2️⃣7️⃣ codePointCount → " + emoji.codePointCount(0, emoji.length())); // 1
        /*
           💡 char stores one UTF-16 code unit (16 bits).
              Emojis like 😀 have code points > 65535 → require two chars in UTF-16.
        */


        // =====================================================
        // 🧩 🔟 Tricky prints: char vs String
        // =====================================================
        System.out.println("2️⃣8️⃣ 'A' + \"B\" → " + ('A' + "B")); // AB (string concat)
        System.out.println("2️⃣9️⃣ 'A' + 'B' → " + ('A' + 'B'));   // 131 (65+66, numeric add)
        /*
           💡 With a String present → concatenation.
              Only chars → promoted to int and added.
        */


        // =====================================================
        // 🧩 1️⃣1️⃣ Boundary values
        // =====================================================
        System.out.println("3️⃣0️⃣ MIN_VALUE → " + (int) Character.MIN_VALUE); // 0
        System.out.println("3️⃣1️⃣ MAX_VALUE → " + (int) Character.MAX_VALUE); // 65535

        // Casting max int code to char gives last Unicode unit
        char maxU = (char) 65535;
        System.out.println("3️⃣2️⃣ (int)(char)65535 → " + (int) maxU); // 65535


        // =====================================================
        // 🧠 Speed-revision (mini)
        // =====================================================
        /*
           🔹 char is unsigned 16-bit (0..65535), numeric inside.
           🔹 Any small-type arithmetic (byte/short/char) → promoted to int.
           🔹 '7' - '0' → 7; 'a' - 'A' → 32 (ASCII trick).
           🔹 Character caching for '\u0000'..'\u007F' can make '==' appear true.
           🔹 Use equals() for Character objects; '==' for primitive char is fine.
           🔹 Some emojis use surrogate pairs → String.length() can be 2 for one symbol.
        */
    }
}
