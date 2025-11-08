// File: QA_Float_IO.java
// Topic: float decimals — printing, parsing, formatting, comparison, and common I/O pitfalls

public class QA1_Float {
    public static void main(String[] args) throws Exception {

        /* ============================================================
         * 1) PRINTING / FORMATTING WITH printf (width, precision)
         * ============================================================
         */
        float f = 12.34567f;

        System.out.printf("Q1: %.2f%n", f);            // -> 12.35
        /* Why: %.2f prints 2 digits after decimal; rounds HALF-UP. */

        System.out.printf("Q2: %8.2f%n", f);           // -> "   12.35"
        /* Why: Total width=8, precision=2; left pads with spaces to width. */

        System.out.printf("Q3: %-8.2fX%n", f);         // -> "12.35   X"
        /* Why: %-8.2f left-aligns in width 8; 'X' shows alignment clearly. */

        System.out.printf("Q4: %.0f%n", f);            // -> 12
        /* Why: zero fractional digits; rounds 12.34567 -> 12. */

        System.out.printf("Q5: %e%n", f);              // -> 1.234567e+01 (format may vary)
        /* Why: %e prints scientific notation. */

    }
}
