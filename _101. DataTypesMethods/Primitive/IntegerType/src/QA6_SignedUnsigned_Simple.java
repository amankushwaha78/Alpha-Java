// =====================================================
// 🧩 QA6 — SIGNED vs UNSIGNED in Java (Simplified)
// =====================================================
// 🧠 Topic: Understand how Java stores positive & negative numbers
// using signed representation (two’s complement) and
// how to “view” them as unsigned when needed.

public class QA6_SignedUnsigned_Simple {
    public static void main(String[] args) {

        // =====================================================
        // 🧩 1️⃣ Signed numbers — default in Java
        // =====================================================
        byte a = 10;     // +10 → 00001010
        byte b = -10;    // -10 → 11110110 (two’s complement)
        System.out.println("1️⃣ a = " + a); // -> 10
        System.out.println("2️⃣ b = " + b); // -> -10

        /*
           💡 Every Java integer type (byte, short, int, long) is SIGNED.
           This means one bit (the leftmost one) is reserved for sign:
              0 → positive
              1 → negative

           Internally, negative numbers are stored using **two’s complement**:
             - Take the positive binary form.
             - Invert all bits.
             - Add 1.

           Example:  +10 → 00001010
                     invert → 11110101
                     +1     → 11110110 → -10 ✅
        */


        // =====================================================
        // 🧩 2️⃣ Overflow (wrap around behavior)
        // =====================================================
        byte max = 127;
        max++; // exceeds byte limit, wraps around
        System.out.println("3️⃣ Overflow 127 + 1 = " + max); // -> -128

        short s = 32767;
        s++;
        System.out.println("4️⃣ Overflow 32767 + 1 = " + s); // -> -32768

        /*
           💡 When a signed number crosses its limit:
              - Positive max overflows to minimum negative.
              - Negative min underflows to maximum positive.
           No error is thrown — it just wraps cyclically (two’s complement behavior).
        */


        // =====================================================
        // 🧩 3️⃣ Viewing signed values as UNSIGNED (Java 8+)
        // =====================================================
        byte neg = -10;
        System.out.println("5️⃣ Signed byte value: " + neg); // -> -10

        // Convert to unsigned view:
        int unsignedInt = Byte.toUnsignedInt(neg);
        System.out.println("6️⃣ Unsigned interpretation: " + unsignedInt); // -> 246

        /*
           💡 Step-by-step understanding:

           ▶️ 1️⃣ byte range = -128 to +127
               Because byte = 8 bits and one bit is reserved for the sign.
               Possible patterns: 00000000 → 11111111 (256 total).

           ▶️ 2️⃣ Let’s take neg = -10.
               In memory (two’s complement):
                  +10 → 00001010
                 invert bits → 11110101
                 add 1 → 11110110
               So  -10 is stored as: 11110110

           ▶️ 3️⃣ What happens when you print neg directly?
                 System.out.println(neg);
                 ➜ Java interprets 11110110 as a signed number → -10 ✅

           ▶️ 4️⃣ What does Byte.toUnsignedInt(neg) do?
                 ➜ It reinterprets the same 8 bits (11110110)
                    as if they belong to an **unsigned range** (0..255).
                 ➜ So instead of treating MSB (leftmost bit) as "sign bit",
                    it just reads the bits as a positive integer:

                      11110110₂ = 128 + 64 + 32 + 16 + 4 + 2 = 246 ✅

                 Hence:
                      Signed:  -10
                      Unsigned: 246

           ▶️ 5️⃣ Why 246?
                 Because we “wrapped” around the byte’s range:
                     256 total values → -10 = 256 - 10 = 246
                 ✅ This is another quick trick:
                    unsigned_value = signed_value + 256 (if signed_value < 0)

           ▶️ 6️⃣ Practical use:
                 Useful when you’re reading raw bytes from a file/network,
                 where the byte actually represents a color (0–255),
                 but Java shows negative numbers due to signed behavior.
        */



        // =====================================================
        // 🧩 4️⃣ char → only unsigned primitive in Java
        // =====================================================
        char c = 'A';  // 65 in Unicode
        System.out.println("7️⃣ char value: " + c);           // -> A
        System.out.println("8️⃣ char numeric value: " + (int)c); // -> 65

        char c2 = 65535;
        System.out.println("9️⃣ Max char value: " + (int)c2); // -> 65535
        // 💡 char uses 16 bits (unsigned range 0–65535). It never stores negative values.


        // =====================================================
        // 🧩 5️⃣ Quick Summary
        // =====================================================
        /*
           ✅ All integer primitives in Java (byte, short, int, long) are SIGNED.
           ✅ Stored in **two’s complement** form.
           ✅ char is UNSIGNED (range 0–65535).
           ✅ Overflow wraps cyclically (no error).
           ✅ Java 8+ provides helper methods for unsigned views:
                - Byte.toUnsignedInt()
                - Short.toUnsignedInt()
                - Integer.toUnsignedLong()
                - Long.compareUnsigned()
        */


        // =====================================================
        // 💬 Interview-style Explanation
        // =====================================================
        /*
           "Java stores all integer values as signed two’s complement.
            The leftmost bit represents the sign — 0 for positive, 1 for negative.
            char is the only unsigned type.
            To interpret signed bytes as positive (0–255), use Byte.toUnsignedInt().
            Overflow doesn’t throw an error — it wraps around cyclically."
        */
    }
}
