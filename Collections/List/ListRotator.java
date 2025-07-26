import java.util.*;

public class ListRotator {
    public static <T> void rotateList(List<T> list, int positions) {
        int n = list.size();
        positions = positions % n;
        List<T> temp = new ArrayList<>(list.subList(0, positions));
        list.subList(0, n - positions).clear();
        list.addAll(temp);
    }

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));
        rotateList(numbers, 2);
        System.out.println("Rotated List: " + numbers);
        // Output: [30, 40, 50, 10, 20]
    }
}
