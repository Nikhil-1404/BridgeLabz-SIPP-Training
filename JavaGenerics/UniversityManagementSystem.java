import java.util.*;

// ----------- Base Abstract Class for Course Type -----------
abstract class CourseType {
    private String courseName;
    private String department;

    public CourseType(String courseName, String department) {
        this.courseName = courseName;
        this.department = department;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getDepartment() {
        return department;
    }

    public abstract void evaluate();
}

// ----------- Subclasses for Course Evaluation Types -----------
class ExamCourse extends CourseType {
    public ExamCourse(String courseName, String department) {
        super(courseName, department);
    }

    @Override
    public void evaluate() {
        System.out.println("Evaluation Method: Final Exam for " + getCourseName());
    }
}

class AssignmentCourse extends CourseType {
    public AssignmentCourse(String courseName, String department) {
        super(courseName, department);
    }

    @Override
    public void evaluate() {
        System.out.println("Evaluation Method: Regular Assignments for " + getCourseName());
    }
}

class ResearchCourse extends CourseType {
    public ResearchCourse(String courseName, String department) {
        super(courseName, department);
    }

    @Override
    public void evaluate() {
        System.out.println("Evaluation Method: Research Paper for " + getCourseName());
    }
}

// ----------- Generic Course Class -----------
class Course<T extends CourseType> {
    private T courseType;
    private int credits;

    public Course(T courseType, int credits) {
        this.courseType = courseType;
        this.credits = credits;
    }

    public T getCourseType() {
        return courseType;
    }

    public int getCredits() {
        return credits;
    }

    public void showCourseInfo() {
        System.out.println("Course: " + courseType.getCourseName() + 
                           " | Department: " + courseType.getDepartment() + 
                           " | Credits: " + credits);
        courseType.evaluate();
    }
}

// ----------- Utility with Wildcard -----------
class CourseUtils {
    public static void displayAllCourses(List<? extends CourseType> courses) {
        for (CourseType course : courses) {
            System.out.println("Course: " + course.getCourseName() + 
                               " | Dept: " + course.getDepartment());
            course.evaluate();
        }
    }
}

// ----------- Main Class to Demonstrate System -----------
public class UniversityManagementSystem {
    public static void main(String[] args) {
        // Creating CourseType instances
        ExamCourse math101 = new ExamCourse("Mathematics 101", "Mathematics");
        AssignmentCourse cs201 = new AssignmentCourse("Data Structures", "Computer Science");
        ResearchCourse bio501 = new ResearchCourse("Genetics Research", "Biotechnology");

        // Creating generic Course wrappers
        Course<ExamCourse> course1 = new Course<>(math101, 4);
        Course<AssignmentCourse> course2 = new Course<>(cs201, 3);
        Course<ResearchCourse> course3 = new Course<>(bio501, 5);

        // Display individual course info
        System.out.println("----- Individual Course Info -----");
        course1.showCourseInfo();
        course2.showCourseInfo();
        course3.showCourseInfo();

        // Use wildcards to handle all types in one list
        List<CourseType> courseList = new ArrayList<>();
        courseList.add(math101);
        courseList.add(cs201);
        courseList.add(bio501);

        System.out.println("\n----- Display All Courses (Wildcard) -----");
        CourseUtils.displayAllCourses(courseList);
    }
}
