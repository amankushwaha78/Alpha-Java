public class _2_ObjectCastingDemo {

    public static void main(String[] args) {

        // ✅ Upcasting Example (Automatic)
        Dog d = new Dog();        // Child class object
        Animal a = d;             // Upcasting (automatic: Dog -> Animal)
        a.sound();                // Works fine (method in Animal class)
        // a.bark();              // ❌ Not allowed (Animal reference can't access Dog methods)

        // ✅ Downcasting Example (Manual)
        Animal a2 = new Dog();    // Upcasting first (safe)
        Dog d2 = (Dog) a2;        // Downcasting (manual)
        d2.bark();                // Works fine (now reference is Dog)
        d2.sound();               // Works (inherited method from Animal)

        // ⚠️ Invalid Downcasting Example (commented to prevent runtime error)
        /*
        Animal a3 = new Animal();  // Pure Animal object
        try {
            Dog d3 = (Dog) a3;     // ❌ Causes ClassCastException at runtime
            d3.bark();
        } catch (ClassCastException e) {
            System.out.println("Caught Exception: " + e);
        }
        */
    }
}

// 🔹 Parent Class
class Animal {
    void sound() {
        System.out.println("Animal sound"); // Common method
    }
}

// 🔹 Child Class
class Dog extends Animal {
    void bark() {
        System.out.println("Dog barks"); // Specific to Dog
    }
}

/**
 [7] Object Casting (Upcasting / Downcasting)
 ---------------------------------------------------
 Object casting means converting one object reference type to another
 when the classes are related by inheritance (Parent ↔ Child).

 ---------------------------------------------------
 🔹 Upcasting (Automatic, Safe)
 ---------------------------------------------------
 Assigning a child object to a parent reference.
 Done automatically by Java.

 Example:
 Dog d = new Dog();
 Animal a = d;  // Upcasting (automatic)
 a.sound();     // Works fine (method from Animal)
 // a.bark();   // ❌ Not accessible (Dog-specific method hidden)

 Why it's safe:
 Because every Dog "is a" valid Animal.

 ---------------------------------------------------
 🔹 Downcasting (Manual, Risky)
 ---------------------------------------------------
 Assigning a parent reference back to a child reference.
 Must be done manually using a cast.

 Example:
 Animal a = new Dog();
 Dog d = (Dog) a;   // ✅ Downcasting
 d.bark();          // Works fine (Dog method accessible)

 If the parent reference does not actually refer to a Dog,
 Java throws ClassCastException.

 Example:
 Animal a = new Animal();
 Dog d = (Dog) a;   // ❌ Runtime error (invalid downcast)

 ---------------------------------------------------
 🔹 Summary Table
 ---------------------------------------------------
 | Type        | Direction        | Example        | Performed By | Safe?  |
 |--------------|------------------|----------------|---------------|---------|
 | Upcasting    | Child -> Parent  | Dog -> Animal  | Automatic     | ✅ Yes  |
 | Downcasting  | Parent -> Child  | Animal -> Dog  | Manual        | ⚠️ Risky |

 ---------------------------------------------------
 💡 INTERVIEW NOTES
 ---------------------------------------------------
 • Upcasting is automatic and always safe.
 • Downcasting must be explicit and may fail at runtime.
 • Both rely on inheritance relationships.
 • ClassCastException occurs if the casted reference isn't
 actually an instance of that subclass.

 ---------------------------------------------------
 🧠 OUTPUT ON CONSOLE:
 ---------------------------------------------------
 Animal sound
 Dog barks
 Animal sound

 (If invalid downcasting block is uncommented:)
 Caught Exception: java.lang.ClassCastException: Animal cannot be cast to Dog
 */
