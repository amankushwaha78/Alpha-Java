// File: ByteAndWrapperNotes.java
// Topic: byte (primitive) + Byte (wrapper class) + inbuilt methods + unsigned helpers + comparison pitfalls
// 🧠 byte = 1 byte (8 bits), range: -128 .. 127 — ideal for compact data (I/O, arrays, file streams).

public class _4_ByteAndWrapperNotes {
    public static void main(String[] args) {

        // --------------------------------------
        // 🧩 1️⃣ byte — Primitive Type
        // --------------------------------------
        // 👉 8-bit signed integer (fast, value stored directly; not an object)
        byte a = 100;   // ✅ within range
        byte b = 27;    // ✅ within range

        // 🧠 Basic arithmetic (Java promotes to int during calculation)
        System.out.println("Sum: "  + (a + b));  // -> 127
        System.out.println("Diff: " + (a - b));  // -> 73
        System.out.println("Prod: " + (a * b));  // -> 2700
        System.out.println("Div: "  + (a / b));  // -> 3
        // 💡 Arithmetic auto-promotes byte → int for safety.

        // ⚠️ Overflow example (interview favorite)
        int big = 130;              // 130 > 127 (out of byte range)
        byte wrapped = (byte) big;  // wraps via 2’s complement
        System.out.println("Cast 130 -> byte: " + wrapped); // -> -126
        // 💡 130 - 256 = -126 → wrapping occurs (mod 256 arithmetic).

        // --------------------------------------
        // 🧩 2️⃣ Byte — Wrapper Class
        // --------------------------------------
        // 👉 Lets you use ‘byte’ as an Object (e.g., in Collections, APIs, etc.)
        Byte box = Byte.valueOf(a);    // Boxing: byte → Byte
        byte unbox = box.byteValue();  // Unboxing: Byte → byte

        System.out.println("Boxed: "   + box);   // -> 100
        System.out.println("Unboxed: " + unbox); // -> 100

        // 🧠 Auto-boxing / auto-unboxing (compiler handles conversion automatically)
        Byte autoBox = 12;          // auto-box: byte → Byte
        byte autoUnbox = autoBox;   // auto-unbox: Byte → byte
        System.out.println("AutoBox: "   + autoBox);   // -> 12
        System.out.println("AutoUnbox: " + autoUnbox); // -> 12

        // --------------------------------------
        // 🧩 3️⃣ Inbuilt Methods in Byte class (daily LeetCode use)
        // --------------------------------------
        // 🧠 Helpful for parsing, base conversion, comparison, unsigned view, and constants.

        // 🔹 1️⃣ Byte.parseByte(String s)
        // ✅ Converts numeric string → primitive byte
        // 🧠 Use: reading small numbers from input
        System.out.println(Byte.parseByte("120")); // -> 120

        // 🔹 2️⃣ Byte.toString(byte v)
        // ✅ Converts byte → String
        // 🧠 Use: logging or string operations
        System.out.println(Byte.toString((byte)45)); // -> "45"

        // 🔹 3️⃣ Byte.valueOf(String s)
        // ✅ Converts string → Byte (object)
        // 🧠 Use: when APIs/Collections require Byte, not byte
        System.out.println(Byte.valueOf("100")); // -> 100 (Byte)

        // 🔹 4️⃣ Byte.valueOf(String s, int radix)
        // ✅ Converts string in any base → Byte object
        // 🧠 Use: binary/octal/hexadecimal conversion
        System.out.println(Byte.valueOf("1010", 2)); // -> 10
        System.out.println(Byte.valueOf("10", 8));   // -> 8
        System.out.println(Byte.valueOf("10", 10));  // -> 10
        System.out.println(Byte.valueOf("7F", 16));  // -> 127
        // 💡 Hexadecimal digits go 0–9, then A=10..F=15

        // 🔹 5️⃣ Byte.decode(String s)
        // ✅ Detects base automatically by prefix → Byte object
        // 🧠 Use: parsing values with 0x/#/0 prefix
        System.out.println(Byte.decode("127"));   // -> 127   (decimal)
        System.out.println(Byte.decode("0x7F"));  // -> 127   (hex)
        System.out.println(Byte.decode("#7F"));   // -> 127   (hex)
        System.out.println(Byte.decode("0177"));  // -> 127   (octal)
        // 💡 “0x/0X/#” = hex, leading “0” = octal, else decimal.

        // 🔹 6️⃣ Byte.compare(byte x, byte y)
        // ✅ Returns -1 / 0 / 1 for less/equal/greater
        // 🧠 Use: safe comparison, no overflow risk
        System.out.println(Byte.compare((byte)5, (byte)9)); // -> -1
        System.out.println(Byte.compare((byte)9, (byte)5)); // -> 1
        System.out.println(Byte.compare((byte)7, (byte)7)); // -> 0

        // 🔹 7️⃣ Unsigned Helpers
        // ✅ Convert signed byte → unsigned int/long (0–255)
        byte neg = (byte)0xF2; // 0xF2 = 242 unsigned → signed view = -14
        System.out.println("Signed view: " + neg);              // -> -14
        System.out.println("Unsigned Int: " + Byte.toUnsignedInt(neg));  // -> 242
        System.out.println("Unsigned Long: " + Byte.toUnsignedLong(neg));// -> 242
        System.out.println("neg & 0xFF: " + (neg & 0xFF));              // -> 242
        // 💡 (b & 0xFF) is a quick manual way to treat byte as unsigned.

        // 🔹 8️⃣ Constants: MAX_VALUE / MIN_VALUE / BYTES / SIZE
        // ✅ Range + bit-size constants
        System.out.println("MAX: "   + Byte.MAX_VALUE + ", MIN: " + Byte.MIN_VALUE);
        // -> MAX: 127, MIN: -128
        System.out.println("Bytes: " + Byte.BYTES + ", Bits: " + Byte.SIZE);
        // -> Bytes: 1, Bits: 8

        // 🔹 9️⃣ Missing methods (not available on Byte)
        // ❌ Byte doesn’t support:
        //    toBinaryString(), bitCount(), numberOfLeadingZeros(), numberOfTrailingZeros(), reverseBytes()
        // 💡 Use Integer helper functions if needed:
        //    Integer.toBinaryString(b & 0xFF)
        //    Integer.bitCount(b & 0xFF)

        // --------------------------------------
        // 🧩 4️⃣ Comparison Pitfall (Caching)
        // --------------------------------------
        // 👉 '==' compares object reference (memory)
        // 👉 'equals()' compares numeric value
        // 👉 Byte cache range = [-128, 127]
        Byte p = 127;  // cached
        Byte q = 127;  // cached (same object)
        Byte r = -128; // cached
        Byte s = -128; // cached (same object)

        System.out.println(p == q);      // -> true   (same reference)
        System.out.println(r == s);      // -> true   (same reference)
        System.out.println(p.equals(q)); // -> true   (equal values)
        // 💡 Interview Tip: Always prefer equals() with wrappers.

        // --------------------------------------
        // 🧠 Summary (quick revision)
        // --------------------------------------
        // ✅ byte  = primitive (fast, 1 byte, range -128..127)
        // ✅ Byte  = wrapper (object form; adds methods & constants)
        // 💡 Commonly used methods:
        //   parseByte, toString, valueOf(s), valueOf(s, radix), decode,
        //   compare, toUnsignedInt, toUnsignedLong,
        //   MAX_VALUE, MIN_VALUE, BYTES, SIZE.
        //
        // ⚠️ Overflow:
        //   (byte)130 == -126 (wraps around mod 256)
        //
        // ⚠️ Missing methods (unlike Integer/Long):
        // 🔹 Leading zeros:       Byte has no numberOfLeadingZeros()
        // 🔹 Trailing zeros:      Byte has no numberOfTrailingZeros()
        // 🔹 Bit count:           Byte has no bitCount()
        // 🔹 Binary string:       Byte has no toBinaryString()
        // 🔹 Max/Min:             Byte has no Byte.max/min()
        // 🔹 Sum:                 Byte has no Byte.sum()

        // 💬 Always use equals() for comparing Byte objects (== only works reliably in cache range).
    }
}
