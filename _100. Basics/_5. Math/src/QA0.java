// File: _QA1_MathOutputScenarios.java
// Topic: Output-Based Java Questions — Math Class Functions
// 🧩 Covers 17 tricky and most commonly asked Math output scenarios.

public class QA0 {
    public static void main(String[] args) {

        /* ============================================================
         * 🧮 1️⃣ Math.round() — midpoint rounding (away from zero)
         * ============================================================
         */
        System.out.println(Math.round(12.4));  // -> 12
        System.out.println(Math.round(12.5));  // -> 13
        System.out.println(Math.round(-12.5)); // -> -12
        /*
           🔍 Explanation:
           • round(x) returns long/int depending on argument type.
           • It rounds to nearest integer, and .5 goes away from zero.
             - 12.4 → 12
             - 12.5 → 13
             - -12.5 → -12
        */

        /* ============================================================
         * ⚙️ 2️⃣ Math.rint() — ties to even (banker’s rounding)
         * ============================================================
         */
        System.out.println(Math.rint(12.5)); // -> 12.0
        System.out.println(Math.rint(13.5)); // -> 14.0
        /*
           🔍 Explanation:
           • rint(x) returns double.
           • If value exactly halfway (.5), rounds to nearest even integer.
             12.5 → 12.0  |  13.5 → 14.0
        */

        /* ============================================================
         * ➗ 3️⃣ floorDiv() vs '/' (with negatives)
         * ============================================================
         */
        System.out.println(-7 / 3);              // -> -2
        System.out.println(Math.floorDiv(-7, 3));// -> -3
        /*
           🔍 Explanation:
           • '/' truncates toward 0 → -7/3 = -2
           • floorDiv() rounds down toward -∞ → -3
           ✅ Use floorDiv() for consistent math with negatives.
        */

        /* ============================================================
         * 🔢 4️⃣ floorMod() vs '%' remainder
         * ============================================================
         */
        System.out.println(-7 % 3);               // -> -1
        System.out.println(Math.floorMod(-7, 3)); // -> 2
        /*
           🔍 Explanation:
           • '%' keeps sign of dividend (-7) → -1
           • floorMod() keeps result non-negative → 2
        */

        /* ============================================================
         * 💣 5️⃣ Overflow-safe addition
         * ============================================================
         */
        System.out.println(Integer.MAX_VALUE + 1);
        // System.out.println(Math.addExact(Integer.MAX_VALUE, 1)); // Exception
        /*
           🔍 Output:
           -2147483648
           ⚠ Overflow occurs silently with '+'
           ✅ addExact() throws ArithmeticException if overflow happens.
        */

        /* ============================================================
         * 💯 6️⃣ Ceil/Floor with negative numbers
         * ============================================================
         */
        System.out.println(Math.ceil(-2.7));  // -> -2.0
        System.out.println(Math.floor(-2.7)); // -> -3.0
        /*
           🔍 Explanation:
           • ceil() → smallest integer ≥ value (less negative)
           • floor() → largest integer ≤ value (more negative)
        */

        /* ============================================================
         * ⚖️ 7️⃣ abs() corner case (Integer.MIN_VALUE)
         * ============================================================
         */
        System.out.println(Math.abs(-2147483648)); // -> -2147483648
        /*
           🔍 Explanation:
           • abs() returns same value because int range = [-2³¹, 2³¹-1]
           • Overflow, as +2147483648 doesn't fit in int.
           💡 Use long for safe absolute calculations.
        */

        /* ============================================================
         * 📉 8️⃣ min() & max()
         * ============================================================
         */
        System.out.println(Math.max(2.5, 2.49)); // -> 2.5
        System.out.println(Math.min(-5, -10));   // -> -10
        /*
           🔍 Explanation:
           • min/max return same type as inputs (int, double, etc.)
        */

        /* ============================================================
         * 📈 9️⃣ pow() and sqrt()
         * ============================================================
         */
        System.out.println(Math.pow(2, 3.5)); // -> 11.313708498984761
        System.out.println(Math.sqrt(2));     // -> 1.4142135623730951
        /*
           🔍 Explanation:
           • pow(a,b) → a raised to power b (returns double)
           • sqrt(x)  → square root (double)
        */

        /* ============================================================
         * 🧮 🔟 sin() with radians vs degrees
         * ============================================================
         */
        System.out.println(Math.sin(30));                   // -> -0.9880316 (wrong)
        System.out.println(Math.sin(Math.toRadians(30)));   // -> 0.5 (correct)
        /*
           🔍 Explanation:
           • Math.sin() expects radians, not degrees.
           • toRadians(30) = π/6 → correct sin(30°) = 0.5
        */

        /* ============================================================
         * 🧩 11️⃣ Random number range
         * ============================================================
         */
        int num = (int)(Math.random() * 5) + 1;
        System.out.println(num); // -> Random number between 1 and 5
        /*
           🔍 Explanation:
           • Math.random() → 0.0 ≤ n < 1.0
           • Multiply by range (5), then add 1 → [1,5]
        */

        /* ============================================================
         * ⚡ 12️⃣ nextAfter() & copySign()
         * ============================================================
         */
        System.out.println(Math.nextAfter(1.0, 2.0)); // -> 1.0000000000000002
        System.out.println(Math.copySign(3.5, -2.0)); // -> -3.5
        /*
           🔍 Explanation:
           • nextAfter(a,b) → next representable double after a towards b.
           • copySign(x,y) → returns |x| with sign of y.
        */

        /* ============================================================
         * 🧠 13️⃣ signum() function
         * ============================================================
         */
        System.out.println(Math.signum(-5.0)); // -> -1.0
        System.out.println(Math.signum(0.0));  // -> 0.0
        System.out.println(Math.signum(7.0));  // -> 1.0
        /*
           🔍 Explanation:
           • signum(x) returns:
             -1.0 if negative
              0.0 if zero
              1.0 if positive
        */

        /* ============================================================
         * 🔍 14️⃣ Logarithmic functions
         * ============================================================
         */
        System.out.println(Math.log(1));   // -> 0.0
        System.out.println(Math.log10(100)); // -> 2.0
        /*
           🔍 Explanation:
           • log(x) → natural logarithm base e.
           • log10(x) → base 10 logarithm.
        */

        /* ============================================================
         * ⚙️ 15️⃣ clamp() boundaries
         * ============================================================
         */
        System.out.println(Math.clamp(120, 0, 100)); // -> 100
        System.out.println(Math.clamp(50, 0, 100));  // -> 50
        /*
           🔍 Explanation:
           • clamp(x,min,max) keeps x inside range:
               → returns max if x > max
               → returns min if x < min
               → else x itself
        */

        /* ============================================================
         * 🧮 16️⃣ NaN and Infinity traps
         * ============================================================
         */
        System.out.println(Math.sqrt(-1));                     // -> NaN
        System.out.println(Double.isNaN(Math.sqrt(-1)));       // -> true
        System.out.println(10.0 / 0);                          // -> Infinity
        /*
           🔍 Explanation:
           • sqrt(-1) → Not a Number (NaN)
           • Division by zero (double) → Infinity
           • NaN != NaN → use Double.isNaN() to check.
        */

        /* ============================================================
         * 🧾 17️⃣ Floating-point precision trap
         * ============================================================
         */
        System.out.println(0.1 + 0.2 == 0.3); // -> false
        /*
           🔍 Explanation:
           • 0.1 and 0.2 can’t be represented exactly in binary.
           • (0.1 + 0.2) = 0.30000000000000004
           • Always compare with tolerance:
             Math.abs(a - b) < 1e-9
        */

        /* ============================================================
         * ✅ Summary — Most Asked Math Output Questions
         * ------------------------------------------------------------
         * 1️⃣ round()     → rounds away from zero (.5)
         * 2️⃣ rint()      → rounds to even
         * 3️⃣ floorDiv()  → rounds down for negatives
         * 4️⃣ floorMod()  → positive remainder
         * 5️⃣ addExact()  → throws on overflow
         * 6️⃣ ceil/floor  → differ for negatives
         * 7️⃣ abs(MIN_INT) → overflow issue
         * 8️⃣ max/min     → same-type results
         * 9️⃣ pow/sqrt    → always double
         * 🔟 sin()        → radians only
         * 11️⃣ random()   → range scaling
         * 12️⃣ nextAfter/copySign → floating helpers
         * 13️⃣ signum()   → sign of value (-1/0/1)
         * 14️⃣ log/log10  → logarithms
         * 15️⃣ clamp()    → bounds restriction
         * 16️⃣ NaN/∞      → special float values
         * 17️⃣ precision  → 0.1+0.2 ≠ 0.3
         * ------------------------------------------------------------
         */
    }
}
