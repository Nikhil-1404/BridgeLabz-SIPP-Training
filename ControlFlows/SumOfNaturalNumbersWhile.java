import java.util.Scanner;

public class SumOfNaturalNumbersWhile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a natural number: ");
        int n = scanner.nextInt();

        if (n < 0) {
            System.out.println("Please enter a natural number (0 or positive integer).");
        } else {
            int sumUsingWhile = 0;
            int i = 1;

            while (i <= n) {
                sumUsingWhile += i;
                i++;
            }

            int sumUsingFormula = n * (n + 1) / 2;

            System.out.println("Sum using while loop: " + sumUsingWhile);
            System.out.println("Sum using formula: " + sumUsingFormula);

            if (sumUsingWhile == sumUsingFormula) {
                System.out.println("Both computations are correct.");
            } else {
                System.out.println("There is a mismatch in the results.");
            }
        }
    }
}
