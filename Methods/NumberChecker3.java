import java.util.Scanner;

public class NumberChecker3 {

    // Method to check if a number is a perfect number
    public static boolean isPerfect(int num) {
        int sum = 0;
        for (int i = 1; i <= num/2; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }
        return sum == num;
    }

    // Method to check if a number is an abundant number
    public static boolean isAbundant(int num) {
        int sum = 0;
        for (int i = 1; i <= num/2; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }
        return sum > num;
    }

    // Method to check if a number is a deficient number
    public static boolean isDeficient(int num) {
        int sum = 0;
        for (int i = 1; i <= num/2; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }
        return sum < num;
    }

    // Method to check if a number is a strong number
    public static boolean isStrong(int num) {
        int original = num;
        int sum = 0;
        while (num > 0) {
            int digit = num % 10;
            sum += factorial(digit);
            num /= 10;
        }
        return sum == original;
    }

    // Helper method to find factorial
    public static int factorial(int n) {
        int fact = 1;
        for (int i = 2; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        System.out.println("Is Perfect Number: " + isPerfect(num));
        System.out.println("Is Abundant Number: " + isAbundant(num));
        System.out.println("Is Deficient Number: " + isDeficient(num));
        System.out.println("Is Strong Number: " + isStrong(num));

        sc.close();
    }
}
