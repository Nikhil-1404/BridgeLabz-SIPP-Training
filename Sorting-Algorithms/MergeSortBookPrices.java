public class MergeSortBookPrices {

    // Merge two sorted subarrays arr[l..m] and arr[m+1..r]
    public static void merge(int arr[], int l, int m, int r) {
        // Sizes of two subarrays
        int n1 = m - l + 1;
        int n2 = r - m;

        // Temporary arrays
        int L[] = new int[n1];
        int R[] = new int[n2];

        // Copy data to temp arrays
        for (int i = 0; i < n1; i++)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; j++)
            R[j] = arr[m + 1 + j];

        // Merge temp arrays back into arr[l..r]
        int i = 0, j = 0, k = l;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of L[], if any
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Copy remaining elements of R[], if any
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Main mergeSort function
    public static void mergeSort(int arr[], int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;

            // Sort first and second halves
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);

            // Merge sorted halves
            merge(arr, l, m, r);
        }
    }

    // Utility to print array
    public static void printArray(int arr[]) {
        for (int price : arr) {
            System.out.print(price + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int prices[] = {250, 150, 500, 100, 350, 200};

        System.out.println("Original Book Prices:");
        printArray(prices);

        mergeSort(prices, 0, prices.length - 1);

        System.out.println("Sorted Book Prices in Ascending Order:");
        printArray(prices);
    }
}
