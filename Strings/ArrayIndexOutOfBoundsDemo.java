import java.util.Scanner;

public class ArrayIndexOutOfBoundsDemo {

    static void generateException(String[] names) {
        System.out.println("Generating ArrayIndexOutOfBoundsException...");
        System.out.println(names[names.length]);
    }

    static void handleException(String[] names) {
        System.out.println("Handling ArrayIndexOutOfBoundsException...");
        try {
            System.out.println(names[names.length]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught ArrayIndexOutOfBoundsException: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Caught RuntimeException: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of names: ");
        int n = sc.nextInt();
        sc.nextLine();

        String[] names = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter name " + (i + 1) + ": ");
            names[i] = sc.nextLine();
        }

        generateException(names);
        handleException(names);
    }
}
