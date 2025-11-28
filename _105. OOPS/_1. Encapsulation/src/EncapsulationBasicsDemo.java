/*
 * File 1 — EncapsulationBasicsDemo.java
 *
 * 💡 GOAL:
 * Demonstrate encapsulation — hiding data (fields) and providing controlled access
 * through public methods (getters & setters).
 *
 * 🧠 Concept:
 * - Keep fields PRIVATE so outside classes can't modify them directly.
 * - Expose PUBLIC methods to read/change values safely.
 * - This helps control, validate, and protect internal state.
 */

class BankAccount {
    // private = hidden data
    private String accountHolder;
    private double balance;

    // constructor
    public BankAccount(String accountHolder, double balance) {
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    // getter → read value
    public String getAccountHolder() {
        return accountHolder;
    }

    // setter → modify value (with validation)
    public void setAccountHolder(String name) {
        if (name == null || name.isBlank())
            System.out.println("❌ Invalid name");
        else
            this.accountHolder = name;
    }

    // getter for balance
    public double getBalance() {
        return balance;
    }

    // setter with validation logic
    public void setBalance(double amount) {
        if (amount < 0)
            System.out.println("❌ Balance can't be negative!");
        else
            this.balance = amount;
    }
}

public class EncapsulationBasicsDemo {
    public static void main(String[] args) {
        BankAccount acc = new BankAccount("Aman", 5000);

        // accessing via methods (not directly)
        System.out.println("Holder: " + acc.getAccountHolder());
        System.out.println("Balance: " + acc.getBalance());

        acc.setBalance(-200); // invalid
        acc.setBalance(8000); // valid
        System.out.println("Updated Balance: " + acc.getBalance());
    }
}

/*
Output:
Holder: Aman
Balance: 5000.0
❌ Balance can't be negative!
Updated Balance: 8000.0

Explanation:
• Fields are private → cannot be accessed directly (e.g. acc.balance ❌).
• Getters and setters allow controlled, validated access.
• Encapsulation = data hiding + safe access.
*/
