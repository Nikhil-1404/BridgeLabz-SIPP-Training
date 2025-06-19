import java.util.Scanner;

public class WordLength2DArray {

    public static String[] splitManual(String text) {
        int length = getLength(text);
        int wordCount = 1;
        for (int i = 0; i < length; i++) {
            if (text.charAt(i) == ' ') wordCount++;
        }

        int[] indexes = new int[wordCount + 1];
        int idx = 0;
        for (int i = 0; i < length; i++) {
            if (text.charAt(i) == ' ') {
                indexes[++idx] = i;
            }
        }
        indexes[++idx] = length;

        String[] words = new String[wordCount];
        int start = 0;
        for (int i = 0; i < wordCount; i++) {
            String word = "";
            for (int j = start; j < indexes[i + 1]; j++) {
                word += text.charAt(j);
            }
            words[i] = word.trim();
            start = indexes[i + 1] + 1;
        }
        return words;
    }

    public static int getLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (Exception e) {
        }
        return count;
    }

    public static String[][] getWordLengthArray(String[] words) {
        String[][] result = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            int len = getLength(words[i]);
            result[i][0] = words[i];
            result[i][1] = String.valueOf(len);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        String[] words = splitManual(text);
        String[][] wordLengthArray = getWordLengthArray(words);

        System.out.printf("%-15s%-10s\n", "Word", "Length");
        for (int i = 0; i < wordLengthArray.length; i++) {
            String word = wordLengthArray[i][0];
            int length = Integer.parseInt(wordLengthArray[i][1]);
            System.out.printf("%-15s%-10d\n", word, length);
        }
    }
}
