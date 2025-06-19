import java.util.Scanner;

public class SplitText {
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

    public static String[] splitManual(String text) {
        int length = getLength(text);
        int wordCount = 1;
        for (int i = 0; i < length; i++) {
            if (text.charAt(i) == ' ') {
                wordCount++;
            }
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

    public static boolean compareArrays(String[] a, String[] b) {
        if (a.length != b.length) return false;
        for (int i = 0; i < a.length; i++) {
            if (!a[i].equals(b[i])) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        String[] manual = splitManual(text);
        String[] builtin = text.split(" ");
        boolean equal = compareArrays(manual, builtin);

        System.out.println("Manual Split:");
        for (String w : manual) System.out.println(w);
        System.out.println("Built-in Split:");
        for (String w : builtin) System.out.println(w);
        System.out.println("Are both equal: " + equal);
    }
}
