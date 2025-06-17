import java.util.Scanner;

public class MultiplicationTableRange {
    public static void main(String[] args) {
        int[] multiplicationResult = new int[4];
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        for (int i = 0; i < multiplicationResult.length; i++) {
            multiplicationResult[i] = number * (i + 6);
        }

        for (int i = 0; i < multiplicationResult.length; i++) {
            System.out.println(number + " * " + (i + 6) + " = " + multiplicationResult[i]);
        }

        scanner.close();
    }
}
