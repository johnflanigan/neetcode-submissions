class Solution {
    public boolean canJump(int[] nums) {
        int furthestPossible = nums[0];

        int i = 0;
        while (i < nums.length && furthestPossible >= i) {
            furthestPossible = Math.max(furthestPossible, i + nums[i]);
            i++;
        }

        return furthestPossible >= nums.length - 1;
    }
}
