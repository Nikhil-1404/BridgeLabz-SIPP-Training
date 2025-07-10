public class SelectionSortScores {

    // Function to perform Selection Sort
    public static void selectionSort(int[] scores) {
        int n = scores.length;

        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n - 1; i++) {
            // Find index of minimum element in unsorted array
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (scores[j] < scores[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap the found minimum element with the first element
            int temp = scores[minIndex];
            scores[minIndex] = scores[i];
            scores[i] = temp;
        }
    }

    // Main function to test Selection Sort
    public static void main(String[] args) {
        int[] scores = {85, 70, 95, 60, 80};

        System.out.println("Before Sorting:");
        for (int score : scores) {
            System.out.print(score + " ");
        }

        selectionSort(scores);

        System.out.println("\nAfter Sorting:");
        for (int score : scores) {
            System.out.print(score + " ");
        }
    }
}
