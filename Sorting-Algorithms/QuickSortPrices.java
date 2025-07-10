public class QuickSortPrices {

    // Function to perform Quick Sort
    public static void quickSort(int[] prices, int low, int high) {
        if (low < high) {
            // Partition the array and get pivot index
            int pi = partition(prices, low, high);
            
            // Recursively sort left and right subarrays
            quickSort(prices, low, pi - 1);
            quickSort(prices, pi + 1, high);
        }
    }

    // Function to partition the array
    public static int partition(int[] prices, int low, int high) {
        int pivot = prices[high]; // choosing last element as pivot
        int i = low - 1; // index of smaller element

        for (int j = low; j < high; j++) {
            if (prices[j] < pivot) {
                i++;
                // swap prices[i] and prices[j]
                int temp = prices[i];
                prices[i] = prices[j];
                prices[j] = temp;
            }
        }

        // Place pivot in correct position
        int temp = prices[i + 1];
        prices[i + 1] = prices[high];
        prices[high] = temp;

        return i + 1; // return pivot index
    }

    // Main function to test Quick Sort
    public static void main(String[] args) {
        int[] prices = {500, 1200, 700, 200, 400, 1500};

        System.out.println("Before Sorting:");
        for (int price : prices) {
            System.out.print(price + " ");
        }

        quickSort(prices, 0, prices.length - 1);

        System.out.println("\nAfter Sorting:");
        for (int price : prices) {
            System.out.print(price + " ");
        }
    }
}
