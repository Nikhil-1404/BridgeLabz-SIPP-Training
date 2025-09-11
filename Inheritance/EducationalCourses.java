// Superclass
class Course {
    String courseName;
    int duration; // in hours

    Course(String courseName, int duration) {
        this.courseName = courseName;
        this.duration = duration;
    }

    void displayDetails() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " hours");
    }
}

// Subclass 1: OnlineCourse extends Course
class OnlineCourse extends Course {
    String platform;
    boolean isRecorded;

    OnlineCourse(String courseName, int duration, String platform, boolean isRecorded) {
        super(courseName, duration);
        this.platform = platform;
        this.isRecorded = isRecorded;
    }

    void displayDetails() {
        super.displayDetails();
        System.out.println("Platform: " + platform);
        System.out.println("Recorded: " + (isRecorded ? "Yes" : "No"));
    }
}

// Subclass 2: PaidOnlineCourse extends OnlineCourse
class PaidOnlineCourse extends OnlineCourse {
    double fee;
    double discount; // in percentage

    PaidOnlineCourse(String courseName, int duration, String platform, boolean isRecorded, double fee, double discount) {
        super(courseName, duration, platform, isRecorded);
        this.fee = fee;
        this.discount = discount;
    }

    void displayDetails() {
        super.displayDetails();
        System.out.println("Fee: Rs." + fee);
        System.out.println("Discount: " + discount + "%");
    }
}

// Main class to test the hierarchy
public class EducationalCourses {
    public static void main(String[] args) {
        Course c = new Course("Data Structures", 40);
        OnlineCourse oc = new OnlineCourse("Java Programming", 30, "Udemy", true);
        PaidOnlineCourse poc = new PaidOnlineCourse("Full Stack Development", 50, "Coursera", true, 4000.0, 20.0);

        System.out.println("=== Course ===");
        c.displayDetails();
        System.out.println();

        System.out.println("=== Online Course ===");
        oc.displayDetails();
        System.out.println();

        System.out.println("=== Paid Online Course ===");
        poc.displayDetails();
    }
}
