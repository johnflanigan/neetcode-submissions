class Solution {
    public List<List<String>> solveNQueens(int n) {
        Map<Integer, Integer> rowByCol = new HashMap<>();
        List<List<String>> result = new ArrayList<>();

        dfs(n, 0, rowByCol, result);

        return result;
    }

    private void dfs(int n, int row, Map<Integer, Integer> rowByCol, List<List<String>> result) {
        if (row == n) {
            writeResult(n, rowByCol, result);
        }

        // We are assigning a queen for row row
        // We iterate over every possible column
        for (int col = 0; col < n; col++) {
            // If there is already a queen at this col, continue
            if (rowByCol.containsKey(col)) {
                continue;
            }

            // If there is a queen on the diagional, continue
            boolean isDiagonalValid = true;
            for (int i = 1; i <= row; i++) {
                if (rowByCol.getOrDefault(col - i, Integer.MIN_VALUE).equals(row - i)
                    || rowByCol.getOrDefault(col + i, Integer.MIN_VALUE).equals(row - i)
                ) {
                    isDiagonalValid = false;
                    break;
                }
            }
            if (!isDiagonalValid) {
                continue;
            }

            // We found a valid position.
            // Add queen.
            rowByCol.put(col, row);
            // Try next row
            dfs(n, row + 1, rowByCol, result);
            // Remove queen and continue
            rowByCol.remove(col);
        }
    }

    private void writeResult(int n, Map<Integer, Integer> rowByCol, List<List<String>> result) {
        List<String> grid = new ArrayList<>();

        for (int row = 0; row < n; row++) {
            StringBuilder line = new StringBuilder();

            for (int col = 0; col < n; col++) {
                if (rowByCol.get(col).equals(row)) {
                    line.append('Q');
                } else {
                    line.append('.');
                }
            }

            grid.add(line.toString());
        }

        result.add(grid);
    }
}
