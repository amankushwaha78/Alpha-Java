/*
 * File 5 — InterfaceAbstractDemo.java
 *
 * 💡 GOAL:
 * Understand how an abstract class can implement an interface and provide
 * shared logic for subclasses.
 *
 * 🔹 Why this matters:
 *   → Interfaces define "what to do".
 *   → Abstract classes can partially implement "how to do it".
 *   → Concrete classes finish the job!
 */

// ✅ Step 1: Define an interface (pure abstraction)
interface Colorable {
    void setColor(String color);  // abstract by default
    String getColor();
}

// ✅ Step 2: Abstract class implementing the interface
// It provides some (or all) logic of the interface
abstract class ColoredShapeBase implements Colorable {
    private String color = "none"; // shared property for all shapes

    // Provide reusable implementation for interface methods
    @Override
    public void setColor(String color) {
        // Handle null or empty color safely
        this.color = (color == null || color.isBlank()) ? "none" : color;
    }

    @Override
    public String getColor() {
        return color;
    }

    // Abstract method: each shape defines its own area
    abstract double area();
}

// ✅ Step 3: Concrete subclass — implements remaining abstract method
class ColoredRectangle extends ColoredShapeBase {
    private final double width, height;

    public ColoredRectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    // Implement the shape-specific method
    @Override
    double area() {
        return width * height;
    }
}

// ✅ Step 4: Main class to test
public class _5_InterfaceAbstractDemo {
    public static void main(String[] args) {
        System.out.println("=== Abstract Class + Interface Example ===");

        ColoredRectangle rect = new ColoredRectangle(5, 3);
        rect.setColor("Teal");

        System.out.println("Shape: Rectangle");
        System.out.println("Color: " + rect.getColor());
        System.out.println("Area: " + rect.area());
    }
}


/*
💬 Example in Simple Words

a. Colorable says: “Every colorable thing must have setColor() and getColor().”
b. ColoredShapeBase says: “Okay, I’ll provide a default implementation.”
c. ColoredRectangle says: “I’ll add shape-specific behavior (like area()).”
 */