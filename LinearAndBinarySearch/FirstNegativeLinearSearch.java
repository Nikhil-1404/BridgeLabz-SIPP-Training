public class FirstNegativeLinearSearch {
    public static int findFirstNegative(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] < 0) {
                return i; // return index of first negative number
            }
        }
        return -1; // no negative number found
    }

    public static void main(String[] args) {
        int[] nums = {5, 8, 0, -3, 7, -2};
        int index = findFirstNegative(nums);

        if(index != -1) {
            System.out.println("First negative number is at index: " + index + ", value: " + nums[index]);
        } else {
            System.out.println("No negative number found in the array.");
        }
    }
}
