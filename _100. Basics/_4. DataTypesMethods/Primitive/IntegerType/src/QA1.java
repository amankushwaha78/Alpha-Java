// File: Main.java
// 🎯 Topic: Integer Type Family (byte, short, int, long)
// 🔍 Focus: Input–Output Scenarios + Interview Tricks + Overflow + Wrapper Caching
// 🧠 Perfect for: Quick revision + Live IntelliJ demo

public class QA1 {
    public static void main(String[] args) {

        System.out.println("🚀 Integer Family Scenarios\n");

        // =====================================================
        // 🧩 1️⃣ Arithmetic Promotion & Casting
        // =====================================================
        byte b = 50;
        b = (byte)(b * 2); // b*2 = 100 (int) → cast to byte
        System.out.println("1️⃣ byte promotion result: " + b); // -> 100
        // 💡 Java promotes smaller types (byte, short, char) to int before arithmetic.

        byte a1 = 10, a2 = 20;
        // byte a3 = a1 + a2; ❌ Compilation error (int result)
        byte a3 = (byte)(a1 + a2);
        System.out.println("2️⃣ Explicit cast result: " + a3); // -> 30

        // =====================================================
        // 🧩 2️⃣ Overflow Demonstrations
        // =====================================================
        byte x = 127;
        x++;
        System.out.println("3️⃣ Byte overflow wrap: " + x); // -> -128
        // 💡 127 → overflow → wraps using 2’s complement

        short s = 32767;
        s++;
        System.out.println("4️⃣ Short overflow wrap: " + s); // -> -32768

        long lmax = 9_223_372_036_854_775_807L;
        System.out.println("5️⃣ Long overflow: " + (lmax + 1)); // -> -9223372036854775808

        // =====================================================
        // 🧩 3️⃣ Type Promotions Between Mixed Types
        // =====================================================
        short s2 = 100;
        char c = 'A'; // 65
        int result = s2 + c; // both promoted to int
        System.out.println("6️⃣ short + char = int: " + result); // -> 165

        byte b1 = 100;
        short s1 = 200;
        int i = 300;
        long l = 400L;
        System.out.println("7️⃣ b+s+i+l = " + (b1 + s1 + i + l)); // -> 1000
        // 💡 Final result is long (largest type wins)

        // =====================================================
        // 🧩 4️⃣ Casting Examples
        // =====================================================
        int big = 130;
        byte wrapped = (byte) big;
        System.out.println("8️⃣ Casting 130 to byte: " + wrapped); // -> -126 (130-256)
        // 💡 Overflow wraps mod 256

        byte b2 = 10;
        int i2 = b2;          // widening (safe)
        byte b3 = (byte)i2;   // narrowing (needs cast)
        System.out.println("9️⃣ Widening + narrowing: " + b3); // -> 10

        // =====================================================
        // 🧩 5️⃣ Wrapper Class Caching & Comparison Pitfalls
        // =====================================================
        Integer i1 = 127, i22 = 127;
        System.out.println("🔟 Integer 127 == 127 → " + (i1 == i22)); // true (cached)

        Integer i3 = 128, i4 = 128;
        System.out.println("11️⃣ Integer 128 == 128 → " + (i3 == i4)); // false (not cached)

        Long l1 = 127L, l2 = 127L;
        System.out.println("12️⃣ Long 127 == 127 → " + (l1 == l2)); // true (cached)

        Short sh1 = 127, sh2 = 127;
        System.out.println("13️⃣ Short 127 == 127 → " + (sh1 == sh2)); // true (cached)

        Byte by1 = 127, by2 = 127;
        System.out.println("14️⃣ Byte 127 == 127 → " + (by1 == by2)); // true (cached entire range)

        // 💡 Always use equals() to compare wrapper objects
        Long L3 = 128L, L4 = 128L;
        System.out.println("15️⃣ Long equals() → " + L3.equals(L4)); // true
        System.out.println("16️⃣ Long == → " + (L3 == L4));          // false

        // =====================================================
        // 🧩 6️⃣ Parsing & Conversion Tricks
        // =====================================================
        System.out.println("17️⃣ Integer.parseInt(\"101\", 2): " + Integer.parseInt("101", 2)); // -> 5
        System.out.println("18️⃣ Long.decode(\"0xA\"): " + Long.decode("0xA"));                 // -> 10
        System.out.println("19️⃣ Short.decode(\"010\"): " + Short.decode("010"));               // -> 8 (octal)
        System.out.println("20️⃣ Byte.decode(\"#7F\"): " + Byte.decode("#7F"));                 // -> 127

        System.out.println("21️⃣ Byte.toUnsignedInt((byte)-1): " + Byte.toUnsignedInt((byte)-1)); // -> 255
        System.out.println("22️⃣ Long.toBinaryString(15L): " + Long.toBinaryString(15L));         // -> 1111

        // =====================================================
        // 🧩 7️⃣ Bitwise Helpers
        // =====================================================
        System.out.println("23️⃣ Long.numberOfTrailingZeros(8L): " + Long.numberOfTrailingZeros(8L)); // -> 3
        System.out.println("24️⃣ Long.numberOfLeadingZeros(8L): " + Long.numberOfLeadingZeros(8L));   // -> 60
        System.out.println("25️⃣ Integer.bitCount(15): " + Integer.bitCount(15));                     // -> 4
        System.out.println("26️⃣ Short.reverseBytes((short)0x1234): " + Short.reverseBytes((short)0x1234)); // -> 13330

        // =====================================================
        // 🧩 8️⃣ Wrapper Comparisons & Edge Cases
        // =====================================================
        Integer I = 1000;
        Long L = 1000L;
        System.out.println("27️⃣ Integer.equals(Long): " + I.equals(L)); // false (type mismatch)
        System.out.println("28️⃣ Objects.equals(1000, 1000L): " + java.util.Objects.equals(1000, 1000L)); // false

        // =====================================================
        // 🧩 9️⃣ Unsigned Behavior Demo
        // =====================================================
        byte neg = (byte)0xF2; // 0xF2 = 242 unsigned
        System.out.println("29️⃣ Signed view: " + neg);               // -14
        System.out.println("30️⃣ Unsigned int view: " + (neg & 0xFF));// 242

        // =====================================================
        // 🧩 🔟 Real-World Overflow Logic
        // =====================================================
        byte bA = (byte)250;
        byte bB = 10;
        System.out.println("31️⃣ (bA + bB): " + (bA + bB));           // -> 260 (int)
        System.out.println("32️⃣ (byte)(bA + bB): " + (byte)(bA + bB)); // -> 4 (wraps mod 256)

        // =====================================================
        // 🧩 1️⃣1️⃣ Long Literal Caution
        // =====================================================
        // long lErr = 9999999999; ❌ Compile error (int literal too large)
        long lOk = 9999999999L;  // ✅
        System.out.println("33️⃣ Long literal ok: " + lOk);

        // =====================================================
        // 🧩 1️⃣2️⃣ Mixed Wrapper Types
        // =====================================================
        Integer iObj = 5;
        Double dObj = 5.0;
        System.out.println("34️⃣ Integer.equals(Double): " + iObj.equals(dObj)); // false

        // =====================================================
        // 🧩 1️⃣3️⃣ Summary Table (Quick Recap)
        // =====================================================
        System.out.println("\n----------------------------------------------");
        System.out.println("✅ Quick Recap Table:");
        System.out.println("Overflow (byte)    → (byte)130 = -126");
        System.out.println("Widening           → byte → int (auto)");
        System.out.println("Narrowing          → int → byte (cast)");
        System.out.println("Cache Range        → -128..127");
        System.out.println("Unsigned Trick     → b & 0xFF");
        System.out.println("Parse/Decode       → String → Number");
        System.out.println("Bit Helpers        → bitCount(), reverseBytes()");
        System.out.println("Always use equals() for wrapper comparison.");
        System.out.println("----------------------------------------------");

        System.out.println("\n🎯 Done — Full integer family mastered!");
    }
}
