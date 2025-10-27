/*
 * File 1 — MethodOverloadingDemo.java
 *
 * 💡 GOAL:
 * Demonstrate compile-time polymorphism — multiple methods with the same name
 * but different parameter lists (type, number, or order).
 */

class Calculator {
    // same method name, different parameter types
    int add(int a, int b) {
        System.out.println("Adding two ints");
        return a + b;
    }

    double add(double a, double b) {
        System.out.println("Adding two doubles");
        return a + b;
    }

    int add(int a, int b, int c) {
        System.out.println("Adding three ints");
        return a + b + c;
    }
}

public class MethodOverloadingDemo {
    public static void main(String[] args) {
        Calculator calc = new Calculator();

        System.out.println(calc.add(2, 3));         // int version
        System.out.println(calc.add(2.5, 3.5));     // double version
        System.out.println(calc.add(1, 2, 3));      // 3-int version
    }
}

/*
Output:
Adding two ints
5
Adding two doubles
6.0
Adding three ints
6

Explanation:
• Overloading is decided at COMPILE TIME based on argument types.
• The compiler picks which version to call by matching the parameter list.
• No overriding or runtime dispatch here — pure compile-time binding.
*/
