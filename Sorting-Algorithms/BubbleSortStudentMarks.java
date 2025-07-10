public class BubbleSortStudentMarks {

    public static void bubbleSort(int[] marks) {
        int n = marks.length;
        boolean swapped;

        // Outer loop for passes
        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            // Inner loop for comparing adjacent elements
            for (int j = 0; j < n - i - 1; j++) {
                if (marks[j] > marks[j + 1]) {
                    // Swap marks[j] and marks[j + 1]
                    int temp = marks[j];
                    marks[j] = marks[j + 1];
                    marks[j + 1] = temp;

                    swapped = true;
                }
            }

            // If no swaps, array is sorted
            if (!swapped)
                break;
        }
    }

    public static void printArray(int[] arr) {
        for (int mark : arr) {
            System.out.print(mark + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] marks = {78, 45, 89, 32, 56, 99, 12};

        System.out.println("Original Marks:");
        printArray(marks);

        bubbleSort(marks);

        System.out.println("Sorted Marks in Ascending Order:");
        printArray(marks);
    }
}
