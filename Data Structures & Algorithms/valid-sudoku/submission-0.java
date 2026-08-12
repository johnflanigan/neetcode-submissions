class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] squares = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.') {
                    continue;
                }
                int val = (int) (c - '1');
                int square = ((i / 3) * 3) + (j / 3);
                if (rows[i][val] == true || cols[j][val] == true || squares[square][val] == true) {
                    return false;
                }

                rows[i][val] = true;
                cols[j][val] = true;
                squares[square][val] = true;
            }
        }

        return true;
    }
}
