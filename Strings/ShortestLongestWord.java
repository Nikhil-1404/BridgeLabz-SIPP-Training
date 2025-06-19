import java.util.Scanner;

public class ShortestLongestWord {

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

    public static String[][] wordLengths(String[] words) {
        String[][] result = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            int len = getLength(words[i]);
            result[i][0] = words[i];
            result[i][1] = String.valueOf(len);
        }
        return result;
    }

    public static int[] findShortestLongest(String[][] words) {
        int minIdx = 0, maxIdx = 0;
        int min = Integer.parseInt(words[0][1]);
        int max = Integer.parseInt(words[0][1]);

        for (int i = 1; i < words.length; i++) {
            int len = Integer.parseInt(words[i][1]);
            if (len < min) {
                min = len;
                minIdx = i;
            }
            if (len > max) {
                max = len;
                maxIdx = i;
            }
        }
        return new int[]{minIdx, maxIdx};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();

        String[] words = splitManual(text);
        String[][] wordWithLengths = wordLengths(words);
        int[] result = findShortestLongest(wordWithLengths);

        System.out.println("Shortest Word: " + wordWithLengths[result[0]][0]);
        System.out.println("Longest Word: " + wordWithLengths[result[1]][0]);
    }
}
