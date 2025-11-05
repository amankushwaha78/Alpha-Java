// Topic: byte (primitive) + Byte (wrapper) + inbuilt methods + unsigned helpers + overflow pitfalls
// 🧠 byte = 1 byte (8 bits), range: -128 .. 127

public class _4_ByteAndWrapperNotes {
    public static void main(String[] args) {

        // --------------------------------------
        // 🧩 1) byte — Primitive Basics
        // --------------------------------------
        byte a = 100;                          // 100 fits in range -128..127
        byte b = 27;                           // another small number
        System.out.println("Sum: " + (a + b));             // -> Sum: 127
        System.out.println("Diff: " + (a - b));            // -> Diff: 73
        System.out.println("Prod: " + (a * b));            // -> Prod: 2700
        System.out.println("Div: " + (a / b));             // -> Div: 3
        // 💡 Arithmetic promotes to int; result type here is int in println.

        // --------------------------------------
        // 🧩 2) Explicit Casting (important with byte)
        // --------------------------------------
        int big = 130;                         // outside byte range
        byte wrapped = (byte) big;             // overflow wrap using 2's complement
        System.out.println("Cast 130 to byte: " + wrapped); // -> Cast 130 to byte: -126
        // 💡 130 - 256 = -126 (mod 256): classic overflow interview example.

        // --------------------------------------
        // 🧩 3) Byte — Wrapper: boxing / unboxing
        // --------------------------------------
        Byte box = Byte.valueOf(a);            // Boxing: byte -> Byte
        byte unbox = box.byteValue();          // Unboxing: Byte -> byte
        System.out.println("Boxed: " + box);                 // -> Boxed: 100
        System.out.println("Unboxed: " + unbox);             // -> Unboxed: 100

        // Auto-boxing / unboxing
        Byte autoBox = 12;                     // auto-box
        byte autoUnbox = autoBox;              // auto-unbox
        System.out.println("AutoBox: " + autoBox);           // -> AutoBox: 12
        System.out.println("AutoUnbox: " + autoUnbox);       // -> AutoUnbox: 12

        // --------------------------------------
        // 🧩 4) Common Inbuilt Methods (Byte)
        // --------------------------------------
        System.out.println(Byte.parseByte("120"));           // -> 120     (String -> byte)
        System.out.println(Byte.parseByte("7F", 16));        // -> 127     (hex "7F" -> 127)
        System.out.println(Byte.toString((byte) 45));        // -> 45      (byte -> String)
        System.out.println(Byte.compare((byte) 5, (byte) 9));// -> -1      (less than)
        System.out.println(Byte.compare((byte) 9, (byte) 5));// -> 1       (greater than)
        System.out.println(Byte.compare((byte) 7, (byte) 7));// -> 0       (equal)

        // --------------------------------------
        // 🧩 5) Unsigned Helpers (treat byte as 0..255)
        // --------------------------------------
        byte neg = (byte) 0xF2;                // 0xF2 = 242 unsigned, but as signed it's -14
        int uInt = Byte.toUnsignedInt(neg);    // interpret as 242
        long uLong = Byte.toUnsignedLong(neg); // 242 as long
        System.out.println("Signed view: " + neg);           // -> Signed view: -14
        System.out.println("Unsigned int: " + uInt);         // -> Unsigned int: 242
        System.out.println("Unsigned long: " + uLong);       // -> Unsigned long: 242
        // 💡 Equivalent trick: (neg & 0xFF) gives 242 as int.
        System.out.println("neg & 0xFF: " + (neg & 0xFF));   // -> neg & 0xFF: 242

        // --------------------------------------
        // 🧩 6) Constants & Metadata
        // --------------------------------------
        System.out.println("MIN_VALUE: " + Byte.MIN_VALUE);  // -> MIN_VALUE: -128
        System.out.println("MAX_VALUE: " + Byte.MAX_VALUE);  // -> MAX_VALUE: 127
        System.out.println("SIZE(bits): " + Byte.SIZE);      // -> SIZE(bits): 8
        System.out.println("BYTES: " + Byte.BYTES);          // -> BYTES: 1

        // --------------------------------------
        // 🧩 7) Comparison Pitfall (Caching & == vs equals)
        // --------------------------------------
        // ✅ Byte caches -128..127, but still use equals() for clarity.
        Byte p = 127, q = 127, r = -128, s = -128;
        System.out.println(p == q);                          // -> true   (cached same ref)
        System.out.println(r == s);                          // -> true   (cached same ref)
        System.out.println(p.equals(q));                     // -> true   (value equal)
        // ⚠ If values come from parsing/boxing outside cache logic, always prefer equals().
    }
}
