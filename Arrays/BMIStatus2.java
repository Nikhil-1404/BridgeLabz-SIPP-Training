import java.util.Scanner;

public class BMIStatus2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        double[] weight = new double[number];
        double[] height = new double[number];
        double[] bmi = new double[number];
        String[] status = new String[number];

        for (int i = 0; i < number; i++) {
            weight[i] = scanner.nextDouble();
            height[i] = scanner.nextDouble();
            bmi[i] = weight[i] / (height[i] * height[i]);

            if (bmi[i] <= 18.4)
                status[i] = "Underweight";
            else if (bmi[i] <= 24.9)
                status[i] = "Normal";
            else if (bmi[i] <= 39.9)
                status[i] = "Overweight";
            else
                status[i] = "Obese";
        }

        for (int i = 0; i < number; i++) {
            System.out.println("Person " + (i + 1) + ": Height = " + height[i] + "m, Weight = " + weight[i] + "kg, BMI = " + bmi[i] + ", Status = " + status[i]);
        }

        scanner.close();
    }
}
