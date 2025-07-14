import java.util.Arrays;

public class SearchComparison {

    // Linear Search
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i; // return index if found
            }
        }
        return -1; // not found
    }

    // Binary Search (Assumes sorted array)
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid; // found
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1; // not found
    }

    public static void main(String[] args) {
        // Example dataset size
        int N = 1000000;
        int[] data = new int[N];

        // Initialize array with sorted data [0,1,2,...,N-1]
        for (int i = 0; i < N; i++) {
            data[i] = i;
        }

        int target = N - 1; // target value at end to simulate worst case for Linear Search

        // Timing Linear Search
        long startTime = System.nanoTime();
        int result1 = linearSearch(data, target);
        long endTime = System.nanoTime();
        System.out.println("Linear Search result: " + result1 + ", Time taken: " + (endTime - startTime)/1e6 + " ms");

        // Timing Binary Search
        startTime = System.nanoTime();
        int result2 = binarySearch(data, target);
        endTime = System.nanoTime();
        System.out.println("Binary Search result: " + result2 + ", Time taken: " + (endTime - startTime)/1e6 + " ms");
    }
}
