// 📘 LocalVariableInitializationDemo.java
// Demonstrates why local variables inside methods must be initialized manually

/*
💡 RULE:
---------------------------------------------------
• Class or instance variables → get default values automatically.
• Local variables (inside methods) → ❌ do NOT get default values.

If you try to use a local variable before assigning a value,
the Java compiler throws:  "variable <name> might not have been initialized".
*/

public class LocalVariableInitializationDemo {

    // 🔹 Class (static) variable — gets default value automatically
    static int classLevelVar;  // default → 0

    public static void main(String[] args) {

        // 🔹 LOCAL variable — declared but NOT initialized
        int localVar;  // ❌ No default value assigned by Java

        // System.out.println(localVar); // ❌ Uncommenting this line causes:
        // error: variable localVar might not have been initialized

        // ✅ Must assign manually before using
        localVar = 10;
        System.out.println("Local variable after initialization: " + localVar);
        // Output → Local variable after initialization: 10

        // ✅ Class variable can be used directly (has default 0)
        System.out.println("Class-level variable default value: " + classLevelVar);
        // Output → Class-level variable default value: 0
    }
}

/*
🧠 OUTPUT ON CONSOLE:
---------------------
Local variable after initialization: 10
Class-level variable default value: 0


🧱 SUMMARY:
=================
✅ Local variables (inside methods):
   • Must be explicitly initialized before use.
   • No default value → compiler error if uninitialized.

✅ Class / Instance variables:
   • Automatically initialized by Java.
   • e.g., int → 0, float → 0.0, boolean → false, Object → null.

🗣️ INTERVIEW ANSWER:
---------------------
"If you declare a local variable inside a method without initializing it,
the compiler throws an error because Java doesn’t assign default values
to local (stack) variables — it enforces explicit initialization for safety."
*/
