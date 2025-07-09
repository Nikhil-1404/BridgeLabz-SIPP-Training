import java.util.Stack;

public class SortStackUsingRecursion {

    // Function to sort the stack
    public static void sortStack(Stack<Integer> stack) {
        // Base case
        if (stack.isEmpty()) {
            return;
        }

        // Remove top element
        int top = stack.pop();

        // Sort remaining stack
        sortStack(stack);

        // Insert the top element back in sorted order
        insertInSortedOrder(stack, top);
    }

    // Helper function to insert an element at correct position in sorted stack
    public static void insertInSortedOrder(Stack<Integer> stack, int element) {
        // Base case
        if (stack.isEmpty() || stack.peek() <= element) {
            stack.push(element);
            return;
        }

        // If top is greater, pop it and recurse
        int top = stack.pop();
        insertInSortedOrder(stack, element);

        // Push back the popped element
        stack.push(top);
    }

    // Utility function to print stack elements
    public static void printStack(Stack<Integer> stack) {
        for (int i = stack.size() - 1; i >= 0; i--) {
            System.out.println(stack.get(i));
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(30);
        stack.push(-5);
        stack.push(18);
        stack.push(14);
        stack.push(-3);

        System.out.println("Original Stack:");
        printStack(stack);

        sortStack(stack);

        System.out.println("\nSorted Stack:");
        printStack(stack);
    }
}
