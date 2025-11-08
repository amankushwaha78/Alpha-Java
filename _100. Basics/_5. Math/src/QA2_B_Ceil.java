// File: QA4_Ceil.java
// Topic: Math.ceil() — rounds UP to the nearest integer
// 🧠 ceil(x) always gives the smallest integer greater than or equal to x.

public class QA2_B_Ceil {
    public static void main(String[] args) {

        /* ============================================================
         * 🧮 1️⃣ Math.ceil() — rounds up (toward positive infinity)
         * ============================================================
         */
        System.out.println(Math.ceil(12.1));   // -> 13.0
        System.out.println(Math.ceil(12.5));   // -> 13.0
        System.out.println(Math.ceil(12.9));   // -> 13.0
        System.out.println(Math.ceil(-12.1));  // -> -12.0
        System.out.println(Math.ceil(-12.9));  // -> -12.0
        System.out.println(Math.ceil(-12.0));  // -> -12.0

        /*
           🔍 Explanation:
           -----------------
           Math.ceil(x) returns the **smallest integer greater than or equal to x**.
           That means it always goes "up" on the number line — toward positive infinity.

           💡 For positive numbers:
              12.1 → next larger integer → 13
              12.5 → next larger integer → 13
              12.9 → next larger integer → 13
              12.0 → stays 12

           💡 For negative numbers:
              -12.1 → next larger integer → -12
              -12.9 → next larger integer → -12
              -12.0 → stays -12

        */

        /* ============================================================
         * 🧩 2️⃣ Difference between Math.ceil() and Math.floor()
         * ============================================================
         */
        System.out.println("ceil(12.5)  = " + Math.ceil(12.5));   // -> 13.0
        System.out.println("floor(12.5) = " + Math.floor(12.5));  // -> 12.0
        System.out.println("ceil(-12.5) = " + Math.ceil(-12.5));  // -> -12.0
        System.out.println("floor(-12.5)= " + Math.floor(-12.5)); // -> -13.0

        /*
           💬 Comparison:
           -----------------------------------------
           ceil(12.5)  → goes UP → 13.0
           floor(12.5) → goes DOWN → 12.0
           ceil(-12.5) → goes UP → -12.0 (less negative)
           floor(-12.5)→ goes DOWN → -13.0 (more negative)

           So:
           - ceil()  → always toward positive infinity (↑)
           - floor() → always toward negative infinity (↓)
        */

        /* ============================================================
         * 🧩 3️⃣ Math.ceil() with decimals smaller than 1
         * ============================================================
         */
        System.out.println(Math.ceil(0.1));    // -> 1.0
        System.out.println(Math.ceil(0.9));    // -> 1.0
        System.out.println(Math.ceil(-0.1));   // -> 0.0
        System.out.println(Math.ceil(-0.9));   // -> 0.0

        /*
           💡 For numbers between -1 and 1:
              Positive side → becomes 1
              Negative side → becomes 0
              Example:
                 ceil(0.1)  → 1
                 ceil(-0.9) → 0  (moves up toward 0)
        */

        /* ============================================================
         * ✅ SIMPLE CONCLUSION (For Beginners)
         * ============================================================
         */
        /*
           🧠 Easy rule to remember:
           -------------------------
           Math.ceil(x) → Always rounds UP (toward +∞).

           ✔ Positive numbers → next integer above (12.1 → 13)
           ✔ Negative numbers → less negative (−12.9 → −12)

           📘 Think of it like this:
                12.1  → 13
                12.9  → 13
               -12.1  → -12
               -12.9  → -12

           💡 ceil() always goes "uphill" on the number line,
              no matter whether the number is positive or negative.
        */
    }
}
