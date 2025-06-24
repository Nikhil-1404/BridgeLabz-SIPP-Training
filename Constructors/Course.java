public class Course {
    // Instance variables
    private String courseName;
    private int duration; 
    private double fee;

    // Class variable (static)
    private static String instituteName = "Default Institute";

    // Constructor
    public Course(String courseName, int duration, double fee) {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }

    // Instance method to display course details
    public void displayCourseDetails() {
        System.out.println("Institute Name: " + instituteName);
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " weeks");
        System.out.println("Fee: $" + fee);
    }

    // Class method to update the institute name
    public static void updateInstituteName(String newName) {
        instituteName = newName;
        System.out.println("Institute name updated to: " + instituteName);
    }

    // Main method to test
    public static void main(String[] args) {
        // Before update
        Course course1 = new Course("Java Programming", 8, 300.0);
        Course course2 = new Course("Web Development", 12, 500.0);

        course1.displayCourseDetails();
        System.out.println();
        course2.displayCourseDetails();
        System.out.println();

        // Update the institute name
        Course.updateInstituteName("Tech Academy");

        System.out.println();

        // After update, check again
        course1.displayCourseDetails();
        System.out.println();
        course2.displayCourseDetails();
    }
}
