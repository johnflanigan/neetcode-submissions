class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        boolean zeroAtTop = false;
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                zeroAtTop = true;
            }
        }

        boolean zeroAtLeft = false;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                zeroAtLeft = true;
            }
        }

        // scan all cells
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // for each top-most row cell with a zero
        for (int j = 1; j < n; j++) {
            if (matrix[0][j] == 0) {
                setCol(matrix, j);
            }
        }
        // for each left-most cell with a zero
        for (int i = 1; i < m; i++) {
            if (matrix[i][0] == 0) {
                setRow(matrix, i);
            }
        }
        if (zeroAtTop) {
            setRow(matrix, 0);
        }
        if (zeroAtLeft) {
            setCol(matrix, 0);
        }
    }

    private void setRow(int[][] matrix, int row) {
        int n = matrix[0].length;

        for (int j = 0; j < n; j++) {
            matrix[row][j] = 0;
        }
    }

    private void setCol(int[][] matrix, int col) {
        int m = matrix.length;

        for (int i = 0; i < m; i++) {
            matrix[i][col] = 0;
        }
    }
}
