// ============================================================
// 🧩 🔟 Memory Leaks & OutOfMemoryError
// ============================================================

/**
 * ------------------------------------------------------------
 * 💡 WHAT IS A MEMORY LEAK IN JAVA?
 * ------------------------------------------------------------
 * • A memory leak happens when objects are **no longer useful**
 *   but are still **referenced somewhere**, preventing GC from reclaiming them.
 *
 * • In simple words:
 *      → The object is *logically dead* but *still reachable*.
 *      → JVM thinks it’s needed → GC never collects it → memory fills up.
 *
 * ------------------------------------------------------------
 * 🧠 EXAMPLE OF MEMORY LEAK
 * ------------------------------------------------------------
 *     import java.util.*;
 *     class LeakDemo {
 *         static List<String> cache = new ArrayList<>();
 *
 *         public static void main(String[] args) {
 *             for (int i = 0; i < 1000000; i++) {
 *                 cache.add("data-" + i);
 *             }
 *         }
 *     }
 *
 * 🔍 What happens:
 *     • The static list `cache` keeps growing.
 *     • Even when loop ends, `cache` still references all Strings.
 *     • GC cannot reclaim them → memory leak.
 *
 * ⚠️ Eventually leads to:
 *     → java.lang.OutOfMemoryError: Java heap space
 *
 * ------------------------------------------------------------
 * 💬 Common Causes of Memory Leaks
 * ------------------------------------------------------------
 * 1️⃣ Static Collections (List, Map) that grow endlessly.
 * 2️⃣ Unclosed resources — file, DB, socket, stream.
 * 3️⃣ Listeners or callbacks not removed.
 * 4️⃣ Inner classes holding outer class references.
 * 5️⃣ Poor caching (never removing old objects).
 *
 * ------------------------------------------------------------
 * 💡 HOW TO FIX MEMORY LEAKS
 * ------------------------------------------------------------
 * ✅ Always close resources (use try-with-resources).
 * ✅ Remove unused listeners or references.
 * ✅ Use WeakReference or SoftReference where applicable.
 * ✅ Clear collections when not needed.
 * ✅ Use profiling tools (VisualVM, JProfiler, Eclipse MAT) to detect leaks.
 *
 * ------------------------------------------------------------
 * 🚨 OutOfMemoryError (OOM)
 * ------------------------------------------------------------
 * • Thrown when JVM cannot allocate memory anymore.
 *
 * 🔹 Common OOM Types:
 *   - java.lang.OutOfMemoryError: Java heap space
 *       → Heap full (usually memory leak).
 *
 *   - java.lang.OutOfMemoryError: Metaspace
 *       → Too many loaded classes (method area full).
 *
 *   - java.lang.OutOfMemoryError: GC overhead limit exceeded
 *       → GC is running too often but freeing very little.
 *
 *   - java.lang.OutOfMemoryError: Direct buffer memory
 *       → Too many direct ByteBuffers (off-heap memory).
 *
 * ------------------------------------------------------------
 * 💬 Prevention Tips
 * ------------------------------------------------------------
 * ✅ Monitor memory with `jconsole`, `VisualVM`, or `jstat`.
 * ✅ Increase heap with JVM args:
 *       -Xms512m  -Xmx1024m
 * ✅ Use object pooling cautiously.
 * ✅ Regularly profile apps for leaks.
 *
 * ------------------------------------------------------------
 * 💬 Interview Summary
 * ------------------------------------------------------------
 * ✅ Memory Leak → object still referenced → GC can’t clean.
 * ✅ OOM → JVM out of memory (Heap/Metaspace full).
 * ✅ Causes → static refs, unclosed resources, bad caching.
 * ✅ Fix → release references, close resources, profile memory.
 *
 * ------------------------------------------------------------
 * 🧠 Quick Analogy
 * ------------------------------------------------------------
 * Think of JVM memory like a fridge:
 * • Memory leak → you keep spoiled food but never throw it away.
 * • OOM → fridge full → can’t store new food.
 */
