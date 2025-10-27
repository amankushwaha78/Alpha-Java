/*
 * File 4 — PartialImplementationDemo.java
 *
 * 💡 GOAL:
 * Understand how an abstract subclass can implement some abstract methods,
 * and leave others for further subclasses to implement.
 *
 * 🔹 Example Flow:
 * PolygonBase (abstract) → RegularPolygonBase (abstract) → EquilateralTriangle (concrete)
 *
 * Each level adds more details until we reach a fully usable class.
 */

// ✅ Step 1: Top-level abstract class
abstract class PolygonBase {
    // All polygons must define how to compute area & perimeter
    abstract double area();
    abstract double perimeter();
}

// ✅ Step 2: Abstract subclass providing *partial* implementation
// RegularPolygonBase provides perimeter formula, but still keeps area() abstract.
abstract class RegularPolygonBase extends PolygonBase {
    protected final int sides;
    protected final double sideLength;

    protected RegularPolygonBase(int sides, double sideLength) {
        if (sides < 3) throw new IllegalArgumentException("A polygon must have at least 3 sides");
        if (sideLength <= 0) throw new IllegalArgumentException("Side length must be > 0");
        this.sides = sides;
        this.sideLength = sideLength;
    }

    // ✅ Now we implement one method: perimeter
    @Override
    double perimeter() {
        return sides * sideLength;
    }

    // ❌ Still abstract → must be defined by next subclass
    @Override
    abstract double area();
}

// ✅ Step 3: Concrete subclass — implements the remaining abstract method
class EquilateralTriangle extends RegularPolygonBase {
    public EquilateralTriangle(double sideLength) {
        super(3, sideLength); // 3 sides for a triangle
    }

    @Override
    double area() {
        // Formula: (√3 / 4) * side²
        return (Math.sqrt(3) / 4) * sideLength * sideLength;
    }
}

// ✅ Step 4: Main class to test everything
public class _4_PartialImplementationDemo {
    public static void main(String[] args) {
        System.out.println("=== Multi-level Abstraction Example ===");

        EquilateralTriangle triangle = new EquilateralTriangle(4);
        System.out.println("Sides: 3");
        System.out.println("Side Length: 4");
        System.out.println("Perimeter: " + triangle.perimeter());
        System.out.println("Area: " + triangle.area());
    }
}

/*
💡 Summary

1. Abstract classes can extend other abstract classes.
2. Each layer can partially fulfill the contract.
3. The lowest concrete subclass provides the final complete behavior.
*/
