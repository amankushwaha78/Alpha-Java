// Demonstrates Type Casting in Java (Implicit vs Explicit)

/*
🧩 1️⃣ What is Type Casting?
---------------------------------------------------
➡️ Type casting means converting one data type into another.

Java supports two main kinds:
1️⃣ **Implicit Casting (Widening)** — automatic conversion by Java.
2️⃣ **Explicit Casting (Narrowing)** — manual conversion by programmer.

---------------------------------------------------
💡 WHY we need it:
Because sometimes we want to convert smaller data types to bigger ones
or vice versa to fit the data or reduce memory usage.
*/

/*
⚙️ 2️⃣ Implicit (Widening) Type Casting
---------------------------------------------------
👉 Happens automatically when converting from smaller → larger type.
✅ Safe, no data loss.

Order of widening (smallest → largest):
byte → short → int → long → float → double
*/

public class _1_TypeCastingDemo {
    public static void main(String[] args) {

        // 🔹 Implicit / Widening Casting Example
        int num = 10;           // 4 bytes
        double widened = num;   // int automatically converted to double (8 bytes)

        System.out.println("Original int value: " + num);      // Output → 10
        System.out.println("After widening to double: " + widened); // Output → 10.0


        /*
        ⚠️ WHY this works:
        Because a double can safely store any int value without overflow.
        Java automatically promotes smaller types to larger ones (auto widening).
        */


        /*
        ⚙️ 3️⃣ Explicit (Narrowing) Type Casting
        ---------------------------------------------------
        👉 Happens manually when converting larger → smaller type.
        ❌ Can cause data loss or overflow.
        */

        double pi = 3.14159;
        int castedPi = (int) pi;    // manually converting double to int
        System.out.println("Original double value: " + pi);    // Output → 3.14159
        System.out.println("After narrowing to int: " + castedPi); // Output → 3 (decimal lost)


        // ⚠️ Example of Overflow during narrowing
        int big = 130;
        byte small = (byte) big;    // byte range -128 to 127 → overflow
        System.out.println("Original int: " + big);            // Output → 130
        System.out.println("After casting to byte: " + small); // Output → -126 (overflow)


        /*
        🧮 Explanation:
        130 → binary 10000010 (in 8 bits)
        Byte range = -128 to 127, so it wraps around to negative value (-126).
        */


        /*
        🎯 4️⃣ Summary Table
        ---------------------------------------------------
        | Casting Type | Direction           | Example                | Performed By | Data Loss |
        |---------------|--------------------|------------------------|---------------|------------|
        | Implicit      | Small → Large       | int → double           | Java Auto     | No         |
        | Explicit      | Large → Small       | double → int           | Programmer    | Possible   |
        */

        /*
        🧠 5️⃣ Key Points
        ---------------------------------------------------
        ✅ Implicit (Widening):
            byte → short → int → long → float → double
        ✅ Explicit (Narrowing):
            double → float → long → int → short → byte
        ⚠️ Possible overflow or truncation in narrowing.
        */
    }
}

/*
💬 INTERVIEW TIP:
-----------------
🗣️ “Type casting is converting data from one type to another.
Implicit casting happens automatically (safe widening),
while explicit casting requires manual conversion (possible data loss).”
*/
