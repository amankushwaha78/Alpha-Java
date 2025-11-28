// File: QA_FloatNotes.java
// Topic: Float Interview Q&A — behavior, precision, NaN/Infinity, comparison, parsing
// 🧠 float = 4 bytes (32-bit IEEE 754 floating-point number)

public class QA2_Float {
    public static void main(String[] args) {

        /* ============================================================
         * 🧩 1️⃣ What is float in Java?
         * ============================================================
         * ➤ float is a primitive data type used to store decimal numbers.
         * ➤ It takes 4 bytes (32 bits) of memory.
         * ➤ Follows IEEE 754 single-precision format.
         * ➤ Needs suffix 'f' or 'F' in literals.
         *
         * Example:
         *   float x = 10.5f;
         *   float y = 5.2F;
         */

        /* ============================================================
         * 🧩 2️⃣ What is the difference between float and double?
         * ============================================================
         * | Feature        | float (32-bit) | double (64-bit) |
         * |----------------|----------------|-----------------|
         * | Precision      | ~6–7 digits    | ~15–16 digits   |
         * | Memory         | 4 bytes        | 8 bytes         |
         * | Suffix needed? | Yes (f/F)      | No              |
         * | Speed          | Faster (less accurate) | Slower (more accurate) |
         *
         * 💡 Use float when memory is limited, double for accuracy.
         */

        /* ============================================================
         * 🧩 3️⃣ Why 0.1f + 0.2f != 0.3f ?
         * ============================================================
         * ➤ Because 0.1 and 0.2 cannot be represented exactly in binary.
         * ➤ Result stored as 0.30000004 — small rounding error.
         *
         * 💡 Floating-point arithmetic is *approximate*, not exact.
         * 💡 Use BigDecimal for money or precise calculations.
         */

        /* ============================================================
         * 🧩 4️⃣ How to compare floats correctly?
         * ============================================================
         * ❌ Wrong:
         *     if (a == b)
         * ✅ Correct:
         *     if (Math.abs(a - b) < 1e-6)
         *
         * ➤ Because tiny rounding errors make == unreliable.
         * ➤ Always compare using a small tolerance (epsilon).
         */

        /* ============================================================
         * 🧩 5️⃣ What happens if we divide by zero in float?
         * ============================================================
         * float x = 10.0f / 0;    // → Infinity
         * float y = 0.0f / 0.0f;  // → NaN
         *
         * 💡 Infinity = too large to represent
         * 💡 NaN = Not a Number (invalid result)
         * 💡 Check using:
         *     Float.isInfinite(x)
         *     Float.isNaN(y)
         */

        /* ============================================================
         * 🧩 6️⃣ What is NaN in float?
         * ============================================================
         * ➤ NaN = "Not a Number"
         * ➤ Created from undefined operations (0/0, sqrt(-1), etc.)
         *
         * Special rule:
         *   NaN != NaN      → true
         *   Float.isNaN(NaN) → true
         *
         * 💡 So always use Float.isNaN() to check.
         */

        /* ============================================================
         * 🧩 7️⃣ What is the range of float?
         * ============================================================
         * ➤ MIN_VALUE = 1.4E-45  (smallest positive number)
         * ➤ MAX_VALUE = 3.4028235E38  (largest number)
         * ➤ Float.NaN, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY
         */

        /* ============================================================
         * 🧩 8️⃣ What is the difference between == and equals() for Float?
         * ============================================================
         * Float a = 10.5f;
         * Float b = 10.5f;
         *
         * a == b       → false (compares memory addresses)
         * a.equals(b)  → true  (compares values)
         *
         * 💡 Unlike Integer, Float does NOT cache values.
         * ➤ Each auto-boxed Float creates a new object.
         */

        /* ============================================================
         * 🧩 9️⃣ What are NaN and Infinity in printing?
         * ============================================================
         * System.out.println(10.0f / 0);   // Infinity
         * System.out.println(0.0f / 0);    // NaN
         * System.out.println(-10.0f / 0);  // -Infinity
         *
         * 💡 These are special constants used internally by JVM.
         */

        /* ============================================================
         * 🧩 🔟 How to round float to 2 decimal places?
         * ============================================================
         * ➤ Using Math.round():
         *     float value = 12.3456f;
         *     float rounded = Math.round(value * 100) / 100f;  // 12.35
         *
         * ➤ Or using String.format():
         *     System.out.printf("%.2f", value);  // prints 12.35
         */

        /* ============================================================
         * 🧩 11️⃣ Can float store negative zero (-0.0f)?
         * ============================================================
         * ➤ Yes! float supports +0.0 and -0.0 (different bit patterns)
         *
         * Example:
         *     float a = 0.0f;
         *     float b = -0.0f;
         *     System.out.println(a == b);       // true (numerically equal)
         *     System.out.println(1f/a);         // Infinity
         *     System.out.println(1f/b);         // -Infinity
         *
         * 💡 -0.0f behaves same as 0.0f except in division or bitwise checks.
         */

        /* ============================================================
         * 🧩 12️⃣ Can float be null?
         * ============================================================
         * ➤ No, primitive float cannot be null.
         * ➤ Use Float (wrapper) to store null when needed.
         *   Example:
         *     Float price = null; // valid
         *     float value = null; // ❌ error
         */

        /* ============================================================
         * 🧩 13️⃣ Why float sometimes prints like 1.20000005 ?
         * ============================================================
         * ➤ Because of binary approximation.
         * ➤ Java prints the closest binary representation of the number.
         * ➤ Use formatted output:
         *     System.out.printf("%.2f", 1.20000005f); // → 1.20
         */

        /* ============================================================
         * 🧩 14️⃣ Is float accurate for money?
         * ============================================================
         * ❌ No — due to rounding issues.
         * ✅ Use BigDecimal for money or currency:
         *    BigDecimal value = new BigDecimal("10.25");
         */

        /* ============================================================
         * 🧩 15️⃣ Can float overflow or underflow?
         * ============================================================
         * ➤ Overflow → when value > MAX_VALUE → becomes Infinity.
         * ➤ Underflow → when value < MIN_VALUE → becomes 0.0f.
         *
         * Example:
         *   float big = 1e40f;  // → Infinity
         *   float small = 1e-50f; // → 0.0
         */

        /* ============================================================
         * 🧩 16️⃣ What’s the output?
         * ============================================================
         * Q: float a = 10.0f / 0;
         *    float b = -10.0f / 0;
         *    System.out.println(a + " " + b);
         * A: Infinity  -Infinity
         *
         * Q: float c = 0.0f / 0.0f;
         *    System.out.println(c == c);
         * A: false (NaN != NaN)
         */

        /* ============================================================
         * 🧩 17️⃣ Quick Summary (for interviews)
         * ============================================================
         * ✅ float → 4 bytes, 6–7 digit precision
         * ✅ Stores decimal values with possible rounding errors
         * ✅ Division by zero → Infinity / -Infinity / NaN
         * ✅ NaN != NaN
         * ✅ Float does not cache objects → always use equals()
         * ✅ Compare floats using tolerance, not ==
         * ✅ Use BigDecimal for money
         */
    }
}
