import java.util.Random;

public class StudentScorecard {

    public static int[][] generateScores(int students) {
        Random rand = new Random();
        int[][] scores = new int[students][3];
        for (int i = 0; i < students; i++) {
            for (int j = 0; j < 3; j++) {
                scores[i][j] = rand.nextInt(51) + 50; // Random 50-100 for realism
            }
        }
        return scores;
    }

    public static double[][] calculateResults(int[][] scores) {
        double[][] results = new double[scores.length][3];
        for (int i = 0; i < scores.length; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double average = total / 3.0;
            double percentage = Math.round((average) * 100.0) / 100.0;
            results[i][0] = total;
            results[i][1] = average;
            results[i][2] = percentage;
        }
        return results;
    }

    public static char[] assignGrades(double[][] results) {
        char[] grades = new char[results.length];
        for (int i = 0; i < results.length; i++) {
            double percent = results[i][2];
            if (percent >= 80) grades[i] = 'A';
            else if (percent >= 70) grades[i] = 'B';
            else if (percent >= 60) grades[i] = 'C';
            else if (percent >= 50) grades[i] = 'D';
            else if (percent >= 40) grades[i] = 'E';
            else grades[i] = 'R';
        }
        return grades;
    }

    public static void displayScorecard(int[][] scores, double[][] results, char[] grades) {
        System.out.printf("%-10s%-10s%-10s%-10s%-10s%-10s%-10s\n", 
            "Student", "Physics", "Chemistry", "Maths", "Total", "Average", "Grade");
        for (int i = 0; i < scores.length; i++) {
            System.out.printf("%-10d%-10d%-10d%-10d%-10.0f%-10.2f%-10c\n", 
                i+1, scores[i][0], scores[i][1], scores[i][2],
                results[i][0], results[i][1], grades[i]);
        }
    }

    public static void main(String[] args) {
        int students = 5;
        int[][] scores = generateScores(students);
        double[][] results = calculateResults(scores);
        char[] grades = assignGrades(results);
        displayScorecard(scores, results, grades);
    }
}
