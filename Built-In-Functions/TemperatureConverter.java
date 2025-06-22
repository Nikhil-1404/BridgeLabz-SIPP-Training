import java.util.Scanner;

public class TemperatureConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Fahrenheit to Celsius");
        System.out.println("2. Celsius to Fahrenheit");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();

        if (choice == 1) {
            System.out.print("Enter Fahrenheit: ");
            double f = scanner.nextDouble();
            double c = fahrenheitToCelsius(f);
            System.out.println("Celsius: " + c);
        } else if (choice == 2) {
            System.out.print("Enter Celsius: ");
            double c = scanner.nextDouble();
            double f = celsiusToFahrenheit(c);
            System.out.println("Fahrenheit: " + f);
        } else {
            System.out.println("Invalid choice");
        }
    }

    static double fahrenheitToCelsius(double f) {
        return (f - 32) * 5 / 9;
    }

    static double celsiusToFahrenheit(double c) {
        return (c * 9 / 5) + 32;
    }
}
