/*
 * File 2 — MultipleInterfacesDemo.java
 *
 * 💡 GOAL:
 * Learn how one class can implement multiple interfaces.
 *
 * 🧠 Concept:
 * - A class can implement more than one interface using commas.
 * - Each interface declares behavior; the class provides implementations.
 * - Interface fields are implicitly public static final (constants).
 */

// ✅ Step 1: Define two interfaces
interface Runner {
    // implicitly: public abstract
    void run();

    // implicitly: public static final
    int MAX_SPEED = 100; // km/h (interface constant)
}

interface Swimmer {
    void swim();
}

// ✅ Step 2: Class implements MULTIPLE interfaces
class Triathlete implements Runner, Swimmer {
    @Override
    public void run() {
        System.out.println("Triathlete running at 20 km/h 🏃");
    }

    @Override
    public void swim() {
        System.out.println("Triathlete swimming freestyle 🏊");
    }
}

// Another class implementing the same pair (to show flexibility)
class RobotDog implements Runner, Swimmer {
    @Override
    public void run() {
        System.out.println("RobotDog sprinting swiftly 🤖🐶");
    }

    @Override
    public void swim() {
        System.out.println("RobotDog paddling with propellers ⚙️");
    }
}

// ✅ Step 3: Main to test
public class _2_MultipleInterfacesDemo {
    public static void main(String[] args) {
        Runner r1 = new Triathlete();   // upcast to Runner
        Swimmer s1 = (Swimmer) r1;      // same object also a Swimmer

        r1.run();
        s1.swim();

        System.out.println("----------------");

        RobotDog bot = new RobotDog();
        bot.run();
        bot.swim();

        System.out.println("----------------");
        // Using an interface constant (public static final)
        System.out.println("Runner.MAX_SPEED = " + Runner.MAX_SPEED);

        // Runner.MAX_SPEED = 120; // ❌ ERROR: cannot assign a value to final variable
    }
}

/*
🧠 What You Learned
-------------------
✅ A class can implement MULTIPLE interfaces by separating them with commas (e.g., `class X implements A, B`).
✅ You must implement ALL abstract methods from ALL interfaces.
✅ Interface fields are implicitly public static final (constants) and accessed like `InterfaceName.CONSTANT`.
✅ If two interfaces declare the SAME abstract method signature, you implement it ONCE in the class.
*/
