// Superclass
class Person {
    String name;
    int age;

    // Constructor
    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Method to display basic details
    void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

// Subclass 1: Teacher
class Teacher extends Person {
    String subject;

    Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    void displayRole() {
        System.out.println("Role: Teacher");
    }

    void displayDetails() {
        super.displayDetails();
        System.out.println("Subject: " + subject);
    }
}

// Subclass 2: Student
class Student extends Person {
    String grade;

    Student(String name, int age, String grade) {
        super(name, age);
        this.grade = grade;
    }

    void displayRole() {
        System.out.println("Role: Student");
    }

    void displayDetails() {
        super.displayDetails();
        System.out.println("Grade: " + grade);
    }
}

// Subclass 3: Staff
class Staff extends Person {
    String department;

    Staff(String name, int age, String department) {
        super(name, age);
        this.department = department;
    }

    void displayRole() {
        System.out.println("Role: Staff");
    }

    void displayDetails() {
        super.displayDetails();
        System.out.println("Department: " + department);
    }
}

// Main class to test the hierarchy
public class SchoolSystem {
    public static void main(String[] args) {
        Teacher t = new Teacher("Mr. Sharma", 40, "Mathematics");
        Student s = new Student("Aditi", 16, "10th Grade");
        Staff st = new Staff("Mrs. Meena", 35, "Administration");

        t.displayRole();
        t.displayDetails();
        System.out.println();

        s.displayRole();
        s.displayDetails();
        System.out.println();

        st.displayRole();
        st.displayDetails();
    }
}
