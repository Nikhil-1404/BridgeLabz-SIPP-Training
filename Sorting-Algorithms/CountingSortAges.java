public class CountingSortAges {

    // Function to perform Counting Sort
    public static void countingSort(int[] ages) {
        int min = 10; // minimum age
        int max = 18; // maximum age

        int range = max - min + 1; // range of ages (9)
        int[] count = new int[range]; // count array
        int[] output = new int[ages.length]; // output array

        // Step 1: Store the count of each age
        for (int age : ages) {
            count[age - min]++;
        }

        // Step 2: Change count[i] so that count[i] contains actual position
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        // Step 3: Build the output array (traverse input from end for stability)
        for (int i = ages.length - 1; i >= 0; i--) {
            output[count[ages[i] - min] - 1] = ages[i];
            count[ages[i] - min]--;
        }

        // Step 4: Copy output array back to original array
        for (int i = 0; i < ages.length; i++) {
            ages[i] = output[i];
        }
    }

    // Main function to test Counting Sort
    public static void main(String[] args) {
        int[] ages = {14, 16, 10, 18, 12, 14, 13};

        System.out.println("Before Sorting:");
        for (int age : ages) {
            System.out.print(age + " ");
        }

        countingSort(ages);

        System.out.println("\nAfter Sorting:");
        for (int age : ages) {
            System.out.print(age + " ");
        }
    }
}
