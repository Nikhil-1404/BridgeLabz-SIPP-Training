import java.util.Scanner;

public class ReverseNumberArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int temp = number;
        int count = 0;

        while (temp != 0) {
            temp /= 10;
            count++;
        }

        int[] digits = new int[count];
        for (int i = 0; i < count; i++) {
            digits[i] = number % 10;
            number /= 10;
        }

        int[] reversed = new int[count];
        for (int i = 0; i < count; i++) {
            reversed[i] = digits[count - 1 - i];
        }

        for (int i = 0; i < count; i++) {
            System.out.print(reversed[i]);
        }

        scanner.close();
    }
}
