class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int[] maxWith = new int[nums.length];
        int[] maxWithout = new int[nums.length];

        maxWith[0] = nums[0];
        maxWithout[0] = 0;

        maxWith[1] = nums[1];
        maxWithout[1] = nums[0];

        for (int i = 2; i < nums.length; i++) {
            maxWith[i] =  nums[i] + Math.max(maxWith[i - 2], maxWithout[i - 1]);
            maxWithout[i] = Math.max(Math.max(maxWith[i - 1], maxWith[i - 1]), maxWithout[i - 1]);
        }

        return Math.max(maxWith[maxWith.length - 2], maxWith[maxWith.length - 1]);
    }
}
