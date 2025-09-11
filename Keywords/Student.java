class Student {
    // 1. Static variable for university name and total students
    static String universityName = "Global University";
    static int totalStudents = 0;

    // 3. Final variable for unique roll number
    private final int rollNumber;
    private String name;
    private char grade;

    // 2. Constructor using 'this' keyword
    public Student(int rollNumber, String name, char grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.grade = grade;
        totalStudents++; // Increment on new student creation
    }

    // 1. Static method to display total students
    public static void displayTotalStudents() {
        System.out.println("Total Enrolled Students: " + totalStudents);
    }

    // Method to update grade
    public void updateGrade(char newGrade) {
        this.grade = newGrade;
    }

    // Method to display student details
    public void displayDetails() {
        System.out.println("University: " + universityName);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name: " + name);
        System.out.println("Grade: " + grade);
    }
}

 class Main {
    public static void main(String[] args) {
        // Creating Student objects
        Student s1 = new Student(101, "Priya Sharma", 'A');
        Student s2 = new Student(102, "Rahul Verma", 'B');

        // 4. instanceof check before performing operations
        if (s1 instanceof Student) {
            System.out.println("Student 1 Details:");
            s1.displayDetails();
        }

        if (s2 instanceof Student) {
            System.out.println("\nStudent 2 Details:");
            s2.displayDetails();

            // Let's update the grade if instance is valid
            System.out.println("\nUpdating Student 2's Grade to 'A'...");
            s2.updateGrade('A');
            s2.displayDetails();
        }

        // Display total enrolled students
        System.out.println();
        Student.displayTotalStudents();
    }
}
