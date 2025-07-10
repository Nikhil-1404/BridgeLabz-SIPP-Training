public class FindRotationPoint {
    public static int findRotationPoint(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while(left < right) {
            int mid = (left + right) / 2;

            if(arr[mid] > arr[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left; // index of smallest element
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int index = findRotationPoint(nums);

        System.out.println("Rotation point (smallest element) is at index: " + index);
        System.out.println("Smallest element: " + nums[index]);
    }
}
