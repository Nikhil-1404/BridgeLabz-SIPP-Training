import java.util.Scanner;

public class BMIStatus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        double[][] personData = new double[number][3];
        String[] weightStatus = new String[number];

        for (int i = 0; i < number; i++) {
            double weight, height;
            do {
                System.out.print("Enter weight in kg for person " + (i + 1) + ": ");
                weight = scanner.nextDouble();
            } while (weight <= 0);

            do {
                System.out.print("Enter height in meters for person " + (i + 1) + ": ");
                height = scanner.nextDouble();
            } while (height <= 0);

            double bmi = weight / (height * height);
            personData[i][0] = weight;
            personData[i][1] = height;
            personData[i][2] = bmi;

            if (bmi <= 18.4)
                weightStatus[i] = "Underweight";
            else if (bmi <= 24.9)
                weightStatus[i] = "Normal";
            else if (bmi <= 39.9)
                weightStatus[i] = "Overweight";
            else
                weightStatus[i] = "Obese";
        }

        for (int i = 0; i < number; i++) {
            System.out.println("Person " + (i + 1) + ": Weight = " + personData[i][0] +
                               " kg, Height = " + personData[i][1] +
                               " m, BMI = " + personData[i][2] +
                               ", Status = " + weightStatus[i]);
        }

        scanner.close();
    }
}
