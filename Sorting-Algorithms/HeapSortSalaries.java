public class HeapSortSalaries {

    // Function to perform Heap Sort
    public static void heapSort(int[] salaries) {
        int n = salaries.length;

        // Build Max Heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(salaries, n, i);
        }

        // Extract elements from heap one by one
        for (int i = n - 1; i >= 0; i--) {
            // Move current root to end
            int temp = salaries[0];
            salaries[0] = salaries[i];
            salaries[i] = temp;

            // call max heapify on the reduced heap
            heapify(salaries, i, 0);
        }
    }

    // Function to heapify a subtree rooted at index i
    public static void heapify(int[] salaries, int n, int i) {
        int largest = i; // Initialize largest as root
        int left = 2 * i + 1; // left child index
        int right = 2 * i + 2; // right child index

        // If left child is larger than root
        if (left < n && salaries[left] > salaries[largest]) {
            largest = left;
        }

        // If right child is larger than largest so far
        if (right < n && salaries[right] > salaries[largest]) {
            largest = right;
        }

        // If largest is not root
        if (largest != i) {
            int swap = salaries[i];
            salaries[i] = salaries[largest];
            salaries[largest] = swap;

            // Recursively heapify the affected subtree
            heapify(salaries, n, largest);
        }
    }

    // Main function to test Heap Sort
    public static void main(String[] args) {
        int[] salaries = {45000, 60000, 30000, 75000, 50000};

        System.out.println("Before Sorting:");
        for (int s : salaries) {
            System.out.print(s + " ");
        }

        heapSort(salaries);

        System.out.println("\nAfter Sorting:");
        for (int s : salaries) {
            System.out.print(s + " ");
        }
    }
}
