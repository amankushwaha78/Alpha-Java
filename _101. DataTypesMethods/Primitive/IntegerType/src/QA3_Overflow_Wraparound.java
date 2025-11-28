// File: _QA3_Overflow_Wraparound.java
// 🎯 Topic: Integer overflow & wrap-around in Java (byte / short / int / long)
// 🧠 Core idea: Java integral types use **two's complement**. On overflow, values **wrap** (no exception).
// ✅ Bonus: How to detect overflow with Math.addExact (throws ArithmeticException).

public class QA3_Overflow_Wraparound {
    public static void main(String[] args) {

        System.out.println("🚀 QA3 — Overflow & Wrap-around (two's complement)\n");

        // =====================================================
        // 🧩 1️⃣ Byte overflow (8 bits, range: -128..127)
        // =====================================================
        byte bx = 127;                     // 0111_1111₂  (max byte)
        bx++;                              // +1 → 1000_0000₂
        System.out.println("1) byte 127 + 1  → " + bx); // -> -128
        /*
           📘 Why?
           - Two's complement flips from max positive to min negative.
           - 127 (0x7F) + 1 = 0x80 → interpreted as -128 in signed byte.
        */

        // =====================================================
        // 🧩 2️⃣ Short overflow (16 bits, range: -32768..32767)
        // =====================================================
        short sx = 32767;                  // 0x7FFF (max short)
        sx++;                              // +1 → 0x8000
        System.out.println("2) short 32767 + 1 → " + sx); // -> -32768
        /*
           📘 Why?
           - 0x7FFF + 0x0001 = 0x8000 → signed short view = -32768.
        */

        // =====================================================
        // 🧩 3️⃣ Int overflow (32 bits, range: -2^31..2^31-1)
        // =====================================================
        int imax = Integer.MAX_VALUE;      //  2,147,483,647
        int iwrap = imax + 1;              // wraps to Integer.MIN_VALUE
        System.out.println("3) int MAX + 1     → " + iwrap); // -> -2147483648

        int imin = Integer.MIN_VALUE;      // -2,147,483,648
        int iwrapBack = imin - 1;          // wraps to Integer.MAX_VALUE
        System.out.println("4) int MIN - 1     → " + iwrapBack); // -> 2147483647
        /*
           📘 Why?
           - Arithmetic is modulo 2^32 for int.
           - Crossing the boundary wraps to the opposite extreme.
        */

        // =====================================================
        // 🧩 4️⃣ Long overflow (64 bits, range: -2^63..2^63-1)
        // =====================================================
        long lmax = Long.MAX_VALUE;        //  9,223,372,036,854,775,807
        long lwrap = lmax + 1;             // wraps to Long.MIN_VALUE
        System.out.println("5) long MAX + 1    → " + lwrap); // -> -9223372036854775808

        long lmin = Long.MIN_VALUE;        // -9,223,372,036,854,775,808
        long lwrapBack = lmin - 1;         // wraps to Long.MAX_VALUE
        System.out.println("6) long MIN - 1    → " + lwrapBack); // -> 9223372036854775807
        /*
           📘 Why?
           - Arithmetic is modulo 2^64 for long.
           - Two's complement keeps the bit pattern; only interpretation changes.
        */

        // =====================================================
        // 🧩 5️⃣ Visual intuition (two's complement circle)
        // =====================================================
        /*
            For each type, think of numbers arranged on a circle:

                 MAX → +1 → MIN → +1 → ... (wrap)
            Example (byte):
                 127 → +1 → -128 → -127 → ... → 0 → ... → 126 → 127

            No exception is thrown for overflow in primitive int/long ops.
        */


        // =====================================================
        // 🧩 8️⃣ Takeaways (talk-track for interviewer)
        // =====================================================
        /*
           ✅ Java uses two's complement fixed-width integers.
           ✅ Overflow does NOT throw by default; it wraps modulo 2^N.
           ✅ byte/short overflow behaves the same (just fewer bits).
           ✅ For huge-precision math, use BigInteger (no overflow).
        */

        System.out.println("\n🎯 QA3 complete — overflow behavior crystal clear!");
    }
}
