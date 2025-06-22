import java.util.Scanner;

public class RemoveCharacter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String input = scanner.nextLine();
        System.out.println("Enter character to remove: ");
        char toRemove = scanner.nextLine().charAt(0);
        String result = "";
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != toRemove) {
                result += input.charAt(i);
            }
        }
        System.out.println("Modified String: " + result);
        scanner.close();
    }
}
