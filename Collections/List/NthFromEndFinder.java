import java.util.*;

public class NthFromEndFinder {

    public static <T> T findNthFromEnd(LinkedList<T> list, int n) {
        Iterator<T> fast = list.iterator();
        Iterator<T> slow = list.iterator();

        // Move fast pointer n steps ahead
        for (int i = 0; i < n; i++) {
            if (!fast.hasNext()) {
                return null; // If n is greater than list size
            }
            fast.next();
        }

        // Move both pointers until fast reaches the end
        while (fast.hasNext()) {
            fast.next();
            slow.next();
        }

        return slow.next(); // slow now points to nth element from the end
    }

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>(Arrays.asList("A", "B", "C", "D", "E"));
        int n = 2;

        String result = findNthFromEnd(list, n);
        if (result != null) {
            System.out.println(n + "th element from end is: " + result);
        } else {
            System.out.println("Invalid input: N is larger than list size.");
        }
    }
}
