import java.util.*;

public class StackUsingQueues {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    // Push element to the stack
    public void push(int x) {
        q2.add(x); // Step 1: Add to q2

        // Step 2: Move all elements from q1 to q2
        while (!q1.isEmpty()) {
            q2.add(q1.remove());
        }

        // Step 3: Swap q1 and q2
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    // Removes the top element
    public int pop() {
        if (q1.isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        return q1.remove();
    }

    // Returns the top element without removing
    public int top() {
        if (q1.isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        return q1.peek();
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return q1.isEmpty();
    }

    public static void main(String[] args) {
        StackUsingQueues stack = new StackUsingQueues();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Top element: " + stack.top()); // Output: 3
        System.out.println("Popped element: " + stack.pop()); // Output: 3
        System.out.println("Top element after pop: " + stack.top()); // Output: 2
    }
}
