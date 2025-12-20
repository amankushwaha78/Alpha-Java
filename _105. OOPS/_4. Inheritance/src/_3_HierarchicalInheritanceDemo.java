
// Parent class
class Animal7 {
    void eat() {
        System.out.println("Animal eats food");
    }
}

// Child class 1
class Dog7 extends Animal7 {
    void bark() {
        System.out.println("Dog barks");
    }
}

// Child class 2
class Cat extends Animal7 {
    void meow() {
        System.out.println("Cat meows");
    }
}

// Main class
public class _3_HierarchicalInheritanceDemo {
    public static void main(String[] args) {

        Dog7 d = new Dog7();
        d.eat();   // inherited from Animal
        d.bark();  // Dog's own method

        Cat7 c = new Cat7();
        c.eat();   // inherited from Animal
        c.meow();  // Cat's own method
    }
}
