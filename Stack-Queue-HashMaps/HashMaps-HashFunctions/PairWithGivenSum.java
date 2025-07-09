import java.util.*;

public class PairWithGivenSum {

    public static boolean hasPairWithSum(int arr[], int target) {
        Set<Integer> seen = new HashSet<>();

        for (int num : arr) {
            int complement = target - num;

            if (seen.contains(complement)) {
                System.out.println("Pair found: (" + complement + ", " + num + ")");
                return true;
            }

            seen.add(num);
        }

        System.out.println("No pair with given sum found.");
        return false;
    }

    public static void main(String[] args) {
        int arr[] = {8, 4, 1, 6};
        int target = 10;

        hasPairWithSum(arr, target);
    }
}
