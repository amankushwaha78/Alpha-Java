// Topic: int (primitive) + Integer (wrapper class) + inbuilt methods + comparison pitfalls
// 🧠 Notes are given step by step so you can understand concept + logic.

public class _1_IntAndIntegerNotes {
    public static void main(String[] args) {

        // --------------------------------------
        // 🧩 1️⃣ int — Primitive Type
        // --------------------------------------
        // 👉 Primitive = raw data stored directly in memory (not an object)
        // 👉 int = 4 bytes (range ≈ -2.1B to +2.1B)
        int a = 10; // variable 'a' holds value 10
        int b = 5;  // variable 'b' holds value 5

        // 🧠 Performing arithmetic operations
        System.out.println("Sum: " + (a + b));  // -> Sum: 15
        System.out.println("Diff: " + (a - b)); // -> Diff: 5
        System.out.println("Prod: " + (a * b)); // -> Prod: 50
        System.out.println("Div: " + (a / b));  // -> Div: 2
        System.out.println("Mod: " + (a % b));  // -> Mod: 0
        // 💡 Note: % gives remainder, / gives integer division result

        // --------------------------------------
        // 🧩 2️⃣ Integer — Wrapper Class
        // --------------------------------------
        // 👉 Integer is a class that wraps primitive int into an Object.
        // 👉 Needed when using Collections or Object-based APIs.
        Integer boxed = Integer.valueOf(a);  // Manual Boxing: int -> Integer object
        int unboxed = boxed.intValue();      // Manual Unboxing: Integer -> int

        System.out.println("Boxed: " + boxed);     // -> Boxed: 10
        System.out.println("Unboxed: " + unboxed); // -> Unboxed: 10

        // 🧠 Auto-boxing and Auto-unboxing (automatic conversion)
        Integer autoBox = 42;  // compiler auto-converts int → Integer
        int autoUnbox = autoBox; // compiler auto-converts Integer → int
        System.out.println("AutoBox: " + autoBox);   // -> AutoBox: 42
        System.out.println("AutoUnbox: " + autoUnbox); // -> AutoUnbox: 42

        // --------------------------------------
        // 🧩 3️⃣ Inbuilt Methods in Integer class
        // --------------------------------------
        // 🧠 Wrapper classes provide helpful utilities for conversions & comparisons

        // 🔹 1️⃣ Integer.parseInt(String s)
        // ✅ Converts numeric String → int (primitive)
        // 🧠 Use case: when reading numeric input as text, like "123" → 123
        System.out.println(Integer.parseInt("123"));  // -> 123

        // 🔹 2️⃣ Integer.toString(int n)
        // ✅ Converts int → String
        // 🧠 Use case: useful for palindrome problems, or concatenating numbers with text
        System.out.println(Integer.toString(99));  // -> "99"

        // 🔹 3️⃣ Integer.valueOf(String s, int radix)
        // ✅ Converts a string written in any base (binary, octal, decimal, or hex) → Integer object
        // 🧠 Use case: converting numbers from different numeral systems to decimal form
        System.out.println(Integer.valueOf("101", 2));   // -> 5
        // "101" (base 2) = 1×2² + 0×2¹ + 1×2⁰ = 4 + 0 + 1 = 5 ✅  (Binary → Decimal)

        System.out.println(Integer.valueOf("10", 8));    // -> 8
        // "10" (base 8) = 1×8¹ + 0×8⁰ = 8 + 0 = 8 ✅  (Octal → Decimal)

        System.out.println(Integer.valueOf("10", 10));   // -> 10
        // "10" (base 10) = normal decimal number = 10 ✅  (Decimal → Decimal)

        System.out.println(Integer.valueOf("A", 16));    // -> 10
        // "A" (base 16) = 10 in decimal ✅  (Hexadecimal → Decimal)
        // 💡 Hexadecimal digits go from 0–9 and then A=10, B=11, C=12, D=13, E=14, F=15.

        // 🧠 Summary Table (easy to remember):
        // Base → Meaning
        //  2 → Binary (digits 0,1)
        //  8 → Octal (digits 0–7)
        // 10 → Decimal (digits 0–9)
        // 16 → Hexadecimal (digits 0–9, A–F)
        //
        // Example conversions:
        //   "101" (base 2) → 5
        //   "10"  (base 8) → 8
        //   "10"  (base 10) → 10
        //   "A"   (base 16) → 10


        // 🔹 1️⃣1️⃣ Integer.valueOf(String s)
        // ✅ Converts string → Integer object (wrapper)
        // 🧠 Use case: when Collections (List<Integer>) or APIs require an object, not primitive
        System.out.println(Integer.valueOf("123")); // -> 123 (Integer object)


        // 🔹 4️⃣ Integer.max(int a, int b)
        // ✅ Returns the larger of two ints
        // 🧠 Use case: DP/Greedy problems needing max/min comparison
        System.out.println(Integer.max(10, 20));  // -> 20   (returns larger)

        // 🔹 5️⃣ Integer.min(int a, int b)
        // ✅ Returns the smaller of two ints
        // 🧠 Use case: minimum cost, min operations type problems
        System.out.println(Integer.min(10, 20));  // -> 10   (returns smaller)

        // 🔹 6️⃣ Integer.compare(int x, int y)
        // ✅ Compares two integers (returns 0 if equal, -1 if x<y, 1 if x>y)
        // 🧠 Use case: custom sorting without overflow (instead of x - y)
        System.out.println(Integer.compare(5, 5));  // -> 0  (equal)
        System.out.println(Integer.compare(5, 8));  // -> -1 (first < second)
        System.out.println(Integer.compare(8, 5));  // -> 1  (first > second)

        // 🔹 7️⃣ Integer.toBinaryString(int n)
        // ✅ Converts integer → binary string
        // 🧠 Use case: bitwise problems, debugging binary representation
        System.out.println(Integer.toBinaryString(10));  // -> "1010" (binary form)

        // 🔹 8️⃣ Integer.bitCount(int n)
        // ✅ Returns number of 1-bits (set bits) in binary representation
        // 🧠 Use case: Hamming weight, Counting Bits, Subset problems
        System.out.println(Integer.bitCount(7));  // -> 3 (111 has three 1s)

        // 🔹 9️⃣ Integer.numberOfLeadingZeros(int n)
        // ✅ Counts how many zero bits come *before* the first 1 in the 32-bit binary form.
        // 🧠 Use case: helps in finding bit length or highest set bit.
        System.out.println(Integer.numberOfLeadingZeros(8));  // 8 = 1000 → 28 leading zeros
        /*
        💡 EXPLANATION (easy):
        Every int in Java is 32 bits long.
        Binary of 8 = 00000000 00000000 00000000 00001000
        👉 There are 28 zeros before the first '1' bit.

        So, numberOfLeadingZeros(8) = 28

        🧠 Real-life use:
        If you want to know "how big" a number is in binary form,
        bitLength = 32 - Integer.numberOfLeadingZeros(n);
        Example: 8 → bitLength = 32 - 28 = 4 bits.
        */


        // 🔹 🔟 Integer.numberOfTrailingZeros(int n)
        // ✅ Counts how many zero bits come *after* the last 1 in binary form.
        // 🧠 Use case: tells how many times a number can be divided by 2 before it becomes odd.
        System.out.println(Integer.numberOfTrailingZeros(8));  // 8 = 1000 → 3 trailing zeros
        /*
        💡 EXPLANATION (easy):
        Binary of 8 = 00000000 00000000 00000000 00001000
        👉 It ends with 3 zeros after the last 1 (1000).

        So, numberOfTrailingZeros(8) = 3

        🧠 Real-life use:
        If a number ends with k zeros in binary,
        it means the number is divisible by 2^k.
        Here, 8 = 2^3, so it has 3 trailing zeros.
        */

        // 🔹 1️⃣2️⃣ Integer.MAX_VALUE & Integer.MIN_VALUE
        // ✅ Constants defining range of int
        // 🧠 Use case: overflow checks (Reverse Integer / Divide Two Integers)
        System.out.println("Max: " + Integer.MAX_VALUE + ", Min: " + Integer.MIN_VALUE);
        // 💡 Useful in coding rounds: parsing, bit ops, base conversions, etc.

        // --------------------------------------
        // 🧩 4️⃣ Comparison Pitfall
        // --------------------------------------
        // 👉 '==' compares object reference (memory address)
        // 👉 'equals()' compares actual numeric value
        // 👉 JVM caches Integer objects in range [-128, 127]
        Integer p = 100; // cached
        Integer q = 100; // same cached object
        Integer r = 200; // new object (not cached)
        Integer s = 200; // another new object

        System.out.println(p == q);      // -> true   (same cached reference)
        System.out.println(r == s);      // -> false  (different objects)
        System.out.println(p.equals(q)); // -> true   (same numeric value)
        System.out.println(r.equals(s)); // -> true   (same numeric value)
        // 💡 Interview Tip: Always use equals() for comparing wrapper objects.

        // --------------------------------------
        // 🧩 5️⃣ Safe Comparison Example
        // --------------------------------------
        Integer x = 7, y = 7;
        System.out.println(x.equals(y)); // -> true (recommended way)
    }
}
