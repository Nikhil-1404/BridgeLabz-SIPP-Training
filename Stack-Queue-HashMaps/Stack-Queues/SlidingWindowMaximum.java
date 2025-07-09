import java.util.*;

public class SlidingWindowMaximum {

    public static void slidingWindowMax(int arr[], int k) {
        int n = arr.length;
        Deque<Integer> dq = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            // Remove indices out of current window
            while (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }

            // Remove elements smaller than current from back
            while (!dq.isEmpty() && arr[i] >= arr[dq.peekLast()]) {
                dq.pollLast();
            }

            // Add current element index
            dq.offerLast(i);

            // Print max of current window
            if (i >= k - 1) {
                System.out.print(arr[dq.peekFirst()] + " ");
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        System.out.println("Sliding window maximums:");
        slidingWindowMax(arr, k);
    }
}
