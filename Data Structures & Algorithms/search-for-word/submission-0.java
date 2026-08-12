class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        boolean[][] visited = new boolean[m][n];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean result = dfs(board, word, visited, i, j, sb);
                if (result) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word, boolean[][] visited, int i, int j, StringBuilder sb) {
        if (sb.length() == word.length()) {
            return sb.toString().equals(word);
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return false;
        }

        char target = word.charAt(sb.length());

        // If this is a valid letter
        if (board[i][j] == target && !visited[i][j]) {
            sb.append(board[i][j]);
            visited[i][j] = true;

            boolean left = dfs(board, word, visited, i, j - 1, sb);
            if (left) {
                return true;
            }
            boolean right = dfs(board, word, visited, i, j + 1, sb);
            if (right) {
                return true;
            }
            boolean up = dfs(board, word, visited, i - 1, j, sb);
            if (up) {
                return true;
            }
            boolean down = dfs(board, word, visited, i + 1, j, sb);
            if (down) {
                return true;
            }

            sb.deleteCharAt(sb.length() - 1);
            visited[i][j] = false;
        }

        return false;
    }
}
