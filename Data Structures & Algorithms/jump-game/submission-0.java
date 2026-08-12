class Solution {
    public boolean canJump(int[] nums) {
        int furthestPossible = nums[0];

        int i = 0;
        while (i < nums.length && furthestPossible >= i) {
            // in the example, from index 1 we can reach 3
            furthestPossible = Math.max(furthestPossible, i + nums[i]);
            i++;

            System.out.println("i: %d, furthestPossible: %d".formatted(i, furthestPossible));
        }

        return furthestPossible >= nums.length - 1;
    }
}
