import java.util.*;

public class ZeroSumSubarrays {

    public static void findZeroSumSubarrays(int arr[]) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Pair> result = new ArrayList<>();
        int cumSum = 0;

        for (int i = 0; i < arr.length; i++) {
            cumSum += arr[i];

            // If subarray from 0 to i sums to zero
            if (cumSum == 0) {
                result.add(new Pair(0, i));
            }

            // If cumSum has been seen before, subarrays from previous indices+1 to i have zero sum
            if (map.containsKey(cumSum)) {
                List<Integer> indices = map.get(cumSum);
                for (int index : indices) {
                    result.add(new Pair(index + 1, i));
                }
            }

            // Add current index to cumSum entry
            map.putIfAbsent(cumSum, new ArrayList<>());
            map.get(cumSum).add(i);
        }

        // Print results
        if (result.isEmpty()) {
            System.out.println("No subarrays with zero sum found.");
        } else {
            System.out.println("Subarrays with zero sum:");
            for (Pair p : result) {
                System.out.println("From index " + p.start + " to " + p.end);
            }
        }
    }

    // Helper class to store subarray indices
    static class Pair {
        int start, end;
        Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        int arr[] = {3, 4, -7, 3, 1, 3, -4, -2, -2};

        findZeroSumSubarrays(arr);
    }
}
