// Base class Employee
class Employee {
    String name;
    int id;
    double salary;

    // Constructor
    Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    // Method to display details
    void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Salary: " + salary);
    }
}

// Subclass Manager
class Manager extends Employee {
    int teamSize;

    Manager(String name, int id, double salary, int teamSize) {
        super(name, id, salary);
        this.teamSize = teamSize;
    }

    @Override
    void displayDetails() {
        super.displayDetails(); // call base method
        System.out.println("Team Size: " + teamSize);
    }
}

// Subclass Developer
class Developer extends Employee {
    String programmingLanguage;

    Developer(String name, int id, double salary, String programmingLanguage) {
        super(name, id, salary);
        this.programmingLanguage = programmingLanguage;
    }

    @Override
    void displayDetails() {
        super.displayDetails(); // call base method
        System.out.println("Programming Language: " + programmingLanguage);
    }
}

// Subclass Intern
class Intern extends Employee {
    String university;

    Intern(String name, int id, double salary, String university) {
        super(name, id, salary);
        this.university = university;
    }

    @Override
    void displayDetails() {
        super.displayDetails(); // call base method
        System.out.println("University: " + university);
    }
}

// Main class to test the hierarchy
public class EmployeeManagementSystem {
    public static void main(String[] args) {
        // Creating objects of each subclass
        Manager manager = new Manager("Alice", 101, 90000, 10);
        Developer developer = new Developer("Bob", 102, 70000, "Java");
        Intern intern = new Intern("Charlie", 103, 20000, "MIT");

        // Display details
        System.out.println("=== Manager Details ===");
        manager.displayDetails();

        System.out.println("\n=== Developer Details ===");
        developer.displayDetails();

        System.out.println("\n=== Intern Details ===");
        intern.displayDetails();
    }
}
