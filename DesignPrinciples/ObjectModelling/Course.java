import java.util.*;

// Course class
class Course {
    private String courseName;
    private List<Student> enrolledStudents;

    public Course(String courseName) {
        this.courseName = courseName;
        this.enrolledStudents = new ArrayList<>();
    }

    public String getCourseName() {
        return courseName;
    }

    // Enroll a student
    public void enrollStudent(Student student) {
        if (!enrolledStudents.contains(student)) {
            enrolledStudents.add(student);
        }
    }

    // Display students in this course
    public void displayEnrolledStudents() {
        System.out.println("\nStudents enrolled in " + courseName + ":");
        for (Student s : enrolledStudents) {
            System.out.println("- " + s.getName());
        }
    }
}

// Student class
class Student {
    private String name;
    private List<Course> courses;

    public Student(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    // Enroll in a course
    public void enrollInCourse(Course course) {
        if (!courses.contains(course)) {
            courses.add(course);
            course.enrollStudent(this); // establish two-way association
        }
    }

    // Display courses this student is enrolled in
    public void displayCourses() {
        System.out.println("\nCourses enrolled by " + name + ":");
        for (Course c : courses) {
            System.out.println("- " + c.getCourseName());
        }
    }
}

// School class aggregates Students
class School {
    private String name;
    private List<Student> students;

    public School(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }

    // Add a student to the school (aggregation)
    public void addStudent(Student student) {
        students.add(student);
    }

    // Display all students in school
    public void displayStudents() {
        System.out.println("\nStudents in " + name + ":");
        for (Student s : students) {
            System.out.println("- " + s.getName());
        }
    }
}

// Main class to demonstrate aggregation and association
 class Main {
    public static void main(String[] args) {
        // Create school
        School dps = new School("Delhi Public School");

        // Create students
        Student s1 = new Student("Alice");
        Student s2 = new Student("Bob");

        // Create courses
        Course math = new Course("Mathematics");
        Course science = new Course("Science");

        // Add students to school (aggregation)
        dps.addStudent(s1);
        dps.addStudent(s2);

        // Students enroll in courses (association)
        s1.enrollInCourse(math);
        s1.enrollInCourse(science);

        s2.enrollInCourse(science);

        // Display school students
        dps.displayStudents();

        // Each student views their courses
        s1.displayCourses();
        s2.displayCourses();

        // Each course shows enrolled students
        math.displayEnrolledStudents();
        science.displayEnrolledStudents();
    }
}
