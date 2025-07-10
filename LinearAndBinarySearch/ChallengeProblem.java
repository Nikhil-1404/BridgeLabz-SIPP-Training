import java.util.Arrays;

public class ChallengeProblem {
    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // Place each number in its correct position if possible
        for(int i = 0; i < n; i++) {
            while(nums[i] > 0 && nums[i] <= n && nums[nums[i]-1] != nums[i]) {
                int temp = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = temp;
            }
        }

        // Find first missing positive
        for(int i = 0; i < n; i++) {
            if(nums[i] != i + 1) {
                return i + 1;
            }
        }

        return n + 1; // if all 1 to n are present
    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        while(left <= right) {
            int mid = (left + right) / 2;

            if(arr[mid] == target) {
                return mid;
            } else if(target < arr[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1; // target not found
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, -1, 1};
        int missing = firstMissingPositive(nums);
        System.out.println("First missing positive: " + missing);

        Arrays.sort(nums); // for binary search
        int target = 4;
        int index = binarySearch(nums, target);

        System.out.println("Index of " + target + " after sorting: " + index);
    }
}
