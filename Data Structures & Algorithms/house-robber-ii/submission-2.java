class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        
        int first = helper(Arrays.copyOfRange(nums, 0, nums.length - 1));
        int second = helper(Arrays.copyOfRange(nums, 1, nums.length));

        return Math.max(first, second);
    }

    private int helper(int[] nums) {
        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        }

        int first = nums[0];
        int second = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            int temp = Math.max(nums[i] + first, second);

            first = second;
            second = temp;
        }

        return second;
    }
}
