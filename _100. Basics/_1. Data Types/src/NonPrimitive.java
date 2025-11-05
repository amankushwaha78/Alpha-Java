/*
🧱 4️⃣ Non-Primitive (Reference) Data Types
---------------------------------------------------
Non-Primitive Data Types are created by programmers (not built-in like primitives).
They **store references (addresses)** to the actual memory objects.
They are **stored in the heap** and can have methods or properties.

💡 Key Points:
✅ Can be null.
✅ Used to call methods, manipulate data.
✅ Can hold multiple values or complex structures.

---------------------------------------------------
| Type       | Example                          | Description                                  |
|-------------|----------------------------------|----------------------------------------------|
| String      | "Aman"                           | Collection of characters (object of String)  |
| Array       | {1, 2, 3}                        | Stores multiple values of same type          |
| Class       | MyClass obj = new MyClass();     | Blueprint for creating objects               |
| Interface   | Runnable r = ...;                | Contract defining behavior (implemented by classes) |
*/

public class NonPrimitive {
    public static void main(String[] args) {

        // 🔹 1️⃣ String Type
        String name = "Aman Kushwaha";   // String is a class in java.lang package
        System.out.println("Name: " + name);          // Output → Name: Aman Kushwaha

        // 🔹 2️⃣ Array Type
        int[] scores = {90, 85, 88};     // Array stores multiple int values in sequence
        System.out.println("First Score: " + scores[0]);  // Output → First Score: 90
        System.out.println("All Scores: " + scores[0] + ", " + scores[1] + ", " + scores[2]);
        // Output → All Scores: 90, 85, 88

        // 🔹 3️⃣ Class Type (User-defined blueprint)
        MyClass obj = new MyClass();     // Object created using class
        obj.showMessage();               // Output → Hello from MyClass!

        // 🔹 4️⃣ Interface Type (using built-in Java Runnable)
        Runnable task = new RunnableExample(); // Interface reference holding object
        task.run();                            // Output → RunnableExample is running...
    }
}

// 🔸 Supporting class for demonstration
class MyClass {
    void showMessage() {
        System.out.println("Hello from MyClass!"); // Output → Hello from MyClass!
    }
}

// 🔸 Supporting class implementing built-in Runnable interface
class RunnableExample implements Runnable {
    public void run() {
        System.out.println("RunnableExample is running..."); // Output → RunnableExample is running...
    }
}

/*
🧠 OUTPUT ON CONSOLE:
---------------------
Name: Aman Kushwaha
First Score: 90
All Scores: 90, 85, 88
Hello from MyClass!
RunnableExample is running...


💡 SUMMARY TABLE
================
| Type       | Description                                  | Stored In | Example Usage |
|-------------|----------------------------------------------|------------|----------------|
| String      | Object representing sequence of chars        | Heap       | String s = "Hello"; |
| Array       | Stores multiple values of same type          | Heap       | int[] arr = {1,2,3}; |
| Class       | Blueprint that defines properties/methods    | Heap       | MyClass obj = new MyClass(); |
| Interface   | Contract defining what a class must do       | Heap       | Runnable r = new Task(); |

🧩 BONUS INSIGHT:
-----------------
• All reference types are subclasses of `Object`.
• They can be assigned `null`.
• Methods can be called directly on reference variables.
• Unlike primitives, they need `new` keyword (except String literals).
*/
