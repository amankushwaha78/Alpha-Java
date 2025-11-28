// File: Test2.java
// Static methods are hidden, not overridden
abstract class A2 {
    abstract void run();
    static void info() { System.out.println("Static in A"); }
}

class B2 extends A2 {
    @Override void run() { System.out.println("Running in B"); }
    static void info() { System.out.println("Static in B"); } // hides A2.info()
}

public class Test2 {
    public static void main(String[] args) {
        A2 obj = new B2();
        obj.run();
        A2.info();
        B2.info();
    }
}

/*
Output:
Running in B
Static in A
Static in B

Explanation:
- obj.run() dispatches to B2 at runtime (override).
- Static methods are resolved by reference type/name, not object:
  A2.info() calls A2's version; B2.info() calls B2's version.
*/
