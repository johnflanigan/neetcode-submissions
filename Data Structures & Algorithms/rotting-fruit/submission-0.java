class Solution {
    public int orangesRotting(int[][] grid) {
        Deque<int[]> rotting = new LinkedList<>();
        int fresh = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    fresh++;
                } else if (grid[i][j] == 2) {
                    rotting.addLast(new int[]{i, j});
                }
            }
        }

        int round = 0;
        int rotted = 0;
        while (!rotting.isEmpty()) {
            round++;
            Deque<int[]> next = new LinkedList<>();

            while (!rotting.isEmpty()) {
                int[] rotten = rotting.removeFirst();
                int i = rotten[0];
                int j = rotten[1];
                // up
                if (i - 1 >= 0 && grid[i - 1][j] == 1) {
                    grid[i - 1][j] = 2;
                    rotted++;
                    next.addLast(new int[]{i - 1, j});
                }
                // down
                if (i + 1 < grid.length && grid[i + 1][j] == 1) {
                    grid[i + 1][j] = 2;
                    rotted++;
                    next.addLast(new int[]{i + 1, j});
                }
                // left
                if (j - 1 >= 0 && grid[i][j - 1] == 1) {
                    grid[i][j - 1] = 2;
                    rotted++;
                    next.addLast(new int[]{i, j - 1});
                }
                // right
                if (j + 1 < grid[0].length && grid[i][j + 1] == 1) {
                    grid[i][j + 1] = 2;
                    rotted++;
                    next.addLast(new int[]{i, j + 1});
                }
            }

            rotting = next;
            // If we did no work this round, we should not count it
            if (next.isEmpty()) {
                round--;
            }
        }

        if (fresh == rotted) {
            return round;
        } else {
            return -1;
        }
    }
}
