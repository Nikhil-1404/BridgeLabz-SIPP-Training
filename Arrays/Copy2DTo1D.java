import java.util.Scanner;

public class Copy2DTo1D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int columns = scanner.nextInt();
        int[][] matrix = new int[rows][columns];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < columns; j++)
                matrix[i][j] = scanner.nextInt();

        int[] array = new int[rows * columns];
        int index = 0;
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < columns; j++)
                array[index++] = matrix[i][j];

        for (int i = 0; i < array.length; i++)
            System.out.print(array[i] + " ");

        scanner.close();
    }
}
