// File: _3_Tricky_Bitwise.java
// 🎯 Topic: Bitwise Operators (&, |, ^, ~) + WHY ~5 == -6 (2's complement explained)

public class _3_Tricky_Bitwise {
    public static void main(String[] args) {

        /**
         * ✅ 1️⃣ Bitwise basics on small positive numbers (5 and 3)
         *
         * 👉 Evaluation direction: LEFT → RIGHT (both operands evaluated), then operator applied.
         *
         * ✔ Let's write 5 and 3 in 4-bit binary (for understanding):
         *
         *      5 = 0101
         *      3 = 0011
         *
         *  🔹 AND (&) → bit is 1 only if BOTH bits are 1
         *      0101
         *    & 0011
         *      ----
         *      0001  = 1
         *
         *  🔹 OR (|) → bit is 1 if ANY one is 1
         *      0101
         *    | 0011
         *      ----
         *      0111  = 7
         *
         *  🔹 XOR (^) → bit is 1 if bits are DIFFERENT
         *      0101
         *    ^ 0011
         *      ----
         *      0110  = 6
         *
         *  🔹 NOT (~) → FLIP every bit (turn 0→1, 1→0)
         *      0101 (this is +5 in 4-bit)
         *      1010 (this is NOT 5)
         *    In 2's complement, 1010 represents -6.
         *
         *  We'll understand ~ and negative representation in the next big block.
         */
        System.out.println("5 & 3  = " + (5 & 3)); // 1
        System.out.println("5 | 3  = " + (5 | 3)); // 7
        System.out.println("5 ^ 3  = " + (5 ^ 3)); // 6
        System.out.println("~5     = " + (~5));    // -6  (this is the main confusion)


        /**
         * ✅ 2️⃣ WHY does ~5 become -6 (and not +something)?
         *
         * 👉 Very, very important: Java 'int' is 32-bit signed, using **2's complement**.
         *
         *  ⚙ Step 1: Write +5 in full 32-bit binary
         *  ----------------------------------------
         *  5 in binary = 00000000 00000000 00000000 00000101
         *
         *      MSB (most significant bit) = leftmost bit = 0  → number is POSITIVE.
         *
         *  ⚙ Step 2: Apply ~ (bitwise NOT) → flip EVERY bit
         *  -----------------------------------------------
         *      00000000 00000000 00000000 00000101   (this is +5)
         *  ~   --------------------------------
         *      11111111 11111111 11111111 11111010   (this is the result of ~5)
         *
         *  ✅ These 32 bits **are actually stored** inside int after ~5.
         *
         *  Now question: "What decimal number do these bits represent?"
         *
         *  👉 Rule in 2's complement:
         *     - If MSB (leftmost bit) is 0 → number is positive → normal binary.
         *     - If MSB is 1 → number is NEGATIVE.
         *
         *  Here MSB = 1, so 11111111 11111111 11111111 11111010 is NEGATIVE.
         *
         *  ⚙ Step 3: Convert NEGATIVE 2's complement to decimal
         *  ----------------------------------------------------
         *  To find value of a negative 2's complement number:
         *
         *    1️⃣ Take the bits.
         *    2️⃣ Invert (flip) all bits.
         *    3️⃣ Add 1.
         *    4️⃣ The result is the POSITIVE magnitude.
         *    5️⃣ Put a minus sign in front.
         *
         *  For our bits:
         *
         *     Original: 11111111 11111111 11111111 11111010   (we know MSB=1 → NEGATIVE)
         *
         *     Step 1: Invert all bits:
         *              00000000 00000000 00000000 00000101
         *
         *     Step 2: Add 1:
         *              00000000 00000000 00000000 00000101
         *            + 00000000 00000000 00000000 00000001
         *            ------------------------------------
         *              00000000 00000000 00000000 00000110
         *
         *     00000000 00000000 00000000 00000110  =  6 (NORMAL positive binary)
         *
         *  🚩 VERY IMPORTANT POINT (your confusion):
         *  ----------------------------------------
         *  You asked:
         *
         *     "but MSB is 0 so it should be positive na
         *      00000000 00000000 00000000 00000110  (6)
         *      Final = -6   → why minus?"
         *
         *  ✅ Answer:
         *  - 00000000 00000000 00000000 00000110 is just the **magnitude** we got AFTER conversion.
         *  - We already knew the original had MSB=1 (so it was NEGATIVE).
         *  - So we take magnitude 6 and attach a minus sign → final value = -6.
         *
         *  So:
         *     11111111 11111111 11111111 11111010  (stored bits after ~5)
         *          ↓
         *     (convert 2's complement → magnitude 6)
         *          ↓
         *     Final decimal value = -6
         *
         *  🔁 Summary:
         *  -----------
         *  - 5  = 00000000 00000000 00000000 00000101
         *  - ~5 = 11111111 11111111 11111111 11111010  (int inside CPU)
         *        MSB=1 → negative, and that pattern means -6 in decimal.
         */
        int five = 5;
        int notFive = ~five;
        System.out.println("\nfive     = " + five);
        System.out.println("~five    = " + notFive); // -6


        /**
         * ✅ 3️⃣ Quick mini-summary for interview:
         *
         *  👉 Bitwise NOT (~x) in Java:
         *     - Works on the binary representation of x.
         *     - Flips all 32 bits.
         *     - If x is positive, ~x will be negative (because MSB becomes 1).
         *
         *  👉 Two's complement rules:
         *     - MSB = 0 → positive → normal binary.
         *     - MSB = 1 → negative → to find value:
         *          • invert bits
         *          • add 1
         *          • put minus sign.
         *
         *  👉 Example you must remember:
         *     - ~0  = -1
         *     - ~1  = -2
         *     - ~5  = -6
         *     - ~(-1) = 0
         *
         *  This combo of examples + explanation will impress interviewer a lot 😎
         */
    }
}
