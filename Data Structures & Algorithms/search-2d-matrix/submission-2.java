class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int l = 0;
        int r = (m * n) - 1;

        while (l <= r) {
            int middle = l + ((r - l) / 2);

            int x = middle / n;
            int y = middle % n;



            if (matrix[x][y] < target) {
                l = middle + 1;
            } else if (matrix[x][y] > target) {
                r = middle - 1;
            } else {
                return true;
            }
        }

        return false;
    }
}
