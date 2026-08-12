class Solution {

    record Pair(int x, int y) {}

    public int numIslands(char[][] grid) {
        
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;

                    Deque<Pair> deque = new LinkedList<>();
                    deque.addLast(new Pair(i, j));
                    grid[i][j] = '0';

                    while (!deque.isEmpty()) {
                        Pair pair = deque.removeFirst();
                        int x = pair.x;
                        int y = pair.y;

                        // up
                        if (x - 1 >= 0 && grid[x - 1][y] == '1') {
                            grid[x - 1][y] = '0';
                            deque.addLast(new Pair(x - 1, y));
                        }
                        // down
                        if (x + 1 < grid.length && grid[x + 1][y] == '1') {
                            grid[x + 1][y] = '0';
                            deque.addLast(new Pair(x + 1, y));
                        }
                        // left
                        if (y - 1 >= 0 && grid[x][y - 1] == '1') {
                            grid[x][y - 1] = '0';
                            deque.addLast(new Pair(x, y - 1));
                        }
                        // right
                        if (y + 1 < grid[0].length && grid[x][y + 1] == '1') {
                            grid[x][y + 1] = '0';
                            deque.addLast(new Pair(x, y + 1));
                        }
                    }
                }
            }
        }

        return count;
    }
}
