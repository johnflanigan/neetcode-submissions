class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // transpose
        for (int row = 0; row < n; row++) {
            for (int col = row; col < n; col++) {
                int temp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = temp;
            }
        }

        // flip
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < (n / 2); col++) {
                int temp = matrix[row][col];
                matrix[row][col] = matrix[row][n - col - 1];
                matrix[row][n - col - 1] = temp;
            }
        }


    }
}
