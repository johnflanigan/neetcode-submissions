class Solution {

    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;

        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        Deque<int[]> searchP = new LinkedList<>();
        Deque<int[]> searchA = new LinkedList<>();

        for (int i = 0; i < rows; i++) {
            pacific[i][0] = true;
            searchP.addLast(new int[]{i, 0});

            atlantic[i][cols - 1] = true;
            searchA.addLast(new int[]{i, cols - 1});
        }

        for (int i = 0; i < cols; i++) {
            pacific[0][i] = true;
            searchP.addLast(new int[]{0, i});

            atlantic[rows - 1][i] = true;
            searchA.addLast(new int[]{rows - 1, i});
        }

        mark(rows, cols, pacific, heights, searchP);
        mark(rows, cols, atlantic, heights, searchA);

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (atlantic[i][j] && pacific[i][j]) {
                    List<Integer> coords = new ArrayList<>();
                    coords.add(i);
                    coords.add(j);
                    result.add(coords);
                }
            }
        }

        return result;
    }

    private void mark(int rows, int cols, boolean[][] visited, int[][] heights, Deque<int[]> nodes) {
        while (!nodes.isEmpty()) {
            int[] node = nodes.removeFirst();
            int row = node[0];
            int col = node[1];

            int height = heights[row][col];

            for (int[] direction : directions) {
                int nextRow = row + direction[0];
                int nextCol = col + direction[1];
                
                if (nextRow < 0 || nextRow >= rows || nextCol < 0 || nextCol >= cols) {
                    continue;
                }
                if (visited[nextRow][nextCol]) {
                    continue;
                }

                int nextHeight = heights[nextRow][nextCol];
                if (nextHeight >= height) {
                    visited[nextRow][nextCol] = true;
                    nodes.addLast(new int[]{nextRow, nextCol});
                }
            }
        }
    }
}
