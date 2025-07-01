// Interface
interface Worker {
    void performDuties();
}

// Superclass
class Person {
    String name;
    int id;

    Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
    }
}

// Subclass 1: Chef inherits Person and implements Worker
class Chef extends Person implements Worker {
    String speciality;

    Chef(String name, int id, String speciality) {
        super(name, id);
        this.speciality = speciality;
    }

    public void performDuties() {
        System.out.println(name + " is preparing " + speciality + " dishes.");
    }

    void displayDetails() {
        super.displayDetails();
        System.out.println("Speciality: " + speciality);
    }
}

// Subclass 2: Waiter inherits Person and implements Worker
class Waiter extends Person implements Worker {
    int tablesAssigned;

    Waiter(String name, int id, int tablesAssigned) {
        super(name, id);
        this.tablesAssigned = tablesAssigned;
    }

    public void performDuties() {
        System.out.println(name + " is serving " + tablesAssigned + " tables.");
    }

    void displayDetails() {
        super.displayDetails();
        System.out.println("Tables Assigned: " + tablesAssigned);
    }
}

// Main class to test hybrid inheritance
public class RestaurantSystem {
    public static void main(String[] args) {
        Chef chef = new Chef("Raj", 101, "Italian");
        Waiter waiter = new Waiter("Amit", 201, 5);

        System.out.println("=== Chef Details ===");
        chef.displayDetails();
        chef.performDuties();
        System.out.println();

        System.out.println("=== Waiter Details ===");
        waiter.displayDetails();
        waiter.performDuties();
    }
}
