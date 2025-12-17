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

/**
 * ============================================================
 * 🧠 ABSTRACT METHODS — FIRST NON-ABSTRACT SUBCLASS RULE
 * ============================================================
 *
 * 🔑 RULE:
 * The FIRST non-abstract (concrete) subclass MUST implement
 * ALL inherited abstract methods.
 *
 * ------------------------------------------------------------
 * 🔍 WHY THIS RULE EXISTS?
 * ------------------------------------------------------------
 * - Abstract class = incomplete blueprint 🏗️
 * - Concrete class = ready-to-use object 🚗
 * - Java does NOT allow creating objects from incomplete classes
 *
 * ➜ Therefore, before a class can become concrete,
 *   ALL abstract methods must be implemented.
 *
 * ------------------------------------------------------------
 * ✅ CASE 1: CORRECT IMPLEMENTATION
 * ------------------------------------------------------------
 *
 * abstract class Vehicle {
 *     abstract void start();
 *     abstract void stop();
 * }
 *
 * // FIRST non-abstract subclass
 * class Car extends Vehicle {
 *     void start() {
 *         System.out.println("Car started");
 *     }
 *
 *     void stop() {
 *         System.out.println("Car stopped");
 *     }
 * }
 *
 * ✔ Car is concrete
 * ✔ Car implements ALL abstract methods
 * ✔ Compilation SUCCESS
 *
 * ------------------------------------------------------------
 * ❌ CASE 2: COMPILER ERROR
 * ------------------------------------------------------------
 *
 * abstract class Vehicle {
 *     abstract void start();
 *     abstract void stop();
 * }
 *
 * class Car extends Vehicle {
 *     void start() {
 *         System.out.println("Car started");
 *     }
 *     // ❌ stop() NOT implemented
 * }
 *
 * ❌ COMPILER ERROR:
 * "Car is not abstract and does not override abstract method stop()"
 *
 * ➜ Reason:
 * Car is the FIRST non-abstract subclass but is incomplete.
 *
 * ------------------------------------------------------------
 * ✅ CASE 3: ABSTRACT SUBCLASS CAN SKIP METHODS
 * ------------------------------------------------------------
 *
 * abstract class Vehicle {
 *     abstract void start();
 *     abstract void stop();
 * }
 *
 * // Still abstract → allowed to skip
 * abstract class Car extends Vehicle {
 *     void start() {
 *         System.out.println("Car started");
 *     }
 *     // stop() pending
 * }
 *
 * // FIRST non-abstract subclass
 * class Sedan extends Car {
 *     void stop() {
 *         System.out.println("Sedan stopped");
 *     }
 * }
 *
 * ✔ Car is abstract → allowed to skip
 * ✔ Sedan is first concrete class → MUST implement stop()
 *
 * ------------------------------------------------------------
 * 🏭 REAL-WORLD ANALOGY (INTERVIEW GOLD ✨)
 * ------------------------------------------------------------
 * - Abstract class = half-built factory blueprint
 * - Concrete class = final product shipped to customer
 * - You cannot ship a product unless all parts are built
 *
 * ------------------------------------------------------------
 * 🎯 ONE-LINE INTERVIEW ANSWER
 * ------------------------------------------------------------
 * "Abstract methods can remain unimplemented until a class
 * becomes non-abstract. The first non-abstract subclass must
 * implement all inherited abstract methods, otherwise the
 * compiler throws an error."
 *
 * ------------------------------------------------------------
 * ⭐ KEY TAKEAWAY
 * ------------------------------------------------------------
 * - abstract class → incomplete allowed
 * - non-abstract class → 100% implementation mandatory
 * ============================================================
 */
