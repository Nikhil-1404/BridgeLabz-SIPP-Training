import java.util.Scanner;

public class StringIndexOutOfBoundsDemo {

    static void generateException(String text) {
        System.out.println("Generating StringIndexOutOfBoundsException...");
        System.out.println(text.charAt(text.length()));
    }

    static void handleException(String text) {
        System.out.println("Handling StringIndexOutOfBoundsException...");
        try {
            System.out.println(text.charAt(text.length()));
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Caught StringIndexOutOfBoundsException: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Caught RuntimeException: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = sc.nextLine();

        generateException(text);
        handleException(text);
    }
}
