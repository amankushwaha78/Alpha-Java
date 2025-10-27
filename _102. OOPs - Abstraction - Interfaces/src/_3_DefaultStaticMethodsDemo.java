/*
 * File 3 — DefaultStaticMethodsDemo.java
 *
 * 💡 GOAL:
 * Learn about DEFAULT and STATIC methods in interfaces.
 *
 * 🧠 Concept:
 * - Default methods: have a body; can be overridden by implementing classes.
 * - Static methods: belong to the interface itself; cannot be overridden.
 */

// ✅ Step 1: Define an interface with default + static methods
interface Vehicle {
    // Abstract method (must be implemented)
    void start();

    // Default method (has a body)
    default void stop() {
        System.out.println("Vehicle stopped 🛑");
    }

    // Static method (belongs to the interface, not instances)
    static void serviceInfo() {
        System.out.println("Service every 6 months 🔧");
    }
}

// ✅ Step 2: Class implementing the interface
class Car implements Vehicle {
    @Override
    public void start() {
        System.out.println("Car started with key ignition 🚗");
    }

    // Optionally override default method
    @Override
    public void stop() {
        System.out.println("Car stopped and engine turned off 💤");
    }
}

// ✅ Step 3: Another class that does NOT override the default method
class Bike implements Vehicle {
    @Override
    public void start() {
        System.out.println("Bike started with kick 🔑🏍️");
    }
}

// ✅ Step 4: Main class to test
public class _3_DefaultStaticMethodsDemo {
    public static void main(String[] args) {
        Vehicle car = new Car();
        Vehicle bike = new Bike();

        car.start();  // Car’s implementation
        car.stop();   // Overridden version

        System.out.println("----------------");

        bike.start(); // Bike’s implementation
        bike.stop();  // Default method from Vehicle

        System.out.println("----------------");

        // Calling static method from interface
        Vehicle.serviceInfo(); // ✅ Called using InterfaceName.methodName()
    }
}

/*
🧠 What You Learned
-------------------
✅ Interfaces can have DEFAULT methods (with body) — useful for backward compatibility.
✅ Default methods can be overridden in implementing classes.
✅ Interfaces can have STATIC methods (with body) — called using the interface name.
✅ Static methods CANNOT be overridden by implementing classes.
✅ Helps interfaces evolve without breaking existing code.
*/
