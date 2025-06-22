import java.util.Scanner;

public class FactorialRecursion {
    public static void main(String[] args) {
        int num = getInput();
        int fact = factorial(num);
        displayResult(num, fact);
    }

    static int getInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        return scanner.nextInt();
    }

    static int factorial(int n) {
        if (n == 0) return 1;
        return n * factorial(n - 1);
    }

    static void displayResult(int num, int fact) {
        System.out.println("Factorial of " + num + " is " + fact);
    }
}
