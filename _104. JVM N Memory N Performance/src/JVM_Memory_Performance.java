// 📁 File: JVM_Memory_Performance.java

/**
 * 🧠 WHAT YOU’LL LEARN
 * ---------------------
 * 1️⃣ What JVM (Java Virtual Machine) does
 * 2️⃣ How Java memory is divided (Heap, Stack, etc.)
 * 3️⃣ Garbage Collection (GC)
 * 4️⃣ Performance tuning basics
 */

public class JVM_Memory_Performance {
    public static void main(String[] args) {

        /**
         * ✅ 1️⃣ JVM — JAVA VIRTUAL MACHINE
         * ---------------------------------
         * 🧩 JVM is the engine that runs your Java code.
         * It converts **bytecode (.class)** into machine code your OS understands.
         *
         * 🔁 FLOW:
         *  Source Code (.java)
         *       ↓ compiled by javac
         *  Bytecode (.class)
         *       ↓ executed by JVM
         *  Machine Code (runs on CPU)
         *
         * 🧠 JVM also:
         *  - Manages memory automatically (no malloc/free)
         *  - Handles garbage collection
         *  - Provides a runtime for multithreading
         */


        /**
         * ✅ 2️⃣ JVM MEMORY AREAS
         * -----------------------
         * JVM divides memory into key sections:
         *
         * 1. 🧠 **Heap**
         *    - Stores objects (created with 'new').
         *    - Shared among all threads.
         *    - Cleaned by Garbage Collector.
         *
         * 2. 📦 **Stack**
         *    - Stores method calls and local variables.
         *    - Each thread has its own stack.
         *    - Automatically cleared when method finishes.
         *
         * 3. 🧮 **Method Area (Metaspace in Java 8+)**
         *    - Stores class definitions, static variables, and metadata.
         *
         * 4. 🧾 **PC Register**
         *    - Keeps track of which instruction a thread is executing.
         *
         * 5. ⚙️ **Native Method Stack**
         *    - Used when Java calls native (C/C++) code.
         */

        // 🧩 Example: simple object allocation
        Person p1 = new Person("Aman", 25); // stored in Heap
        p1.sayHello();

        /**
         * 💬 OUTPUT:
         * Hello, my name is Aman and I am 25
         *
         * 🧠 EXPLANATION:
         * - p1 reference → stored on Stack.
         * - new Person(...) object → stored on Heap.
         */


        /**
         * ✅ 3️⃣ GARBAGE COLLECTION (GC)
         * ------------------------------
         * - GC automatically frees memory of unreachable objects.
         * - You don’t delete manually (like in C++).
         *
         * Example: setting reference to null removes link to object,
         *          making it eligible for GC.
         */
        p1 = null; // eligible for Garbage Collection
        System.gc(); // request GC (no guarantee)
        System.out.println("GC requested ✅");

        /**
         * 💡 FUN FACT:
         * System.gc() only *suggests* GC — JVM decides when to run it.
         */


        /**
         * ✅ 4️⃣ PERFORMANCE TIPS
         * -----------------------
         * ⚙️ MEMORY:
         * - Prefer local variables (auto-cleared from Stack).
         * - Avoid creating too many short-lived objects.
         *
         * 🚀 THREADS:
         * - Reuse threads using ExecutorService (don’t create new ones in loops).
         *
         * 🧮 COLLECTIONS:
         * - Use proper size in ArrayList/HashMap to avoid resizing overhead.
         *
         * 🗑️ GC TUNING:
         * - JVM options like:
         *   `-Xms256m` (min heap)
         *   `-Xmx1024m` (max heap)
         *   control memory usage.
         */

        System.out.println("✅ JVM and Memory concepts demo completed!");
    }
}


/** 🧱 SIMPLE CLASS TO TEST MEMORY ALLOCATION **/
class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name; // stored on heap (part of object)
        this.age = age;
    }

    void sayHello() {
        System.out.println("Hello, my name is " + name + " and I am " + age);
    }

    @Override
    protected void finalize() {
        System.out.println("🧹 finalize() called before object deletion.");
    }
}


/**
 * 💡 SUMMARY
 * -----------
 * ✅ JVM runs your bytecode, manages memory & threads.
 * ✅ Heap → objects, Stack → local variables.
 * ✅ GC automatically removes unused objects.
 * ✅ Use memory wisely: reuse objects, avoid unnecessary allocations.
 */


/**
 * 🔹 MEMORY STRUCTURE TABLE
 * --------------------------
 * | Area               | Stores What?                     | Thread Shared? | Auto Managed? |
 * |--------------------|----------------------------------|----------------|----------------|
 * | Heap               | Objects, arrays                  | ✅ Yes          | ✅ Yes (GC)     |
 * | Stack              | Local vars, method calls         | ❌ No (per thread) | ✅ Yes       |
 * | Method Area        | Class info, static vars          | ✅ Yes          | ✅ Yes          |
 * | PC Register        | Current instruction pointer      | ❌ No           | ✅ Yes          |
 * | Native Method Stack| Native (C/C++) code frames       | ❌ No           | ✅ Yes          |
 */
