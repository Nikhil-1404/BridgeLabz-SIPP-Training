import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        int[] table = new int[10];
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        for (int i = 0; i < table.length; i++) {
            table[i] = number * (i + 1);
        }
        for (int i = 0; i < table.length; i++) {
            System.out.println(number + " * " + (i + 1) + " = " + table[i]);
        }
        scanner.close();
    }
}
