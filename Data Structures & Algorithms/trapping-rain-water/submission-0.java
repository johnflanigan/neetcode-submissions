class Solution {
    public int trap(int[] height) {
        int right[] = new int[height.length];
        
        right[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            right[i] = Math.max(height[i], right[i + 1]);
        }

        int left[] = new int[height.length];
        left[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            left[i] = Math.max(height[i], left[i - 1]);
        }

        int sum = 0;

        for (int i = 1; i < height.length - 1; i++) {
            int water = Math.min(left[i - 1], right[i + 1]) - height[i];
            if (water > 0) {
                sum += water;
            }
        }

        return sum;
    }
}
