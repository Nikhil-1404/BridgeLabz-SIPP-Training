import java.util.*;

public class MergeMaps {

    public static Map<String, Integer> mergeAndSum(Map<String, Integer> map1, Map<String, Integer> map2) {
        Map<String, Integer> merged = new HashMap<>(map1);

        for (Map.Entry<String, Integer> entry : map2.entrySet()) {
            merged.merge(entry.getKey(), entry.getValue(), Integer::sum);
        }

        return merged;
    }

    public static void main(String[] args) {
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("A", 1);
        map1.put("B", 2);

        Map<String, Integer> map2 = new HashMap<>();
        map2.put("B", 3);
        map2.put("C", 4);

        Map<String, Integer> result = mergeAndSum(map1, map2);
        System.out.println("Merged Map: " + result);
    }
}
