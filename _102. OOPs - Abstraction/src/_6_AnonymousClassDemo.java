/*
 * File 6 — AnonymousClassDemo.java
 *
 * 💡 GOAL:
 * Learn how to create an object of an abstract class
 * using an anonymous inner class.
 *
 * 🧠 Why use this?
 * - For small, one-time implementations (e.g., quick test, temporary behavior).
 * - Commonly used in GUI code, event listeners, etc.
 */

// ✅ Step 1: Define an abstract class
abstract class Shape {
    abstract double area();
    abstract double perimeter();
}

// ✅ Step 2: Use an anonymous class to create an instance inline
public class _6_AnonymousClassDemo {
    public static void main(String[] args) {
        System.out.println("=== Anonymous Class Example ===");

        // ❌ You cannot do this:
        // Shape s = new Shape(); // ERROR: cannot instantiate abstract class

        // ✅ But you CAN do this:
        Shape rightTriangle = new Shape() {
            // define base and height (local variables inside anonymous class)
            double base = 3;
            double height = 4;

            // Implement abstract methods right here
            @Override
            double area() {
                return 0.5 * base * height;
            }

            @Override
            double perimeter() {
                double hyp = Math.hypot(base, height);
                return base + height + hyp;
            }
        };

        // ✅ Now we can use it like a normal object
        System.out.println("Area: " + rightTriangle.area());
        System.out.println("Perimeter: " + rightTriangle.perimeter());
    }
}

/*
💬 Example in Real Life

Think of this like writing a custom recipe on the spot, without giving it a name.
You use it once — and it works immediately 🔥
 */