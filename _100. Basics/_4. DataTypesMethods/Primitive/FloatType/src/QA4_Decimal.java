
public class QA4_Decimal {
    public static void main(String[] args) {

        /* ============================================================
         * 🧩 1️⃣ What are decimal data types in Java?
         * ============================================================
         * ➤ Java has three main ways to handle decimal numbers:
         *   1️⃣ float   → 4 bytes (32-bit, single precision)
         *   2️⃣ double  → 8 bytes (64-bit, double precision)
         *   3️⃣ BigDecimal → high precision (class for exact decimals)
         *
         * 💡 Use float/double for scientific or approximate data.
         * 💡 Use BigDecimal for money or financial calculations.
         */

        /* ============================================================
         * 🧩 2️⃣ Difference between float and double
         * ============================================================
         * | Feature     | float (4 bytes) | double (8 bytes) |
         * |--------------|----------------|------------------|
         * | Precision    | ~6–7 digits    | ~15–16 digits    |
         * | Speed        | Faster         | Slower           |
         * | Accuracy     | Lower          | Higher           |
         * | Suffix       | f or F needed  | Not needed       |
         *
         * Example:
         *   float f = 3.14f;
         *   double d = 3.14159265358979;
         */

        /* ============================================================
         * 🧩 3️⃣ Why 0.1 + 0.2 != 0.3 ?
         * ============================================================
         * ➤ In binary, 0.1 and 0.2 cannot be represented exactly.
         * ➤ They are stored as repeating binary fractions.
         * ➤ So 0.1 + 0.2 becomes 0.30000000000000004
         *
         * 💡 Always remember:
         *   Floating point math is approximate, not exact.
         */

        /* ============================================================
         * 🧩 4️⃣ When to use BigDecimal?
         * ============================================================
         * ➤ Use BigDecimal for precise decimal math (like money, tax).
         *
         * Example:
         *   BigDecimal a = new BigDecimal("0.1");
         *   BigDecimal b = new BigDecimal("0.2");
         *   BigDecimal sum = a.add(b);
         *   System.out.println(sum); // → 0.3 ✅ exact
         *
         * ⚠ If you use BigDecimal with double:
         *   new BigDecimal(0.1) → 0.10000000000000000555 ❌ (inaccurate)
         *
         * ✅ Always pass String in constructor, not double.
         */

        /* ============================================================
         * 🧩 5️⃣ What are NaN and Infinity in decimals?
         * ============================================================
         * ➤ Only float and double can produce these special values.
         *
         * Example:
         *   double x = 10.0 / 0;    // Infinity
         *   double y = -10.0 / 0;   // -Infinity
         *   double z = 0.0 / 0.0;   // NaN (Not a Number)
         *
         * 💡 Check using:
         *   Double.isInfinite(x)
         *   Double.isNaN(z)
         *
         * Note:
         *   NaN != NaN  → true
         *   Double.NaN.equals(Double.NaN) → false
         */

        /* ============================================================
         * 🧩 6️⃣ What is -0.0 in float/double?
         * ============================================================
         * ➤ IEEE 754 allows both +0.0 and -0.0.
         * ➤ They compare equal but behave differently in division.
         *
         * Example:
         *   double a = 0.0, b = -0.0;
         *   System.out.println(a == b);  // true
         *   System.out.println(1.0/a);   // Infinity
         *   System.out.println(1.0/b);   // -Infinity
         */

        /* ============================================================
         * 🧩 7️⃣ How to round decimals in Java?
         * ============================================================
         * ✅ Using Math:
         *   double value = 12.3456;
         *   double rounded = Math.round(value * 100.0) / 100.0;  // → 12.35
         *
         * ✅ Using BigDecimal:
         *   BigDecimal bd = new BigDecimal("12.3456");
         *   bd = bd.setScale(2, RoundingMode.HALF_UP);
         *   System.out.println(bd);  // → 12.35
         *
         * 💡 RoundingMode options:
         *   - HALF_UP → 1.25 → 1.3
         *   - HALF_DOWN → 1.25 → 1.2
         *   - FLOOR → always down
         *   - CEILING → always up
         */

        /* ============================================================
         * 🧩 8️⃣ How to compare decimals safely?
         * ============================================================
         * ❌ Never do:
         *     if (a == b)
         * ✅ Do this instead:
         *     if (Math.abs(a - b) < 1e-6)
         *
         * ➤ For BigDecimal:
         *     a.compareTo(b) == 0 ✅
         *
         * Example:
         *   BigDecimal x = new BigDecimal("1.20");
         *   BigDecimal y = new BigDecimal("1.200");
         *   x.equals(y) → false ❌ (scale matters)
         *   x.compareTo(y) → 0 ✅ (numerically equal)
         */

        /* ============================================================
         * 🧩 9️⃣ Formatting decimals for output
         * ============================================================
         * Using printf:
         *   System.out.printf("%.2f", 12.3456); // → 12.35
         *
         * Using String.format:
         *   String s = String.format("%.3f", 1.2367); // → 1.237
         *
         * Using DecimalFormat:
         *   DecimalFormat df = new DecimalFormat("#,##0.00");
         *   System.out.println(df.format(12345.678)); // → 12,345.68
         */

        /* ============================================================
         * 🧩 🔟 Why use BigDecimal in banking systems?
         * ============================================================
         * ➤ Because float/double may produce rounding errors:
         *   0.1 + 0.2 = 0.30000000000000004 ❌
         *
         * ➤ BigDecimal keeps exact value:
         *   new BigDecimal("0.1").add(new BigDecimal("0.2")) = 0.3 ✅
         *
         * 💡 BigDecimal supports exact precision and multiple rounding modes.
         */

        /* ============================================================
         * 🧩 11️⃣ What’s the range of double?
         * ============================================================
         * ➤ MIN_VALUE = 4.9E-324  (smallest positive)
         * ➤ MAX_VALUE = 1.7976931348623157E308
         * ➤ MIN_NORMAL = 2.2250738585072014E-308
         * ➤ POSITIVE_INFINITY, NEGATIVE_INFINITY, NaN
         */

        /* ============================================================
         * 🧩 12️⃣ Common Interview Traps
         * ============================================================
         * Q1:  System.out.println(0.1f + 0.2f == 0.3f);
         * A1:  false (precision loss)
         *
         * Q2:  System.out.println(Double.NaN == Double.NaN);
         * A2:  false (NaN is never equal)
         *
         * Q3:  System.out.println(1.0 / 0.0);
         * A3:  Infinity
         *
         * Q4:  System.out.println(new BigDecimal(0.1));
         * A4:  0.10000000000000000555 ❌
         *      (Never create BigDecimal from double)
         *
         * Q5:  System.out.println(new BigDecimal("0.1"));
         * A5:  0.1 ✅
         */

        /* ============================================================
         * 🧩 13️⃣ Summary for interviews
         * ============================================================
         * ✅ float  — fast, 6–7 digits precision, small memory
         * ✅ double — precise, 15–16 digits, default for decimals
         * ✅ BigDecimal — exact, used for money
         * ✅ NaN, Infinity, -0.0 are part of IEEE floating point
         * ✅ Compare using tolerance or compareTo()
         * ✅ Format output using printf or DecimalFormat
         * ✅ BigDecimal → always use String constructor
         */
    }
}
