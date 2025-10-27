/*
 * File 1 — InheritanceBasicsDemo.java
 *
 * 💡 GOAL:
 * Demonstrate single inheritance — one class (child) inheriting
 * from another class (parent).
 *
 * 🧠 Concept:
 * - The child class (subclass) automatically gets access to all
 *   non-private members (fields + methods) of the parent class.
 * - "extends" keyword is used.
 * - Promotes code reusability.
 */

// ✅ Step 1: Parent (Super) class
class Animal {
    String name;

    void eat() {
        System.out.println(name + " is eating 🍽️");
    }

    void sleep() {
        System.out.println(name + " is sleeping 😴");
    }
}

// ✅ Step 2: Child (Sub) class
class Dog extends Animal {
    void bark() {
        System.out.println(name + " is barking 🐶");
    }
}

// ✅ Step 3: Main class to test
public class _1_InheritanceBasicsDemo {
    public static void main(String[] args) {
        Dog dog = new Dog();

        // Inherited field from Animal
        dog.name = "Tommy";

        // Using inherited methods
        dog.eat();
        dog.sleep();

        // Using child’s own method
        dog.bark();
    }
}

/*
Output:
Tommy is eating 🍽️
Tommy is sleeping 😴
Tommy is barking 🐶

Explanation:
• Dog extends Animal → Dog inherits Animal's fields and methods.
• Object of Dog can use both parent (eat, sleep) and its own (bark) methods.
• "extends" = "is-a" relationship. (Dog is an Animal)
*/
