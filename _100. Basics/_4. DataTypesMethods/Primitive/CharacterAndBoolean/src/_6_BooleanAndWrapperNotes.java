// File: BooleanAndWrapperNotes.java
// Topic: boolean (primitive) + Boolean (wrapper class) + inbuilt methods + parsing + comparison
// 🧠 boolean can only hold two values: true or false (1 bit conceptually)

public class _6_BooleanAndWrapperNotes {
    public static void main(String[] args) {

        // --------------------------------------
        // 🧩 1️⃣ boolean — Primitive Type
        // --------------------------------------
        boolean isActive = true;                // represents truth value
        boolean isAdmin = false;

        // Simple logical operations
        System.out.println("AND: " + (isActive && isAdmin)); // -> false
        System.out.println("OR: " + (isActive || isAdmin));  // -> true
        System.out.println("NOT: " + (!isAdmin));            // -> true
        // 💡 boolean is not numeric; no +, -, *, / allowed.

        // --------------------------------------
        // 🧩 2️⃣ Boolean — Wrapper Class
        // --------------------------------------
        // 👉 Boolean allows null and methods like parseBoolean(), valueOf(), etc.
        Boolean flagBox = Boolean.valueOf(isActive); // Boxing primitive → object
        boolean flagUnbox = flagBox.booleanValue();  // Unboxing object → primitive
        System.out.println("Boxed: " + flagBox);     // -> true
        System.out.println("Unboxed: " + flagUnbox); // -> true

        // Auto-boxing / unboxing
        Boolean autoBox = true;
        boolean autoUnbox = autoBox;
        System.out.println("AutoBox: " + autoBox);   // -> true
        System.out.println("AutoUnbox: " + autoUnbox);// -> true

        // --------------------------------------
        // 🧩 3️⃣ Inbuilt Methods
        // --------------------------------------
        System.out.println(Boolean.parseBoolean("true"));    // -> true
        System.out.println(Boolean.parseBoolean("FALSE"));   // -> false (case-insensitive)
        System.out.println(Boolean.parseBoolean("yes"));     // -> false (only "true" → true)
        System.out.println(Boolean.toString(true));          // -> "true"
        System.out.println(Boolean.logicalAnd(true, false)); // -> false
        System.out.println(Boolean.logicalOr(true, false));  // -> true
        System.out.println(Boolean.logicalXor(true, true));  // -> false
        // 💡 logicalAnd/Or/Xor added in Java 1.8; same as &&, ||, ^ for primitives.

        // --------------------------------------
        // 🧩 4️⃣ Comparison (== vs equals)
        // --------------------------------------
        Boolean b1 = true;
        Boolean b2 = true;
        Boolean b3 = false;
        System.out.println(b1 == b2);        // -> true   (cached constants)
        System.out.println(b1.equals(b2));   // -> true   (same value)
        System.out.println(b1.equals(b3));   // -> false  (different value)
        // 💡 Boolean also caches TRUE/FALSE objects, so == often works,
        // but always prefer equals() for clarity.

        // --------------------------------------
        // 🧩 5️⃣ Constants
        // --------------------------------------
        System.out.println(Boolean.TRUE);    // -> true
        System.out.println(Boolean.FALSE);   // -> false
        // 💡 Useful when APIs expect Boolean objects instead of primitive boolean.

        // --------------------------------------
        // 🧩 6️⃣ Safe null handling
        // --------------------------------------
        // Boolean can be null, unlike primitive boolean.
        Boolean maybe = null;
        System.out.println("Nullable Boolean: " + maybe);    // -> null
        // ⚠️ Be careful: using 'if (maybe)' will throw NullPointerException.
        // Always use Boolean.TRUE.equals(maybe) for safe checks.
    }
}
