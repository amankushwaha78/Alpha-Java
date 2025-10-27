/*
 * File 1 — InterfaceBasicsDemo.java
 *
 * 💡 GOAL:
 * Understand what an interface is and how a class implements it.
 *
 * 🧠 Concept:
 * - An interface is a pure abstract type (all methods are abstract by default).
 * - It defines *what to do*, not *how to do it*.
 * - A class implements an interface to provide its own version of those methods.
 */

// ✅ Step 1: Define an interface
interface Animal {
    void makeSound();   // implicitly public & abstract
    void eat();         // implicitly public & abstract
}

// ✅ Step 2: Class implements the interface
class Dog implements Animal2 {
    @Override
    public void makeSound() {
        System.out.println("Bark! 🐶");
    }

    @Override
    public void eat() {
        System.out.println("Dog eats bones 🍖");
    }
}

// ✅ Step 3: Another class implementing same interface
class Cat implements Animal2 {
    @Override
    public void makeSound() {
        System.out.println("Meow! 🐱");
    }

    @Override
    public void eat() {
        System.out.println("Cat drinks milk 🥛");
    }
}

// ✅ Step 4: Main class to test
public class _1_InterfaceBasicsDemo {
    public static void main(String[] args) {
        Animal2 dog = new Dog2();
        Animal2 cat = new Cat();

        dog.makeSound();
        dog.eat();

        System.out.println("----------------");

        cat.makeSound();
        cat.eat();
    }
}

/*
🧠 What You Learned
-------------------
✅ All interface methods are public + abstract (even if you don’t write it).
✅ A class uses the 'implements' keyword, not 'extends'.
✅ One class can implement multiple interfaces (you’ll see next).
✅ Interfaces define behavior contracts, not implementation.
*/
