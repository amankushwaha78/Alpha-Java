// File: QA3_Floor.java
// Topic: Math.floor() — rounds DOWN to the nearest integer
// 🧠 floor(x) always gives the largest integer less than or equal to x.

public class QA2_A_Floor {
        public static void main(String[] args) {

                /* ============================================================
                 * 🧮 1️⃣ Math.floor() — rounds down (toward negative infinity)
                 * ============================================================
                 */
                System.out.println(Math.floor(12.4));   // -> 12.0
                System.out.println(Math.floor(12.9));   // -> 12.0
                System.out.println(Math.floor(12.0));   // -> 12.0
                System.out.println(Math.floor(-12.4));  // -> -13.0
                System.out.println(Math.floor(-12.9));  // -> -13.0
                System.out.println(Math.floor(-12.0));  // -> -12.0

        /*
           🔍 Explanation:
           -----------------
           Math.floor(x) returns the **greatest integer less than or equal to x**.
           That means it always goes "down" on the number line.

           💡 For positive numbers:
              12.4 → next smaller integer → 12
              12.9 → next smaller integer → 12
              12.0 → stays 12

           💡 For negative numbers:
              -12.4 → next smaller integer → -13
              -12.9 → next smaller integer → -13
              -12.0 → stays -12
        */


                /* ============================================================
                 * 🧩 3️⃣ Math.floor() with decimals smaller than 1
                 * ============================================================
                 */
                System.out.println(Math.floor(0.9));    // -> 0.0
                System.out.println(Math.floor(0.1));    // -> 0.0
                System.out.println(Math.floor(-0.1));   // -> -1.0
                System.out.println(Math.floor(-0.9));   // -> -1.0

        /*
           💡 For numbers between -1 and 1:
              Positive side → becomes 0
              Negative side → becomes -1
              So, -0.9 floors to -1 (because -1 < -0.9)
        */

                /* ============================================================
                 * ✅ SIMPLE CONCLUSION (For Beginners)
                 * ============================================================
                 */
        /*
           🧠 Easy rule to remember:
           -------------------------
           Math.floor(x) → Always rounds DOWN (toward -∞).

           ✔ Positive numbers → drops decimals (12.9 → 12)
           ✔ Negative numbers → goes to smaller number (-12.4 → -13)

           📘 Think of it like this:
                12.9  → 12
                12.1  → 12
               -12.1  → -13
               -12.9  → -13

           💡 floor() always goes "downhill" on the number line,
              no matter whether the number is positive or negative.
        */
        }
}
