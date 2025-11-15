// File: _2_Tricky2_ShiftOperators.java
// 🎯 Topic: Shift Operators (<<  >>  >>>) with Easy Binary Explanation
// 🧠 Specially made for interview tricky questions

public class _2_Tricky2_ShiftOperators {

    public static void main(String[] args) {

        /*
           ⭐ IMPORTANT RULE:
           Shift operators work on BITS of a number.
           They DO NOT change the actual value step-by-step.
           They shift the binary representation.

           ✔ Left Shift:      <<   (multiply by 2^n)
           ✔ Right Shift:     >>   (divide by 2^n, keeps sign)
           ✔ Unsigned Shift:  >>>  (fills leading bits with 0)
        */



        /* ============================================================
           ✅ 1️⃣  Left Shift (<<)
           -------------------------------------------------------------
           👉 Expression:   1 << 3

           ✔ Meaning:
             Shift all bits of 1 to the LEFT by 3 positions.

           ✔ Binary Steps:
             1  in binary = 0000 0001

             Shift left by 3:
             0000 0001 << 3  =  0000 1000

           ✔ Convert binary back:
             00001000 = 8

           ✔ Conclusion:
             1 << 3 = 8
           (Same as: 1 * 2^3 = 8)
        ============================================================ */
        System.out.println("1 << 3 = " + (1 << 3));





        /* ============================================================
           ✅ 2️⃣  Arithmetic Right Shift (>>)
           -------------------------------------------------------------
           👉 Expression:   -8 >> 1

           ✔ Meaning:
             Shift bits of -8 one step RIGHT.
             The LEFTMOST bit (sign bit) stays **1** because number is negative.

           ✔ Binary of -8:
             -8 in 32-bit two's complement:
             11111111 11111111 11111111 11111000

           ✔ Right shift by 1:
             11111111 11111111 11111111 11111000 >> 1
             becomes
             11111111 11111111 11111111 11111100

           ✔ Convert back:
             11111100 = -4

           ✔ Conclusion:
             -8 >> 1 = -4
           (Same as: floor(-8 / 2) = -4)
        ============================================================ */
        System.out.println("-8 >> 1 = " + (-8 >> 1));






        /* ============================================================
           ✅ 3️⃣  UNSIGNED Right Shift (>>>)
           -------------------------------------------------------------
           👉 Expression:  -8 >>> 1

           ✔ Meaning:
             Logical shift → fills LEFT side with **0**, NOT sign bit.

           ✔ Binary of -8:
             11111111 11111111 11111111 11111000   (negative)

           ✔ Unsigned shift by 1:
             01111111 11111111 11111111 11111100

           ✔ Now number becomes LARGE POSITIVE.
             (Because highest bit is now 0)

           ✔ Convert to decimal:
             2147483644

           ✔ Conclusion:
             -8 >>> 1 = 2147483644
           (Unsigned right shift ALWAYS turns negative → positive)
        ============================================================ */
        System.out.println("-8 >>> 1 = " + (-8 >>> 1));






        System.out.println("\n🎉 Shift Operator Concepts Completed Successfully!");
    }
}


/**
 *  -------------------------------------------------------------------------
 *  ✅ SHIFT OPERATOR MASTER EXPLANATION  (1 << 3), (-8 >> 1), (-8 >>> 1)
 *  -------------------------------------------------------------------------
 *
 *  ⭐ Evaluation direction: LEFT → RIGHT (but shift operations are simple)
 *
 *  ⭐ IMPORTANT:
 *    Java stores integers in **32-bit two's complement** form.
 *
 *
 *  ========================================================================
 *  🔥 PART 2 — Understanding: -8  (HOW its binary is formed)
 *  ========================================================================
 *
 *  ⭐ Two's complement RULE:
 *      Step 1: Write +8
 *             00000000 00000000 00000000 00001000
 *
 *      Step 2: Invert all bits  (0→1, 1→0)
 *             11111111 11111111 11111111 11110111
 *
 *      Step 3: Add +1
 *             11111111 11111111 11111111 11111000   (THIS is -8)
 *
 *  ✔ FINAL BINARY OF -8:
 *      11111111 11111111 11111111 11111000
 *
 *
 *  ========================================================================
 *  🔥 PART 3 — Understanding: -8 >> 1  (ARITHMETIC RIGHT SHIFT)
 *  ========================================================================
 *
 *  ⭐ >> keeps SIGN BIT (leftmost bit).
 *
 *  Since -8 has sign bit = 1 (negative), shifting right FILLS with 1:
 *
 *  BEFORE (binary of -8):
 *      11111111 11111111 11111111 11111000
 *
 *  AFTER shifting >>1:
 *      11111111 11111111 11111111 11111100   (sign bit preserved)
 *
 *  ➤ This binary = -4
 *
 *  ✔ FINAL:
 *      -8 >> 1 = -4
 *
 *
 *  ========================================================================
 *  🔥 PART 4 — Understanding: -8 >>> 1  (LOGICAL RIGHT SHIFT)
 *  ========================================================================
 *
 *  ⭐ >>> DOES NOT PRESERVE SIGN BIT
 *      It always fills the left with 0s.
 *
 *  BEFORE (binary of -8):
 *      11111111 11111111 11111111 11111000
 *
 *  AFTER >>> 1:
 *      01111111 11111111 11111111 11111100
 *
 *  🚀 This is a HUGE POSITIVE number because sign bit becomes 0.
 *
 *  ✔ FINAL:
 *      -8 >>> 1 = 2147483644
 *
 *
 *  ========================================================================
 *  📌 QUICK SUMMARY
 *  ========================================================================
 *
 *      1 << 3      →   8      (multiply by 8)
 *      -8 >> 1     →  -4      (sign bit preserved)
 *      -8 >>> 1    →  a very large positive number (sign removed)
 *
 *  -------------------------------------------------------------------------
 *  END OF SHIFT MASTER EXPLANATION
 *  -------------------------------------------------------------------------
 */
