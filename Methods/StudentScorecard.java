import java.util.Random;
import java.util.Scanner;

public class StudentScorecard {

    public static int[][] generateMarks(int students) {
        int[][] marks = new int[students][3];
        Random rand = new Random();
        for (int i = 0; i < students; i++) {
            for (int j = 0; j < 3; j++) {
                marks[i][j] = rand.nextInt(41) + 60; // 60 to 100 for reasonable scores
            }
        }
        return marks;
    }

    public static double[][] calculateScores(int[][] marks) {
        int students = marks.length;
        double[][] result = new double[students][3];
        for (int i = 0; i < students; i++) {
            int total = marks[i][0] + marks[i][1] + marks[i][2];
            double avg = (double) total / 3;
            double percent = ((double) total / 300) * 100;
            result[i][0] = total;
            result[i][1] = Math.round(avg * 100.0) / 100.0;
            result[i][2] = Math.round(percent * 100.0) / 100.0;
        }
        return result;
    }

    public static void displayScorecard(int[][] marks, double[][] scores) {
        System.out.println("ID\tPhysics\tChemistry\tMaths\tTotal\tAverage\tPercentage");
        for (int i = 0; i < marks.length; i++) {
            System.out.print((i + 1) + "\t");
            for (int j = 0; j < 3; j++) {
                System.out.print(marks[i][j] + "\t\t");
            }
            System.out.print((int) scores[i][0] + "\t");
            System.out.print(scores[i][1] + "\t");
            System.out.println(scores[i][2]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int students = sc.nextInt();

        int[][] marks = generateMarks(students);
        double[][] scores = calculateScores(marks);

        displayScorecard(marks, scores);

        sc.close();
    }
}
