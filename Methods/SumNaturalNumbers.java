import java.util.Scanner;

public class SumNaturalNumbers {
    public static int recursiveSum(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n + recursiveSum(n - 1);
        }
    }

    public static int formulaSum(int n) {
        return n * (n + 1) / 2;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a natural number: ");
        int n = scanner.nextInt();

        if (n <= 0) {
            System.out.println("Please enter a natural number greater than 0.");
        } else {
            int sumRecursive = recursiveSum(n);
            int sumFormula = formulaSum(n);

            System.out.println("Sum using recursion: " + sumRecursive);
            System.out.println("Sum using formula: " + sumFormula);

            if (sumRecursive == sumFormula) {
                System.out.println("Both sums are equal. Verified!");
            } else {
                System.out.println("Sums do not match. Check the logic.");
            }
        }

        scanner.close();
    }
}
