// File: Test7.java
// “Must implement abstract method” rule
interface A7 { void run(); }

// ❌ This would be fine (abstract class can skip implementing):
abstract class B7 implements A7 { }

// ❌ This concrete subclass would NOT compile if it didn't implement run():
// class C7 extends B7 { } // Uncommenting this line causes a compile error

// ✅ Correct concrete subclass that implements the missing method:
class C7Fixed extends B7 {
    @Override public void run() { System.out.println("run implemented"); }
}

public class Test7 {
    public static void main(String[] args) {
        new C7Fixed().run();
    }
}

/*
Output:
run implemented

Explanation:
- An abstract class (B7) may skip implementing interface methods.
- The first concrete subclass (C7) MUST implement them; otherwise compilation fails.
- C7Fixed shows the correct approach.
*/
