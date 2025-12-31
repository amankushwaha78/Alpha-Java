/**
 * 📌 CORE MULTITHREADING CONCEPTS DEMO
 *
 * This single file demonstrates:
 * 6️⃣ start() vs run()
 * 7️⃣ Thread lifecycle
 * 8️⃣ Race condition
 * 9️⃣ How to prevent race condition
 * 🔟 Synchronization
 *
 * ---------------------------------------------------
 * 🧪 EXPECTED OUTPUT (order may vary for threads):
 *
 * Running thread name: main
 * After run(), current thread: main
 * Running thread name: Thread-0
 *
 * State before start(): NEW
 * State after start(): RUNNABLE
 * Lifecycle thread running
 * State after completion: TERMINATED
 *
 * Final count (race condition): 1834   // (can vary, NOT always 2000 ❌)
 * Final count (synchronized): 2000     // always correct ✅
 * ---------------------------------------------------
 */

public class _3_CoreMultithreadingConceptsDemo {

    public static void main(String[] args) throws InterruptedException {

        /* =====================================================
         * 6️⃣ start() vs run()
         * ===================================================== */

        Thread demoThread = new Thread(() -> {
            System.out.println("Running thread name: "
                    + Thread.currentThread().getName());
        });

        // ❌ run() — normal method call (runs in main thread)
        demoThread.run();

        // OUTPUT:
        // Running thread name: main

        System.out.println("After run(), current thread: "
                + Thread.currentThread().getName());

        // OUTPUT:
        // After run(), current thread: main

        // ✅ start() — creates NEW thread
        demoThread.start();

        // OUTPUT (from new thread):
        // Running thread name: Thread-0


        /* =====================================================
         * 7️⃣ THREAD LIFECYCLE
         * =====================================================
         *
         * NEW        → Thread object created
         * RUNNABLE   → start() called
         * TIMED_WAITING → sleep()
         * TERMINATED → execution finished
         */

        Thread lifecycleThread = new Thread(() -> {
            try {
                System.out.println("Lifecycle thread running");

                // Moves thread to TIMED_WAITING
                Thread.sleep(1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // Thread object created but not started
        System.out.println("State before start(): "
                + lifecycleThread.getState());

        // OUTPUT:
        // State before start(): NEW

        lifecycleThread.start();

        System.out.println("State after start(): "
                + lifecycleThread.getState());

        // OUTPUT:
        // State after start(): RUNNABLE

        // main thread waits (WAITING state internally)
        lifecycleThread.join();

        System.out.println("State after completion: "
                + lifecycleThread.getState());

        // OUTPUT:
        // Lifecycle thread running
        // State after completion: TERMINATED


        /* =====================================================
         * 8️⃣ RACE CONDITION (PROBLEM)
         * ===================================================== */

        Counter counter = new Counter(); // shared object

        Thread t1 = new Thread(() -> counter.increment());
        Thread t2 = new Thread(() -> counter.increment());

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        // ❌ Expected = 2000
        // ❌ Actual result may be LESS due to race condition
        System.out.println("Final count (race condition): "
                + counter.count);

        // OUTPUT (varies every run):
        // Final count (race condition): 1765
        // Final count (race condition): 1892
        // Final count (race condition): 1998


        /* =====================================================
         * 9️⃣ + 🔟 SYNCHRONIZATION (SOLUTION)
         * ===================================================== */

        SafeCounter safeCounter = new SafeCounter();

        Thread t3 = new Thread(() -> safeCounter.increment());
        Thread t4 = new Thread(() -> safeCounter.increment());

        t3.start();
        t4.start();

        t3.join();
        t4.join();

        // ✅ Always correct because of synchronization
        System.out.println("Final count (synchronized): "
                + safeCounter.count);

        // OUTPUT:
        // Final count (synchronized): 2000
    }
}

/* =====================================================
 * 8️⃣ RACE CONDITION CLASS
 * ===================================================== */
class Counter {
    int count = 0; // shared mutable data

    void increment() {
        for (int i = 0; i < 1000; i++) {
            count++; // ❌ NOT thread-safe
        }
    }
}

/* =====================================================
 * 🔟 SYNCHRONIZED VERSION (THREAD-SAFE)
 * ===================================================== */
class SafeCounter {
    int count = 0;

    synchronized void increment() {
        for (int i = 0; i < 1000; i++) {
            count++; // ✅ only one thread at a time
        }
    }
}
