import java.util.Scanner;

 class FibonacciGenerator {
    public static void main(String[] args) {
        int terms = getInput();
        generateFibonacci(terms);
    }

    static int getInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of terms: ");
        return scanner.nextInt();
    }

    static void generateFibonacci(int terms) {
        int a = 0, b = 1;
        for (int i = 1; i <= terms; i++) {
            System.out.print(a + " ");
            int next = a + b;
            a = b;
            b = next;
        }
    }
}
