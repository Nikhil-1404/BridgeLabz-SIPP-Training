public class FirstLastOccurrence {
    public static int findFirst(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int result = -1;

        while(left <= right) {
            int mid = (left + right) / 2;

            if(arr[mid] == target) {
                result = mid;
                right = mid - 1; // continue search on left
            } else if(target < arr[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }

    public static int findLast(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int result = -1;

        while(left <= right) {
            int mid = (left + right) / 2;

            if(arr[mid] == target) {
                result = mid;
                left = mid + 1; // continue search on right
            } else if(target < arr[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 4, 4, 6, 8, 8, 10};
        int target = 4;

        int first = findFirst(arr, target);
        int last = findLast(arr, target);

        if(first == -1) {
            System.out.println("Element not found");
        } else {
            System.out.println("First Occurrence: " + first);
            System.out.println("Last Occurrence: " + last);
        }
    }
}
