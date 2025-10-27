/*
 * File 2 — MethodOverridingDemo.java
 *
 * 💡 GOAL:
 * Demonstrate runtime polymorphism — a subclass provides its own version
 * of a parent method, and the decision of which method to call happens at RUNTIME.
 */

class Vehicle {
    void start() {
        System.out.println("Vehicle starting 🚗");
    }
}

class Car extends Vehicle {
    @Override
    void start() {
        System.out.println("Car engine starting with key 🔑");
    }
}

class ElectricCar extends Vehicle {
    @Override
    void start() {
        System.out.println("Electric car starting silently ⚡");
    }
}

public class MethodOverridingDemo {
    public static void main(String[] args) {
        Vehicle v1 = new Car();         // upcasting
        Vehicle v2 = new ElectricCar(); // upcasting

        v1.start(); // calls Car.start()
        v2.start(); // calls ElectricCar.start()
    }
}

/*
Output:
Car engine starting with key 🔑
Electric car starting silently ⚡

Explanation:
• start() is overridden in both subclasses.
• The reference type (Vehicle) is the same, but the OBJECT type differs.
• JVM calls the version belonging to the real object at runtime (dynamic dispatch).
*/
