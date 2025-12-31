/**
 * 📌 IMPORTANT MULTITHREADING INTERVIEW FAVORITES
 *
 * Covers:
 * 1️⃣1️⃣ Deadlock
 * 1️⃣2️⃣ Deadlock conditions
 * 1️⃣3️⃣ Deadlock avoidance
 * 1️⃣4️⃣ volatile keyword
 * 1️⃣5️⃣ volatile vs synchronized
 *
 * =====================================================
 * 🧪 EXPECTED OUTPUT (ORDER MAY VARY SLIGHTLY)
 * =====================================================
 *
 * ---- DEADLOCK DEMO ----
 * Thread-1 acquired LockA
 * Thread-2 acquired LockB
 * Thread-1 waiting for LockB
 * Thread-2 waiting for LockA
 *
 * ❌ Program STUCK here (DEADLOCK)
 *
 * ---- DEADLOCK FREE (LOCK ORDERING) ----
 * Thread-3 acquired LockA
 * Thread-3 acquired LockB
 * Thread-4 acquired LockA
 * Thread-4 acquired LockB
 * ✅ No deadlock
 *
 * ---- VOLATILE DEMO ----
 * Worker thread started
 * Main thread updated flag
 * Worker thread stopped
 * =====================================================
 */

public class _4_Deadlock_Volatile_Synchronization_Demo {

    /* =====================================================
     * 1️⃣4️⃣ volatile variable
     * ===================================================== */
    static volatile boolean flag = true;

    public static void main(String[] args) throws InterruptedException {

        /* =====================================================
         * 1️⃣1️⃣ DEADLOCK EXAMPLE (PROBLEM)
         * ===================================================== */

        Object lockA = new Object();
        Object lockB = new Object();

        Thread t1 = new Thread(() -> {
            synchronized (lockA) {
                System.out.println("Thread-1 acquired LockA");
                // OUTPUT: Thread-1 acquired LockA

                try { Thread.sleep(100); } catch (Exception e) {}

                System.out.println("Thread-1 waiting for LockB");
                // OUTPUT: Thread-1 waiting for LockB

                synchronized (lockB) {
                    System.out.println("Thread-1 acquired LockB");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (lockB) {
                System.out.println("Thread-2 acquired LockB");
                // OUTPUT: Thread-2 acquired LockB

                try { Thread.sleep(100); } catch (Exception e) {}

                System.out.println("Thread-2 waiting for LockA");
                // OUTPUT: Thread-2 waiting for LockA

                synchronized (lockA) {
                    System.out.println("Thread-2 acquired LockA");
                }
            }
        });

        t1.start();
        t2.start();

        Thread.sleep(1000);

        /*
         * ❌ DEADLOCK HAPPENS HERE
         * Thread-1 holds LockA → waits for LockB
         * Thread-2 holds LockB → waits for LockA
         */


        /* =====================================================
         * 1️⃣3️⃣ DEADLOCK AVOIDANCE (LOCK ORDERING)
         * ===================================================== */

        Object lockX = new Object();
        Object lockY = new Object();

        Thread t3 = new Thread(() -> {
            synchronized (lockX) {
                System.out.println("Thread-3 acquired LockA");
                // OUTPUT: Thread-3 acquired LockA

                synchronized (lockY) {
                    System.out.println("Thread-3 acquired LockB");
                    // OUTPUT: Thread-3 acquired LockB
                }
            }
        });

        Thread t4 = new Thread(() -> {
            synchronized (lockX) { // SAME ORDER ✔
                System.out.println("Thread-4 acquired LockA");
                // OUTPUT: Thread-4 acquired LockA

                synchronized (lockY) {
                    System.out.println("Thread-4 acquired LockB");
                    // OUTPUT: Thread-4 acquired LockB
                }
            }
        });

        t3.start();
        t4.start();

        t3.join();
        t4.join();

        System.out.println("✅ No deadlock");
        // OUTPUT: ✅ No deadlock


        /* =====================================================
         * 1️⃣4️⃣ VOLATILE KEYWORD DEMO
         * ===================================================== */

        Thread worker = new Thread(() -> {
            System.out.println("Worker thread started");
            // OUTPUT: Worker thread started

            while (flag) {
                // busy waiting until flag becomes false
            }

            System.out.println("Worker thread stopped");
            // OUTPUT: Worker thread stopped
        });

        worker.start();

        Thread.sleep(1000);

        System.out.println("Main thread updated flag");
        // OUTPUT: Main thread updated flag

        flag = false;

        worker.join();
    }
}
