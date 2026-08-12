class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int[] max = new int[nums.length];

        int max1 = nums[0];
        int max2 = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            int temp = Math.max(max1 + nums[i], max2);

            max1 = max2;
            max2 = temp;
        }

        return max2;
    }
}
