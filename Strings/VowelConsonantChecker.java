import java.util.Scanner;

public class VowelConsonantChecker {

    public static String checkChar(char c) {
        if (c >= 'A' && c <= 'Z') {
            c = (char)(c + 32);
        }
        if (c >= 'a' && c <= 'z') {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                return "Vowel";
            } else {
                return "Consonant";
            }
        }
        return "Not a Letter";
    }

    public static String[][] getCharTypes(String text) {
        String[][] result = new String[text.length()][2];
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            result[i][0] = String.valueOf(c);
            result[i][1] = checkChar(c);
        }
        return result;
    }

    public static void displayResult(String[][] data) {
        System.out.printf("%-10s%-15s\n", "Character", "Type");
        for (int i = 0; i < data.length; i++) {
            System.out.printf("%-10s%-15s\n", data[i][0], data[i][1]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        String[][] charTypes = getCharTypes(text);
        displayResult(charTypes);
    }
}
