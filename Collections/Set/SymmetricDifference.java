import java.util.*;

public class SymmetricDifference {

    public static <T> Set<T> getSymmetricDifference(Set<T> set1, Set<T> set2) {
        Set<T> result = new HashSet<>(set1);    // Copy of set1
        Set<T> temp = new HashSet<>(set2);      // Copy of set2

        result.removeAll(set2); // result = set1 - set2
        temp.removeAll(set1);   // temp = set2 - set1

        result.addAll(temp);    // result = (set1 - set2) ∪ (set2 - set1)

        return result;
    }

    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(3, 4, 5));

        Set<Integer> symmetricDiff = getSymmetricDifference(set1, set2);

        System.out.println("Set1: " + set1);
        System.out.println("Set2: " + set2);
        System.out.println("Symmetric Difference: " + symmetricDiff);
    }
}
