/*
 * File 2 — AbstractMethodsDemo.java
 * GOAL: Learn the RULES of abstract methods.
 *
 * 💡 Abstract Method Rules:
 * ✅ Must have no body (only declaration).
 * ✅ Can be public, protected, or package-private (no modifier).
 * ❌ Cannot be private (cannot be overridden).
 * ❌ Cannot be static.
 * ❌ Cannot be final.
 */

// ✅ Step 1: Create an abstract class
abstract class Vehicle {
    // ✅ Allowed: public abstract
    public abstract void start();

    // ✅ Allowed: protected abstract
    protected abstract void stop();

    // ✅ Allowed: package-private (no modifier)
    abstract int wheels();

    // ❌ Not allowed:
    // private abstract void engine();   // ❌ (compiler error)
    // static abstract void foo();       // ❌ (cannot be static)
    // public final abstract void bar(); // ❌ (cannot be final)
}

// ✅ Step 2: Concrete subclass that implements all abstract methods
class Car extends Vehicle {
    @Override
    public void start() {
        System.out.println("Car started with key ignition 🔑");
    }

    @Override
    protected void stop() {
        System.out.println("Car stopped 🛑");
    }

    @Override
    int wheels() {
        return 4;
    }
}

// ✅ Step 3: Main class to test
public class _2_AbstractMethodsDemo {
    public static void main(String[] args) {
        Vehicle v = new Car();  // ✅ Abstract reference → Concrete object
        v.start();
        v.stop();
        System.out.println("Number of wheels: " + v.wheels());
    }
}

/*
🧠 WHAT YOU LEARNED ABOUT ABSTRACT METHODS
-------------------------------------------
1. Abstract methods = method declaration without body
2. You can use any access modifier except 🚫 private
3. Abstract methods cannot be ⚡ static or 🔒 final
4. The first non-abstract subclass 🧩 must implement all of them
*/

