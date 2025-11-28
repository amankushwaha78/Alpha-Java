// File: _6_BooleanAndWrapperNotes.java
// Topic: boolean (primitive) + Boolean (wrapper class) + inbuilt methods + parsing + comparison
// 🧠 boolean can only hold two values: true or false (conceptually 1 bit)
//    Most frequently used for conditions, flags, and logical operations.

public class _6_BooleanAndWrapperNotes {
    public static void main(String[] args) {

        // =====================================================
        // 🧩 1️⃣ boolean — Primitive Type
        // =====================================================
        boolean isActive = true;
        boolean isAdmin = false;

        // Basic logical operations
        System.out.println("AND: " + (isActive && isAdmin)); // -> false
        System.out.println("OR: " + (isActive || isAdmin));  // -> true
        System.out.println("NOT: " + (!isAdmin));            // -> true
        /*
           💡 Notes:
           - boolean supports only true/false values.
           - Cannot use arithmetic (+, -, *, /) on booleans.
           - Commonly used in control flow, conditions, and flags.
        */

        // =====================================================
        // 🧩 2️⃣ Boolean — Wrapper Class
        // =====================================================
        // 👉 Boolean adds object behavior and helper methods.
        Boolean flagBox = Boolean.valueOf(isActive); // Boxing
        boolean flagUnbox = flagBox.booleanValue();  // Unboxing

        System.out.println("Boxed: " + flagBox);     // -> true
        System.out.println("Unboxed: " + flagUnbox); // -> true

        // 🧠 Auto-boxing & auto-unboxing
        Boolean autoBox = true;   // boolean → Boolean automatically
        boolean autoUnbox = autoBox; // Boolean → boolean automatically
        System.out.println("AutoBox: " + autoBox);     // -> true
        System.out.println("AutoUnbox: " + autoUnbox); // -> true

        /*
           💡 Why Wrapper Exists:
           - Used in Collections (e.g., List<Boolean>)
           - Allows null (unlike primitive)
           - Provides parsing & logical helper methods
        */

        // =====================================================
        // 🧩 3️⃣ Inbuilt Methods (Boolean class)
        // =====================================================
        System.out.println(Boolean.parseBoolean("true"));    // -> true
        System.out.println(Boolean.parseBoolean("FALSE"));   // -> false (case-insensitive)
        System.out.println(Boolean.parseBoolean("yes"));     // -> false (only "true" → true)
        System.out.println(Boolean.toString(true));          // -> "true"
        System.out.println(Boolean.logicalAnd(true, false)); // -> false
        System.out.println(Boolean.logicalOr(true, false));  // -> true
        System.out.println(Boolean.logicalXor(true, true));  // -> false

        /*
           📘 Explanation Table
           -----------------------------------------------
           | Method | Description | Example | Result |
           |---------|--------------|----------|---------|
           | parseBoolean("true")  | String → boolean | "TRUE" | true |
           | toString(true)        | boolean → String | true | "true" |
           | logicalAnd(a,b)       | Returns a && b   | T,F | false |
           | logicalOr(a,b)        | Returns a || b   | T,F | true |
           | logicalXor(a,b)       | Returns a ^ b    | T,T | false |
           💡 logicalAnd/Or/Xor were added in Java 8 for cleaner code with predicates & streams.
        */

        // =====================================================
        // 🧩 4️⃣ Comparison (== vs equals)
        // =====================================================
        Boolean b1 = true;
        Boolean b2 = true;
        Boolean b3 = false;

        System.out.println("b1 == b2 → " + (b1 == b2));        // -> true (cached constants)
        System.out.println("b1.equals(b2) → " + b1.equals(b2));// -> true (same value)
        System.out.println("b1.equals(b3) → " + b1.equals(b3));// -> false (different value)

        /*
           💡 Boolean Caching:
           - Boolean caches only two constants:
                 Boolean.TRUE  and Boolean.FALSE
           - Therefore, == often appears to work, but use equals() for clarity.
           - Cross-type comparison:
                 Boolean.equals(null) → false
                 Boolean.equals("true") → false
        */

        // =====================================================
        // 🧩 5️⃣ Constants & Static Fields
        // =====================================================
        System.out.println(Boolean.TRUE);   // -> true
        System.out.println(Boolean.FALSE);  // -> false
        /*
           💡 Useful when APIs expect Boolean objects instead of primitives.
           Example: Map<String, Boolean>, Optional<Boolean>, etc.
        */

        // =====================================================
        // 🧩 6️⃣ Safe Null Handling
        // =====================================================
        Boolean maybe = null;
        System.out.println("Nullable Boolean: " + maybe); // -> null

        /*
           ⚠️ Using 'if (maybe)' causes NullPointerException.
           ✅ Use safe check:
              if (Boolean.TRUE.equals(maybe)) { ... }  // safe null handling
        */

        // =====================================================
        // 🧠 Interview Highlights
        // =====================================================
        /*
           🔹 boolean → primitive (fast, no null)
           🔹 Boolean → wrapper (nullable, object utilities)
           🔹 Default values:
               • boolean default = false
               • Boolean default (if uninitialized) = null
           🔹 Cached constants: Boolean.TRUE, Boolean.FALSE
           🔹 Common parsing methods: parseBoolean(), valueOf(), toString()
           🔹 logicalAnd(), logicalOr(), logicalXor() introduced in Java 8
           🔹 Always prefer equals() when comparing Boolean objects
           🔹 Never compare Boolean with == if it could be null.

           💬 Interview Quote:
           "In Java, boolean is primitive while Boolean is its wrapper class.
            Boolean provides static helpers like parseBoolean() and logicalAnd().
            Since Boolean caches TRUE and FALSE, '==' may seem to work,
            but equals() is always the correct choice—especially when null is possible."
        */
    }
}

/**
 * 🧮 BOOLEAN LOGIC TRUTH TABLE
 * -------------------------------------------------------
 * | A (Input 1) | B (Input 2) | A && B (AND) | A || B (OR) | A ^ B (XOR) | !A (NOT) |
 * |--------------|-------------|--------------|-------------|--------------|-----------|
 * | false        | false       | false        | false       | false        | true      |
 * | false        | true        | false        | true        | true         | true      |
 * | true         | false       | false        | true        | true         | false     |
 * | true         | true        | true         | true        | false        | false     |
 *
 * 🔹 AND (&&)  → true only if both A and B are true.
 * 🔹 OR  (||)  → true if *either* A or B is true.
 * 🔹 XOR (^)   → true if exactly one is true (exclusive or).
 * 🔹 NOT (!)   → inverts the value of a single boolean.
 *
 * 💡 Quick Interview Hints:
 *   → AND is used when *all* conditions must hold.
 *   → OR is used when *any* condition is enough.
 *   → XOR is often used for toggling or parity checks.
 *   → NOT is used for negation.
 *
 * 🧠 Example:
 *   boolean a = true, b = false;
 *   System.out.println(a && b); // false
 *   System.out.println(a || b); // true
 *   System.out.println(a ^ b);  // true
 *   System.out.println(!a);     // false
 */
