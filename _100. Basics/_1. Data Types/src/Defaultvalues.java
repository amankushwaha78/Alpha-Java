/*
🎯 6️⃣ Summary — Default Values of Data Types
---------------------------------------------------
When variables are declared as **class fields** (not inside a method),
Java automatically assigns them **default values**.

⚠️ Local variables (inside methods) have **no default values** —
they must be explicitly initialized before use.

---------------------------------------------------
| Type                    | Example                | Default Value | Category   |
|--------------------------|------------------------|----------------|-------------|
| byte, short, int, long   | int age = 25;          | 0              | Numeric     |
| float, double            | double price = 99.99;  | 0.0            | Decimal     |
| char                     | char grade = 'A';      | '\u0000' (blank)| Character  |
| boolean                  | boolean isActive = true;| false         | Logical     |
| String, Array, Object    | String s = "Aman";     | null           | Reference   |
*/

public class Defaultvalues {
    // 🔹 Class-level variables (to show default values)
    static byte b;
    static short s;
    static int i;
    static long l;
    static float f;
    static double d;
    static char c;
    static boolean flag;
    static String name;
    static int[] arr;
    static MyClass2 obj;

    public static void main(String[] args) {

        System.out.println("byte default: " + b);          // Output → 0
        System.out.println("short default: " + s);         // Output → 0
        System.out.println("int default: " + i);           // Output → 0
        System.out.println("long default: " + l);          // Output → 0
        System.out.println("float default: " + f);         // Output → 0.0
        System.out.println("double default: " + d);        // Output → 0.0
        System.out.println("char default: '" + c + "'");   // Output → '' (blank, Unicode '\u0000')
        System.out.println("boolean default: " + flag);    // Output → false
        System.out.println("String default: " + name);     // Output → null
        System.out.println("Array default: " + arr);       // Output → null
        System.out.println("Object default: " + obj);      // Output → null
    }
}

// 🔸 Simple supporting class
class MyClass2 {
    void show() {
        System.out.println("Hello!");
    }
}

/*



💡 QUICK NOTES
==============
• These defaults only apply to **class or instance variables**.
• Local variables inside methods must be initialized manually.
• `char '\u0000'` represents the **null character** (not visible, blank).
• Reference types (String, Array, Object) default to **null**,
  meaning they point to no object yet.
*/
