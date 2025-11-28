/*
 * File 7 — GenericsAbstractDemo.java
 *
 * 💡 GOAL:
 * Learn how to combine abstraction + generics to create reusable, type-safe code.
 *
 * 🧠 Real-world analogy:
 * Think of a generic repository (like a mini database service)
 * that can save or find ANY type of object — Users, Products, Orders, etc.
 */
// ✅ Step 2: Concrete subclass implementing generic abstract class
import java.util.*;

// ✅ Step 1: Define an abstract class with a type parameter <T>
abstract class Repository<T> {
    // Abstract methods define the blueprint
    public abstract void save(T entity);
    public abstract T findById(String id);
}

class InMemoryRepository<T> extends Repository<T> {
    private final Map<String, T> store = new HashMap<>();

    @Override
    public void save(T entity) {
        String id = UUID.randomUUID().toString(); // generate unique id
        store.put(id, entity);
        System.out.println("💾 Saved: " + entity + " (ID: " + id + ")");
    }

    @Override
    public T findById(String id) {
        return store.get(id); // may return null if not found
    }
}

// ✅ Step 3: Create a simple class to store
class User {
    private final String name;
    public User(String name) { this.name = name; }
    @Override
    public String toString() { return "User(" + name + ")"; }
}

// ✅ Step 4: Main class to test the generic abstract pattern
public class _7_GenericsAbstractDemo {
    public static void main(String[] args) {
        System.out.println("=== Generics + Abstract Class Demo ===");

        // Create a repository for User objects
        Repository<User> userRepo = new InMemoryRepository<>();

        // Save some users
        userRepo.save(new User("Aman"));
        userRepo.save(new User("Priya"));
        userRepo.save(new User("Ravi"));

        // Try finding a user (using random id to show null case)
        User found = userRepo.findById("123");
        System.out.println("Search result for ID 123 → " + found);
    }
}
