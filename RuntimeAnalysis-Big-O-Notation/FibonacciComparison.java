public class FibonacciComparison {

    // Recursive Fibonacci (Exponential Time)
    public static int fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    // Iterative Fibonacci (Linear Time)
    public static int fibonacciIterative(int n) {
        if (n <= 1) return n;
        int a = 0, b = 1, sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    public static void main(String[] args) {
        int n = 30; // try with 10, 30, 50 for comparison

        System.out.println("Fibonacci Comparison for N = " + n);

        // Recursive Fibonacci timing
        long start = System.nanoTime();
        int recResult = fibonacciRecursive(n);
        long end = System.nanoTime();
        System.out.println("Recursive Fibonacci Result: " + recResult + ", Time: " + (end - start)/1e6 + " ms");

        // Iterative Fibonacci timing
        start = System.nanoTime();
        int iterResult = fibonacciIterative(n);
        end = System.nanoTime();
        System.out.println("Iterative Fibonacci Result: " + iterResult + ", Time: " + (end - start)/1e6 + " ms");
    }
}
