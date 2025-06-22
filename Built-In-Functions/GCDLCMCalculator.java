import java.util.Scanner;

public class GCDLCMCalculator {
    public static void main(String[] args) {
        int[] numbers = getInput();
        int gcd = findGCD(numbers[0], numbers[1]);
        int lcm = findLCM(numbers[0], numbers[1], gcd);
        System.out.println("GCD: " + gcd);
        System.out.println("LCM: " + lcm);
    }

    static int[] getInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int a = scanner.nextInt();
        System.out.print("Enter second number: ");
        int b = scanner.nextInt();
        return new int[]{a, b};
    }

    static int findGCD(int a, int b) {
        if (b == 0) return a;
        return findGCD(b, a % b);
    }

    static int findLCM(int a, int b, int gcd) {
        return (a * b) / gcd;
    }
}
