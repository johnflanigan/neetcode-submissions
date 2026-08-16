class Solution {
    public int missingNumber(int[] nums) {

        int max = 0;
        int res = 0;

        for (int num : nums) {
            max = Math.max(max, num);
            res = res ^ num;
        }

        for (int i = 0; i <= nums.length; i++) {
            res = res ^ i;
        }

        return res;
    }
}
