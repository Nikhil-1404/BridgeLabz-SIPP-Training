import java.util.*;

public class ReverseQueue {
    public static <T> void reverseQueue(Queue<T> queue) {
        Stack<T> stack = new Stack<>();

        // Step 1: Dequeue all elements and push onto stack
        while (!queue.isEmpty()) {
            stack.push(queue.remove());
        }

        // Step 2: Pop all elements from stack and enqueue back
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);

        System.out.println("Original Queue: " + queue);
        reverseQueue(queue);
        System.out.println("Reversed Queue: " + queue);
    }
}
