public class InsertionSortEmployeeIDs {

    public static void insertionSort(int[] empIDs) {
        int n = empIDs.length;

        // Loop through unsorted elements
        for (int i = 1; i < n; i++) {
            int key = empIDs[i];  // Current element to insert
            int j = i - 1;

            // Shift elements greater than key to right
            while (j >= 0 && empIDs[j] > key) {
                empIDs[j + 1] = empIDs[j];
                j--;
            }

            // Insert key at correct position
            empIDs[j + 1] = key;
        }
    }

    public static void printArray(int[] arr) {
        for (int id : arr) {
            System.out.print(id + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] empIDs = {105, 102, 108, 101, 103, 107};

        System.out.println("Original Employee IDs:");
        printArray(empIDs);

        insertionSort(empIDs);

        System.out.println("Sorted Employee IDs in Ascending Order:");
        printArray(empIDs);
    }
}
