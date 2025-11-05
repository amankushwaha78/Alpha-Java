// 📘 DataTypesDemo.java
// A simple demo showing all primitive data types in Java
public class Primitive {

    public static void main(String[] args) {

        // 🔹 Integer types
        byte b = 10;               // byte → 1 byte (-128 to 127)
        short s = 2000;            // short → 2 bytes (-32,768 to 32,767)
        int i = 50000;             // int → 4 bytes (most used for integers)
        long l = 10000000000L;     // long → 8 bytes (note the 'L' suffix)

        // 🔹 Floating point types
        float f = 12.5f;           // float → 4 bytes (note 'f' suffix)
        double d = 99.99;          // double → 8 bytes (more precise decimals)

        // 🔹 Character & Boolean
        char c = 'A';              // char → 2 bytes, single character
        boolean flag = true;       // boolean → 1 bit, true/false

        // 🔹 Print all with outputs in comments
        System.out.println("byte: " + b);         // Output ➜ byte: 10
        System.out.println("short: " + s);        // Output ➜ short: 2000
        System.out.println("int: " + i);          // Output ➜ int: 50000
        System.out.println("long: " + l);         // Output ➜ long: 10000000000
        System.out.println("float: " + f);        // Output ➜ float: 12.5
        System.out.println("double: " + d);       // Output ➜ double: 99.99
        System.out.println("char: " + c);         // Output ➜ char: A
        System.out.println("boolean: " + flag);   // Output ➜ boolean: true
    }
}
/*
🧩 1️⃣ What Are Data Types?
        ---------------------------------------------------
        Data types tell Java what kind of value a variable can hold —
        whether it’s a number, text, true/false, or object.

        Java has two main kinds:

        1️⃣ Primitive Data Types → Built-in types (fast, stored in stack)
        2️⃣ Non-Primitive (Reference) Types → Objects, arrays, strings, etc.

        ⚙️ 2️⃣ Primitive Data Types (8 total)
        ---------------------------------------------------
        | Type     | Size     | Example                              | Range in 2^power form                         | Description |
        |-----------|----------|--------------------------------------|------------------------------------------------|--------------|

// 🔹 Integer types
        | byte      | 1 byte   | byte b = 100;                        | -2^7  to  (2^7)-1    →  -128 to 127            | Small integers |
        | short     | 2 bytes  | short s = 32000;                     | -2^15 to (2^15)-1    →  -32,768 to 32,767      | Medium integers |
        | int       | 4 bytes  | int age = 25;                        | -2^31 to (2^31)-1    →  -2,147,483,648 to 2,147,483,647 | Common integer |
        | long      | 8 bytes  | long pop = 7800000000L;              | -2^63 to (2^63)-1    →  -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807 | Large integer |

// 🔹 Floating point types
        | float     | 4 bytes  | float price = 12.5f;                 | ±(3.4 × 10^38) ≈ ±2^(±128)                     | Decimal, ~6–7 digits precision |
        | double    | 8 bytes  | double pi = 3.14159;                 | ±(1.7 × 10^308) ≈ ±2^(±1024)                   | High precision decimal (~15 digits) |

// 🔹 Character & Boolean
        | char      | 2 bytes  | char grade = 'A';                    | 0 to (2^16)-1 → 0 to 65,535 (Unicode)          | Single Unicode character |
        | boolean   | 1 bit    | boolean isActive = true;             | true or false                                 | Logical type |

*/
