// File: _4_ClassLoadingMechanism.java
// Topic: Class Loading Mechanism in JVM — Loading, Linking, Initialization
// 🧠 Explains how JVM loads .class files into memory before execution.

/**
 * ============================================================
 * 🧠 What is Class Loading?
 * ============================================================
 * The **Class Loading Mechanism** is the process by which the JVM
 * loads `.class` files (bytecode) into memory so that they can be executed.
 *
 * 📘 Flow:
 *    Source Code (.java) → Compiled (.class) → JVM loads into memory → Executes
 *
 * Every Java class must be **loaded**, **linked**, and **initialized**
 * before it can be used.
 *
 * ============================================================
 * 🔹 1️⃣ Phases of Class Loading
 * ============================================================
 * The class loading process has 3 main steps:
 *
 *   1️⃣ Loading
 *   2️⃣ Linking
 *   3️⃣ Initialization
 *
 * ------------------------------------------------------------
 * 1️⃣ LOADING
 * ------------------------------------------------------------
 * • The `.class` file (bytecode) is read by the JVM’s **ClassLoader**.
 * • It brings the class definition into memory.
 * • Creates an object of type `Class` in the **Method Area**.
 *
 * 🔹 Example:
 *     ClassLoader loads “Student.class” when we first use:
 *         new Student();
 *
 * ------------------------------------------------------------
 * 2️⃣ LINKING
 * ------------------------------------------------------------
 * • The JVM verifies and prepares the loaded class before execution.
 *
 * 🔸 Sub-steps of Linking:
 *    1. Verification — Ensures bytecode is safe & valid.
 *    2. Preparation  — Allocates memory for static fields, sets defaults.
 *    3. Resolution   — Converts symbolic references → direct memory addresses.
 *
 * Example:
 *     int count = 5;  // during preparation, memory allocated with default 0
 *
 * ------------------------------------------------------------
 * 3️⃣ INITIALIZATION
 * ------------------------------------------------------------
 * • Executes all static blocks and assigns final values to static variables.
 * • Runs in top-down order, following class hierarchy.
 *
 * Example:
 *     static int x = 10;
 *     static { System.out.println("Class initialized"); }
 *
 * When the class is first used → initialization happens.
 *
 * ============================================================
 * 🔹 2️⃣ ClassLoader Hierarchy
 * ============================================================
 * JVM uses **three main ClassLoaders** in a parent-child hierarchy:
 *
 *   1️⃣ Bootstrap ClassLoader
 *        → Loads core Java classes (java.lang.*, java.util.*, etc.)
 *        → Implemented in native code (C/C++).
 *
 *   2️⃣ Extension (Platform) ClassLoader
 *        → Loads classes from `ext` or `jre/lib/ext` directory.
 *
 *   3️⃣ Application (System) ClassLoader
 *        → Loads user-defined classes from the classpath.
 *
 * 📘 Hierarchy (Parent Delegation Model):
 *
 *     ApplicationClassLoader
 *           ↑
 *     ExtensionClassLoader
 *           ↑
 *     BootstrapClassLoader
 *
 * 💡 Delegation Process:
 *     When ApplicationClassLoader is asked to load a class:
 *       → It first asks its parent (ExtensionLoader)
 *       → Which asks Bootstrap
 *       → If not found anywhere, it loads it itself.
 *
 * ✅ This prevents multiple copies of the same core class being loaded.
 *
 * ============================================================
 * 🔹 3️⃣ Custom ClassLoader
 * ============================================================
 * • You can create your own ClassLoader by extending `ClassLoader`.
 * • Useful for:
 *      - Loading classes from network or encrypted files.
 *      - Plugin architectures (e.g., Tomcat, Spring Boot).
 *
 * Example:
 *     class MyLoader extends ClassLoader {
 *         @Override
 *         public Class<?> findClass(String name) {
 *             // custom logic to read bytes and define class
 *             return defineClass(name, byteCode, 0, byteCode.length);
 *         }
 *     }
 *
 * ============================================================
 * 🔹 4️⃣ When Class is Loaded (Triggered Events)
 * ============================================================
 * A class is loaded by JVM when:
 *   • You create an object with `new`
 *   • You access a static field or method
 *   • You call `Class.forName("MyClass")`
 *   • You load it manually via a custom ClassLoader
 *
 * ============================================================
 * 🔹 5️⃣ Unloading Classes
 * ============================================================
 * • The JVM unloads classes when:
 *      → The ClassLoader that loaded them becomes unreachable.
 * • Usually happens only in custom or dynamic class loading scenarios.
 *
 * ⚠️ Classes loaded by the system classloader (like main classes)
 *     stay in memory until JVM shutdown.
 *
 * ============================================================
 * 🔹 6️⃣ Diagram — Class Loading Lifecycle
 * ============================================================
 *
 *        ┌─────────────────────────────┐
 *        │      Class Loading          │
 *        │  (via ClassLoader)          │
 *        └─────────────┬───────────────┘
 *                      ↓
 *        ┌─────────────────────────────┐
 *        │        Linking              │
 *        │ Verify → Prepare → Resolve  │
 *        └─────────────┬───────────────┘
 *                      ↓
 *        ┌─────────────────────────────┐
 *        │      Initialization         │
 *        │ (Static blocks, vars init)  │
 *        └─────────────┬───────────────┘
 *                      ↓
 *        ┌─────────────────────────────┐
 *        │         Execution           │
 *        │ (Objects, Methods, GC etc.) │
 *        └─────────────────────────────┘
 *
 * ============================================================
 * 🔹 7️⃣ Quick Interview Summary
 * ============================================================
 * ✅ ClassLoader loads .class files into JVM memory.
 * ✅ Phases → Loading → Linking → Initialization.
 * ✅ ClassLoader types → Bootstrap, Extension, Application.
 * ✅ Delegation model ensures no duplicate core classes.
 * ✅ finalize() no longer used — rely on GC & AutoCloseable.
 *
 * 💬 One-liner:
 *   “JVM loads classes lazily through ClassLoaders, verifies and links them,
 *    then initializes static members before execution — ensuring safety,
 *    reusability, and memory efficiency.”
 */
