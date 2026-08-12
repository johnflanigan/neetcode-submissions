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
        
        Map<Integer, Map<Integer, Boolean>> memo = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            memo.put(i, new HashMap<>());
        }

        boolean result = dfs(nums, 0, 0, target, memo);

        return result;
    }

    private boolean dfs(int[] nums, int i, int current, int target, Map<Integer, Map<Integer, Boolean>> memo) {
        if (i >= nums.length) {
            return false;
        }

        // if we have already checked when we see i and current, return that result
        if (memo.get(i).containsKey(current)) {
            return memo.get(i).get(current);
        }

        int num = nums[i];

        if (num + current == target) {
            return true;
        }
        
        boolean result = dfs(nums, i + 1, current + num, target, memo);
        if (result) {
            return true;
        }
        result = dfs(nums, i + 1, current, target, memo);

        memo.get(i).put(current, result);
        return result;
    }
}
