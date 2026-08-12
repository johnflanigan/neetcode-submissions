class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxRectangle = 0;
        for (int i = 0; i < heights.length; i++) {
            for (int j = i; j < heights.length; j++) {
                maxRectangle = Math.max(maxRectangle, computeRectangle(i, j, heights));
            }
        }
        return maxRectangle;
    }

    private int computeRectangle(int i, int j, int[] heights) {
        int min = Integer.MAX_VALUE;
        for (int x = i; x <= j; x++) {
            min = Math.min(min, heights[x]);
        }
        return min * (j - i + 1);
    }
}
