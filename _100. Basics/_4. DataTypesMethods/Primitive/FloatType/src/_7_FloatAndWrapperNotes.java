// Topic: float (primitive) + Float (wrapper class) + inbuilt methods + precision + NaN/Infinity
// 🧠 float = 4 bytes (32-bit IEEE 754 floating-point number)

public class _7_FloatAndWrapperNotes {
    public static void main(String[] args) {

        // --------------------------------------
        // 🧩 1️⃣ float — Primitive Type
        // --------------------------------------
        float price = 10.5f;         // 'f' suffix is mandatory for float literals
        float tax = 2.3f;
        System.out.println("Price + Tax: " + (price + tax));   // -> 12.8
        System.out.println("Price - Tax: " + (price - tax));   // -> 8.2
        System.out.println("Price * 2: " + (price * 2));       // -> 21.0
        System.out.println("Price / 2: " + (price / 2));       // -> 5.25
        // 💡 float is less precise than double — may show small rounding errors

        // --------------------------------------
        // 🧩 2️⃣ Precision Example
        // --------------------------------------
        float x = 0.1f + 0.2f;
        System.out.println("0.1f + 0.2f = " + x);              // -> 0.30000004 (precision loss)
        // 💡 Floating-point numbers are approximate due to binary representation.

        // --------------------------------------
        // 🧩 3️⃣ Float — Wrapper Class
        // --------------------------------------
        Float boxed = Float.valueOf(price);   // Boxing: primitive → object
        float unboxed = boxed.floatValue();   // Unboxing: object → primitive
        System.out.println("Boxed: " + boxed);               // -> 10.5
        System.out.println("Unboxed: " + unboxed);           // -> 10.5

        // Auto-boxing and auto-unboxing
        Float autoBox = 99.9f;
        float autoUnbox = autoBox;
        System.out.println("AutoBox: " + autoBox);            // -> 99.9
        System.out.println("AutoUnbox: " + autoUnbox);        // -> 99.9

        // --------------------------------------
        // 🧩 4️⃣ Inbuilt Methods (Float class)
        // --------------------------------------
        System.out.println(Float.parseFloat("12.34"));        // -> 12.34   (String → float)
        System.out.println(Float.toString(5.5f));             // -> "5.5"
        System.out.println(Float.compare(10.0f, 20.0f));      // -> -1  (less than)
        System.out.println(Float.compare(20.0f, 10.0f));      // -> 1   (greater than)
        System.out.println(Float.compare(10.0f, 10.0f));      // -> 0   (equal)
        System.out.println(Float.max(10.5f, 20.8f));          // -> 20.8
        System.out.println(Float.min(10.5f, 20.8f));          // -> 10.5
        System.out.println(Float.sum(1.5f, 2.5f));            // -> 4.0
        // 💡 Float methods mirror Integer/Double but focus on decimal values.

        // --------------------------------------
        // 🧩 5️⃣ Special Values (NaN, Infinity)
        // --------------------------------------
        float divZero = 10.0f / 0;        // division by 0 (float → Infinity)
        float invalid = 0.0f / 0.0f;      // invalid operation → NaN
        System.out.println("10/0: " + divZero);               // -> Infinity
        System.out.println("0/0: " + invalid);                // -> NaN
        System.out.println(Float.isInfinite(divZero));        // -> true
        System.out.println(Float.isNaN(invalid));             // -> true
        // 💡 NaN = Not a Number (undefined results like 0/0)
        // 💡 Infinity used to represent very large values.

        // --------------------------------------
        // 🧩 6️⃣ Comparison Pitfall (NaN behavior)
        // --------------------------------------
        float nan1 = Float.NaN;
        float nan2 = Float.NaN;
        System.out.println(nan1 == nan2);                     // -> false
        System.out.println(Float.isNaN(nan1));                // -> true
        // 💡 NaN is never equal to anything, even itself.

        // --------------------------------------
        // 🧩 7️⃣ Constants
        // --------------------------------------
        System.out.println("MAX_VALUE: " + Float.MAX_VALUE);  // -> 3.4028235E38
        System.out.println("MIN_VALUE: " + Float.MIN_VALUE);  // -> 1.4E-45 (smallest positive)
        System.out.println("POSITIVE_INFINITY: " + Float.POSITIVE_INFINITY); // -> Infinity
        System.out.println("NEGATIVE_INFINITY: " + Float.NEGATIVE_INFINITY); // -> -Infinity
        System.out.println("NaN: " + Float.NaN);              // -> NaN
        // 💡 MAX_VALUE ≠ infinity — it’s the largest representable finite number.

        // --------------------------------------
        // 🧠 Summary:
        // float = primitive (4 bytes, less precision)
        // Float = object wrapper with utilities
        // Common methods: parseFloat, toString, compare, max, min, sum, isNaN, isInfinite
        // Watch out for: precision loss, NaN != NaN, Infinity behavior
    }
}
