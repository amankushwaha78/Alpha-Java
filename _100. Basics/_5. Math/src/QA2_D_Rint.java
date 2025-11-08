// File: QA5_Rint.java
// Topic: Math.rint() — rounds to the nearest integer but returns double
// 🧠 Math.rint() = “round to nearest integer (double type)”
// Uses “bankers rounding” — ties (.5) go to the nearest **even** integer.

public class QA2_D_Rint {
    public static void main(String[] args) {

        /* ============================================================
         * 🧮 1️⃣ Math.rint() — rounds to nearest integer (returns double)
         * ============================================================
         */
        System.out.println(Math.rint(12.4));   // -> 12.0
        System.out.println(Math.rint(12.5));   // -> 12.0 👈 note this!
        System.out.println(Math.rint(13.5));   // -> 14.0 👈 note this!
        System.out.println(Math.rint(-12.4));  // -> -12.0
        System.out.println(Math.rint(-12.5));  // -> -12.0 👈 note this!
        System.out.println(Math.rint(-13.5));  // -> -14.0 👈 note this!

        /*
           🔍 Explanation:
           -----------------
           Math.rint(x) returns the closest integer value — **as a double**.

           BUT ⚠️ it handles .5 differently from Math.round():
           - If the fractional part = 0.5 exactly → it rounds to the nearest *even* integer.

           💡 Examples:
              Math.rint(12.4) → 12.0  (normal rounding down)
              Math.rint(12.5) → 12.0  (12 is even)
              Math.rint(13.5) → 14.0  (14 is even)
              Math.rint(-12.5) → -12.0 (even)
              Math.rint(-13.5) → -14.0 (even)

           So, “ties” (.5) always go to the nearest even integer — this is called **bankers rounding**.
        */

        /* ============================================================
         * 🧩 2️⃣ Difference: Math.round() vs Math.rint()
         * ============================================================
         */
        System.out.println("Math.round(12.5) = " + Math.round(12.5));  // -> 13
        System.out.println("Math.rint(12.5)  = " + Math.rint(12.5));   // -> 12.0
        System.out.println("Math.round(13.5) = " + Math.round(13.5));  // -> 14
        System.out.println("Math.rint(13.5)  = " + Math.rint(13.5));   // -> 14.0

        System.out.println("Math.round(-12.5) = " + Math.round(-12.5)); // -> -12
        System.out.println("Math.rint(-12.5)  = " + Math.rint(-12.5));  // -> -12.0
        System.out.println("Math.round(-13.5) = " + Math.round(-13.5)); // -> -13
        System.out.println("Math.rint(-13.5)  = " + Math.rint(-13.5));  // -> -14.0

        /*
           💬 Comparison Table
           Math.round() → “away from zero” rule (.5 goes up)
           Math.rint()  → “to even number” rule (.5 goes to even)
        */

        /* ============================================================
         * 🧩 3️⃣ Math.rint() for small values and edge cases
         * ============================================================
         */
        System.out.println(Math.rint(0.4));   // -> 0.0
        System.out.println(Math.rint(0.5));   // -> 0.0 (0 is even)
        System.out.println(Math.rint(1.5));   // -> 2.0 (2 is even)
        System.out.println(Math.rint(-0.5));  // -> 0.0 (0 is even)
        System.out.println(Math.rint(-1.5));  // -> -2.0 (even)
        /*
           💡 Notice:
           - At 0.5 or -0.5 → rounds to 0.0 (since 0 is even)
           - Keeps result as a double (decimal .0)
        */

        /* ============================================================
         * ✅ SIMPLE CONCLUSION (For Beginners)
         * ============================================================
         */
        /*
           🧠 Easy rule to remember:
           -------------------------
           Math.rint(x):
             - Returns nearest integer **as a double**
             - If exactly halfway (.5) → goes to nearest **even** integer
             - Called “bankers rounding”

           🧮 Example Summary:
             12.4  → 12.0
             12.5  → 12.0  (12 is even)
             13.5  → 14.0  (14 is even)
            -12.5  → -12.0 (even)
            -13.5  → -14.0 (even)

           ⚖ Difference from round():
             • round() → always away from zero (.5 goes up)
             • rint()  → to nearest even (.5 ties go even)

           💡 Both are used for rounding,
              but rint() is used more for **statistical or financial calculations**
              where even-tie rounding reduces bias.
        */
    }
}
