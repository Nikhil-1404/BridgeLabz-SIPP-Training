public class Search2DMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int left = 0;
        int right = rows * cols - 1;

        while(left <= right) {
            int mid = (left + right) / 2;
            int row = mid / cols;
            int col = mid % cols;
            int midValue = matrix[row][col];

            if(midValue == target) {
                return true;
            } else if(target < midValue) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return false; // target not found
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 50}
        };

        int target = 3;
        boolean result = searchMatrix(matrix, target);
        System.out.println("Target found: " + result);
    }
}
