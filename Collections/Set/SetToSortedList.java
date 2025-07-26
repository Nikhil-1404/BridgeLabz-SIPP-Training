import java.util.*;

public class SetToSortedList {

    public static List<Integer> convertAndSort(Set<Integer> set) {
        List<Integer> sortedList = new ArrayList<>(set); // Convert Set to List
        Collections.sort(sortedList);                    // Sort List in ascending order
        return sortedList;
    }

    public static void main(String[] args) {
        Set<Integer> inputSet = new HashSet<>(Arrays.asList(5, 3, 9, 1));
        List<Integer> sortedList = convertAndSort(inputSet);

        System.out.println("Original Set: " + inputSet);
        System.out.println("Sorted List: " + sortedList);
    }
}
