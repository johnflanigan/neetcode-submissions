class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {

        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        List<Integer> result = new ArrayList<>();

        while (left <= right && top <= bottom) {
            // move right
            int row = top;
            int col = left;
            while (col <= right && left <= right && top <= bottom) {
                result.add(matrix[row][col]);
                col++;
            }
            top++;

            row = top;
            col = right;
            while (row <= bottom && left <= right && top <= bottom) {
                result.add(matrix[row][col]);
                row++;
            }
            right--;

            row = bottom;
            col = right;
            while (col >= left && left <= right && top <= bottom) {
                result.add(matrix[row][col]);
                col--;
            }
            bottom--;

            row = bottom;
            col = left;
            while (row >= top && left <= right && top <= bottom) {
                result.add(matrix[row][col]);
                row--;
            }
            left++;
        }

        return result;
    }
}
