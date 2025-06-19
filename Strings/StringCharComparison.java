import java.util.Scanner;

public class StringCharComparison {
    public static char[] getChars(String text) {
        char[] chars = new char[text.length()];
        for (int i = 0; i < text.length(); i++) {
            chars[i] = text.charAt(i);
        }
        return chars;
    }

    public static boolean compareArrays(char[] arr1, char[] arr2) {
        if (arr1.length != arr2.length) return false;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.next();
        char[] userDefinedChars = getChars(text);
        char[] builtInChars = text.toCharArray();
        boolean result = compareArrays(userDefinedChars, builtInChars);

        System.out.println("User Defined Method Result: ");
        for (char c : userDefinedChars) System.out.print(c + " ");
        System.out.println("\nBuilt-in Method Result: ");
        for (char c : builtInChars) System.out.print(c + " ");
        System.out.println("\nArrays are equal: " + result);
    }
}
