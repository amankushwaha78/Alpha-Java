/*
 * File 3 — ConstructorsFieldsDemo.java
 *
 * 💡 GOAL:
 * Learn how constructors, instance/static/final fields, and initializer blocks
 * behave in an abstract class.
 *
 * ⚙️ RULES:
 * ✅ Abstract classes CAN have constructors.
 * ✅ They’re called when a subclass object is created.
 * ✅ You can have static, instance, and final fields.
 * ✅ Static blocks run only once (when class loads).
 * ✅ Instance blocks run before the constructor (rarely used).
 */

import java.util.concurrent.atomic.AtomicInteger;

// ✅ Step 1: Abstract base class
abstract class ShapeBase {
    // Instance field
    protected double scale = 1.0;

    // Final field (must be initialized once)
    protected final String name;

    // Static field (shared among all objects)
    private static final AtomicInteger COUNT = new AtomicInteger(0);

    // Static initializer — runs once when class is first loaded
    static {
        System.out.println("[ShapeBase] Static block called 🧱 (Class loaded once)");
    }

    // Instance initializer — runs every time *before* constructor body
    {
        System.out.println("[ShapeBase] Instance block called ⚙️");
    }

    // Constructor — called every time a new object is created
    protected ShapeBase(String name) {
        this.name = name;
        COUNT.incrementAndGet();
        System.out.println("[ShapeBase] Constructor called 🏗️ for " + name);
    }

    // Static method to get total objects created
    public static int getCreatedCount() {
        return COUNT.get();
    }

    // Abstract method (must be implemented by child)
    public abstract double area();
}

// ✅ Step 2: Concrete subclass
class Circle extends ShapeBase {
    private final double radius;

    public Circle(double radius) {
        super("Circle"); // Calls abstract class constructor
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius * scale * scale;
    }
}

// ✅ Step 3: Main class to test
public class _3_ConstructorsFieldsDemo {
    public static void main(String[] args) {
        System.out.println("=== Creating Circle Objects ===");

        Circle c1 = new Circle(2);
        Circle c2 = new Circle(3);

        System.out.println("Area of c1: " + c1.area());
        System.out.println("Area of c2: " + c2.area());
        System.out.println("Total shapes created: " + ShapeBase.getCreatedCount());
    }
}


/*
🧠 What You Learned

1. Abstract classes can have constructors ✅
   → They’re used to initialize common fields for all subclasses.

2. Static fields & static blocks run only once when the class is loaded.

3. Instance initializers run every time before a constructor executes.

4. Final fields must be initialized once (in constructor or directly).

5. Abstract class constructors are called before subclass constructors.
*/

