/*
 * File 4 — InheritanceInInterfacesDemo.java
 *
 * 💡 GOAL:
 * Understand how interfaces can inherit from other interfaces.
 *
 * 🧠 Concept:
 * - One interface can extend another (or multiple interfaces).
 * - The child interface inherits all abstract methods.
 * - A class implementing the child interface must implement *all* inherited methods.
 */

// ✅ Step 1: Base interfaces
interface Animal2 {
    void eat();
}

interface Pet {
    void play();
}

// ✅ Step 2: Interface extending multiple parent interfaces
// (this is INTERFACE MULTIPLE INHERITANCE)
interface Dog2 extends Animal2, Pet {
    void bark();
}

// ✅ Step 3: Class implementing the child interface
// (must implement methods from Animal, Pet, and Dog)
class Labrador implements Dog2 {
    @Override
    public void eat() {
        System.out.println("Labrador eats dog food 🍖");
    }

    @Override
    public void play() {
        System.out.println("Labrador loves to fetch balls 🎾");
    }

    @Override
    public void bark() {
        System.out.println("Labrador barks happily 🐶");
    }
}

// ✅ Step 4: Main class to test
public class _4_InheritanceInInterfacesDemo {
    public static void main(String[] args) {
        Labrador dog = new Labrador();

        dog.eat();   // from Animal
        dog.play();  // from Pet
        dog.bark();  // from Dog
    }
}

/*
🧠 What You Learned
-------------------
✅ Interfaces can EXTEND other interfaces (just like classes extend classes).
✅ One interface can extend MULTIPLE interfaces.
✅ A class implementing the child interface must implement ALL inherited methods.
✅ Interface inheritance is used to build hierarchical, modular designs.
✅ It avoids the "diamond problem" because methods are only declared (no state/implementation).
*/
