class Solution {

    private static final int INF = 2147483647;

    public void islandsAndTreasure(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    dfs(i + 1, j, grid, 1);
                    dfs(i - 1, j, grid, 1);
                    dfs(i, j + 1, grid, 1);
                    dfs(i, j - 1, grid, 1);
                }
            }
        }
    }

    private void dfs(int i, int j, int[][] grid, int steps) {
        // If we are out of bounds, return
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return;
        }

        int current = grid[i][j];
        // If we hit water, return
        if (current == -1) {
            return;
        }

        if (steps < current) {
            grid[i][j] = steps;
            dfs(i + 1, j, grid, steps + 1);
            dfs(i - 1, j, grid, steps + 1);
            dfs(i, j + 1, grid, steps + 1);
            dfs(i, j - 1, grid, steps + 1);
        }
    }
}
