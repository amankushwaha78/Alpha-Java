// ============================================================
// 🧩 9️⃣ finalize() and System.gc()
// ============================================================

/**
 * ------------------------------------------------------------
 * 🔹 finalize() — OLD WAY (Now Deprecated)
 * ------------------------------------------------------------
 * • The `finalize()` method was used in early Java versions to clean up
 *   resources (like closing files or network sockets) before an object
 *   was destroyed by the Garbage Collector (GC).
 *
 *     class MyClass {
 *         @Override
 *         protected void finalize() throws Throwable {
 *             System.out.println("Finalize called before GC!");
 *         }
 *     }
 *
 * 💡 But it had major problems:
 *   - ❌ No guarantee when or even if it will run.
 *   - ❌ Could cause memory leaks (if GC delayed).
 *   - ❌ Deprecated in Java 9 (JEP 421) due to unreliability.
 *
 * ✅ Modern alternative:
 *   → Use try-with-resources or explicit close() methods.
 *   → Example:
 *       try (FileInputStream fis = new FileInputStream("data.txt")) {
 *           // use file
 *       }  // auto-closed safely here
 *
 * ------------------------------------------------------------
 * 🔹 System.gc() — SUGGESTS Garbage Collection
 * ------------------------------------------------------------
 * • The call `System.gc()` (or `Runtime.getRuntime().gc()`)
 *   only **requests** the JVM to start Garbage Collection.
 *
 * • The JVM *may* choose to run GC — but it’s **not guaranteed**.
 *
 * Example:
 *     MyClass obj = new MyClass();
 *     obj = null;
 *     System.gc(); // suggests GC
 *     // finalize() (if overridden) may run *sometime later*.
 *
 * ⚙️ Internal Process:
 *   1️⃣ JVM sees the GC request.
 *   2️⃣ Marks unreachable objects.
 *   3️⃣ Sweeps and reclaims memory (maybe immediately, maybe later).
 *
 * ------------------------------------------------------------
 * 💡 Interview Summary
 * ------------------------------------------------------------
 * ✅ finalize() → deprecated cleanup hook (unreliable, slow)
 * ✅ System.gc() → suggests GC run (not guaranteed)
 * ✅ Modern Java → Use AutoCloseable / try-with-resources
 * ✅ JVM automatically handles GC efficiently — manual calls rarely needed.
 *
 * ------------------------------------------------------------
 * 💬 Example Output:
 * ------------------------------------------------------------
 *     class Demo {
 *         @Override
 *         protected void finalize() {
 *             System.out.println("Finalize called!");
 *         }
 *     }
 *
 *     public static void main(String[] args) {
 *         Demo d = new Demo();
 *         d = null;
 *         System.gc();
 *         System.out.println("Main done");
 *     }
 *
 * 👉 Possible Output:
 *     Main done
 *     Finalize called!   (order not guaranteed)
 *
 * ⚠️ Why? Because GC runs asynchronously.
 */
