/*
 * File 6 — InterfaceVsAbstractDemo.java
 *
 * 💡 GOAL:
 * Compare INTERFACE vs ABSTRACT CLASS with a side-by-side example.
 *
 * 🧠 Concept:
 * - Both are used to achieve abstraction, but differ in flexibility, inheritance, and use.
 *
 * 🔹 When to use:
 *   → Interface: For defining “what should be done” (contract/behavior).
 *   → Abstract class: For providing “partial implementation” (shared logic + structure).
 */

// ✅ Step 1: Interface (defines contract only)
interface Flyable {
    void fly();  // abstract by default
    default void land() {
        System.out.println("Landing using default behavior ✈️");
    }
}

// ✅ Step 2: Abstract class (partial implementation + state)
abstract class Bird {
    String name;

    Bird(String name) {
        this.name = name;
    }

    void eat() {
        System.out.println(name + " is eating 🐛");
    }

    // abstract method
    abstract void makeSound();
}

// ✅ Step 3: Concrete class implementing BOTH interface and abstract class
class Eagle extends Bird implements Flyable {
    Eagle(String name) {
        super(name);
    }

    @Override
    void makeSound() {
        System.out.println("Screech! 🦅");
    }

    @Override
    public void fly() {
        System.out.println(name + " is soaring high in the sky ☁️");
    }

    // Optionally override default method
    @Override
    public void land() {
        System.out.println(name + " lands gracefully on a cliff 🪶");
    }
}

// ✅ Step 4: Another concrete class to show differences
class Penguin extends Bird {
    Penguin(String name) {
        super(name);
    }

    @Override
    void makeSound() {
        System.out.println("Honk! 🐧");
    }

    void swim() {
        System.out.println(name + " is swimming in icy water ❄️");
    }
}

// ✅ Step 5: Main class to test
public class _6_InterfaceVsAbstractDemo {
    public static void main(String[] args) {
        System.out.println("=== Interface vs Abstract Class Demo ===");

        Eagle eagle = new Eagle("Eagle");
        eagle.eat();       // from abstract class
        eagle.fly();       // from interface
        eagle.land();      // overridden default
        eagle.makeSound(); // from subclass

        System.out.println("----------------");

        Penguin penguin = new Penguin("Penguin");
        penguin.eat();       // from abstract class
        penguin.makeSound(); // from subclass
        penguin.swim();      // unique to Penguin
    }
}

/*
🧠 What You Learned
-------------------
✅ Interface:
   - Defines a contract (what to do), not implementation.
   - All methods are abstract by default (can have default/static too).
   - No instance fields allowed (only constants).
   - A class can implement multiple interfaces.
   - Supports multiple inheritance.

✅ Abstract Class:
   - Provides partial implementation (shared logic).
   - Can have abstract + concrete methods.
   - Can have instance fields, constructors, and state.
   - A class can extend only ONE abstract (or normal) class.
   - Used when classes share behavior or common fields.

✅ Key Rule:
   - Use INTERFACE when you want a contract for capabilities (like Flyable, Runnable).
   - Use ABSTRACT CLASS when you want to share common code among related classes.
*/
