/*
 * File 1 — MultiLevelInheritanceDemo.java
 *
 * 💡 GOAL:
 * Show a multi-level chain: Parent → Child → Grandchild.
 */

class Animall {
    void eat() { System.out.println("Animal is eating 🍽️"); }
}

class Dogg extends Animall {
    void bark() { System.out.println("Dog is barking 🐶"); }
}

class Puppy extends Dogg {
    void weep() { System.out.println("Puppy is weeping 🍼"); }
}

public class _2_MultiLevelInheritanceDemo {
    public static void main(String[] args) {
        Puppy p = new Puppy();
        p.eat();   // from Animal
        p.bark();  // from Dog
        p.weep();  // from Puppy
    }
}

/*
Output:
Animal is eating 🍽️
Dog is barking 🐶
Puppy is weeping 🍼

Explanation:
• Each subclass inherits everything from its parent chain.
• Puppy → Dog → Animal (three levels deep).
• Java executes methods from the most specific class first when called.
*/
