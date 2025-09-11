// Base class: Student
public class Student {
    public int rollNumber;        // public
    protected String name;        // protected
    private double CGPA;          // private

    // Constructor
    public Student(int rollNumber, String name, double CGPA) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.CGPA = CGPA;
    }

    // Public getter for CGPA
    public double getCGPA() {
        return CGPA;
    }

    // Public setter for CGPA
    public void setCGPA(double CGPA) {
        this.CGPA = CGPA;
    }

    // Method to display student details
    public void displayDetails() {
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name: " + name);
        System.out.println("CGPA: " + CGPA);
    }
}

// Subclass: PostgraduateStudent
class PostgraduateStudent extends Student {
    private String specialization;

    // Constructor
    public PostgraduateStudent(int rollNumber, String name, double CGPA, String specialization) {
        super(rollNumber, name, CGPA);
        this.specialization = specialization;
    }

    // Method to display postgraduate student details
    public void displayPGDetails() {
        // Access public rollNumber, protected name, and private CGPA through getter
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name (protected): " + name); // Accessing protected member
        System.out.println("CGPA: " + getCGPA());        // Accessing private via public getter
        System.out.println("Specialization: " + specialization);
    }
}

// Main class to test
class UniversityManagementSystem {
    public static void main(String[] args) {
        // Create a Student object
        Student student1 = new Student(101, "Alice", 3.8);
        student1.displayDetails();

        System.out.println();

        // Update CGPA
        student1.setCGPA(3.9);
        System.out.println("Updated CGPA: " + student1.getCGPA());

        System.out.println();

        // Create a PostgraduateStudent object
        PostgraduateStudent pgStudent = new PostgraduateStudent(201, "Bob", 4.0, "Computer Science");
        pgStudent.displayPGDetails();
    }
}
