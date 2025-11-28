// File: _QA4_MixedTypePromotions_CharShortByte.java
// 🎯 Topic: Mixed-Type Promotions (byte, short, char) → int; long wins; char arithmetic
// 🧠 Key Rule: In arithmetic, byte/short/char are FIRST PROMOTED TO int. Result type widens to the largest type involved.

public class QA4_MixedTypePromotions_CharShortByte {
    public static void main(String[] args) {

        System.out.println("🚀 QA4 — Mixed-Type Promotions & char arithmetic\n");

        // =====================================================
        // 🧩 1️⃣ short + char → int (both promoted)
        // =====================================================
        short s2 = 100;         // 16-bit signed
        char  c  = 'A';         // Unicode 65
        int result = s2 + c;    // short -> int, char -> int  ➜ int
        System.out.println("1) short(100) + char('A') → int: " + result); // -> 165
        // 💡 Any arithmetic on byte/short/char promotes to int before the op.

        // =====================================================
        // 🧩 2️⃣ Chain with multiple types → widest type (long)
        // =====================================================
        byte  b1 = 100;
        short s1 = 200;
        int   i  = 300;
        long  l  = 400L;
        long sum = b1 + s1 + i + l; // result widened stepwise to long
        System.out.println("2) byte+short+int+long → long: " + sum); // -> 1000
        // 💡 “Largest type wins” for the final expression type.

        // =====================================================
        // 🧩 3️⃣ Assigning back to smaller types needs cast
        // =====================================================
        // short sBad = s2 + b1;  // ❌ Compilation error (int → short narrowing)
        short sOk  = (short)(s2 + b1);     // ✅ Explicit narrowing
        System.out.println("3) (short)(100 + 100) = " + sOk); // -> 200

        // =====================================================
        // 🧩 4️⃣ char arithmetic (code points)
        // =====================================================
        char ch = 'A'; // 65
        System.out.println("4) 'A' + 1 (as int)      → " + (ch + 1));          // -> 66
        System.out.println("5) (char)('A' + 1)       → " + (char)(ch + 1));    // -> B
        System.out.println("6) (int)'A'              → " + (int) ch);           // -> 65
        // 💡 Adding to a char yields an int. Cast back to char to get the next letter.

        /*
           📘 ASCII = 0–127 (7 bits)
           --------------------------
           0–31   : Control characters (non-printable)
           32–47  : Symbols  (space, !, ", #, $, %, &, etc.)
           48–57  : Digits   ('0'–'9')
           65–90  : Uppercase letters ('A'–'Z')
           97–122 : Lowercase letters ('a'–'z')
           127    : DEL (delete, control char)

           💡 Unicode extends beyond ASCII (supports ₹, ©, emojis, etc.).
           But ASCII is the foundation for English alphanumerics.
        */

        // =====================================================
        // 🧩 5️⃣ char cannot be negative (but you can cast)
        // =====================================================
        // char neg = -1; // ❌ compile error: char is unsigned 16-bit
        char wrap = (char) -1;  // bit pattern 0xFFFF
        System.out.println("7) (char)-1 as code point → " + (int) wrap); // -> 65535 (unsigned view)
        // 💡 char holds 0..65535. Casting a negative int wraps its 16 bits.

        // =====================================================
        // 🧩 6️⃣ Useful char–int tricks for interviews
        // =====================================================
        System.out.println("8) '5' - '0' → " + ('5' - '0'));   // -> 5   (digit to int)
        System.out.println("9) 'A' < 'a' → " + ('A' < 'a'));   // -> true (65 < 97)
        char rupee = '\u20B9';
        System.out.println("10) Unicode rupee char: " + rupee); // → ₹

        // =====================================================
        // 🧩 7️⃣ Constant-expression exception (compiler folding)
        // =====================================================
        byte k1 = 10, k2 = 20;
        // byte k3 = k1 + k2;           // ❌ variables → int result → needs cast
        byte k3 = 10 + 20;              // ✅ both constants; 30 fits in byte
        System.out.println("11) byte k3 = 10+20 → " + k3); // -> 30
        // 💡 Compiler folds constant expressions and checks range at compile-time.

        // =====================================================
        // 🧩 8️⃣ Compound assignment auto-casts (but can overflow!)
        // =====================================================
        short acc = 1;
        acc += 200000; // ✅ compiles (implicit cast after +), but value overflows
        System.out.println("12) short acc after '+= 200000' → " + acc);
        // 💡 'acc = (short)(acc + 200000)' happens under the hood → narrowing + wrap.

        // =====================================================
        // 🧩 9️⃣ Mini reference rules (talk-track)
        // =====================================================
        /*
           ✅ byte/short/char in arithmetic → promoted to int.
           ✅ Expression result widens to the largest type among operands (long > int > …).
           ✅ Assigning int result back to byte/short/char requires explicit cast.
           ✅ char is unsigned 16-bit: 0..65535 (no negatives).
           ✅ 'A' + 1 returns int; cast to char for the next letter.
           ✅ Constant expressions are folded at compile time if in range.
           ✅ 'x += y' may hide narrowing+overflow; review carefully.
        */

        System.out.println("\n🎯 QA4 complete — mixed promotions & char arithmetic are clear!");
    }
}
