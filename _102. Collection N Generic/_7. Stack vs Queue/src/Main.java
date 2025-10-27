// 📁 File: StackVsQueue.java
import java.util.*;

/**
 * 🧠 WHAT YOU’LL LEARN
 * ---------------------
 * 1️⃣ Difference between Stack and Queue
 * 2️⃣ How they store and process elements
 * 3️⃣ When to use each
 */

public class Main {
    public static void main(String[] args) {

        /**
         * ✅ 1️⃣ STACK (LIFO — Last In, First Out)
         * ----------------------------------------
         * ✔️ The last element added is the first one removed.
         * ✔️ Think of a stack of plates — last plate on top is removed first.
         * ✔️ Used in: function calls, undo operations, recursion.
         *
         * Common class: Stack<E> (from java.util)
         */
        Stack<String> stack = new Stack<>();
        stack.push("A");
        stack.push("B");
        stack.push("C");

        System.out.println("Stack: " + stack);
        System.out.println("Popped: " + stack.pop()); // removes top element
        System.out.println("After pop: " + stack);
        System.out.println("Top element (peek): " + stack.peek());

        /**
         * 💬 OUTPUT:
         * Stack: [A, B, C]
         * Popped: C
         * After pop: [A, B]
         * Top element (peek): B
         *
         * 🧠 EXPLANATION:
         * - push() → adds on top
         * - pop() → removes top
         * - peek() → checks top without removing
         * - Works in reverse order (LIFO)
         */


        /**
         * ✅ 2️⃣ QUEUE (FIFO — First In, First Out)
         * -----------------------------------------
         * ✔️ The first element added is the first one removed.
         * ✔️ Think of people in a line — first person goes first.
         * ✔️ Used in: scheduling, message queues, printer jobs.
         *
         * Common class: LinkedList<E> implements Queue<E>
         */
        Queue<String> queue = new LinkedList<>();
        queue.add("A");
        queue.add("B");
        queue.add("C");

        System.out.println("\nQueue: " + queue);
        System.out.println("Removed: " + queue.remove()); // removes front element
        System.out.println("After remove: " + queue);
        System.out.println("Front element (peek): " + queue.peek());

        /**
         * 💬 OUTPUT:
         * Queue: [A, B, C]
         * Removed: A
         * After remove: [B, C]
         * Front element (peek): B
         *
         * 🧠 EXPLANATION:
         * - add() → inserts at end
         * - remove() → removes from front
         * - peek() → checks front element
         * - Works in natural order (FIFO)
         */


        /**
         * 🧠 QUICK SUMMARY
         * ----------------
         * ✅ Stack → LIFO (last in, first out)
         * ✅ Queue → FIFO (first in, first out)
         */
    }
}


/**
 * 💡 COMPARISON TABLE
 * --------------------
 * | Feature              | Stack (LIFO)                  | Queue (FIFO)                 |
 * |----------------------|------------------------------|------------------------------|
 * | Order Type           | Last In → First Out           | First In → First Out         |
 * | Real-Life Example    | Stack of plates               | Line at ticket counter       |
 * | Main Methods         | push(), pop(), peek()         | add(), remove(), peek()      |
 * | Access Point         | One end (top)                 | Both ends (front & rear)     |
 * | Common Class         | Stack                         | LinkedList / ArrayDeque      |
 * | Used For             | Recursion, Undo, Parsing      | Scheduling, Queues, Buffers  |
 * | Speed                | ⚡ Fast (for top operations)   | ⚡ Fast (for front operations)|
 */
