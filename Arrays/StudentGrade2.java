import java.util.Scanner;

public class StudentGrade2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] marks = new int[1][3];

        System.out.print("Enter marks for Physics: ");
        marks[0][0] = scanner.nextInt();
        System.out.print("Enter marks for Chemistry: ");
        marks[0][1] = scanner.nextInt();
        System.out.print("Enter marks for Maths: ");
        marks[0][2] = scanner.nextInt();

        int total = marks[0][0] + marks[0][1] + marks[0][2];
        double percentage = total / 3.0;

        String grade;

        if (percentage >= 80) {
            grade = "A";
        } else if (percentage >= 70) {
            grade = "B";
        } else if (percentage >= 60) {
            grade = "C";
        } else if (percentage >= 50) {
            grade = "D";
        } else if (percentage >= 40) {
            grade = "E";
        } else {
            grade = "R";
        }

        System.out.println("Percentage: " + percentage + "%");
        System.out.println("Grade: " + grade);

        scanner.close();
    }
}
