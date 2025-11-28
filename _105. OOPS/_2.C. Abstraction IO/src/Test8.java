// File: Test8.java
// Interface constants and ambiguity
interface A8 { int X = 10; } // public static final by default
interface B8 { int X = 20; }

class C8 implements A8, B8 {
    public void print() {
        System.out.println(A8.X + " " + B8.X);
        // System.out.println(X); // ambiguous if used without qualification
    }
}

public class Test8 {
    public static void main(String[] args) {
        new C8().print();
    }
}

/*
Output:
10 20

Explanation:
- Interface fields are constants (public static final).
- When two interfaces provide the same name, qualify with InterfaceName.FIELD
  to avoid ambiguity.
*/
