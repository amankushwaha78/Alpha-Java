/*
 * File 5 — MarkerFunctionalInterfaceDemo.java
 *
 * 💡 GOAL:
 * Learn about two special types of interfaces:
 * 1️⃣ Marker Interface — no methods (used for tagging classes).
 * 2️⃣ Functional Interface — only ONE abstract method (used for Lambdas).
 */

// ✅ Step 1: Marker Interface (no methods)
interface SerializableMarker {
    // no methods → used just to "mark" certain classes
    // Example: java.io.Serializable (in-built marker interface)
}

// ✅ Step 2: Class implementing the marker interface
class Student implements SerializableMarker {
    String name;
    int age;
    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

// ✅ Step 3: Functional Interface (exactly ONE abstract method)
@FunctionalInterface  // ✅ annotation ensures only one abstract method exists
interface MathOperation {
    int operate(int a, int b);

    // allowed → default or static methods don’t count as abstract
    default void description() {
        System.out.println("Performs a math operation 🧮");
    }

    static void info() {
        System.out.println("Functional Interface Example ⚙️");
    }
}

// ✅ Step 4: Main class to test
public class _5_MarkerFunctionalInterfaceDemo {
    public static void main(String[] args) {
        System.out.println("=== Marker Interface Demo ===");

        Student s1 = new Student("Aman", 25);
        if (s1 instanceof SerializableMarker) {
            System.out.println("Student object is marked as Serializable ✅");
        } else {
            System.out.println("Student object is NOT serializable ❌");
        }

        System.out.println("\n=== Functional Interface Demo ===");

        // ✅ Using Lambda Expression (Java 8+)
        MathOperation addition = (a, b) -> a + b;
        MathOperation multiply = (a, b) -> a * b;

        System.out.println("Addition: " + addition.operate(10, 5));
        System.out.println("Multiplication: " + multiply.operate(10, 5));

        addition.description(); // default method
        MathOperation.info();   // static method
    }
}

/*
🧠 What You Learned
-------------------
✅ Marker Interface → an interface with NO methods (used for tagging classes, like Serializable, Cloneable).
✅ Functional Interface → has EXACTLY ONE abstract method (used with Lambda Expressions).
✅ `@FunctionalInterface` annotation ensures that you don’t accidentally add more abstract methods.
✅ Default and static methods in interfaces don’t break functional interface rules.
✅ Lambdas can be used wherever a Functional Interface is expected.
*/
