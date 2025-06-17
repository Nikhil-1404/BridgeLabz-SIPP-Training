import java.util.Scanner;

public class MeanHeight {
    public static void main(String[] args) {
        double[] heights = new double[11];
        Scanner scanner = new Scanner(System.in);
        double sum = 0;

        for (int i = 0; i < heights.length; i++) {
            heights[i] = scanner.nextDouble();
            sum += heights[i];
        }

        double mean = sum / heights.length;
        System.out.println("The mean height of the football team is " + mean);
        scanner.close();
    }
}
