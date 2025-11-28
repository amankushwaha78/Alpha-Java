// File: Test6.java
// Illegal abstract modifiers (compile-time rule shown safely)
abstract class X6 {
    // ❌ This would NOT compile if uncommented:
    // private abstract void test(); // Illegal: abstract methods cannot be private
    // static abstract void foo();   // Illegal: abstract cannot be static
    // final abstract void bar();    // Illegal: abstract cannot be final

    // ✅ Valid abstract method (must be non-private, non-static, non-final)
    protected abstract void ok();
}

class Y6 extends X6 {
    @Override protected void ok() { System.out.println("ok implemented"); }
}

public class Test6 {
    public static void main(String[] args) {
        new Y6().ok();
    }
}

/*
Output:
ok implemented

Explanation:
- Abstract methods cannot be private (must be overridable).
- Abstract methods cannot be static/final.
- This file compiles because illegal lines are commented; ok() is valid.
*/
