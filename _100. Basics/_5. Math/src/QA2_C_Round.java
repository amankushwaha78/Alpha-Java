public class QA2_C_Round {
    public static void main(String[] args) {
        /* ============================================================
         * 🧮 1️⃣ Math.round() — midpoint rounding (away from zero)
         * ============================================================
         */
        System.out.println(Math.round(12.4));  // -> 12
        System.out.println(Math.round(12.5));  // -> 13
        System.out.println(Math.round(-12.5)); // -> -12

/*
   🔍 Explanation (Very Important):

   📘 What Math.round(x) does internally:
       → It adds 0.5 and then applies Math.floor()
          i.e. round(x) = floor(x + 0.5)

   --------------------------------------------
   🔹 For positive numbers:
   --------------------------------------------
   Math.round(12.4)
      → 12.4 + 0.5 = 12.9
      → floor(12.9) = 12 ✅

   Math.round(12.5)
      → 12.5 + 0.5 = 13.0
      → floor(13.0) = 13 ✅

   So, positive numbers round up if the decimal part ≥ 0.5.

   --------------------------------------------
   🔹 For negative numbers:
   --------------------------------------------
   Math.round(-12.5)
      → (-12.5 + 0.5) = -12.0
      → floor(-12.0) = -12 ✅

   Math.round(-12.6)
      → (-12.6 + 0.5) = -12.1
      → floor(-12.1) = -13 ✅

   So, -12.5 rounds to -12 (toward zero),
   and -12.6 rounds to -13 (away from zero in number line).

   --------------------------------------------
   💡 Summary Rule:
   --------------------------------------------
   - Math.round() rounds "away from zero" at the midpoint (.5)
       • +12.5 → +13  (upward)
       • -12.5 → -12  (toward zero, less negative)
   - It returns a long (for double input) or int (for float input).
*/

    }

}
