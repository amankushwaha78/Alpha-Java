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

        // Basic arithmetic
        System.out.println("Sum: " + (distance + population));   // -> 16380000000
        System.out.println("Diff: " + (distance - population));  // -> 13620000000
        System.out.println("Prod: " + (population * 2));         // -> 2760000000
        System.out.println("Div: " + (distance / 10));           // -> 1500000000
        // 💡 Works just like int, but for bigger values

        // --------------------------------------
        // 🧩 2️⃣ Long — Wrapper Class
        // --------------------------------------
        // 👉 Allows you to use 'long' as an Object
        Long box = Long.valueOf(distance);  // Boxing
        long unbox = box.longValue();       // Unboxing

        System.out.println("Boxed: " + box);     // -> 15000000000
        System.out.println("Unboxed: " + unbox); // -> 15000000000

        // Auto-boxing and auto-unboxing
        Long autoBox = 5000L;   // compiler converts primitive -> object
        long autoUnbox = autoBox; // compiler converts object -> primitive
        System.out.println("AutoBox: " + autoBox);     // -> 5000
        System.out.println("AutoUnbox: " + autoUnbox); // -> 5000

        // --------------------------------------
        // 🧩 3️⃣ Inbuilt Methods in Long class
        // --------------------------------------
        // 🧠 Useful for parsing, comparison, and conversions
        System.out.println(Long.parseLong("12345"));            // -> 12345  (String → long)
        System.out.println(Long.toString(99999));               // -> 99999  (long → String)
        System.out.println(Long.valueOf("1010", 2));            // -> 10     (binary "1010" → decimal)
        System.out.println(Long.max(100L, 500L));               // -> 500
        System.out.println(Long.min(100L, 500L));               // -> 100
        System.out.println(Long.compare(50L, 50L));             // -> 0   (equal)
        System.out.println(Long.compare(50L, 100L));            // -> -1  (less)
        System.out.println(Long.compare(200L, 100L));           // -> 1   (greater)
        System.out.println(Long.toBinaryString(15L));           // -> 1111
        System.out.println(Long.toHexString(255L));             // -> ff
        System.out.println(Long.bitCount(7L));                  // -> 3   (111 has three 1s)
        // 💡 Long methods mirror Integer methods but handle bigger numbers.

        // --------------------------------------
        // 🧩 4️⃣ Comparison Pitfall
        // --------------------------------------
        // 👉 Same caching behavior as Integer, range = [-128, 127]
        Long a = 127L;
        Long b = 127L;
        Long c = 128L;
        Long d = 128L;

        System.out.println(a == b);       // -> true  (cached range)
        System.out.println(c == d);       // -> false (outside cache)
        System.out.println(a.equals(b));  // -> true  (value equal)
        System.out.println(c.equals(d));  // -> true  (value equal)
        // 💡 Always use equals() for comparing Long values.

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
        // 🧠 Summary:
        // long = primitive (fast, 8 bytes)
        // Long = object wrapper (has methods, slower)
        // Use equals() not == for object comparison
        // Range caching same as Integer: -128 to 127
        // Common methods: parseLong, toString, valueOf, max, min, compare, bitCount
    }
}
