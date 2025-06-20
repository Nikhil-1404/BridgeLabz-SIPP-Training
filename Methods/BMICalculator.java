import java.util.Scanner;

public class BMICalculator {

    public static void calculateBMI(double[][] data) {
        for (int i = 0; i < data.length; i++) {
            double weight = data[i][0];
            double heightCm = data[i][1];
            double heightM = heightCm / 100.0;
            double bmi = weight / (heightM * heightM);
            data[i][2] = bmi;
        }
    }

    public static String[] getBMIStatus(double[][] data) {
        String[] status = new String[data.length];
        for (int i = 0; i < data.length; i++) {
            double bmi = data[i][2];
            if (bmi <= 18.4) {
                status[i] = "Underweight";
            } else if (bmi <= 24.9) {
                status[i] = "Normal";
            } else if (bmi <= 39.9) {
                status[i] = "Overweight";
            } else {
                status[i] = "Obese";
            }
        }
        return status;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[][] data = new double[10][3];

        for (int i = 0; i < data.length; i++) {
            System.out.println("Enter weight (kg) for person " + (i + 1) + ":");
            data[i][0] = sc.nextDouble();
            System.out.println("Enter height (cm) for person " + (i + 1) + ":");
            data[i][1] = sc.nextDouble();
        }

        calculateBMI(data);
        String[] status = getBMIStatus(data);

        System.out.println("\nHeight(cm)\tWeight(kg)\tBMI\t\tStatus");
        for (int i = 0; i < data.length; i++) {
            System.out.printf("%.2f\t\t%.2f\t\t%.2f\t%s\n", 
                              data[i][1], data[i][0], data[i][2], status[i]);
        }

        sc.close();
    }
}
