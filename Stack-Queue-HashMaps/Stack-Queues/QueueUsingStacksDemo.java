import java.util.Stack;

class MyQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    // Constructor
    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    // Enqueue operation: push into stack1
    public void enqueue(int x) {
        stack1.push(x);
    }

    // Dequeue operation
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1; // or throw exception
        }

        if (stack2.isEmpty()) {
            // Transfer all elements from stack1 to stack2
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        return stack2.pop();
    }

    // Peek operation to get front element
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }

        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        return stack2.peek();
    }

    // Check if queue is empty
    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}

public class QueueUsingStacksDemo {
    public static void main(String[] args) {
        MyQueue q = new MyQueue();

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        System.out.println("Dequeued: " + q.dequeue()); // 10
        System.out.println("Front element: " + q.peek()); // 20

        q.enqueue(40);

        System.out.println("Dequeued: " + q.dequeue()); // 20
        System.out.println("Dequeued: " + q.dequeue()); // 30
        System.out.println("Dequeued: " + q.dequeue()); // 40

        System.out.println("Is queue empty? " + q.isEmpty()); // true
    }
}
