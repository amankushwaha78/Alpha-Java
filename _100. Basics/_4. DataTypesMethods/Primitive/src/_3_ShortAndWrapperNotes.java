// Topic: short (primitive) + Short (wrapper class) + inbuilt methods + comparison pitfalls
// 🧠 Short = 2 bytes (range: -32,768 to 32,767)

public class _3_ShortAndWrapperNotes {
    public static void main(String[] args) {

        // --------------------------------------
        // 🧩 1️⃣ short — Primitive Type
        // --------------------------------------
        short a = 100;      // simple 16-bit integer
        short b = 50;       // another short value
        System.out.println("Sum: " + (a + b));   // -> 150
        System.out.println("Diff: " + (a - b));  // -> 50
        System.out.println("Prod: " + (a * b));  // -> 5000
        System.out.println("Div: " + (a / b));   // -> 2
        // 💡 short is smaller than int, used to save memory.

        // --------------------------------------
        // 🧩 2️⃣ Short — Wrapper Class
        // --------------------------------------
        // 👉 Allows short to behave like an object.
        Short box = Short.valueOf(a);   // Boxing: short → Short
        short unbox = box.shortValue(); // Unboxing: Short → short
        System.out.println("Boxed: " + box);       // -> 100
        System.out.println("Unboxed: " + unbox);   // -> 100

        // Auto-boxing and auto-unboxing
        Short autoBox = 25;   // automatic conversion (primitive → object)
        short autoUnbox = autoBox; // automatic (object → primitive)
        System.out.println("AutoBox: " + autoBox);     // -> 25
        System.out.println("AutoUnbox: " + autoUnbox); // -> 25

        // --------------------------------------
        // 🧩 3️⃣ Inbuilt Methods (Short class)
        // --------------------------------------
        System.out.println(Short.parseShort("123"));     // -> 123  (String → short)
        System.out.println(Short.toString((short) 45));  // -> 45   (short → String)
        System.out.println(Short.compare((short) 10, (short) 20)); // -> -1 (10 < 20)
        System.out.println(Short.compare((short) 20, (short) 10)); // -> 1  (20 > 10)
        System.out.println(Short.compare((short) 5, (short) 5));   // -> 0  (equal)
        System.out.println(Short.reverseBytes((short) 0x1234));    // -> 13330 (byte-swapped)
        // 💡 reverseBytes() swaps high/low order bytes — useful in networking.

        // --------------------------------------
        // 🧩 4️⃣ Comparison Pitfall (Caching)
        // --------------------------------------
        // 👉 Short caches values from -128 to 127 (same as Integer)
        Short x = 100;
        Short y = 100;
        Short p = 200;
        Short q = 200;

        System.out.println(x == y);        // -> true   (cached)
        System.out.println(p == q);        // -> false  (not cached)
        System.out.println(x.equals(y));   // -> true   (value equal)
        System.out.println(p.equals(q));   // -> true   (value equal)
        // 💡 Always use equals() for comparing wrapper objects.

        // --------------------------------------
        // 🧠 Summary
        // short → primitive (2 bytes)
        // Short → object wrapper (has helper methods)
        // Auto-boxing/unboxing simplifies conversion
        // Use equals(), not == for wrapper comparison
        // Cache range: -128 to 127
    }
}
