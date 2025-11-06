// File: LongAndWrapperNotes.java
// Topic: long (primitive) + Long (wrapper class) + inbuilt methods + comparison pitfalls
// 🧠 Notes are added throughout for full understanding.

public class _2_LongAndWrapperNotes {
    public static void main(String[] args) {

        // --------------------------------------
        // 🧩 1️⃣ long — Primitive Type
        // --------------------------------------
        // 👉 Used for storing very large integers (8 bytes)
        // 👉 Range ≈ -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807
        long distance = 15000000000L;   // 'L' suffix required for long literal
        long population = 1380000000L;  // 1.38 billion (example)

        // 🧠 Basic arithmetic (works like int, just a bigger range)
        System.out.println("Sum: " + (distance + population));   // -> 16380000000
        System.out.println("Diff: " + (distance - population));  // -> 13620000000
        System.out.println("Prod: " + (population * 2));         // -> 2760000000
        System.out.println("Div: " + (distance / 10));           // -> 1500000000
        // 💡 Watch out for overflow even with long if values exceed the long range.

        // --------------------------------------
        // 🧩 2️⃣ Long — Wrapper Class
        // --------------------------------------
        // 👉 Allows you to use 'long' as an Object (Collections, APIs expecting objects)
        Long box = Long.valueOf(distance);  // Boxing: long -> Long
        long unbox = box.longValue();       // Unboxing: Long -> long

        System.out.println("Boxed: " + box);     // -> 15000000000
        System.out.println("Unboxed: " + unbox); // -> 15000000000

        // 🧠 Auto-boxing and auto-unboxing (compiler does it for you)
        Long autoBox = 5000L;       // primitive -> object automatically
        long autoUnbox = autoBox;   // object -> primitive automatically
        System.out.println("AutoBox: " + autoBox);     // -> 5000
        System.out.println("AutoUnbox: " + autoUnbox); // -> 5000

        // --------------------------------------
        // 🧩 3️⃣ Inbuilt Methods in Long class (daily LeetCode use)
        // --------------------------------------
        // 🧠 Helpful for parsing, comparison, base conversions, and bit ops

        // 🔹 1️⃣ Long.parseLong(String s)
        // ✅ Converts numeric String → long (primitive)
        // 🧠 Use case: reading big numbers from input
        System.out.println(Long.parseLong("12345"));  // -> 12345

        // 🔹 2️⃣ Long.toString(long n)
        // ✅ Converts long → String
        // 🧠 Use case: building outputs, palindrome checks on numbers as text
        System.out.println(Long.toString(99999));     // -> "99999"

        // 🔹 3️⃣ Long.valueOf(String s, int radix)
        // ✅ Converts a string written in any base → Long object
        // 🧠 Use case: binary/octal/hexadecimal inputs to decimal
        System.out.println(Long.valueOf("1010", 2));  // -> 10
        // "1010" (base 2) = 1×2³ + 0×2² + 1×2¹ + 0×2⁰ = 8 + 0 + 2 + 0 = 10 ✅  (Binary → Decimal)

        System.out.println(Long.valueOf("10", 8));    // -> 8
        // "10" (base 8) = 1×8¹ + 0×8⁰ = 8 ✅  (Octal → Decimal)

        System.out.println(Long.valueOf("10", 10));   // -> 10
        // "10" (base 10) = 10 ✅  (Decimal → Decimal)

        System.out.println(Long.valueOf("A", 16));    // -> 10
        // "A" (base 16) = 10 ✅  (Hexadecimal → Decimal)
        // 💡 Hex digits: 0–9 then A=10, B=11, C=12, D=13, E=14, F=15.

        // 🔹 4️⃣ Long.max(long a, long b) / Long.min(long a, long b)
        // ✅ Larger/smaller of two longs
        // 🧠 Use case: DP/Greedy comparisons without branching
        System.out.println(Long.max(100L, 500L));  // -> 500
        System.out.println(Long.min(100L, 500L));  // -> 100

        // 🔹 5️⃣ Long.compare(long x, long y)
        // ✅ Returns 0 (equal), -1 (x<y), 1 (x>y)
        // 🧠 Use case: safe comparator without overflow (avoid x - y)
        System.out.println(Long.compare(50L, 50L));   // -> 0
        System.out.println(Long.compare(50L, 100L));  // -> -1
        System.out.println(Long.compare(200L, 100L)); // -> 1

        // 🔹 6️⃣ Long.toBinaryString(long n)
        // ✅ Converts long → binary string
        // 🧠 Use case: debugging bitmasks or binary thinking on big numbers
        System.out.println(Long.toBinaryString(15L)); // -> "1111"

        // 🔹 7️⃣ Long.bitCount(long n)
        // ✅ Number of set bits (1s) in the binary form
        // 🧠 Use case: Hamming weight / Counting Bits
        System.out.println(Long.bitCount(7L));        // -> 3   (111 has three 1s)

        // 🔹 8️⃣ Long.numberOfLeadingZeros(long n)
        // ✅ Counts how many 0-bits come *before* the first 1-bit in the 64-bit binary form.
        // 🧠 Use case: helps find how many bits are actually used to represent the number.
        // Formula: bitLength = 64 - Long.numberOfLeadingZeros(n)
        System.out.println(Long.numberOfLeadingZeros(8L));  // -> 60
        /*
        💡 EXPLANATION (simple):
        Every long = 64 bits in Java.

        Binary of 8 = 1000
        Expanded to 64 bits:
        00000000 00000000 00000000 00000000 00000000 00000000 00000000 00001000
        ↑────────── 60 zeros before the first 1 ──────────────────────────↑

        So, Long.numberOfLeadingZeros(8L) = 60 ✅

        🧠 Why useful:
        You can find the number of bits needed to represent a number:
        bitLength = 64 - Long.numberOfLeadingZeros(n);
        For 8 → bitLength = 64 - 60 = 4 bits → fits binary 1000.
        */

        // 🔹 9️⃣ Long.numberOfTrailingZeros(long n)
        // ✅ Counts how many 0-bits come *after* the last 1-bit (from the right/LSB side).
        // 🧠 Use case: tells how many times the number can be divided by 2 before it becomes odd.
        // In math: if n = 2^k × odd, then k = numberOfTrailingZeros(n)
        System.out.println(Long.numberOfTrailingZeros(8L));  // -> 3
        /*
        💡 EXPLANATION (simple):

        Binary of 8 = 1000
        Expanded to 64 bits:
        00000000 00000000 00000000 00000000 00000000 00000000 00000000 00001000
                                                                          ↑1 0 0 0
                                                                            └───3 zeros───┘

        👉 There are **3 zeros after the last 1-bit** (counting from rightmost bit).

        So, Long.numberOfTrailingZeros(8L) = 3 ✅

        🧠 Why useful:
        If a number ends with k zeros in its binary form,
        it means it’s divisible by 2^k.

        Examples:
          - 8  (1000₂) → 3 trailing zeros → 2³ divides it
          - 12 (1100₂) → 2 trailing zeros → 2² divides it
          - 20 (10100₂) → 2 trailing zeros → 2² divides it
          - 40 (101000₂) → 3 trailing zeros → 2³ divides it
        */


        // 🔹 🔟 Long.valueOf(String s)
        // ✅ Converts String → Long object (wrapper)
        // 🧠 Use case: when Collections (List<Long>) or APIs need an object, not primitive
        System.out.println(Long.valueOf("12345"));    // -> 12345 (as Long)

        // 🔹 1️⃣1️⃣ Long.MAX_VALUE & Long.MIN_VALUE
        // ✅ Constants defining the range of long
        // 🧠 Use case: guardrails for overflow, DP sentinels
        System.out.println("Max: " + Long.MAX_VALUE + ", Min: " + Long.MIN_VALUE);

        // --------------------------------------
        // 🧩 4️⃣ Comparison Pitfall
        // --------------------------------------
        // 👉 '==' on wrappers compares OBJECT REFERENCES (memory), not numeric value.
        // 👉 'equals()' compares numeric value.
        // 👉 Long cache range (like Integer): [-128, 127] for autoboxed/valueOf() instances.
        Long a = 127L;   // cached
        Long b = 127L;   // same cached object
        Long c = 128L;   // outside cache → distinct objects
        Long d = 128L;   // outside cache → distinct objects

        System.out.println(a == b);       // -> true  (same cached reference)
        System.out.println(c == d);       // -> false (different objects)
        System.out.println(a.equals(b));  // -> true  (value equal)
        System.out.println(c.equals(d));  // -> true  (value equal)
        // 💡 Interview Tip: Always use equals() for comparing Long/Integer wrappers.

        // --------------------------------------
        // 🧩 5️⃣ Safe Comparison (Recommended)
        // --------------------------------------
        Long p = 500L, q = 500L;
        if (p.equals(q)) {
            System.out.println("Both are equal ✔️"); // -> Both are equal ✔️
        } else {
            System.out.println("Not equal ❌");
        }

        // --------------------------------------
        // 🧠 Summary (quick revision):
        // long  = primitive (fast, 8 bytes, huge range)
        // Long  = wrapper object (use in Collections/APIs, has utility methods)
        // Methods you’ll actually use often:
        //   parseLong, toString, valueOf(s, radix), max, min, compare,
        //   toBinaryString, bitCount, numberOfLeadingZeros, numberOfTrailingZeros,
        //   MAX_VALUE / MIN_VALUE.
        // Pitfall: use equals() (not ==) with wrappers due to caching/reference semantics.
    }
}
