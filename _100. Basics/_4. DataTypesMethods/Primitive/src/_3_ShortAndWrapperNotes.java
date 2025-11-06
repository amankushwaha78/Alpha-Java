// File: ShortAndWrapperNotes.java
// Topic: short (primitive) + Short (wrapper class) + inbuilt methods + comparison pitfalls
// 🧠 Short = 2 bytes (range: -32,768 to 32,767) — use when you need compact integers (memory-friendly arrays, IoT data, etc.)

public class _3_ShortAndWrapperNotes {
    public static void main(String[] args) {

        // --------------------------------------
        // 🧩 1️⃣ short — Primitive Type
        // --------------------------------------
        // 👉 16-bit signed integer (fast, value stored directly; not an object)
        short a = 100;   // OK: inside range
        short b = 50;    // OK: inside range

        // 🧠 Basic arithmetic (Java promotes to int during ops, result prints fine)
        System.out.println("Sum: "  + (a + b));  // -> 150
        System.out.println("Diff: " + (a - b));  // -> 50
        System.out.println("Prod: " + (a * b));  // -> 5000
        System.out.println("Div: "  + (a / b));  // -> 2
        // 💡 Integer division: fractions are discarded.

        // --------------------------------------
        // 🧩 2️⃣ Short — Wrapper Class
        // --------------------------------------
        // 👉 Object form of short; needed for Collections/APIs that require Objects.
        Short box = Short.valueOf(a);     // Boxing:  short  → Short
        short unbox = box.shortValue();   // Unboxing: Short → short

        System.out.println("Boxed: "   + box);   // -> 100   (now it’s an object)
        System.out.println("Unboxed: " + unbox); // -> 100   (back to primitive)

        // 🧠 Auto-boxing / auto-unboxing (compiler does the conversion for you)
        Short autoBox = 25;           // short → Short automatically
        short autoUnbox = autoBox;    // Short → short automatically
        System.out.println("AutoBox: "   + autoBox);   // -> 25
        System.out.println("AutoUnbox: " + autoUnbox); // -> 25

        // --------------------------------------
        // 🧩 3️⃣ Inbuilt Methods in Short class (daily LeetCode use)
        // --------------------------------------
        // 🧠 Helpful for parsing, base conversions, comparison, byte order, and constants.

        // 🔹 1️⃣ Short.parseShort(String s)
        // ✅ String → primitive short
        // 🧠 Use: reading numeric tokens from input
        System.out.println(Short.parseShort("123")); // -> 123

        // 🔹 2️⃣ Short.toString(short v)
        // ✅ short → String
        // 🧠 Use: building outputs, logs, or “string-based” checks
        System.out.println(Short.toString((short)45)); // -> "45"

        // 🔹 3️⃣ Short.valueOf(String s)
        // ✅ String → Short (OBJECT, not primitive)
        // 🧠 Use: when APIs/Collections (List<Short>) need an object
        System.out.println(Short.valueOf("120")); // -> 120 (Short)

        // 🔹 4️⃣ Short.valueOf(String s, int radix)
        // ✅ Base-N string → Short (object)
        // 🧠 Use: binary/octal/hex inputs to decimal form
        System.out.println(Short.valueOf("101", 2));  // -> 5
        // "101"₂ = 1×2² + 0×2¹ + 1×2⁰ = 4 + 0 + 1 = 5 ✅

        System.out.println(Short.valueOf("10", 8));   // -> 8
        // "10"₈ = 1×8¹ + 0×8⁰ = 8 ✅

        System.out.println(Short.valueOf("10", 10));  // -> 10
        // "10"₁₀ = 10 ✅

        System.out.println(Short.valueOf("A", 16));   // -> 10
        // "A"₁₆ = 10 (Hex digits: 0–9, A=10..F=15) ✅

        // 🔹 5️⃣ Short.decode(String s)
        // ✅ Auto-detects base by prefix → Short (object)
        // 🧠 Use: config strings / literals that may come with prefixes
        System.out.println(Short.decode("123"));   // -> 123   (decimal)
        System.out.println(Short.decode("0x7B"));  // -> 123   (hex “0x”)
        System.out.println(Short.decode("#7B"));   // -> 123   (hex “#”)
        System.out.println(Short.decode("0173"));  // -> 123   (octal leading 0)
        // 💡 Rule: “0x/0X/#” → hex, leading “0” → octal, else decimal.

        // 🔹 6️⃣ Short.compare(short x, short y)
        // ✅ Returns -1 / 0 / 1  (x<y / x==y / x>y)
        // 🧠 Use: safe comparisons for sorting, avoids (x - y) overflow tricks
        System.out.println(Short.compare((short)10, (short)20)); // -> -1
        System.out.println(Short.compare((short)20, (short)10)); // -> 1
        System.out.println(Short.compare((short)5,  (short)5));  // -> 0


        // 🔹 9️⃣ Constants: MAX/MIN, BYTES/SIZE
        // ✅ Range + size info (great for guards / bit math)
        System.out.println("MAX: "   + Short.MAX_VALUE + ", MIN: " + Short.MIN_VALUE);
        // -> MAX: 32767, MIN: -32768

        System.out.println("Bytes: " + Short.BYTES + ", Bits: " + Short.SIZE);
        // -> Bytes: 2, Bits: 16

        // 🔹 8️⃣ Leading zeros (Short has no numberOfLeadingZeros)
        // 🔹 9️⃣ Trailing zeros (Short has no numberOfTrailingZeros)
        // 🔹 7️⃣ Bit count (Short has no bitCount)
        // 🔹 6️⃣ Binary string (Short has no toBinaryString)
        // 🔹 4️⃣ Max/Min (Short has no Short.max/min)

        // --------------------------------------
        // 🧩 4️⃣ Comparison Pitfall
        // --------------------------------------
        // 👉 '==' on wrappers compares OBJECT REFERENCES (memory), not numeric value.
        // 👉 'equals()' compares numeric value.
        // 👉 Short cache range (like Integer/Long): [-128, 127] for autoboxed/valueOf() instances.
        Short p = 127;  // cached
        Short q = 127;  // same cached object
        Short r = 128;  // new object (not cached)
        Short s = 128;  // another new object

        System.out.println(p == q);       // -> true   (same cached reference)
        System.out.println(r == s);       // -> false  (different objects)
        System.out.println(p.equals(q));  // -> true   (same numeric value)
        System.out.println(r.equals(s));  // -> true   (same numeric value)
        // 💡 Interview Tip: Always use equals() for comparing wrapper objects.

        // --------------------------------------
        // 🧩 5️⃣ Safe Comparison (Recommended)
        // --------------------------------------
        Short s1 = 127, s2 = 127;
        if (s1.equals(s2)) {
            System.out.println("Both are equal ✔️");
        } else {
            System.out.println("Not equal ❌");
        }

        // --------------------------------------
        // 🧠 Summary (quick revision):
        // short  = primitive (fast, 2 bytes)
        // Short  = wrapper (object; works with Collections/APIs)
        // Daily methods you’ll actually use:
        //   parseShort, toString, valueOf(s), valueOf(s,radix), decode,
        //   compare, reverseBytes, hashCode, MAX_VALUE/MIN_VALUE, BYTES/SIZE.
        // Pitfall: use equals() (not ==) with wrappers because of caching [-128..127].
        //
        // 🔧 Need bit helpers (bitCount/leadingZeros/trailingZeros) for short?
        //   → Short doesn’t have them; use int view:
        //      int ui16 = s & 0xFFFF;
        //      Integer.bitCount(ui16), Integer.numberOfLeadingZeros(ui16)-16,
        //      Integer.numberOfTrailingZeros(ui16), Integer.highestOneBit(ui16).
    }
}
