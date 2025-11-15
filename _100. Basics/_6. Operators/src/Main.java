// File: Operators_All_In_One.java
// 🎯 Topic: Every Java Operator in ONE main() with examples + concept comments
// 🧠 Use this as a revision sheet + runnable file for interviews.

public class Main {
    public static void main(String[] args) {

        // ============================================================
        // 1️⃣ ARITHMETIC OPERATORS: +, -, *, /, %
        // ============================================================
        System.out.println("\n-----------------------------");
        System.out.println("1️⃣ ARITHMETIC OPERATORS");
        System.out.println("-----------------------------");

        int a = 10;      // a = 10  → example value for arithmetic
        int b = 3;       // b = 3   → example value for arithmetic

        // ➕ Addition: adds two numbers
        System.out.println("a + b = " + (a + b)); // 10 + 3 = 13

        // ➖ Subtraction: subtracts second from first
        System.out.println("a - b = " + (a - b)); // 10 - 3 = 7

        // ✖ Multiplication: multiplies two numbers
        System.out.println("a * b = " + (a * b)); // 10 * 3 = 30

        // ➗ Division: integer division (fraction part discarded)
        System.out.println("a / b = " + (a / b)); // 10 / 3 = 3 (0.333 part is dropped)

        // 〽 Modulus: gives remainder of division
        System.out.println("a % b = " + (a % b)); // 10 % 3 = 1 (remainder)

        // ============================================================
        // 2️⃣ UNARY OPERATORS: +, -, ++, --, !, ~
        // ============================================================
        System.out.println("\n-----------------------------");
        System.out.println("2️⃣ UNARY OPERATORS (+, -, ++, --, !, ~)");
        System.out.println("-----------------------------");

        int x = 5; // x = 5 → to demonstrate ++ and --
        System.out.println("Initial x = " + x); // prints 5

        // ++x → pre-increment: increment first, then use the new value
        // Dry run: x=5 → ++x makes x=6 → print 6
        System.out.println("++x = " + (++x)); // 6

        // x++ → post-increment: use current value, then increment
        // Dry run: x=6 at this line → prints 6 → then x becomes 7
        System.out.println("x++ = " + (x++)); // prints 6, x now = 7

        // --x → pre-decrement: decrement first, then use value
        // Dry run: x=7 → --x makes x=6 → print 6
        System.out.println("--x = " + (--x)); // 6

        // x-- → post-decrement: use current value, then decrement
        // Dry run: x=6 → prints 6 → x becomes 5
        System.out.println("x-- = " + (x--)); // prints 6, x now = 5

        int y = 5; // y = 5 for bitwise NOT demo

        // ~y → bitwise NOT: flips all bits (in 2's complement)
        // For 5 (000...0101) it becomes ...1010 which is -6 in decimal
        System.out.println("~y = " + (~y)); // -6

        boolean flag = true; // flag = true for logical NOT demo

        // !flag → logical NOT: true → false, false → true
        System.out.println("!flag = " + (!flag)); // false

        // ============================================================
        // 3️⃣ ASSIGNMENT OPERATORS: =, +=, -=, *=, /=, %=
        // ============================================================
        System.out.println("\n-----------------------------");
        System.out.println("3️⃣ ASSIGNMENT OPERATORS (+=, -=, etc)");
        System.out.println("-----------------------------");

        int k = 10; // k starts with 10

        // k += 5 → k = k + 5
        // Dry run: k=10 → k=15
        k += 5;

        // k -= 3 → k = k - 3
        // Dry run: k=15 → k=12
        k -= 3;

        // k *= 2 → k = k * 2
        // Dry run: k=12 → k=24
        k *= 2;

        // k /= 4 → k = k / 4 (integer division)
        // Dry run: k=24 → k=6
        k /= 4;

        // k %= 5 → k = k % 5 (remainder)
        // Dry run: k=6 → 6 % 5 = 1 → k=1
        k %= 5;

        System.out.println("Final k = " + k); // prints 1

        // 💡 Assignment operators modify the variable in-place
        // and return the updated value (can be used in expressions too).

        // ============================================================
        // 4️⃣ RELATIONAL (COMPARISON) OPERATORS
        //    >, <, >=, <=, ==, !=
        // ============================================================
        System.out.println("\n-----------------------------");
        System.out.println("4️⃣ RELATIONAL OPERATORS");
        System.out.println("-----------------------------");

        int r1 = 10; // r1 = 10
        int r2 = 20; // r2 = 20

        // == checks if values are equal
        System.out.println("r1 == r2 → " + (r1 == r2)); // false

        // != checks if values are not equal
        System.out.println("r1 != r2 → " + (r1 != r2)); // true

        // > checks if left is greater than right
        System.out.println("r1 > r2 → " + (r1 > r2)); // false

        // < checks if left is less than right
        System.out.println("r1 < r2 → " + (r1 < r2)); // true

        // >= checks if left is greater than or equal to right
        System.out.println("r1 >= 10 → " + (r1 >= 10)); // true

        // <= checks if left is less than or equal to right
        System.out.println("r2 <= 10 → " + (r2 <= 10)); // false

        // Result of relational ops is always boolean: true / false

        // ============================================================
        // 5️⃣ LOGICAL OPERATORS: &&, ||, !
        //    (Short-circuit operators for boolean expressions)
        // ============================================================
        System.out.println("\n-----------------------------");
        System.out.println("5️⃣ LOGICAL OPERATORS (&&, ||, !)");
        System.out.println("-----------------------------");

        int m = 5;  // m = 5
        int n = 10; // n = 10

        // && → logical AND: true only if both sides are true
        // m > 2 → true, n > 5 → true → result true
        System.out.println("m > 2 && n > 5 → " + (m > 2 && n > 5)); // true

        // || → logical OR: true if at least one side is true
        // m > 10 → false, n > 5 → true → result true
        System.out.println("m > 10 || n > 5 → " + (m > 10 || n > 5)); // true

        // ! → logical NOT: inverts boolean
        // m > n → 5 > 10 → false → !false = true
        System.out.println("!(m > n) → " + (!(m > n))); // true

        // 💡 Short-circuit:
        // - For && if left is false, right is NOT evaluated.
        // - For || if left is true, right is NOT evaluated.

        // ============================================================
        // 6️⃣ BITWISE OPERATORS: &, |, ^, ~
        //    Work on bits of integer types
        // ============================================================
        System.out.println("\n-----------------------------");
        System.out.println("6️⃣ BITWISE OPERATORS (&, |, ^, ~)");
        System.out.println("-----------------------------");

        int bitA = 5; // 5 in binary:  0101
        int bitB = 3; // 3 in binary:  0011

        // & → bitwise AND: 1 only if both bits are 1
        // 0101
        // 0011
        // ----
        // 0001 → 1
        System.out.println("5 & 3 = " + (bitA & bitB)); // 1

        // | → bitwise OR: 1 if any bit is 1
        // 0101
        // 0011
        // ----
        // 0111 → 7
        System.out.println("5 | 3 = " + (bitA | bitB)); // 7

        // ^ → bitwise XOR: 1 if bits are different
        // 0101
        // 0011
        // ----
        // 0110 → 6
        System.out.println("5 ^ 3 = " + (bitA ^ bitB)); // 6

        // ~ → bitwise NOT: flips all bits (2's complement)
        // For 5 → result is -6 (same as earlier ~y demo)
        System.out.println("~5 = " + (~bitA)); // -6

        // ============================================================
        // 7️⃣ SHIFT OPERATORS: <<, >>, >>>
        // ============================================================
        System.out.println("\n-----------------------------");
        System.out.println("7️⃣ SHIFT OPERATORS (<<, >>, >>>)");
        System.out.println("-----------------------------");

        int s = 8; // s = 8 → binary: 0000...1000

        // << n → shift left by n bits = multiply by 2^n
        // 8 << 1 → 8 * 2 = 16
        System.out.println("8 << 1 = " + (s << 1)); // 16

        // >> n → arithmetic right shift: divide by 2^n (keeps sign)
        // 8 >> 1 → 8 / 2 = 4
        System.out.println("8 >> 1 = " + (s >> 1)); // 4

        // >>> n → logical right shift: fills left bits with 0 (for int)
        // For positive numbers, >> and >>> same effect
        System.out.println("8 >>> 1 = " + (s >>> 1)); // 4

        int neg = -8; // negative number demo

        // >> keeps sign bit (1 for negative), so remains negative
        System.out.println("-8 >> 1 = " + (neg >> 1)); // -4

        // >>> ignores sign bit and fills with 0 → large positive number
        // Because highest bit becomes 0, and bits shift to the right
        System.out.println("-8 >>> 1 = " + (neg >>> 1)); // large positive

        // ============================================================
        // 8️⃣ TERNARY OPERATOR: condition ? valueIfTrue : valueIfFalse
        // ============================================================
        System.out.println("\n-----------------------------");
        System.out.println("8️⃣ TERNARY OPERATOR (?:)");
        System.out.println("-----------------------------");

        int age = 20; // age = 20

        // If condition (age >= 18) is true → result = "Adult"
        // else result = "Minor"
        String result = (age >= 18) ? "Adult" : "Minor";
        System.out.println("Result of ternary: " + result); // Adult

        // Ternary is shorthand for:
        // if (age >= 18) result = "Adult"; else result = "Minor";

        // ============================================================
        // 9️⃣ instanceof OPERATOR
        //    Checks: "is this object an instance of this type?"
        // ============================================================
        System.out.println("\n-----------------------------");
        System.out.println("9️⃣ instanceof OPERATOR");
        System.out.println("-----------------------------");

        String str = "Hello"; // str is a String object

        // true because str is created as new String literal
        System.out.println("str instanceof String → " + (str instanceof String)); // true

        Object obj = str; // upcasting String → Object

        // Every String is also an Object → true
        System.out.println("obj instanceof Object → " + (obj instanceof Object)); // true

        // obj actually refers to a String, not an Integer
        System.out.println("obj instanceof Integer → " + (obj instanceof Integer)); // false

        // instanceof is commonly used in inheritance + polymorphism for safe downcasting.

        // ============================================================
        // 🔟 TRICKY INTERVIEW EXPRESSIONS (ORDER + ++/--)
        // ============================================================
        System.out.println("\n-----------------------------");
        System.out.println("🔟 TRICKY INTERVIEW QUESTIONS");
        System.out.println("-----------------------------");

        // 👉 Expression evaluation is left-to-right for + operator.

        // First: 10 + 20 = 30 (both are int)
        // Then: 30 + "Java" → int + String → "30Java"
        System.out.println("10 + 20 + \"Java\" → " + (10 + 20 + "Java")); // "30Java"

        // Here first operand is "Java" (String)
        // "Java" + 10 → "Java10" (string concatenation)
        // "Java10" + 20 → "Java1020"
        System.out.println("\"Java\" + 10 + 20 → " + ("Java" + 10 + 20)); // "Java1020"

        int z = 10; // z = 10 for ++ demo

        // z++ + ++z
        // Step 1: z++ → returns 10, z becomes 11
        // Step 2: ++z → z becomes 12, returns 12
        // Step 3: 10 + 12 = 22
        System.out.println("z++ + ++z = " + (z++ + ++z)); // prints 22, z now = 12

        // Now z = 12
        // z++ + z++
        // Step 1: first z++ → returns 12, z becomes 13
        // Step 2: second z++ → returns 13, z becomes 14
        // Step 3: 12 + 13 = 25
        System.out.println("z++ + z++ = " + (z++ + z++)); // prints 25, z now = 14

        // 💡 Interview Tip:
        // Never write such code in production.
        // But in interviews, explain:
        //  - + is left to right
        //  - pre/post increment modifies variable at different times.

        // ============================================================
        // ✅ END
        // ============================================================
        System.out.println("\n🎉 All Operators Covered with Concepts & Comments!");
    }
}
