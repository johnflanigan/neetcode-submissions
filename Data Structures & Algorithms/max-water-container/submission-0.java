class Solution {
    public int maxArea(int[] heights) {
        int i = 0;
        int j = heights.length - 1;

        int max = 0;

        while (i < j) {
            int x = heights[i];
            int y = heights[j];

            int current = Math.min(x, y) * (j - i);
            max = Math.max(max, current);

            if (x < y) {
                i++;
            } else {
                j--;
            }
        }

        return max;
    }
}
