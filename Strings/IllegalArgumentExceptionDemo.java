import java.util.Scanner;

public class IllegalArgumentExceptionDemo {

    static void generateException(String input) {
        System.out.println("Generating IllegalArgumentException...");
        String result = input.substring(5, 2);
        System.out.println("Substring: " + result);
    }

    static void handleException(String input) {
        System.out.println("Handling IllegalArgumentException...");
        try {
            String result = input.substring(5, 2);
            System.out.println("Substring: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught IllegalArgumentException: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Caught RuntimeException: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        generateException(input);
        handleException(input);
    }
}
