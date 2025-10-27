/*
 * File 3 — SuperKeywordDemo.java
 *
 * 💡 GOAL:
 * Learn how to use `super` to:
 *  1️⃣ Call parent constructor
 *  2️⃣ Call parent method (when overridden)
 *  3️⃣ Access parent variable (when hidden)
 */

// ✅ Step 1: Parent class
class Animalo {
    String name = "Animal";

    // Parent constructor
    Animalo() {
        System.out.println("Animal constructor called 🐾");
    }

    void sound() {
        System.out.println("Animal makes a sound 🎵");
    }
}

// ✅ Step 2: Child class
class Doggi extends Animalo {
    String name = "Dog";

    // Child constructor
    Doggi() {
        // Calls parent constructor (MUST be first line)
        super();
        System.out.println("Dog constructor called 🐶");
    }

    // Overriding parent method
    @Override
    void sound() {
        super.sound(); // calls parent method
        System.out.println("Dog barks loudly 🗣️");
    }

    // Show difference between parent & child variables
    void showNames() {
        System.out.println("Child name: " + name);       // Dog’s variable
        System.out.println("Parent name: " + super.name); // Parent’s variable
    }
}

// ✅ Step 3: Main class
public class _10_SuperKeywordDemo {
    public static void main(String[] args) {
        Doggi d = new Doggi();
        d.sound();
        d.showNames();
    }
}

/*
Output:
Animal constructor called 🐾
Dog constructor called 🐶
Animal makes a sound 🎵
Dog barks loudly 🗣️
Child name: Dog
Parent name: Animal

Explanation:
• super() → calls parent constructor first.
• super.sound() → calls parent’s version of overridden method.
• super.name → accesses parent’s variable when hidden by child variable.
• “super” = bridge to parent class members.
*/
