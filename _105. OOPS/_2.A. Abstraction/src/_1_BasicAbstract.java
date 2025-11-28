/*
 * File 1 — BasicsDemo.java
 * GOAL: Understand what an abstract class is and how subclasses implement it.
 */

// ✅ Step 1: Create an abstract class
abstract class Animal {
    // Abstract method → declared, but no body.
    // Each subclass must implement its own version.
    abstract void makeSound();

    // Concrete method → already implemented.
    // Shared behavior for all animals.
    void sleep() {
        System.out.println("Zzz... 😴");
    }
}

// ✅ Step 2: Create a concrete subclass (Dog) that extends Animal
class Dog extends Animal {
    // Must implement the abstract method
    @Override
    void makeSound() {
        System.out.println("Bark! 🐶");
    }
}

// ✅ Step 3: Create the main class to test
public class _1_BasicAbstract {
    public static void main(String[] args) {
        // Animal a = new Animal(); // ❌ ERROR: cannot instantiate abstract class

        // ✅ Create a Dog (concrete subclass)
        Animal d = new Dog();   // Upcasting (Animal reference → Dog object)
        d.makeSound();          // Output: Bark! 🐶
        d.sleep();              // Output: Zzz... 😴
    }
}


//
//🧠 What You Learned
// ------------------
//  1. abstract keyword makes a class incomplete (cannot be instantiated).
//  2. Abstract classes can contain both abstract and normal methods.
//  3. Subclasses must override all abstract methods.
//  4. Abstract classes allow shared code reuse through concrete methods.