// File: Test9.java
// Functional interface + lambdas
@FunctionalInterface
interface Operation9 {
    int perform(int a, int b);
    // default/static methods allowed (do not break @FunctionalInterface)
    default void desc() { System.out.println("Performs a binary operation"); }
    static void info() { System.out.println("Functional Interface Example"); }
}

public class Test9 {
    public static void main(String[] args) {
        Operation9 add = (a, b) -> a + b;
        Operation9 mul = (a, b) -> a * b;

        Operation9.info();
        System.out.println(add.perform(3, 4));
        System.out.println(mul.perform(3, 4));
        add.desc();
    }
}

/*
Output:
Functional Interface Example
7
12
Performs a binary operation

Explanation:
- A functional interface has exactly one abstract method, ideal for lambdas.
- Lambdas provide inline implementations for that single abstract method.
- Default/static in interfaces are allowed and do not affect functional status.
*/
