import java.util.Scanner;

public class OddEvenArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        if (number <= 0) {
            System.out.println("Error: Not a natural number");
            return;
        }

        int size = number / 2 + 1;
        int[] even = new int[size];
        int[] odd = new int[size];
        int evenIndex = 0, oddIndex = 0;

        for (int i = 1; i <= number; i++) {
            if (i % 2 == 0)
                even[evenIndex++] = i;
            else
                odd[oddIndex++] = i;
        }

        System.out.print("Even numbers: ");
        for (int i = 0; i < evenIndex; i++)
            System.out.print(even[i] + " ");

        System.out.println();
        System.out.print("Odd numbers: ");
        for (int i = 0; i < oddIndex; i++)
            System.out.print(odd[i] + " ");

        scanner.close();
    }
}
