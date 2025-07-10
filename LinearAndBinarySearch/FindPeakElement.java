public class FindPeakElement {
    public static int findPeak(int[] arr) {
        int n = arr.length;
        int left = 0;
        int right = n - 1;

        while(left <= right) {
            int mid = (left + right) / 2;

            boolean leftOk = (mid == 0) || (arr[mid] > arr[mid - 1]);
            boolean rightOk = (mid == n - 1) || (arr[mid] > arr[mid + 1]);

            if(leftOk && rightOk) {
                return arr[mid]; // peak element found
            }

            if(mid > 0 && arr[mid] < arr[mid - 1]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1; // should not reach here if array has at least one element
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 20, 4, 1, 0};
        int peak = findPeak(nums);
        System.out.println("Peak element is: " + peak);
    }
}
