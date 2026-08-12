class Solution {
    public int lengthOfLIS(int[] nums) {
        Map<Integer, Map<Integer, Integer>> dp = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            dp.put(i, new HashMap<>());
        }

        return helper(nums, 0, Integer.MIN_VALUE, dp);
    }

    private int helper(int[] nums, int i, int max, Map<Integer, Map<Integer, Integer>> dp) {
        if (i == nums.length) {
            return 0;
        }
        if (dp.get(i).containsKey(max)) {
            return dp.get(i).get(max);
        }

        int num = nums[i];
        int a = 0;
        // If we can choose this num, try choosing it. Add 1 to result.
        if (num > max) {
            a = helper(nums, i + 1, num, dp) + 1;
        }
        // We can always exclude.
        int b = helper(nums, i + 1, max, dp);

        dp.get(i).put(max, Math.max(a, b));
        return Math.max(a, b);
    }
}
