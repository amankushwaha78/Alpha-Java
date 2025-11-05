// 🔹 File: ControlFlowDemo.java
// This file demonstrates all major control flow statements in Java:
// if–else, switch, for, while, break, and continue.

public class Main {
    public static void main(String[] args) {

        // ---------------------------
        // 🧩 1️⃣ IF – ELSE
        // ---------------------------
        int age = 20; // variable storing age

        // Check if person is adult or minor
        if (age >= 18) {
            System.out.println("✅ You are an adult.");
        } else {
            System.out.println("❌ You are a minor.");
        }

        // ---------------------------
        // 🧩 2️⃣ SWITCH STATEMENT
        // ---------------------------
        int day = 3; // Example: 1=Monday, 2=Tuesday, 3=Wednesday

        switch (day) {
            case 1 -> {
                System.out.println("🌞 Today is Monday");
                System.out.println("Start your week strong!");
            }
            case 2 -> System.out.println("Today is Tuesday");
            case 3 -> System.out.println("Today is Wednesday");
            case 4 -> System.out.println("Today is Thursday");
            case 5 -> System.out.println("Today is Friday");
            case 6 -> System.out.println("Today is Saturday");
            case 7 -> System.out.println("Today is Sunday");
            default -> System.out.println("Invalid day number");
        }

        // ---------------------------
        // 🧩 3️⃣ FOR LOOP
        // ---------------------------
        // Print numbers 1 to 5 using for loop
        for (int i = 1; i <= 5; i++) { // start=1; stop=5; step=+1
            System.out.println("For loop count: " + i);
        }

        // ---------------------------
        // 🧩 4️⃣ WHILE LOOP
        // ---------------------------
        int count = 1; // initialize counter
        while (count <= 3) { // condition check before loop
            System.out.println("While loop count: " + count);
            count++; // increment counter
        }

        // ---------------------------
        // 🧩 5️⃣ BREAK and CONTINUE
        // ---------------------------
        for (int j = 1; j <= 5; j++) {
            if (j == 2) {
                System.out.println("🚫 Skipping number 2 using continue");
                continue; // skips this iteration
            }
            if (j == 4) {
                System.out.println("⛔ Breaking at number 4");
                break; // stops loop completely
            }
            System.out.println("Loop iteration: " + j);
        }

        System.out.println("🎯 Program ended successfully.");
    }
}


/*
🧩 Older Java (< 14) syntax :
    You would instead write:
switch (day) {
    case 1:
        System.out.println("🌞 Today is Monday");
        System.out.println("Start your week strong!");
        break;
    case 2:
        System.out.println("🌤 Today is Tuesday");
        System.out.println("Keep going!");
        break;
    default:
        System.out.println("❓ Unknown day");
}

 */