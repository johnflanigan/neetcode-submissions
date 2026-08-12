class Solution {
    
    private static final int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public void solve(char[][] board) {
        
        int rows = board.length;
        int cols = board[0].length;

        Deque<int[]> deque = new LinkedList<>();
        boolean[][] safe = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            if (board[i][0] == 'O') {
                safe[i][0] = true;
                deque.addLast(new int[]{i, 0});
            }
            if (board[i][cols - 1] == 'O') {
                safe[i][cols - 1] = true;
                deque.addLast(new int[]{i, cols - 1});
            }
        }

        for (int j = 0; j < cols; j++) {
            if (board[0][j] == 'O') {
                safe[0][j] = true;
                deque.addLast(new int[]{0, j});
            }
            if (board[rows - 1][j] == 'O') {
                safe[rows - 1][j] = true;
                deque.addLast(new int[]{rows - 1, j});
            }
        }

        while (!deque.isEmpty()) {
            int[] current = deque.removeFirst();

            int row = current[0];
            int col = current[1];

            for (int[] direction : DIRECTIONS) {
                int nextRow = row + direction[0];
                int nextCol = col + direction[1];

                if (nextRow < 0 || nextRow >= rows || nextCol < 0 || nextCol >= cols) {
                    continue;
                }
                if (safe[nextRow][nextCol]) {
                    continue;
                }

                if (board[nextRow][nextCol] == 'O') {
                    safe[nextRow][nextCol] = true;
                    deque.addLast(new int[]{nextRow, nextCol});
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (safe[i][j]) {
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }
    }
}
