// File: Test5.java
// Polymorphism with interface + abstract class
interface I5 { void show(); }

abstract class A5 implements I5 {
    @Override public void show() { System.out.println("A"); }
}

class B5 extends A5 {
    @Override public void show() { System.out.println("B"); }
}

public class Test5 {
    public static void main(String[] args) {
        I5 obj = new B5(); // reference type = interface, object type = B5
        obj.show();
    }
}

/*
Output:
B

Explanation:
- Even with an interface reference, the overridden method on the actual object (B5)
  is chosen at runtime (dynamic dispatch).
*/
