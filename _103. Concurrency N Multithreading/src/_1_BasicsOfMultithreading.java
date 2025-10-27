// 📁 File: BasicsOfMultithreading.java
/**
 * 🧠 WHAT YOU’LL LEARN
 * ---------------------
 * 1️⃣ What is Thread
 * 2️⃣ How to create threads (2 ways)
 * 3️⃣ What is Concurrency vs Parallelism
 * 4️⃣ Simple output demo
 */

public class _1_BasicsOfMultithreading {
    public static void main(String[] args) {

        /**
         * ✅ 1️⃣ WHAT IS A THREAD?
         * ------------------------
         * - A thread is a small unit of a program that runs independently.
         * - Every Java program starts with ONE main thread:
         *   👉 The one that runs main().
         * - We can create more threads to do multiple tasks at the same time.
         *
         * Example: Download a file + show progress bar simultaneously.
         */

        /**
         * ✅ 2️⃣ WAY 1 — EXTEND THREAD CLASS
         * ---------------------------------
         * Create a class that extends Thread and override run().
         */
        class MyThread extends Thread {
            public void run() {
                for (int i = 1; i <= 3; i++) {
                    System.out.println("MyThread running... step " + i);
                }
            }
        }

        MyThread t1 = new MyThread(); // create thread object
        t1.start(); // start executes run() in a new thread

        /**
         * 🧠 EXPLANATION:
         * - start() → launches a new thread.
         * - run() → actual code executed inside that thread.
         * - If you call run() directly, it runs in main thread (❌).
         */


        /**
         * ✅ 3️⃣ WAY 2 — IMPLEMENT RUNNABLE INTERFACE
         * --------------------------------------------
         * This is the preferred modern way.
         */
        class MyRunnable implements Runnable {
            public void run() {
                for (int i = 1; i <= 3; i++) {
                    System.out.println("Runnable thread step " + i);
                }
            }
        }

        Thread t2 = new Thread(new MyRunnable()); // pass runnable to thread
        t2.start();

        /**
         * 💬 OUTPUT (order may vary):
         * MyThread running... step 1
         * Runnable thread step 1
         * MyThread running... step 2
         * Runnable thread step 2
         * ...
         *
         * 🧠 REASON:
         * - Both threads run **concurrently** (mixed order).
         * - Java decides the scheduling — so order isn’t fixed.
         */


        /**
         * ✅ 4️⃣ CONCURRENCY vs PARALLELISM
         * ---------------------------------
         * 🌀 Concurrency: Two tasks appear to run at same time (by switching fast).
         * ⚡ Parallelism: Two tasks actually run at same time (on multiple cores).
         *
         * Example:
         * - Concurrency → 1 core sharing time.
         * - Parallelism → 2 cores running together.
         */
    }
}

/**
 * 💡 SUMMARY
 * -----------
 * ✅ Thread → independent path of execution.
 * ✅ Two ways to create threads → extend Thread OR implement Runnable.
 * ✅ start() → launches new thread.
 * ✅ run() → contains task code.
 * ✅ Concurrency = illusion of simultaneity; Parallelism = true simultaneity.
 */
