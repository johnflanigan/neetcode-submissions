class Solution {
    public boolean canPartition(int[] nums) {
        if (nums.length == 0) {
            return false;
        }

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 == 1) {
            return false;
        }

        int target = sum / 2;
        
        boolean result = dfs(nums, 0, 0, target);

        return result;
    }

    private boolean dfs(int[] nums, int i, int current, int target) {
        if (i >= nums.length) {
            return false;
        }

        int num = nums[i];

        if (num + current == target) {
            return true;
        }
        
        boolean result = dfs(nums, i + 1, current + num, target);
        if (result) {
            return true;
        }
        return dfs(nums, i + 1, current, target);
    }
}
