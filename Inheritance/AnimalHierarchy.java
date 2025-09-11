// Superclass Animal
class Animal {
    String name;
    int age;

    // Constructor
    Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Method to be overridden
    void makeSound() {
        System.out.println("Some generic animal sound");
    }
}

// Subclass Dog
class Dog extends Animal {

    Dog(String name, int age) {
        super(name, age);
    }

    @Override
    void makeSound() {
        System.out.println(name + " says: Woof woof!");
    }
}

// Subclass Cat
class Cat extends Animal {

    Cat(String name, int age) {
        super(name, age);
    }

    @Override
    void makeSound() {
        System.out.println(name + " says: Meow meow!");
    }
}

// Subclass Bird
class Bird extends Animal {

    Bird(String name, int age) {
        super(name, age);
    }

    @Override
    void makeSound() {
        System.out.println(name + " says: Tweet tweet!");
    }
}

// Main class to test the hierarchy
public class AnimalHierarchy {
    public static void main(String[] args) {
        // Creating objects of subclasses
        Dog dog = new Dog("Bruno", 3);
        Cat cat = new Cat("Kitty", 2);
        Bird bird = new Bird("Tweety", 1);

        // Polymorphism: calling makeSound on each
        dog.makeSound();
        cat.makeSound();
        bird.makeSound();
    }
}
