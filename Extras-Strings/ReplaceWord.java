import java.util.Scanner;

public class ReplaceWord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a sentence: ");
        String sentence = scanner.nextLine();
        System.out.println("Enter word to replace: ");
        String oldWord = scanner.nextLine();
        System.out.println("Enter new word: ");
        String newWord = scanner.nextLine();
        String result = "";
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(oldWord)) {
                words[i] = newWord;
            }
            result += words[i];
            if (i < words.length - 1) {
                result += " ";
            }
        }
        System.out.println("Modified sentence: " + result);
        scanner.close();
    }
}
