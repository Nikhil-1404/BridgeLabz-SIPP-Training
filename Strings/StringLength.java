import java.util.Scanner;

public class StringLength {

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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.next();
        int manualLength = getLength(text);
        int builtinLength = text.length();
        System.out.println("Manual Length: " + manualLength);
        System.out.println("Built-in Length: " + builtinLength);
    }
}
