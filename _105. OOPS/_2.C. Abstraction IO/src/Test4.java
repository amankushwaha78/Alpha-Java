// File: Test4.java
// Interface static vs default methods
interface I4 {
    static void info() { System.out.println("Static Info"); } // call via I4.info()
    default void display() { System.out.println("Default Display"); } // on instance
}

public class Test4 implements I4 {
    public static void main(String[] args) {
        I4.info();               // static method on interface
        new Test4().display();   // default method on instance
    }
}

/*
Output:
Static Info
Default Display

Explanation:
- Static methods in interfaces belong to the interface itself.
- Default methods are instance methods with a body and can be called/overridden.
*/
