// File: _5_StringWrapperMethods.java
// Topic: String Wrapper Methods (Clean Explanation + Example + Output)

public class _5_StringWrapperMethods {

    public static void main(String[] args) {

        // =====================================================
        // 1) valueOf(primitive or object)
        // =====================================================

        // ➤ (1) valueOf()
        // Meaning: Converts any primitive type (int, float, double, boolean, char) or object to String.
        // Syntax:
        //     String str = String.valueOf(data);
        //
        // Example:
        int num = 100;
        System.out.println(String.valueOf(num));
        // Output:
        // 100

        boolean flag = true;
        System.out.println(String.valueOf(flag));
        // Output:
        // true

        char ch = 'A';
        System.out.println(String.valueOf(ch));
        // Output:
        // A

        Object obj = 123;
        System.out.println(String.valueOf(obj));
        // Output:
        // 123



        // =====================================================
        // 2) toString() of Wrapper Classes
        // =====================================================

        // ➤ (2) toString()
        // Meaning: Converts wrapper objects (Integer, Double, Boolean, etc.) into String.
        // Syntax:
        //     String str = wrapperObject.toString();
        //
        // Example:
        Integer iObj = 50;
        System.out.println(iObj.toString());
        // Output:
        // 50

        Double dObj = 25.5;
        System.out.println(dObj.toString());
        // Output:
        // 25.5

        Boolean bObj = false;
        System.out.println(bObj.toString());
        // Output:
        // false



        // =====================================================
        // 3) parseX() Methods
        // =====================================================

        // ➤ (3) parseInt()
        // Meaning: Converts String to int primitive.
        // Syntax:
        //     int x = Integer.parseInt("123");
        //
        // Example:
        String strInt = "200";
        int x = Integer.parseInt(strInt);
        System.out.println(x + 50);
        // Output:
        // 250


        // ➤ (4) parseDouble()
        // Meaning: Converts String to double primitive.
        // Syntax:
        //     double y = Double.parseDouble("3.14");
        //
        // Example:
        String strDouble = "12.5";
        double y = Double.parseDouble(strDouble);
        System.out.println(y + 2.5);
        // Output:
        // 15.0


        // ➤ (5) parseBoolean()
        // Meaning: Converts String to boolean primitive.
        // Syntax:
        //     boolean z = Boolean.parseBoolean("true");
        //
        // Example:
        String strBool = "true";
        boolean z = Boolean.parseBoolean(strBool);
        System.out.println(z);
        // Output:
        // true



        // =====================================================
        // 4) valueOf() vs parseX()
        // =====================================================

        // ➤ (6) valueOf() vs parseX()
        // Meaning:
        // - valueOf() → converts primitive → String
        // - parseX() → converts String → primitive
        //
        // Example:
        int num2 = 75;
        String strNum = String.valueOf(num2);   // int → String
        System.out.println(strNum + 25);
        // Output:
        // 7525  (concatenation)

        String sNum = "50";
        int parsed = Integer.parseInt(sNum);    // String → int
        System.out.println(parsed + 25);
        // Output:
        // 75  (addition)



        // =====================================================
        // 5) Interview Notes / Important Points
        // =====================================================

        // 1️⃣ String.valueOf(null) returns "null", safe for objects
        // 2️⃣ parseX() throws NumberFormatException for invalid input
        // 3️⃣ Wrapper conversion is heavily used when reading Scanner input
        // 4️⃣ toString() is only for wrapper objects, not primitives

    }
}
