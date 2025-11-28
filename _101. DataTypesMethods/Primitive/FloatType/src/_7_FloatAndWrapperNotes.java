// File: _7_FloatAndWrapperNotes.java
// Topic: float (primitive) + Float (wrapper class) + inbuilt methods + precision + NaN/Infinity
// 🧠 float = 4 bytes (32-bit IEEE 754 floating-point number)

public class _7_FloatAndWrapperNotes {
    public static void main(String[] args) {

        // =====================================================
        // 🧩 1️⃣ float — Primitive Basics
        // =====================================================
        // 👉 float is used to store decimal (fractional) numbers.
        // 👉 Suffix 'f' (or 'F') is mandatory for float literals in Java.
        // 👉 It offers ~6–7 digits of precision.

        float price = 10.5f;   // Example float literal
        float tax = 2.3f;

        System.out.println("Sum: " + (price + tax));   // -> 12.8
        System.out.println("Diff: " + (price - tax));  // -> 8.2
        System.out.println("Prod: " + (price * 2));    // -> 21.0
        System.out.println("Div: " + (price / 2));     // -> 5.25

        // 💡 float is less precise than double (can lose decimals due to binary representation)

        // =====================================================
        // 🧩 2️⃣ Precision Example
        // =====================================================
        float x = 0.1f + 0.2f;
        System.out.println("0.1f + 0.2f = " + x);      // -> 0.30000004 (small rounding error)
        /*
           💡 Why this happens:
              Because 0.1 and 0.2 cannot be represented exactly in binary form.
              float is only 32 bits → limited precision.
              double (64-bit) is more accurate for decimal math.
        */

        // =====================================================
        // 🧩 3️⃣ Float — Wrapper Class
        // =====================================================
        // 👉 Allows float to behave like an object.
        // 👉 Useful when using Collections (ArrayList, etc.) or null values.

        Float boxed = Float.valueOf(price);   // Boxing: primitive → object
        float unboxed = boxed.floatValue();   // Unboxing: object → primitive

        System.out.println("Boxed: " + boxed);     // -> 10.5
        System.out.println("Unboxed: " + unboxed); // -> 10.5

        // Auto-boxing and auto-unboxing
        Float autoBox = 99.9f;
        float autoUnbox = autoBox;
        System.out.println("AutoBox: " + autoBox);   // -> 99.9
        System.out.println("AutoUnbox: " + autoUnbox); // -> 99.9

        // =====================================================
        // 🧩 4️⃣ Inbuilt Methods (Float class)
        // =====================================================
        System.out.println(Float.parseFloat("12.34"));       // -> 12.34   (String → float)
        System.out.println(Float.toString(5.5f));            // -> "5.5"   (float → String)
        System.out.println(Float.compare(10.0f, 20.0f));     // -> -1  (10 < 20)
        System.out.println(Float.compare(20.0f, 10.0f));     // -> 1   (20 > 10)
        System.out.println(Float.compare(10.0f, 10.0f));     // -> 0   (equal)
        System.out.println(Float.max(10.5f, 20.8f));         // -> 20.8
        System.out.println(Float.min(10.5f, 20.8f));         // -> 10.5
        System.out.println(Float.sum(1.5f, 2.5f));           // -> 4.0
        /*
           💡 Key Methods:
              - parseFloat(String) → String → float
              - toString(float) → float → String
              - compare(a, b) → Compare 2 floats (-1, 0, 1)
              - max/min/sum → numeric utilities (same as Integer/Double)
        */

        // =====================================================
        // 🧩 5️⃣ Special Values — NaN & Infinity
        // =====================================================
        float divZero = 10.0f / 0;   // Division by zero → Infinity
        float invalid = 0.0f / 0.0f; // Invalid → NaN (Not a Number)

        System.out.println("10.0f / 0 = " + divZero);        // -> Infinity
        System.out.println("0.0f / 0.0f = " + invalid);      // -> NaN

        System.out.println(Float.isInfinite(divZero));        // -> true
        System.out.println(Float.isNaN(invalid));             // -> true

        /*
           💡 Explanation:
              - Infinity → result too large or division by zero.
              - NaN (Not-a-Number) → result of undefined operation like 0/0.
              - You can check them using Float.isInfinite() and Float.isNaN().
        */

        // =====================================================
        // 🧩 6️⃣ Comparison Pitfall — NaN Behavior
        // =====================================================
        float nan1 = Float.NaN;
        float nan2 = Float.NaN;

        System.out.println("nan1 == nan2 → " + (nan1 == nan2)); // -> false
        System.out.println("Float.isNaN(nan1) → " + Float.isNaN(nan1)); // -> true

        /*
           💡 Why false?
              In IEEE 754 standard, NaN is not equal to any value, even itself.
              Always use Float.isNaN() to check NaN safely.
        */

        // =====================================================
        // 🧩 7️⃣ Constants
        // =====================================================
        System.out.println("MAX_VALUE: " + Float.MAX_VALUE);          // -> 3.4028235E38
        System.out.println("MIN_VALUE: " + Float.MIN_VALUE);          // -> 1.4E-45 (smallest positive)
        System.out.println("POSITIVE_INFINITY: " + Float.POSITIVE_INFINITY); // -> Infinity
        System.out.println("NEGATIVE_INFINITY: " + Float.NEGATIVE_INFINITY); // -> -Infinity
        System.out.println("NaN: " + Float.NaN);                      // -> NaN
        /*
           💡 Notes:
              - MAX_VALUE → largest finite positive number.
              - MIN_VALUE → smallest positive non-zero.
              - Infinity and NaN are special constants defined in Float class.
        */

        // =====================================================
        // 🧩 8️⃣ Comparison Pitfall — Wrapper Float
        // =====================================================
        // 👉 For primitive float → '==' compares actual numeric values ✅
        // 👉 For Float objects → '==' compares references (memory address) ❌
        // 👉 Use equals() to compare numeric values safely.

        Float a = 12.5f;   // auto-boxed Float object
        Float b = 12.5f;   // same value but may or may not be same object

        System.out.println("a == b → " + (a == b));       // -> false (different objects)
        System.out.println("a.equals(b) → " + a.equals(b)); // -> true  (same numeric value)

        /*
           💡 Why?
              - Unlike Integer (which caches values -128 to 127),
                Float does NOT cache values at all.
              - So every Float auto-boxing creates a new object.
              - Hence, '==' will usually be false even for same value.
              - Always use equals() to compare Float or Double wrappers.
        */

        // =====================================================
        // 🧩 9️⃣ Safe Comparison Example
        // =====================================================
        Float f1 = 10.5f;
        Float f2 = 10.5f;
        System.out.println("Safe compare → " + f1.equals(f2)); // -> true (correct way)

        /*
           ⚠️ Special Case with NaN:
              Float.NaN.equals(Float.NaN) → true
              But (Float.NaN == Float.NaN) → false
           💡 So always use equals() or Float.isNaN() to avoid traps.
        */

        // =====================================================
        // 🧠 Summary
        // =====================================================
        /*
           ✅ float → 4 bytes (32-bit floating point)
           ✅ Float → Wrapper class with utilities for parsing & comparison
           ✅ Precision: 6–7 decimal digits (less than double)
           ✅ Special constants: NaN, Infinity, -Infinity
           ✅ Common Methods:
               • parseFloat(), toString(), compare(), max(), min(), sum()
               • isNaN(), isInfinite()
           ⚠️ Be cautious:
               - Floating-point rounding errors (0.1 + 0.2 ≠ 0.3)
               - NaN != NaN (always use isNaN())
               - Infinity may appear from division by zero
        */
    }
}
