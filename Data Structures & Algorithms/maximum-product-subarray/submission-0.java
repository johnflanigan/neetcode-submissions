class Solution {
    public int maxProduct(int[] nums) {
        
        int globalMax = nums[0];

        int min = nums[0];
        int max = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];

            int newMin = Integer.min(num, Integer.min(max * num, min * num));
            int newMax = Integer.max(num, Integer.max(max * num, min * num));

            min = newMin;
            max = newMax;

            globalMax = Math.max(globalMax, max);
        }

        return globalMax;
    }
}
