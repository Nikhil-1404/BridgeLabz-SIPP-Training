import java.util.Scanner;

public class BasicCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        double number1 = input.nextDouble();

        System.out.print("Enter the second number: ");
        double number2 = input.nextDouble();

        double sum = number1 + number2;
        double difference = number1 - number2;
        double product = number1 * number2;
        double division = number1 / number2;

        System.out.println("The addition, subtraction, multiplication, and division value of 2 numbers " 
        + number1 + " and " + number2 + " is:");
        System.out.println("Addition = " + sum);
        System.out.println("Subtraction = " + difference);
        System.out.println("Multiplication = " + product);
        System.out.println("Division = " + division);
    }
}

