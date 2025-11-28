// File: Test3.java
// Default method conflict resolution
interface I3A { default void show() { System.out.println("A"); } }
interface I3B { default void show() { System.out.println("B"); } }

class C3 implements I3A, I3B {
    @Override public void show() {
        I3A.super.show();
        I3B.super.show();
        System.out.println("C");
    }
}

public class Test3 {
    public static void main(String[] args) {
        new C3().show();
    }
}

/*
Output:
A
B
C

Explanation:
- Two interfaces provide the same default method. The class must override it
  and may delegate explicitly via I3A.super.show() / I3B.super.show().
*/
