// File: _QA2_BytePromotionAndTypeCasting.java
// 🎯 Topic: Why does "byte a3 = a1 + a2;" cause compilation error in Java?
// 🧠 Concept: Type Promotion Rules, Compile-time Constants, and Explicit Casting
// 🧩 Category: byte / short / char → int promotion (most asked interview trap)

public class QA2_Arithmetic_Promotion_Casting {
    public static void main(String[] args) {
        // ------------------------------------------------------------
        // 🧩 1️⃣ The Problem Code (Compilation Error)
        // ------------------------------------------------------------
        byte a1 = 10;
        byte a2 = 20;
        // byte a3 = a1 + a2;  // ❌ Compilation Error: possible lossy conversion from int to byte
        // Why? Let's explain 👇

        /*
         🧠 REASON:
         -------------------------------
         1️⃣ In Java, any arithmetic (+, -, *, /, %) on smaller-than-int types
             → automatically promotes both operands to **int** before calculation.

             So: a1 + a2  ➡  (int)a1 + (int)a2  ➡  int result.

         2️⃣ The result of that addition is therefore **int** (32 bits).
             But we’re trying to store it into a **byte** (8 bits).

         3️⃣ Since int → byte is a *narrowing conversion*, Java blocks it
             unless you explicitly cast.

             Hence the error:
             “possible lossy conversion from int to byte”
         */

        // ------------------------------------------------------------
        // 🧩 2️⃣ The Correct Way — Explicit Casting ✅
        // ------------------------------------------------------------
        byte a3 = (byte) (a1 + a2); // ✅ forcefully narrow int → byte
        System.out.println("✅ Explicit cast result (byte): " + a3); // -> 30
        /*
         💡 Explanation:
         (a1 + a2) = 30 as int
         (byte)30  = 30 safely fits within byte range (-128..127)
         */

        // ------------------------------------------------------------
        // 🧩 3️⃣ Compile-Time Constant Shortcut 🪄 (byte)
        // ------------------------------------------------------------
        byte b = 10 + 20; // ✅ allowed without cast
        System.out.println("✅ Constant expression result (byte): " + b); // -> 30

        /*
         🧠 Why allowed:
         Both operands (10, 20) are *compile-time constants*.
         Compiler evaluates 10 + 20 = 30 during compilation itself,
         then checks if 30 fits inside byte range (-128..127). ✅ It fits, so allowed.

         ⚠️ If the result didn’t fit, it would fail even here:
             // byte b2 = 100 + 100;  // ❌ 200 is out of range for byte
        */

        // ------------------------------------------------------------
        // 🧩 4️⃣ Practical Demo — Overflow Case (byte)
        // ------------------------------------------------------------
        byte b3 = (byte) (127 + 1);
        System.out.println("⚙️ Overflow result (byte): " + b3); // -> -128

        /*
         💡 (127 + 1) = 128 as int → (byte)128 = -128 (wrap-around using 2’s complement)
         This demonstrates overflow when narrowing large int → small byte.
        */

        // ------------------------------------------------------------
        // 🧩 5️⃣ Quick Visual Representation 🧮 (byte)
        // ------------------------------------------------------------
        /*
         Imagine memory layout (simplified):

         byte a1 = 10;     // binary: 00001010 (8 bits)
         byte a2 = 20;     // binary: 00010100 (8 bits)

         🪄 Step 1: Promote to int (32 bits each)
              a1 → 00000000 00000000 00000000 00001010
              a2 → 00000000 00000000 00000000 00010100

         🪄 Step 2: Add → 00000000 00000000 00000000 00011110 (decimal 30)

         🪄 Step 3: Cast back to byte (optional narrowing)
              Result fits → 00011110 = 30 ✅

         🧩 If overflow example:
              (byte)(130) = -126  → because 130 - 256 = -126
        */

        // ============================================================
        // 🧩 6️⃣ Quick Summary (applies to byte/short/char) 🧾
        // ============================================================
        /*
         ✅ Java promotes smaller numeric types (byte, short, char) to int before any arithmetic.
         ✅ The result of such arithmetic is always int unless operands are long/double/float.
         ✅ You must use explicit cast to assign int → byte or int → short (or char).
         ✅ Constant expressions (like 10 + 20) are computed at compile-time and allowed if in range.
         ✅ Overflow happens silently (wraps around using 2’s complement).
        */

        System.out.println("\n🎯 Summary (byte):");
        System.out.println("byte a3 = a1 + a2;   ❌ Error — int result cannot fit into byte without cast");
        System.out.println("byte a3 = (byte)(a1 + a2); ✅ Works");
        System.out.println("byte b = 10 + 20; ✅ Compile-time constant allowed");
        System.out.println("(byte)(127 + 1) = -128 (overflow wrap-around)");

        // ============================================================
        // 🧩 7️⃣ EXACT SAME RULES FOR short ✅
        // ============================================================
        // 7A) Compile-time error without cast (if we try):
        short s1 = 1000;
        short s2 = 2000;
        // short s3 = s1 + s2;     // ❌ Compilation Error: int → short (narrowing)
        short s3 = (short) (s1 + s2); // ✅ Explicit cast
        System.out.println("\n✅ Explicit cast result (short): " + s3); // -> 3000

        // 7B) Compile-time constant within range → allowed without cast
        short sConst = 1000 + 2000; // ✅ 3000 fits in short (-32768..32767)
        System.out.println("✅ Constant expression result (short): " + sConst); // -> 3000

        // 7C) Constant out of range → compile-time error (uncomment to see)
        // short sBad = 30000 + 30000; // ❌ 60000 doesn't fit in short

        // 7D) Overflow example for short
        short sOverflow = (short) (32767 + 1); // 32767 is Short.MAX_VALUE
        System.out.println("⚙️ Overflow result (short): " + sOverflow); // -> -32768

        /*
         🧠 Recap for short:
         - s1 + s2 becomes int (promotion), so assignment to short needs an explicit cast.
         - Constant expressions are folded at compile-time and checked against short’s range.
         - Overflow wraps around (two’s complement), e.g., 32767 + 1 → -32768 after narrowing.
        */

        System.out.println("\n🎯 Summary (short):");
        System.out.println("short s3 = s1 + s2;   ❌ Error — int result cannot fit into short without cast");
        System.out.println("short s3 = (short)(s1 + s2); ✅ Works");
        System.out.println("short sConst = 1000 + 2000; ✅ Compile-time constant allowed");
        System.out.println("(short)(32767 + 1) = -32768 (overflow wrap-around)");

        System.out.println("\n🔥 Interview Tip: Always mention Java’s 'binary numeric promotion' rule!");
    }
}
