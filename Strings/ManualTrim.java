import java.util.Scanner;

public class ManualTrim {

    public static int[] getTrimIndexes(String text) {
        int start = 0;
        int end = 0;
        int length = 0;
        try {
            while (true) {
                text.charAt(length);
                length++;
            }
        } catch (Exception e) {
        }
        for (int i = 0; i < length; i++) {
            if (text.charAt(i) != ' ') {
                start = i;
                break;
            }
        }
        for (int i = length - 1; i >= 0; i--) {
            if (text.charAt(i) != ' ') {
                end = i;
                break;
            }
        }
        return new int[]{start, end};
    }

    public static String manualSubstring(String text, int start, int end) {
        String result = "";
        for (int i = start; i <= end; i++) {
            result += text.charAt(i);
        }
        return result;
    }

    public static boolean compareStrings(String a, String b) {
        int lenA = 0, lenB = 0;
        try {
            while (true) {
                a.charAt(lenA);
                lenA++;
            }
        } catch (Exception e) {
        }
        try {
            while (true) {
                b.charAt(lenB);
                lenB++;
            }
        } catch (Exception e) {
        }
        if (lenA != lenB) return false;
        for (int i = 0; i < lenA; i++) {
            if (a.charAt(i) != b.charAt(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        int[] indexes = getTrimIndexes(text);
        String manualTrimmed = manualSubstring(text, indexes[0], indexes[1]);
        String builtinTrimmed = text.trim();
        boolean areEqual = compareStrings(manualTrimmed, builtinTrimmed);

        System.out.println("Manual Trim: '" + manualTrimmed + "'");
        System.out.println("Built-in Trim: '" + builtinTrimmed + "'");
        System.out.println("Are both equal: " + areEqual);
    }
}
