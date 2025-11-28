// 📁 File: QueueTypes.java
import java.util.*;

/**
 * 🧠 WHAT YOU’LL LEARN
 * ---------------------
 * 1️⃣ Difference between Queue, Deque, and PriorityQueue
 * 2️⃣ How they store and process elements
 * 3️⃣ When to use each
 */

public class Main {
    public static void main(String[] args) {

        /**
         * ✅ 1️⃣ QUEUE
         * -------------
         * ✔️ Follows FIFO (First In, First Out)
         * ✔️ Add elements at the end → remove from front
         * ✔️ Used in task scheduling, buffering, etc.
         *
         * Common Implementations:
         * - LinkedList
         * - PriorityQueue
         */
        Queue<String> queue = new LinkedList<>();
        queue.add("Task1");
        queue.add("Task2");
        queue.add("Task3");

        System.out.println("Queue: " + queue);
        System.out.println("Removed: " + queue.remove()); // removes front
        System.out.println("After remove: " + queue);

        /**
         * 💬 OUTPUT:
         * Queue: [Task1, Task2, Task3]
         * Removed: Task1
         * After remove: [Task2, Task3]
         *
         * 🧠 EXPLANATION:
         * - Works like a line at a ticket counter.
         * - First added, first removed (FIFO).
         */


        /**
         * ✅ 2️⃣ DEQUE (Double Ended Queue)
         * ---------------------------------
         * ✔️ Can add/remove from BOTH ends.
         * ✔️ Supports FIFO and LIFO behavior.
         * ✔️ Used in stack-like or queue-like structures.
         *
         * Common Implementation: ArrayDeque
         */
        Deque<String> deque = new ArrayDeque<>();
        deque.addFirst("Front");
        deque.addLast("Back");

        System.out.println("Deque: " + deque);
        deque.removeFirst();
        deque.addFirst("NewFront");
        System.out.println("After operations: " + deque);

        /**
         * 💬 OUTPUT:
         * Deque: [Front, Back]
         * After operations: [NewFront, Back]
         *
         * 🧠 EXPLANATION:
         * - addFirst() / removeFirst() → front operations.
         * - addLast() / removeLast() → back operations.
         * - Can be used as a Stack or Queue easily.
         */


        /**
         * ✅ 3️⃣ PRIORITYQUEUE
         * --------------------
         * ✔️ Elements are ordered based on **priority** (natural order or custom comparator).
         * ✔️ NOT FIFO — smallest (or highest priority) element is removed first.
         * ✔️ Does NOT allow null elements.
         * ✔️ Commonly used in scheduling, heaps, Dijkstra’s algorithm, etc.
         */
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(50);
        pq.add(10);
        pq.add(30);

        System.out.println("PriorityQueue: " + pq);
        System.out.println("Removed (highest priority): " + pq.remove());
        System.out.println("After remove: " + pq);

        /**
         * 💬 OUTPUT (natural ascending order):
         * PriorityQueue: [10, 50, 30]
         * Removed (highest priority): 10
         * After remove: [30, 50]
         *
         * 🧠 EXPLANATION:
         * - Automatically arranges elements based on priority (min-heap by default).
         * - Not meant for ordered printing but for priority retrieval.
         */


        /**
         * 🧠 QUICK SUMMARY
         * ----------------
         * ✅ Queue → FIFO order.
         * ✅ Deque → Both ends, flexible.
         * ✅ PriorityQueue → Based on priority (not order of insertion).
         */
    }
}


/**
 * 💡 COMPARISON TABLE
 * --------------------
 * | Feature              | Queue                        | Deque (Double Ended Queue)     | PriorityQueue                |
 * |----------------------|------------------------------|--------------------------------|------------------------------|
 * | Order Type           | FIFO (First In First Out)     | FIFO or LIFO (both possible)   | Based on element priority    |
 * | Add/Remove From      | One end only                 | Both ends                     | Automatic order by priority  |
 * | Null Allowed?        | ✅ Yes (in LinkedList)        | ✅ Yes (in LinkedList)         | ❌ No                        |
 * | Maintains Insertion? | ✅ Yes                        | ✅ Yes                        | ❌ No (sorted internally)     |
 * | Common Classes       | LinkedList                   | ArrayDeque                    | PriorityQueue               |
 * | Speed                | ⚡ Fast                       | ⚡ Fast                        | ⚡ Depends on heap operations |
 * | Best Use Case        | Task queue, buffering         | Stack/Undo systems             | Scheduling, shortest jobs    |
 */
