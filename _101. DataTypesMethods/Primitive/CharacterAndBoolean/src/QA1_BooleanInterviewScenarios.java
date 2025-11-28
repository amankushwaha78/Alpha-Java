// File: QA7_BooleanInterviewScenarios.java
// Topic: Output-based and tricky Boolean questions for interviews
// 🧠 Covers: logical ops, wrapper caching, == vs equals, parsing, null safety, truth tables

public class QA1_BooleanInterviewScenarios {
    public static void main(String[] args) {

        // =====================================================
        // 🧩 1️⃣ Basic Logical Operations
        // =====================================================
        boolean a = true, b = false;

        System.out.println("1️⃣ a && b → " + (a && b)); // false
        System.out.println("2️⃣ a || b → " + (a || b)); // true
        System.out.println("3️⃣ a ^ b → " + (a ^ b));   // true (only one true)
        System.out.println("4️⃣ !a → " + (!a));         // false

        /**
         * 💡 Explanation:
         *  a && b → true only if both true.
         *  a || b → true if any one is true.
         *  a ^ b  → true if exactly one is true (exclusive OR).
         *  !a     → negation of a.
         */


        // =====================================================
        // 🧩 2️⃣ Operator Precedence
        // =====================================================
        System.out.println("5️⃣ true || false && false → " + (true || false && false)); // true
        System.out.println("6️⃣ (true || false) && false → " + ((true || false) && false)); // false
        /*
           💡 Precedence: && > ||
           So “true || false && false” = true || (false && false) = true
           Parentheses can change order of evaluation.
        */


        // =====================================================
        // 🧩 3️⃣ Boolean Wrapper Caching
        // =====================================================
        Boolean x = true;
        Boolean y = true;
        Boolean z = false;

        System.out.println("7️⃣ x == y → " + (x == y)); // true  (cached)
        System.out.println("8️⃣ x.equals(y) → " + x.equals(y)); // true
        System.out.println("9️⃣ x == z → " + (x == z)); // false

        /*
           💡 Boolean caches only two constants:
              Boolean.TRUE and Boolean.FALSE
           So == returns true for identical constants, but always use equals().
        */


        // =====================================================
        // 🧩 4️⃣ Null Handling Pitfall
        // =====================================================
        Boolean maybe = null;

        try {
            if (maybe) // ❌ NullPointerException
                System.out.println("10️⃣ Inside if-block");
        } catch (Exception e) {
            System.out.println("10️⃣ if (maybe) threw → " + e.getClass().getSimpleName()); // NullPointerException
        }

        // ✅ Safe check
        if (Boolean.TRUE.equals(maybe)) {
            System.out.println("11️⃣ Safe true check");
        } else {
            System.out.println("11️⃣ Safe check avoids crash"); // ✅
        }

        /*
           💡 Always use Boolean.TRUE.equals(variable)
              instead of (if (variable)) when it can be null.
        */


        // =====================================================
        // 🧩 5️⃣ Parsing Strings to Boolean
        // =====================================================
        System.out.println("12️⃣ Boolean.parseBoolean(\"true\") → " + Boolean.parseBoolean("true"));  // true
        System.out.println("13️⃣ Boolean.parseBoolean(\"TRUE\") → " + Boolean.parseBoolean("TRUE"));  // true
        System.out.println("14️⃣ Boolean.parseBoolean(\"false\") → " + Boolean.parseBoolean("false")); // false
        System.out.println("15️⃣ Boolean.parseBoolean(\"yes\") → " + Boolean.parseBoolean("yes"));     // false
        System.out.println("16️⃣ Boolean.valueOf(\"true\") → " + Boolean.valueOf("true"));             // true
        System.out.println("17️⃣ Boolean.valueOf(\"xyz\") → " + Boolean.valueOf("xyz"));               // false

        /*
           💡 parseBoolean() / valueOf():
              Only "true" (ignoring case) returns true.
              Any other string returns false.
        */


        // =====================================================
        // 🧩 6️⃣ == vs equals()
        // =====================================================
        Boolean b1 = true;
        Boolean b2 = Boolean.valueOf("true");
        Boolean b3 = new Boolean(true); // forces new object

        System.out.println("18️⃣ b1 == b2 → " + (b1 == b2)); // true (cached)
        System.out.println("19️⃣ b1 == b3 → " + (b1 == b3)); // false (new object)
        System.out.println("20️⃣ b1.equals(b3) → " + b1.equals(b3)); // true (same value)

        /*
           💡 '==' → compares object references (memory)
           💡 equals() → compares content/value.
           Boolean caches true/false, so == may sometimes appear to work.
           Always use equals() for clarity.
        */


        // =====================================================
        // 🧩 7️⃣ logicalAnd(), logicalOr(), logicalXor()
        // =====================================================
        System.out.println("21️⃣ Boolean.logicalAnd(true, false) → " + Boolean.logicalAnd(true, false)); // false
        System.out.println("22️⃣ Boolean.logicalOr(false, true) → " + Boolean.logicalOr(false, true));   // true
        System.out.println("23️⃣ Boolean.logicalXor(true, true) → " + Boolean.logicalXor(true, true));   // false

        /*
           💡 These methods were added in Java 8 for functional style programming.
           They work exactly like &&, ||, and ^ but are methods instead of operators.
           Commonly used in Streams or Predicates (e.g., filter(logicalAnd(...))).
        */


        // =====================================================
        // 🧩 8️⃣ Boolean Constants
        // =====================================================
        System.out.println("24️⃣ Boolean.TRUE  → " + Boolean.TRUE);   // true
        System.out.println("25️⃣ Boolean.FALSE → " + Boolean.FALSE);  // false

        /*
           💡 These are final static objects — same as using true/false literals.
              Often used when methods require Boolean objects, not primitives.
        */


        // =====================================================
        // 🧩 9️⃣ Complex Trick — Mixed Operations
        // =====================================================
        boolean p = false, q = true, r = true;
        System.out.println("26️⃣ p || q && r → " + (p || q && r));   // true
        System.out.println("27️⃣ (p || q) && r → " + ((p || q) && r)); // true
        System.out.println("28️⃣ p || (q && !r) → " + (p || (q && !r))); // false

        /*
           💡 Operator precedence:
              NOT (!) > AND (&&) > OR (||)
           Always use parentheses in interview code for clarity.
        */


        // =====================================================
        // 🧠 INTERVIEW HIGHLIGHTS (REVISION)
        // =====================================================
        /*
           🔹 boolean → primitive (true/false only, no null)
           🔹 Boolean → wrapper (can be null, object, cached constants TRUE/FALSE)
           🔹 parseBoolean() / valueOf() → only "true" → true
           🔹 logicalAnd(), logicalOr(), logicalXor() → functional equivalents
           🔹 == compares references (may appear true due to caching)
           🔹 equals() compares values (always preferred)
           🔹 Default values:
                boolean → false
                Boolean → null
           🔹 Common pitfalls:
                → if(BooleanVar) // ❌ may throw NPE
                → if(Boolean.TRUE.equals(BooleanVar)) ✅ safe
        */

        // =====================================================
        // 🧩 10️⃣ Truth Table (for quick mental reference)
        // =====================================================
        /**
         * | A | B | A&&B | A||B | A^B | !A |
         * |---|---|------|------|-----|----|
         * | F | F |  F   |  F   |  F  | T  |
         * | F | T |  F   |  T   |  T  | T  |
         * | T | F |  F   |  T   |  T  | F  |
         * | T | T |  T   |  T   |  F  | F  |
         */
    }
}
