/*
 * File 3 — ConstructorsFieldsDemo.java
 *
 * 💡 GOAL:
 * Understand how constructors, fields, and initializer blocks
 * behave inside an abstract class.
 *
 * ⚙️ RULES:
 * ✅ Abstract classes CAN have constructors
 * ✅ Parent constructor is ALWAYS called first
 * ✅ Static fields are shared across all objects
 * ✅ Static blocks run ONCE (class loading)
 * ✅ Instance blocks run BEFORE constructor
 */

abstract class ShapeBase {

    // Instance field (object-level state)
    protected double scale = 1.0;

    // Final field (must be initialized exactly once)
    protected final String name;

    // Static field (shared counter for all shapes)
    private static int count = 0;

    // Static initializer — runs once when class is loaded
    static {
        System.out.println("[ShapeBase] Static block executed 🧱");
    }

    // Instance initializer — runs before constructor for every object
    {
        System.out.println("[ShapeBase] Instance block executed ⚙️");
    }

    // Constructor — initializes final field and updates counter
    protected ShapeBase(String name) {
        this.name = name;
        count++;
        System.out.println("[ShapeBase] Constructor executed 🏗️ for " + name);
    }

    // Static method — returns total objects created
    public static int getCreatedCount() {
        return count;
    }

    // Abstract method — must be implemented by subclasses
    public abstract double area();
}

// --------------------------------------------------
// Concrete subclass
// --------------------------------------------------
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

// --------------------------------------------------
// Main class
// --------------------------------------------------
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

