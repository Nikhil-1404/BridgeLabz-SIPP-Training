import java.util.Scanner;

public class MultipleBelow100 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a positive integer less than 100: ");
        int number = scanner.nextInt();

        if (number <= 0 || number >= 100) {
            System.out.println("Please enter a positive integer less than 100.");
        } else {
            int counter = number - 1;
            System.out.println("Multiple of " + number + " below 100 are:");
            while (counter > 1) {
                if (counter * number < 100) {
                    System.out.println(counter * number);
                }
                counter--;
            }
        }
    }
}
