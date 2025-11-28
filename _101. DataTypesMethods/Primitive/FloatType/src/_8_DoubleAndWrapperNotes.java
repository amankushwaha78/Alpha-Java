// File: _8_DoubleAndWrapperNotes.java
// Topic: double (primitive) + Double (wrapper) + precision + compare + NaN/Infinity + -0.0
// 🧠 double = 8 bytes (64-bit IEEE 754 floating-point number) — more precise than float (~15–16 digits)

import java.math.BigDecimal;
// import java.math.RoundingMode; // Uncomment for rounding examples

public class _8_DoubleAndWrapperNotes {
    public static void main(String[] args) {

        // =====================================================
        // 🧩 1️⃣ double — Primitive Basics
        // =====================================================
        // 👉 double is the default type for decimal values in Java.
        // 👉 More precise and larger range than float (uses 64 bits).

        double price = 10.5;   // double literal (no 'f' needed)
        double tax   = 2.3;

        System.out.println("Sum : " + (price + tax));   // -> 12.8
        System.out.println("Diff: " + (price - tax));   // -> 8.2
        System.out.println("Prod: " + (price * 2));     // -> 21.0
        System.out.println("Div : " + (price / 2));     // -> 5.25

        // 💡 Use double for scientific or precise fractional values (but not for money).

        // =====================================================
        // 🧩 2️⃣ Precision Example
        // =====================================================
        double y = 0.1 + 0.2;
        System.out.println("0.1 + 0.2 = " + y); // -> 0.30000000000000004

        /*
           💡 Why this happens:
              - Decimal numbers like 0.1, 0.2 can’t be exactly represented in binary.
              - Tiny rounding errors appear due to IEEE 754 format.
              - Always use BigDecimal for financial calculations.
        */

        // =====================================================
        // 🧩 3️⃣ Double — Wrapper Class
        // =====================================================
        // 👉 Converts primitive double into an object (useful in Collections, null values).

        Double boxed = Double.valueOf(price);   // Boxing (primitive → object)
        double unboxed = boxed.doubleValue();   // Unboxing (object → primitive)

        System.out.println("Boxed   : " + boxed);   // -> 10.5
        System.out.println("Unboxed : " + unboxed); // -> 10.5

        // Auto-boxing / Auto-unboxing
        Double autoBox = 55.75;
        double autoUnbox = autoBox;
        System.out.println("AutoBox   : " + autoBox);
        System.out.println("AutoUnbox : " + autoUnbox);

        // =====================================================
        // 🧩 4️⃣ Inbuilt Methods (Double class)
        // =====================================================
        System.out.println(Double.parseDouble("12.345"));  // -> 12.345 (String → double)
        System.out.println(Double.toString(5.5));          // -> "5.5"  (double → String)
        System.out.println(Double.compare(10.0, 20.0));    // -> -1
        System.out.println(Double.max(10.5, 20.8));        // -> 20.8
        System.out.println(Double.min(10.5, 20.8));        // -> 10.5
        System.out.println(Double.sum(1.5, 2.5));          // -> 4.0

        /*
           💡 Key Methods:
              - parseDouble(String) → converts String → double
              - toString(double)   → converts double → String
              - compare(a, b) → returns -1 / 0 / 1
              - max(), min(), sum() → utility math helpers
        */

        // =====================================================
        // 🧩 5️⃣ Special Values — Infinity & NaN
        // =====================================================
        double posInf = 10.0 / 0.0;   // Infinity
        double nanVal = 0.0 / 0.0;    // NaN

        System.out.println("10/0 = " + posInf);   // -> Infinity
        System.out.println("0/0  = " + nanVal);   // -> NaN
        System.out.println(Double.isInfinite(posInf)); // -> true
        System.out.println(Double.isNaN(nanVal));      // -> true

        /*
           💡 Explanation:
              - Infinity → when number too large or divide by zero.
              - NaN (Not a Number) → invalid operation like 0.0/0.0.
              - NaN != NaN (use Double.isNaN() instead).
        */

        // =====================================================
        // 🧩 6️⃣ IEEE 754 Quirk — +0.0 vs -0.0
        // =====================================================
        double plusZero  = 0.0;
        double minusZero = -0.0;

        System.out.println(plusZero == minusZero);   // -> true (numerically equal)
        System.out.println(Double.doubleToLongBits(plusZero)
                == Double.doubleToLongBits(minusZero)); // -> false (different bits)
        System.out.println(1.0 / plusZero);          // -> Infinity
        System.out.println(1.0 / minusZero);         // -> -Infinity

        System.out.println(Double.valueOf(0.0).equals(Double.valueOf(-0.0))); // -> false

        /*
           💡 +0.0 and -0.0 are equal in math but differ in binary representation.
              This affects certain operations and comparisons.
        */

        // =====================================================
        // 🧩 7️⃣ Comparison Pitfall — Wrapper Behavior
        // =====================================================
        // 👉 '==' compares object reference (memory address)
        // 👉 'equals()' compares actual numeric value
        // 👉 JVM caches some wrapper objects like Integer (-128 to 127),
        //    but Double does NOT cache any range — always creates new objects.

        Double p = 100.0; // new object
        Double q = 100.0; // another new object
        Double r = 200.0;
        Double s = 200.0;

        System.out.println(p == q);      // -> false (no caching)
        System.out.println(r == s);      // -> false
        System.out.println(p.equals(q)); // -> true  (same numeric value)
        System.out.println(r.equals(s)); // -> true

        // 💡 Always use equals() when comparing Double or Float objects.

        // =====================================================
        // 🧩 8️⃣ Safe Equality for Primitive double
        // =====================================================
        double a = 0.3;
        double b = 0.1 + 0.2;
        double eps = 1e-9; // small tolerance

        boolean approxEqual = Math.abs(a - b) < eps;
        System.out.println("Approx equal? " + approxEqual); // -> true

        /*
           💡 Due to rounding errors, always use tolerance comparison:
              |a - b| < ε (epsilon) → considered approximately equal.
        */

        // =====================================================
        // 🧩 9️⃣ Rounding Helpers (Math)
        // =====================================================
        double val = 12.3456;
        System.out.println(Math.round(val)); // -> 12  (rounds to nearest long)
        System.out.println(Math.floor(val)); // -> 12.0 (rounds down)
        System.out.println(Math.ceil(val));  // -> 13.0 (rounds up)

        /*
           💡 Math Rounding:
              - round() → nearest integer
              - floor() → round down
              - ceil()  → round up
        */

        // =====================================================
        // 🧩 🔟 BigDecimal Tip (Precise Rounding)
        // =====================================================
        // ⚠ Use BigDecimal for accurate financial calculations.
//        BigDecimal bd = new BigDecimal("12.3456")
//                .setScale(2, RoundingMode.HALF_UP);
//        System.out.println("Rounded with BigDecimal: " + bd); // -> 12.35

        /*
           💡 BigDecimal avoids floating-point rounding errors.
              Always create BigDecimal using String, not double!
        */

        // =====================================================
        // 🧩 1️⃣1️⃣ Constants
        // =====================================================
        System.out.println("MAX_VALUE : " + Double.MAX_VALUE);        // 1.7976931348623157E308
        System.out.println("MIN_VALUE : " + Double.MIN_VALUE);        // 4.9E-324
        System.out.println("MIN_NORMAL: " + Double.MIN_NORMAL);       // 2.2250738585072014E-308
        System.out.println("POS_INF   : " + Double.POSITIVE_INFINITY);// Infinity
        System.out.println("NEG_INF   : " + Double.NEGATIVE_INFINITY);// -Infinity
        System.out.println("NaN const : " + Double.NaN);              // NaN

        // =====================================================
        // 🧠 Summary
        // =====================================================
        /*
           ✅ double — 8 bytes, high-precision decimal type
           ✅ Double — wrapper class (no caching unlike Integer)
           ✅ NaN & Infinity follow IEEE-754 rules
           ✅ +0.0 ≠ -0.0 in bits (but equal numerically)
           ✅ Use epsilon-based check for precision equality
           ✅ Use BigDecimal for accurate monetary values
           ✅ Always use equals() for wrapper comparison
           ✅ Common methods:
               • parseDouble(), toString(), compare(), max(), min(), sum()
               • isNaN(), isInfinite()
        */
    }
}
