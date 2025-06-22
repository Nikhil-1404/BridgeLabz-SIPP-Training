import java.util.Scanner;

public class AnagramCheck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first string: ");
        String s1 = scanner.nextLine();
        System.out.println("Enter second string: ");
        String s2 = scanner.nextLine();
        s1 = s1.replaceAll("\\s", "").toLowerCase();
        s2 = s2.replaceAll("\\s", "").toLowerCase();
        if (s1.length() != s2.length()) {
            System.out.println("Not anagrams");
        } else {
            char[] a1 = s1.toCharArray();
            char[] a2 = s2.toCharArray();
            java.util.Arrays.sort(a1);
            java.util.Arrays.sort(a2);
            boolean result = java.util.Arrays.equals(a1, a2);
            System.out.println(result ? "Anagrams" : "Not anagrams");
        }
        scanner.close();
    }
}
