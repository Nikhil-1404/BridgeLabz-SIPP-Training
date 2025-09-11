import java.util.*;

// Professor class
class Professor {
    private String name;
    private String department;

    public Professor(String name, String department) {
        this.name = name;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void displayProfessor() {
        System.out.println("Professor: " + name + ", Department: " + department);
    }
}

// Student class
class Student {
    private String name;
    private List<Course> enrolledCourses;

    public Student(String name) {
        this.name = name;
        this.enrolledCourses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    // Enroll in course (communication)
    public void enrollCourse(Course course) {
        if (!enrolledCourses.contains(course)) {
            enrolledCourses.add(course);
            course.addStudent(this); // establish two-way association
            System.out.println(name + " enrolled in course: " + course.getCourseName());
        }
    }

    public void displayEnrolledCourses() {
        System.out.println("\nCourses enrolled by " + name + ":");
        for (Course c : enrolledCourses) {
            System.out.println("- " + c.getCourseName());
        }
    }
}

// Course class
class Course {
    private String courseName;
    private Professor professor;
    private List<Student> students;

    public Course(String courseName) {
        this.courseName = courseName;
        this.students = new ArrayList<>();
    }

    public String getCourseName() {
        return courseName;
    }

    // Assign professor to course (communication)
    public void assignProfessor(Professor professor) {
        this.professor = professor;
        System.out.println("Professor " + professor.getName() + " assigned to course: " + courseName);
    }

    // Add student to course
    public void addStudent(Student student) {
        if (!students.contains(student)) {
            students.add(student);
        }
    }

    // Display course details
    public void displayCourse() {
        System.out.println("\nCourse: " + courseName);
        if (professor != null) {
            System.out.println("Taught by: " + professor.getName());
        } else {
            System.out.println("No professor assigned yet.");
        }
        System.out.println("Enrolled Students:");
        for (Student s : students) {
            System.out.println("- " + s.getName());
        }
    }
}

// University class (aggregates students, professors, courses)
class University {
    private String name;
    private List<Student> students;
    private List<Professor> professors;
    private List<Course> courses;

    public University(String name) {
        this.name = name;
        this.students = new ArrayList<>();
        this.professors = new ArrayList<>();
        this.courses = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void addProfessor(Professor professor) {
        professors.add(professor);
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    // Display university structure
    public void displayUniversity() {
        System.out.println("\nUniversity: " + name);
        System.out.println("Students:");
        for (Student s : students) {
            System.out.println("- " + s.getName());
        }
        System.out.println("Professors:");
        for (Professor p : professors) {
            System.out.println("- " + p.getName());
        }
        System.out.println("Courses:");
        for (Course c : courses) {
            System.out.println("- " + c.getCourseName());
        }
    }
}

// Main class to demonstrate relationships and communication
 class Main {
    public static void main(String[] args) {
        // Create university
        University vit = new University("VIT University");

        // Create students
        Student s1 = new Student("Alice");
        Student s2 = new Student("Bob");

        // Create professors
        Professor p1 = new Professor("Dr. Smith", "Computer Science");
        Professor p2 = new Professor("Dr. John", "Mechanical Engineering");

        // Create courses
        Course c1 = new Course("Data Structures");
        Course c2 = new Course("Thermodynamics");

        // Add to university
        vit.addStudent(s1);
        vit.addStudent(s2);
        vit.addProfessor(p1);
        vit.addProfessor(p2);
        vit.addCourse(c1);
        vit.addCourse(c2);

        // Assign professors to courses
        c1.assignProfessor(p1);
        c2.assignProfessor(p2);

        // Students enroll in courses
        s1.enrollCourse(c1);
        s2.enrollCourse(c1);
        s2.enrollCourse(c2);

        // Display university structure
        vit.displayUniversity();

        // Display enrolled courses for students
        s1.displayEnrolledCourses();
        s2.displayEnrolledCourses();

        // Display courses with their professors and students
        c1.displayCourse();
        c2.displayCourse();
    }
}
