// Topic: double (primitive) + Double (wrapper) + precision + compare + NaN/Infinity + -0.0
// 🧠 double = 8 bytes, 64-bit IEEE 754 floating point. Higher precision than float.

import java.math.BigDecimal;
//import java.math.RoundingMode;

public class _8_DoubleAndWrapperNotes {
    public static void main(String[] args) {

        // --------------------------------------
        // 1) double — Primitive Basics
        // --------------------------------------
        double price = 10.5;                                // double literal (no suffix needed)
        double tax   = 2.3;
        System.out.println("Sum: " + (price + tax));        // -> Sum: 12.8
        System.out.println("Diff: " + (price - tax));       // -> Diff: 8.2
        System.out.println("Prod: " + (price * 2));         // -> Prod: 21.0
        System.out.println("Div : " + (price / 2));         // -> Div : 5.25

        // --------------------------------------
        // 2) Precision / Binary Representation
        // --------------------------------------
        double y = 0.1 + 0.2;
        System.out.println("0.1 + 0.2 = " + y);             // -> 0.30000000000000004  (not exact)
        // 💡 Binary floating point can't represent many decimals exactly.

        // --------------------------------------
        // 3) Double — Wrapper (boxing/unboxing)
        // --------------------------------------
        Double boxed = Double.valueOf(price);                // Boxing
        double unboxed = boxed.doubleValue();                // Unboxing
        System.out.println("Boxed: " + boxed);               // -> 10.5
        System.out.println("Unboxed: " + unboxed);           // -> 10.5
        // ⚠ Double/Float wrappers are typically NOT cached; don't rely on '==' for objects.

        // --------------------------------------
        // 4) Inbuilt Methods (Double)
        // --------------------------------------
        System.out.println(Double.parseDouble("12.345"));    // -> 12.345
        System.out.println(Double.toString(5.5));            // -> 5.5
        System.out.println(Double.compare(10.0, 20.0));      // -> -1
        System.out.println(Double.compare(20.0, 10.0));      // -> 1
        System.out.println(Double.compare(10.0, 10.0));      // -> 0
        System.out.println(Double.max(10.5, 20.8));          // -> 20.8
        System.out.println(Double.min(10.5, 20.8));          // -> 10.5
        System.out.println(Double.sum(1.5, 2.5));            // -> 4.0

        // --------------------------------------
        // 5) Special Values: Infinity & NaN
        // --------------------------------------
        double posInf = 10.0 / 0.0;                          // Infinity (allowed for doubles)
        double nanVal = 0.0 / 0.0;                            // NaN (undefined)
        System.out.println("10/0  : " + posInf);             // -> Infinity
        System.out.println("0/0   : " + nanVal);             // -> NaN
        System.out.println(Double.isInfinite(posInf));        // -> true
        System.out.println(Double.isNaN(nanVal));             // -> true
        // 💡 NaN is contagious in ops, and NaN != NaN.

        // --------------------------------------
        // 6) -0.0 vs 0.0 (IEEE 754 quirk)
        // --------------------------------------
        double plusZero  = 0.0;
        double minusZero = -0.0;
        System.out.println(plusZero == minusZero);           // -> true   (numerically equal)
        System.out.println(Double.doubleToLongBits(plusZero)
                == Double.doubleToLongBits(minusZero));      // -> false  (different bit patterns)
        System.out.println(1.0/plusZero);                    // -> Infinity
        System.out.println(1.0/minusZero);                   // -> -Infinity
        // 💡 Double.equals uses bitwise comparison; 0.0 and -0.0 are NOT equal by equals().

        System.out.println(Double.valueOf(0.0).equals(Double.valueOf(-0.0))); // -> false

        // --------------------------------------
        // 7) Rounding Helpers (Math)
        // --------------------------------------
        double v = 12.3456;
        System.out.println(Math.round(v));                   // -> 12  (to long; halves away from 0)
        System.out.println(Math.floor(v));                   // -> 12.0
        System.out.println(Math.ceil(v));                    // -> 13.0

        // --------------------------------------
        // 8) Proper Decimal Rounding (BigDecimal tip)
        // --------------------------------------
        // ⚠ Use BigDecimal for money/currency to avoid float/double errors.
//        BigDecimal bd = new BigDecimal("12.3456")
//                .setScale(2, RoundingMode.HALF_UP);
//        System.out.println("BigDecimal(2dp): " + bd);        // -> 12.35

        // --------------------------------------
        // 9) Constants
        // --------------------------------------
        System.out.println("MAX_VALUE : " + Double.MAX_VALUE);   // -> 1.7976931348623157E308
        System.out.println("MIN_VALUE : " + Double.MIN_VALUE);   // -> 4.9E-324 (smallest +ve subnormal)
        System.out.println("MIN_NORMAL: " + Double.MIN_NORMAL);  // -> 2.2250738585072014E-308
        System.out.println("POS_INF   : " + Double.POSITIVE_INFINITY); // -> Infinity
        System.out.println("NEG_INF   : " + Double.NEGATIVE_INFINITY); // -> -Infinity
        System.out.println("NaN const : " + Double.NaN);         // -> NaN

        // --------------------------------------
        // 10) Safe Equality Guidance
        // --------------------------------------
        // Prefer tolerance-based comparison for doubles:
        double a = 0.3, b = 0.1 + 0.2, eps = 1e-9;
        boolean approxEqual = Math.abs(a - b) < eps;
        System.out.println("Approx equal? " + approxEqual);  // -> true
    }
}
