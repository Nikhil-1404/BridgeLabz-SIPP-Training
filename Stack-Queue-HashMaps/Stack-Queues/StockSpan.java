import java.util.Stack;

public class StockSpan {

    public static void calculateSpan(int price[], int n, int span[]) {
        Stack<Integer> stack = new Stack<>();

        // Span for first day is always 1
        span[0] = 1;
        stack.push(0);

        // Calculate span for remaining days
        for (int i = 1; i < n; i++) {
            // Pop prices from stack while top price is less or equal to current price
            while (!stack.isEmpty() && price[stack.peek()] <= price[i]) {
                stack.pop();
            }

            // If stack is empty, all previous prices are smaller
            if (stack.isEmpty()) {
                span[i] = i + 1;
            } else {
                span[i] = i - stack.peek();
            }

            // Push this element index into stack
            stack.push(i);
        }
    }

    public static void main(String[] args) {
        int price[] = {100, 80, 60, 70, 60, 75, 85};
        int n = price.length;
        int span[] = new int[n];

        calculateSpan(price, n, span);

        System.out.println("Stock Spans:");
        for (int i = 0; i < n; i++) {
            System.out.print(span[i] + " ");
        }
    }
}
