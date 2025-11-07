// File: _3_Garbage_Collection.java
// Topic: Garbage Collection (GC) in JVM — Working, Phases, Generations, Interview Notes
// 🧠 Garbage Collection (GC) is JVM’s automatic memory management system.
// It removes unused (unreachable) objects from the Heap to free space.

public class _3_Garbage_Collection {
    public static void main(String[] args) {
        System.out.println("🧹 JVM Garbage Collection — Notes Loaded!");
    }
}

/**
 * ============================================================
 * 🧠 WHAT IS GARBAGE COLLECTION?
 * ============================================================
 * Garbage Collection (GC) is the JVM’s automatic memory cleanup process.
 * It frees memory by removing objects that are **no longer referenced**.
 *
 * 💡 In Java, you don’t delete objects manually (no `free()` like C/C++).
 *     JVM’s GC automatically finds and removes unreferenced objects in Heap.
 *
 * ------------------------------------------------------------
 * 🔹 WHY IT’S NEEDED
 * ------------------------------------------------------------
 * • Prevents memory leaks.
 * • Reduces OutOfMemoryError.
 * • Keeps JVM memory healthy and efficient.
 *
 * ============================================================
 * 🔹 1️⃣ HOW GC WORKS (Simple Steps)
 * ============================================================
 * 1️⃣ Mark   → Identify all objects that are still reachable.
 * 2️⃣ Sweep  → Delete all unreachable objects.
 * 3️⃣ Compact → Reorganize memory to remove gaps (optional step).
 *
 * 💬 Example:
 *     MyClass obj = new MyClass();   // object in heap
 *     obj = null;                    // now unreachable → eligible for GC
 *
 * ============================================================
 * 🔹 2️⃣ GENERATIONAL GARBAGE COLLECTION
 * ============================================================
 *
 * 🎯 Simplified Meaning — “Generational Garbage Collection”
 * ------------------------------------------------------------
 * When the JVM runs your program, all objects you create using `new`
 * live in a special memory called the Heap.
 *
 * But not all objects live for the same amount of time:
 * • Some die quickly (like temporary variables inside a method),
 * • Some stay longer (like configuration or cache objects).
 *
 * To manage memory efficiently, the JVM divides the Heap into sections
 * (generations) depending on the **age of objects**.
 *
 * ------------------------------------------------------------
 * 🧩 GENERATIONS IN THE HEAP
 * ------------------------------------------------------------
 *        ┌────────────────────────────────────────────┐
 *        │                 HEAP                       │
 *        │────────────────────────────────────────────│
 *        │             YOUNG GENERATION                │
 *        │────────────────────────────────────────────│
 *        │   Eden Space   |   Survivor 0   |  Survivor 1
 *        │   (new objs)   |   (after GC)   |  (alternate)
 *        │────────────────────────────────────────────│
 *        │             OLD (TENURED) GENERATION        │
 *        │────────────────────────────────────────────│
 *        │   Long-lived objects (survived multiple GCs)
 *        │────────────────────────────────────────────│
 *        │             METASPACE (outside heap)        │
 *        │────────────────────────────────────────────│
 *        │   Class metadata (method info, constants)   │
 *        └────────────────────────────────────────────┘
 *
 * ------------------------------------------------------------
 * 💡 EXPLANATION (Step-by-step)
 * ------------------------------------------------------------
 * 1️⃣ YOUNG GENERATION  👶
 *     - New, short-lived objects are created here.
 *     - Divided into:
 *         • Eden Space → where all objects start their life.
 *         • Survivor 0 (S0) and Survivor 1 (S1) → for objects that survive GC.
 *     - When Eden fills up → Minor GC runs:
 *         → Deletes dead (unreachable) objects.
 *         → Moves surviving ones to Survivor spaces 0 and 1.
 *         → After surviving several Minor GCs → promoted to Old Generation.
 *
 * 2️⃣ OLD (TENURED) GENERATION  👴
 *     - Contains long-lived, stable objects (like caches or singletons).
 *     - When full → Major GC (Full GC) runs.
 *     - Major GC is slower since it scans more memory.
 *
 * 3️⃣ METASPACE (formerly Method Area / PermGen)  📘
 *     - Lives outside the Heap.
 *     - Stores:
 *         • Class metadata (class names, method info)
 *         • Static variables
 *         • Constant pool (e.g. string literals)
 *     - Since Java 8 → uses native memory (Metaspace) instead of Heap.
 *
 * ------------------------------------------------------------
 * ⚙️ SUMMARY TABLE
 * ------------------------------------------------------------
 * | Generation            | Stores                             | Trigger       | GC Type   | Speed  |
 * |-----------------------|------------------------------------|---------------|-----------|--------|
 * | Young Gen (Eden+S0/S1)| Newly created, short-lived objects | Eden full     | Minor GC  | Fast   |
 * | Old Gen (Tenured)     | Long-lived objects                 | Old gen full  | Major GC  | Slower |
 * | Metaspace             | Class metadata (outside heap)      | Full          | Not GC’d  | —      |
 *
 * ------------------------------------------------------------
 * 🧠 EASY ANALOGY — Heap as a Hostel 🏠
 * ------------------------------------------------------------
 * • Eden Room → New guests (objects), cleaned often (Minor GC)
 * • Survivor Rooms → Guests who extended their stay
 * • Old Block → Permanent residents (long-lived objects)
 * • Metaspace → Building information (class blueprints, not guests)
 *
 * ============================================================
 * 🔹 3️⃣ TYPES OF GARBAGE COLLECTORS (Java 8+)
 * ============================================================
 * | Collector | Description                        | Best For                    |
 * |------------|------------------------------------|------------------------------|
 * | Serial GC  | Single-threaded, simple            | Small apps, single CPU       |
 * | Parallel GC| Multi-threaded young GC            | General-purpose applications |
 * | CMS GC     | Concurrent Mark-Sweep, low pause   | Legacy apps (Java 6–8)       |
 * | G1 GC      | Region-based, balanced pauses      | Default since Java 9         |
 * | ZGC        | Ultra-low pause (sub-ms latency)   | Large memory systems         |
 *
 * ============================================================
 * 🔹 4️⃣ REQUESTING GC (Manually)
 * ============================================================
 * JVM decides *when* to run GC, but you can *suggest* it:
 *
 *     System.gc();                  // Suggests JVM to perform GC
 *     Runtime.getRuntime().gc();    // Same effect
 *
 * ⚠️ Not guaranteed — JVM may ignore it if not needed.
 *
 * ============================================================
 * 🔹 5️⃣ FINALIZATION (Deprecated Concept)
 * ============================================================
 * Older versions used:
 *     protected void finalize() { ... }
 * to clean up before deletion — but it’s **deprecated since Java 9+**.
 *
 * ✅ Instead, use `try-with-resources` or explicit `close()` methods.
 *
 *
 * ============================================================
 * 🔹 7️⃣ COMMON INTERVIEW QUESTIONS
 * ============================================================
 * 💬 Q: How does JVM decide an object is eligible for GC?
 *     → When no live reference exists to that object.
 *
 * 💬 Q: Difference between Minor GC and Major GC?
 *     → Minor → Cleans Young Gen (fast)
 *       Major → Cleans Old Gen (slow)
 *
 * 💬 Q: Can you force GC?
 *     → No, only suggest via System.gc().
 *
 * 💬 Q: Does GC collect static variables?
 *     → No. Static members live in Method Area until class unload.
 *
 * 💬 Q: What is a memory leak in Java?
 *     → When objects are still referenced unintentionally,
 *        preventing GC from cleaning them.
 *
 * ============================================================
 * 🔹 8️⃣ SUMMARY (Quick Revision)
 * ============================================================
 * ✅ GC automatically removes unreachable objects from Heap.
 * ✅ Works on Heap (not Stack/Method Area).
 * ✅ Two main types: Minor GC (Young) & Major GC (Old).
 * ✅ G1 GC → default since Java 9 (low pause, balanced).
 * ✅ System.gc() → for testing, not control.
 *
 * 💬 One-liner:
 * “Garbage Collection in JVM automatically removes unreachable
 *  objects from the Heap using Mark–Sweep–Compact algorithms,
 *  making Java memory management safe and efficient.”
 */
