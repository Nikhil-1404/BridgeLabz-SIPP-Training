import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int maxLen = 0;

        // Add all elements to set
        for (int num : nums) {
            set.add(num);
        }

        // Check for sequence starting points
        for (int num : nums) {
            // If num-1 is not in set, num is the start of a sequence
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentLen = 1;

                // Count sequence length
                while (set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentLen += 1;
                }

                maxLen = Math.max(maxLen, currentLen);
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};

        int result = longestConsecutive(nums);
        System.out.println("Length of longest consecutive sequence: " + result);
    }
}
