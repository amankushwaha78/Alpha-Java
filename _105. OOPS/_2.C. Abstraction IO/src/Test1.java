// File: Test1.java
// Abstract class constructor order
abstract class A1 {
    A1() { System.out.println("A constructor"); }
    abstract void show();
}

class B1 extends A1 {
    B1() { System.out.println("B constructor"); }
    @Override void show() { System.out.println("show() in B"); }
}

public class Test1 {
    public static void main(String[] args) {
        A1 obj = new B1();
        obj.show();
    }
}

/*
Output:
A constructor
B constructor
show() in B

Explanation:
- When creating B1(), Java first calls the superclass constructor (A1), then B1’s.
- obj.show() calls B1's overridden implementation due to runtime polymorphism.
*/
