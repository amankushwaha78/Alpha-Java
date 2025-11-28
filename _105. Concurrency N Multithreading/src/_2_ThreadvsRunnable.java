/**
 * 🧠 WHAT YOU’LL LEARN
 * ---------------------
 * 1️⃣ Thread vs Runnable
 * 2️⃣ Why "implements Runnable" is preferred over "extends Thread"
 * 3️⃣ How Runnable works better with Executors (thread pools)
 */

public class _2_ThreadvsRunnable {
    public static void main(String[] args) {

        /**
         * ✅ 1️⃣ EXTENDING THREAD CLASS
         * ------------------------------
         * - You create a subclass of Thread and override run().
         * - Not flexible — you cannot extend any other class (Java allows only single inheritance).
         */
        class MyThread extends Thread {
            public void run() {
                System.out.println("Running by extending Thread — " + Thread.currentThread().getName());
            }
        }

        MyThread t1 = new MyThread();
        t1.start(); // starts a new thread


        /**
         * ✅ 2️⃣ IMPLEMENTING RUNNABLE INTERFACE (PREFERRED ✅)
         * ----------------------------------------------------
         * - Runnable separates the "task" from the "thread".
         * - You can reuse the same Runnable object in different threads or executors.
         * - Better for large applications and thread pools.
         */
        class MyRunnable implements Runnable {
            public void run() {
                System.out.println("Running by implementing Runnable — " + Thread.currentThread().getName());
            }
        }

        Thread t2 = new Thread(new MyRunnable());
        t2.start();


        /**
         * ✅ 3️⃣ USING LAMBDA (MODERN SHORTCUT)
         * -------------------------------------
         * Runnable is a functional interface (one abstract method),
         * so you can write it using a lambda expression.
         */
        Runnable task = () -> System.out.println("Running via lambda Runnable — " + Thread.currentThread().getName());
        new Thread(task).start();


        /**
         * ✅ 4️⃣ SUBMITTING RUNNABLE TO EXECUTOR (PROFESSIONAL WAY)
         * ----------------------------------------------------------
         * - ExecutorService manages a pool of threads for you.
         * - You just submit tasks (Runnable or Callable).
         * - No need to manually create or start threads.
         */
        java.util.concurrent.ExecutorService executor = java.util.concurrent.Executors.newFixedThreadPool(2);
        executor.submit(new MyRunnable());
        executor.submit(() -> System.out.println("Task 2 via Executor — " + Thread.currentThread().getName()));
        executor.shutdown();

        /**
         * 💬 POSSIBLE OUTPUT (order varies):
         * Running by extending Thread — Thread-0
         * Running by implementing Runnable — Thread-1
         * Running via lambda Runnable — Thread-2
         * Running by implementing Runnable — pool-1-thread-1
         * Task 2 via Executor — pool-1-thread-2
         */
    }
}


/**
 * 💡 COMPARISON TABLE
 * --------------------
 * | Feature                | Extends Thread                    | Implements Runnable (Preferred)     |
 * |------------------------|-----------------------------------|------------------------------------|
 * | Inheritance Limitation | ❌ Can't extend other classes      | ✅ Can implement multiple interfaces |
 * | Code Reusability       | ❌ Tightly coupled task + thread   | ✅ Task and thread separate         |
 * | Used With Executors    | ❌ No                             | ✅ Yes (submit Runnable)            |
 * | Recommended For        | Small/simple programs             | Large, scalable applications       |
 * | Syntax                 | class MyThread extends Thread     | class MyTask implements Runnable   |
 */

