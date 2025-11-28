// File: QA1_Decimal.java
// Topic: double decimals — printing, formatting, precision, and rounding using printf()

public class QA3_Decimal {
    public static void main(String[] args) {

        /* ============================================================
         * 🧩 1️⃣ PRINTING & FORMATTING with printf()
         * ============================================================
         * printf() helps to control how decimals are displayed.
         * Format → % [flags] [width] [.precision] f
         * Example: %.2f → show 2 digits after decimal.
         */

        double d = 123.456789;

        System.out.printf("Q1: %.2f%n", d);
        /* ✅ %.2f → prints 2 digits after decimal.
           123.456789 → 123.46  (rounded half-up)
        */

        System.out.printf("Q2: %.0f%n", d);
        /* ✅ %.0f → no digits after decimal → 123 (rounded)
           Works like Math.round()
        */

        System.out.printf("Q3: %8.2f%n", d);
        /* ✅ %8.2f → total width = 8, 2 decimals.
           Pads with spaces on left if number < 8 characters.
           Output: "  123.46"
        */

        System.out.printf("Q4: %-8.2fX%n", d);
        /* ✅ %-8.2f → left-align inside 8 spaces.
           Output: "123.46  X"
           'X' shows the space after number.
        */

        System.out.printf("Q5: %.4f%n", d);
        /* ✅ Prints 4 digits after decimal: 123.4568
           (last digit is rounded up)
        */

        System.out.printf("Q6: %e%n", d);
        /* ✅ %e → scientific (exponential) notation
           Output: 1.234568e+02
           Common in scientific/engineering results.
        */

        System.out.printf("Q7: %10.3e%n", d);
        /* ✅ %10.3e → scientific format, width 10, 3 decimals.
           Output: " 1.235e+02"
           Total field width = 10 chars, right aligned.
        */

        System.out.printf("Q8: %010.2f%n", d);
        /* ✅ %010.2f → total width 10, padded with zeros on left.
           Output: 0000123.46
           ⚠ Useful for aligned numeric reports.
        */

        System.out.printf("Q9: %,.2f%n", 12345.6789);
        /* ✅ %,.2f → comma grouping (locale aware).
           Output: 12,345.68
           💡 ',' adds thousand separators.
        */

        System.out.printf("Q10: %+8.2f%n", 12.5);
        System.out.printf("Q11: %+8.2f%n", -12.5);
        /* ✅ %+ → always show sign.
           Output:
           +12.50
           -12.50
           💡 '+' ensures positive numbers show '+' too.
        */

        System.out.printf("Q12: %8.2f%n", 0.125);
        System.out.printf("Q13: %.1f%n", 0.125);
        /* ✅ Demonstrates rounding:
           %.2f → 0.13
           %.1f → 0.1 (rounds down)
        */

        /* ============================================================
         * 🧠 Summary:
         * ------------------------------------------------------------
         * | Format   | Meaning                           | Example Output    |
         * |----------|-----------------------------------|-------------------|
         * | %.2f     | 2 decimal places                  | 12.35             |
         * | %8.2f    | width 8, right aligned            | "   12.35"        |
         * | %-8.2f   | width 8, left aligned             | "12.35   "        |
         * | %+8.2f   | width 8, always show + / - sign   | "  +12.35"        |
         * | %010.2f  | pad with zeros to width 10        | "000012.35"       |
         * | %e       | scientific notation               | 1.234567e+01      |
         * | %,.2f    | comma grouping                    | 12,345.68         |
         * ------------------------------------------------------------

         * 💬 Interview Quick Facts:
         * ✅ %.nf → rounds to n decimals (not truncates)
         * ✅ Default rounding = HALF_UP (0.5 → up)
         * ✅ Use printf / String.format for consistent decimal printing
         * ✅ For exact rounding in money, use BigDecimal
         */
    }
}
