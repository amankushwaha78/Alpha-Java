// File: _1_Tricky1.java
// 🎯 Java Operators – Tricky Questions with Evaluation Direction + Dry Runs

public class _1_Tricky1 {
    public static void main(String[] args) {

        /*
           ✅ 1️⃣ Why does "10" + 20 give "1020"
                but 10 + 20 + "Java" gives "30Java"?

           👉 Evaluation direction: LEFT → RIGHT

           ✔ Concept:
             - Java evaluates + from left to right.
             - If the FIRST evaluated operand is a String,
               the rest becomes string concatenation.

           ✔ Dry Run:
             10 + 20 + "Java"
               → (10 + 20) + "Java"
               → 30 + "Java"
               → "30Java"

             "Java" + 10 + 20
               → ("Java" + 10) + 20
               → "Java10" + 20
               → "Java1020"
        */
        System.out.println(10 + 20 + "Java");   // 30Java
        System.out.println("Java" + 10 + 20);   // Java1020



        /*
           ✅ 2️⃣ What is the output of: x++ + ++x ?

           👉 Evaluation direction: LEFT → RIGHT

           ✔ Concept:
             - Java first evaluates the LEFT operand (x++),
               then the RIGHT operand (++x), then adds.
             - Post-increment: use → then increment.
             - Pre-increment: increment → then use.

           ✔ Dry Run:
             Initial: x = 5

             Step 1 (left):   x++   → uses 5, x becomes 6
             Step 2 (right):  ++x   → x becomes 7, uses 7

             Result = 5 + 7 = 12
        */
        int x = 5;
        System.out.println(x++ + ++x);  // 12



        /*
           ✅ 3️⃣ What is the output of: x++ + x++ ?

           👉 Evaluation direction: LEFT → RIGHT

           ✔ Concept:
             - Both operands are x++.
             - First x++ (left), then second x++ (right).

           ✔ Dry Run:
             Initial: x = 5

             Step 1 (left):   x++   → uses 5, x becomes 6
             Step 2 (right):  x++   → uses 6, x becomes 7

             Result = 5 + 6 = 11
        */
        x = 5;
        System.out.println(x++ + x++);  // 11



        /*
           ✅ 4️⃣ Evaluate: a++ + a++ + ++a

           👉 Evaluation direction: LEFT → MIDDLE → RIGHT (strict LEFT → RIGHT)

           ✔ Concept:
             - Java evaluates each operand from left to right:
                 1) left a++
                 2) middle a++
                 3) right ++a

           ✔ Dry Run:
             Initial: a = 5

             Step 1 (left):   a++   → uses 5, a becomes 6
             Step 2 (mid):    a++   → uses 6, a becomes 7
             Step 3 (right):  ++a   → a becomes 8, uses 8

             Result = 5 + 6 + 8 = 19
        */
        int a = 5;
        System.out.println(a++ + a++ + ++a); // 19



        /*
           ✅ 5️⃣ Evaluate: (++p * 2) + (p-- / 2)

           👉 Evaluation direction: LEFT operand → RIGHT operand

           ✔ Concept:
             - For the +, Java first fully evaluates "(++p * 2)",
               then fully evaluates "(p-- / 2)", then adds.

           ✔ Dry Run:
             Initial: p = 10

             Left side: (++p * 2)
               ++p → p becomes 11, uses 11
               11 * 2 = 22

             Now p = 11

             Right side: (p-- / 2)
               p-- → uses 11, p becomes 10
               11 / 2 = 5   (integer division)

             Final:
               22 + 5 = 27
        */
        int p = 10;
        System.out.println((++p * 2) + (p-- / 2)); // 27



        /*
           ✅ 6️⃣ Why does (byte)130 give -126 ?

           👉 Evaluation direction: single cast, no left-right issue
              (but concept is overflow & 2's complement)

           ✔ Concept:
             - byte range: -128 to 127
             - 130 is outside this range → wraps around (overflow).

           ✔ Math reasoning:
             130 - 256 = -126

           So (byte)130 → -126
        */
        byte bb = (byte) 130;
        System.out.println(bb); // -126



        /*
           ✅ 7️⃣ Why doesn't this throw exception?
               true || (10 / 0 == 0)

           👉 Evaluation direction: LEFT → RIGHT,
              but with SHORT-CIRCUIT on ||

           ✔ Concept:
             - For (A || B), if A is true, B is NOT evaluated.
             - Here A = true, so (10 / 0 == 0) never runs.

           ✔ Therefore:
             No ArithmeticException, expression evaluates to true.
        */
        System.out.println(true || (10 / 0 == 0)); // true



        /*
           ✅ 8️⃣ Why doesn't this throw exception?
               false && (10 / 0 == 0)

           👉 Evaluation direction: LEFT → RIGHT,
              but with SHORT-CIRCUIT on &&

           ✔ Concept:
             - For (A && B), if A is false, B is NOT evaluated.
             - Here A = false, so (10 / 0 == 0) never runs.

           ✔ Therefore:
             No exception, result is simply false.
        */
        System.out.println(false && (10 / 0 == 0)); // false



        /*
           ✅ 9️⃣ Bitwise operations on 5 and 3

           👉 Evaluation direction: both operands evaluated left → right,
              then single bitwise operation.

           ✔ Binary:
             5 = 0101
             3 = 0011

             5 & 3 = 0001 = 1
             5 | 3 = 0111 = 7
             5 ^ 3 = 0110 = 6
             ~5    = bitwise NOT of 5 → -6 (2's complement)
        */
        System.out.println(5 & 3); // 1
        System.out.println(5 | 3); // 7
        System.out.println(5 ^ 3); // 6
        System.out.println(~5);    // -6



        /*
           ✅ 🔟 Shift operator trick: 1 << 3, -8 >> 1, -8 >>> 1

           👉 Evaluation direction: simple unary/binary ops (no tricky chaining)

           ✔ Concept:
             - a << n : multiply by 2ⁿ
             - a >> n : arithmetic right shift (keeps sign bit)
             - a >>> n: logical right shift (fills with 0)

           ✔ Results:
             1 << 3   → 8
             -8 >> 1  → -4
             -8 >>> 1 → very large positive (sign bit cleared)
        */
        System.out.println(1 << 3);    // 8
        System.out.println(-8 >> 1);   // -4
        System.out.println(-8 >>> 1);  // big positive number



        /*
           ✅ 1️⃣1️⃣ instanceof basics

           👉 Evaluation direction: single operand check (no left-right)

           ✔ Concept:
             - String is a subclass of Object.
             - So "Hi" is instanceof String AND Object.
        */
        String s = "Hi";
        System.out.println(s instanceof String);  // true
        System.out.println(s instanceof Object);  // true
//        System.out.println(s instanceof Integer); // false



        /*
           ✅ 1️⃣2️⃣ The DEADLIEST expression:
               t = t++ + ++t - --t + t--;

           👉 Evaluation direction: LEFT → RIGHT

           ✔ Concept:
             - Java evaluates each operand left to right:
                 1) t++
                 2) ++t
                 3) --t
                 4) t--
             - Then applies + and -.

           ✔ Dry Run:
             Initial: t = 1

             Step 1 (left):   t++  → uses 1,   t becomes 2
             Step 2:          ++t  → t becomes 3, uses 3
             Step 3:          --t  → t becomes 2, uses 2
             Step 4 (right):  t--  → uses 2,   t becomes 1

             Expression value:
               = 1 + 3 - 2 + 2
               = 4

             Final assignment:
               t = 4     (value of expression)
               (the internal t went back to 1 after last --,
                but then we overwrite it with 4)
        */
        int t = 1;
        t = t++ + ++t - --t + t--;
        System.out.println(t); // 4



        System.out.println("\n🎉 All tricky operator Q&A with LEFT→RIGHT direction explained!");
    }
}
