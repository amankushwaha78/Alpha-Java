// File: _6_StringInterviewQA.java                               // file name comment
// Topic: Interview-based Output Q&A for Strings                 // topic comment
// 🧠 Focus: SCP, == vs equals, concat traps, intern, regex split // scope comment

public class _Q1_QA {                              // class declaration
    public static void main(String[] args) {                     // main method start

        // ===================================================== // section line
        // ✅ Q1️⃣  == vs equals() (SCP vs Heap)                  // question title
        // ===================================================== // section line
        String q1a = "Java";                                     // literal in SCP
        String q1b = "Java";                                     // same literal reused
        String q1c = new String("Java");                         // new heap object
        System.out.println(q1a == q1b);                          // true
        System.out.println(q1a == q1c);                          // false
        System.out.println(q1a.equals(q1c));                     // true

        // ===================================================== // section line
        // ✅ Q2️⃣  Compile-time vs Runtime concat               // question title
        // ===================================================== // section line
        String q2a = "Ja" + "va";                                // compile-time → SCP
        String q2part = "Ja";                                    // literal SCP ref
        String q2b = q2part + "va";                              // runtime → heap
        String q2c = "Java";                                     // literal SCP ref
        System.out.println(q2a == q2c);                          // true
        System.out.println(q2b == q2c);                          // false
        System.out.println(q2b.equals(q2c));                     // true

        // ===================================================== // section line
        // ✅ Q3️⃣  final variable concat optimization           // question title
        // ===================================================== // section line
        final String q3x = "Ja";                                 // final compile-time constant
        String q3y = q3x + "va";                                 // compile-time concat → SCP
        String q3z = "Java";                                     // literal SCP
        System.out.println(q3y == q3z);                          // true

        // ===================================================== // section line
        // ✅ Q4️⃣  intern() effect                              // question title
        // ===================================================== // section line
        String q4h = new String("HI");                           // heap object
        String q4i = q4h.intern();                               // SCP reference
        String q4j = "HI";                                       // SCP literal
        System.out.println(q4h == q4j);                          // false
        System.out.println(q4i == q4j);                          // true

        // ===================================================== // section line
        // ✅ Q5️⃣  + operator LEFT → RIGHT trap                 // question title
        // ===================================================== // section line
        System.out.println(10 + 20 + "Java");                    // 30Java
        System.out.println("Java" + 10 + 20);                    // Java1020

        // ===================================================== // section line
        // ✅ Q6️⃣  substring() end exclusive + edge             // question title
        // ===================================================== // section line
        String q6 = "ABCDE";                                     // sample string
        System.out.println(q6.substring(2, 5));                  // CDE
        System.out.println(q6.substring(0, 0));                  // "" (empty)

        // ===================================================== // section line
        // ✅ Q7️⃣  split() is REGEX trap                        // question title
        // ===================================================== // section line
        String q7 = "1.2.3";                                     // dotted string
        System.out.println(q7.split(".").length);                // 0  ('.' means any char)
        System.out.println(q7.split("\\.").length);              // 3  (correct)

        // ===================================================== // section line
        // ✅ Q8️⃣  replace vs replaceAll                         // question title
        // ===================================================== // section line
        String q8 = "A1B2C3";                                    // mixed string
        System.out.println(q8.replace("1", "_"));                // A_B2C3
        System.out.println(q8.replaceAll("\\d", "_"));           // A_B_C_

        // ===================================================== // section line
        // ✅ Q9️⃣  trim() vs strip() (Unicode)                  // question title
        // ===================================================== // section line
        String q9 = "\u2003  Aman  \u2003";                      // unicode spaces + text
        System.out.println(q9.trim());                           // may keep unicode spaces
        System.out.println(q9.strip());                          // Aman

        // ===================================================== // section line
        // ✅ Q🔟  isEmpty() vs isBlank()                        // question title
        // ===================================================== // section line
        System.out.println("".isEmpty());                        // true
        System.out.println("   ".isEmpty());                     // false
        System.out.println("   ".isBlank());                     // true

        // ===================================================== // section line
        // ✅ Q1️⃣1️⃣ compareTo() outputs                        // question title
        // ===================================================== // section line
        System.out.println("abc".compareTo("abc"));              // 0
        System.out.println("abc".compareTo("abd"));              // -1
        System.out.println("abd".compareTo("abc"));              // 1

        // ===================================================== // section line
        // ✅ Q1️⃣2️⃣ equalsIgnoreCase()                         // question title
        // ===================================================== // section line
        System.out.println("Java".equalsIgnoreCase("java"));     // true
        System.out.println("Java".equals("java"));               // false

        // ===================================================== // section line
        // ✅ Q1️⃣3️⃣ contentEquals() with builder              // question title
        // ===================================================== // section line
        String q13s = "Hello";                                   // normal string
        StringBuilder q13b = new StringBuilder("Hello");         // builder same text
        System.out.println(q13s.equals(q13b));                   // false (type mismatch)
        System.out.println(q13s.contentEquals(q13b));            // true

        // ===================================================== // section line
        // ✅ Q1️⃣4️⃣ UTF-16 emoji length trap                  // question title
        // ===================================================== // section line
        String q14 = "😄";                                       // emoji (surrogate pair)
        System.out.println(q14.length());                        // 2

        // ===================================================== // section line
        // ✅ Q1️⃣5️⃣ Null concatenation trap                   // question title
        // ===================================================== // section line
        String q15 = null;                                       // null reference
        System.out.println(q15 + "X");                           // nullX

        // ===================================================== // section line
        // ✅ Q1️⃣6️⃣ Loop concat performance note              // question title
        // ===================================================== // section line
        String q16 = "";                                         // empty string
        for (int k = 0; k < 3; k++) {                            // small loop
            q16 += k;                                            // creates new object each time
        }
        System.out.println(q16);                                 // 012

        // ===================================================== // section line
        // ✅ Q1️⃣7️⃣ repeat(), join(), format()                // question title
        // ===================================================== // section line
        System.out.println("ha".repeat(3));                      // hahaha
        System.out.println(String.join("-", "A", "B", "C"));     // A-B-C
        System.out.println(String.format("Name=%s Age=%d",       // formatting call
                "Aman", 24));                                    // args for format → Name=Aman Age=24

    }                                                           // main method end
}                                                               // class end
