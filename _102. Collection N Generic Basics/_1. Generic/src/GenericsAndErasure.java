// 📁 File: GenericsAndErasure.java
import java.util.*;

/**
 * 🧠 WHAT YOU’LL LEARN
 * ---------------------
 * 1️⃣ Custom Generic Class (Box<T>)
 * 2️⃣ Generic Method (<T> method)
 * 3️⃣ Type Erasure (what happens at runtime)
 */

public class GenericsAndErasure {

    /** 🔸 GENERIC CLASS — Box<T>
     * T is a placeholder for any type (Integer, String, etc.)
     */
    static class Box<T> {
        private T value;                 // stores value of any type
        Box(T value) { this.value = value; }  // constructor
        T getValue() { return value; }        // returns stored value
    }

    /** 🔸 GENERIC METHOD
     * Works for any type because of <T> before return type.
     */
    static <T> void printTwice(T item) {
        System.out.println(item);
        System.out.println(item);
    }

    public static void main(String[] args) {

        /**
         * ✅ 1️⃣ CUSTOM GENERIC CLASS
         * ----------------------------
         * - Same class can work for multiple types using <T>.
         * - Example: Box<Integer>, Box<String>
         */
        Box<Integer> intBox = new Box<>(100);
        Box<String> strBox  = new Box<>("Hello Generics");

        System.out.println("Integer Box: " + intBox.getValue());
        System.out.println("String Box: " + strBox.getValue());

        /**
         * 💬 OUTPUT:
         * Integer Box: 100
         * String Box: Hello Generics
         */


        /**
         * ✅ 2️⃣ GENERIC METHOD
         * ---------------------
         * - One method works for all data types.
         */
        printTwice("Generics are awesome!");
        printTwice(999);

        /**
         * 💬 OUTPUT:
         * Generics are awesome!
         * Generics are awesome!
         * 999
         * 999
         */


        /**
         * ✅ 3️⃣ TYPE ERASURE
         * --------------------
         * - After compilation, Java removes type info.
         * - Box<Integer> and Box<String> both become Box (raw type).
         */
        Box<String> box1 = new Box<>("Test");
        Box<Integer> box2 = new Box<>(123);

        System.out.println(box1.getClass() == box2.getClass()); // true ✅

        /**
         * 💬 OUTPUT:
         * true
         *
         * 🧠 REASON:
         * Both look identical at runtime because <T> info is erased.
         */
    }
}

/**
 * 💡 SUMMARY
 * -----------
 * ✅ Generic Class → Reusable for different data types.
 * ✅ Generic Method → One method for all data types.
 * ✅ Type Erasure → Removes generic type info at runtime.
 */
