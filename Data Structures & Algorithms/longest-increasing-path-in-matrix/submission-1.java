class Solution {

    private static final int[][] DIRECTIONS = new int[][] {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};

    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(i, j, -1, matrix, dp);
            }
        }

        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, dp[i][j]);
            }
        }

        return max;
    }

    private int dfs(int i, int j, int prev, int[][] matrix, int[][] dp) {
        if (i < 0 || i >= matrix.length 
            || j < 0 || j >= matrix[0].length
            || prev >= matrix[i][j] 
        ) {
            return 0;
        }

        if (dp[i][j] > 0) {
            return dp[i][j];
        }

        int adj = 0;
        for (int[] direction : DIRECTIONS) {
            int newRow = i + direction[0];
            int newCol = j + direction[1];

            adj = Math.max(adj, dfs(newRow, newCol, matrix[i][j], matrix, dp));            
        }

        dp[i][j] = 1 + adj;
        return 1 + adj;
    }
}
