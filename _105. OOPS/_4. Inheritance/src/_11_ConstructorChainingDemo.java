/*
 * File 4 — ConstructorChainingDemo.java
 *
 * 💡 GOAL:
 * Learn how constructors are executed in order when using `this()` and `super()`.
 *
 * 🧠 Concept:
 * - `super()` → calls parent class constructor (must be FIRST line).
 * - `this()`  → calls another constructor in the same class.
 * - Java always calls the parent constructor first, even if not written explicitly.
 */

// ✅ Step 1: Parent class
class Vehicle {
    Vehicle() {
        System.out.println("🚗 Vehicle: Default constructor");
    }

    Vehicle(String type) {
        System.out.println("🚙 Vehicle: Parameterized constructor - " + type);
    }
}

// ✅ Step 2: Child class
class Car extends Vehicle {
    Car() {
        // implicit super() here
        System.out.println("🚘 Car: Default constructor");
    }

    Car(String brand) {
        this(); // calls the Car() constructor first
        System.out.println("🚘 Car: Parameterized constructor - " + brand);
    }
}

// ✅ Step 3: Another child to show explicit super()
class Bike extends Vehicle {
    Bike() {
        super("Two Wheeler"); // explicit call to parent parameterized constructor
        System.out.println("🏍️ Bike: Default constructor");
    }
}

// ✅ Step 4: Main class
public class _11_ConstructorChainingDemo {
    public static void main(String[] args) {
        System.out.println("=== Creating Car Object ===");
        Car c = new Car("BMW");

        System.out.println("\n=== Creating Bike Object ===");
        Bike b = new Bike();
    }
}

/*
Output:
=== Creating Car Object ===
🚗 Vehicle: Default constructor
🚘 Car: Default constructor
🚘 Car: Parameterized constructor - BMW

=== Creating Bike Object ===
🚙 Vehicle: Parameterized constructor - Two Wheeler
🏍️ Bike: Default constructor

Explanation:
• Every time an object is created, Java starts constructor calls from the top of the inheritance chain.
• For Car("BMW"):
    - this() → calls Car()
    - Car() automatically calls super() → Vehicle()
    - So order: Vehicle() → Car() → Car("BMW")
• For Bike():
    - super("Two Wheeler") → calls Vehicle(String)
    - Then Bike() runs.
• Parent constructors always execute before child constructors.
*/
