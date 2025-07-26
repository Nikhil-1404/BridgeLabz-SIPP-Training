import java.util.*;

public class GenerateBinaryNumbers {
    public static List<String> generateBinary(int n) {
        List<String> result = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();

        queue.add("1");

        for (int i = 0; i < n; i++) {
            String current = queue.remove();
            result.add(current);

            queue.add(current + "0");
            queue.add(current + "1");
        }

        return result;
    }

    public static void main(String[] args) {
        int n = 10;
        List<String> binaryNumbers = generateBinary(n);

        System.out.println("First " + n + " binary numbers:");
        for (String binary : binaryNumbers) {
            System.out.print(binary + " ");
        }
    }
}
