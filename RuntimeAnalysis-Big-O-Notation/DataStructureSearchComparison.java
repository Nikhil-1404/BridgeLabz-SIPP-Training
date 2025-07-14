import java.util.HashSet;
import java.util.TreeSet;
import java.util.Random;

public class DataStructureSearchComparison {

    // Array search (Linear)
    public static boolean arraySearch(int[] arr, int target) {
        for (int num : arr) {
            if (num == target)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int N = 100000; // dataset size
        int[] data = new int[N];
        HashSet<Integer> hashSet = new HashSet<>();
        TreeSet<Integer> treeSet = new TreeSet<>();
        Random rand = new Random();

        // Populate data structures
        for (int i = 0; i < N; i++) {
            data[i] = rand.nextInt(N * 10);
            hashSet.add(data[i]);
            treeSet.add(data[i]);
        }

        int target = data[N - 1]; // ensure target is present

        System.out.println("Searching Comparison for N = " + N + " and target = " + target);

        // Array Search timing
        long start = System.nanoTime();
        boolean foundArray = arraySearch(data, target);
        long end = System.nanoTime();
        System.out.println("Array Search: " + foundArray + ", Time: " + (end - start)/1e6 + " ms");

        // HashSet Search timing
        start = System.nanoTime();
        boolean foundHashSet = hashSet.contains(target);
        end = System.nanoTime();
        System.out.println("HashSet Search: " + foundHashSet + ", Time: " + (end - start)/1e6 + " ms");

        // TreeSet Search timing
        start = System.nanoTime();
        boolean foundTreeSet = treeSet.contains(target);
        end = System.nanoTime();
        System.out.println("TreeSet Search: " + foundTreeSet + ", Time: " + (end - start)/1e6 + " ms");
    }
}
