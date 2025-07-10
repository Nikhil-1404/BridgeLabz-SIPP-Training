import java.util.HashSet;

public class RemoveDuplicatesUsingSB {
    public static String removeDuplicates(String str) {
        StringBuilder sb = new StringBuilder();
        HashSet<Character> set = new HashSet<>();

        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(!set.contains(ch)) {
                sb.append(ch);
                set.add(ch);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String input = "programming";
        String result = removeDuplicates(input);
        System.out.println("Original String: " + input);
        System.out.println("String without duplicates: " + result);
    }
}
