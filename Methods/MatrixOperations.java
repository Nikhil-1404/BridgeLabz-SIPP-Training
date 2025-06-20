import java.util.Random;
import java.util.Scanner;

public class MatrixOperations {

    // Method to create a random matrix
    public static int[][] createRandomMatrix(int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        Random rand = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = rand.nextInt(10); // Random integers 0-9
            }
        }
        return matrix;
    }

    // Method to add two matrices
    public static int[][] addMatrices(int[][] A, int[][] B) {
        int rows = A.length;
        int cols = A[0].length;
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = A[i][j] + B[i][j];
            }
        }
        return result;
    }

    // Method to subtract two matrices
    public static int[][] subtractMatrices(int[][] A, int[][] B) {
        int rows = A.length;
        int cols = A[0].length;
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = A[i][j] - B[i][j];
            }
        }
        return result;
    }

    // Method to multiply two matrices
    public static int[][] multiplyMatrices(int[][] A, int[][] B) {
        int rowsA = A.length;
        int colsA = A[0].length;
        int colsB = B[0].length;

        int[][] result = new int[rowsA][colsB];

        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                int sum = 0;
                for (int k = 0; k < colsA; k++) {
                    sum += A[i][k] * B[k][j];
                }
                result[i][j] = sum;
            }
        }

        return result;
    }

    // Method to print a matrix
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.printf("%4d", val);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Get dimensions for addition and subtraction (must be same)
        System.out.print("Enter number of rows for addition/subtraction: ");
        int rows = sc.nextInt();
        System.out.print("Enter number of columns for addition/subtraction: ");
        int cols = sc.nextInt();

        int[][] A = createRandomMatrix(rows, cols);
        int[][] B = createRandomMatrix(rows, cols);

        System.out.println("\nMatrix A:");
        printMatrix(A);
        System.out.println("\nMatrix B:");
        printMatrix(B);

        int[][] sum = addMatrices(A, B);
        System.out.println("\nA + B:");
        printMatrix(sum);

        int[][] diff = subtractMatrices(A, B);
        System.out.println("\nA - B:");
        printMatrix(diff);

        // For multiplication, use dimensions compatible for multiplication
        System.out.print("\nEnter rows for Matrix X: ");
        int rowsX = sc.nextInt();
        System.out.print("Enter columns for Matrix X: ");
        int colsX = sc.nextInt();
        System.out.print("Enter columns for Matrix Y (rows will be equal to Matrix X columns): ");
        int colsY = sc.nextInt();

        int[][] X = createRandomMatrix(rowsX, colsX);
        int[][] Y = createRandomMatrix(colsX, colsY);

        System.out.println("\nMatrix X:");
        printMatrix(X);
        System.out.println("\nMatrix Y:");
        printMatrix(Y);

        int[][] product = multiplyMatrices(X, Y);
        System.out.println("\nX * Y:");
        printMatrix(product);

        sc.close();
    }
}
