import java.util.*;

public class MaxValueKeyFinder {

    public static String getKeyWithMaxValue(Map<String, Integer> map) {
        String maxKey = null;
        int maxValue = Integer.MIN_VALUE;

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                maxKey = entry.getKey();
            }
        }

        return maxKey;
    }

    public static void main(String[] args) {
        Map<String, Integer> data = new HashMap<>();
        data.put("A", 10);
        data.put("B", 20);
        data.put("C", 15);

        String result = getKeyWithMaxValue(data);
        System.out.println("Key with the highest value: " + result);
    }
}
