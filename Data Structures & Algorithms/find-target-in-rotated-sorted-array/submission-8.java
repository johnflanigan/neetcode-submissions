class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while (l < r) {
            int m = l + ((r - l) / 2);

            if (nums[m] < nums[r]) {
                r = m;
            } else {
                l = m + 1;
            }
        }

        int pivot = l;
        
        int res = binarySearch(0, l - 1, nums, target);
        if (res != -1) {
            return res;
        }
        res = binarySearch(l, nums.length - 1, nums, target);
        return res;
    }

    private int binarySearch(int l, int r, int[] nums, int target) {
        while (l <= r) {
            int m = l + ((r - l) / 2);

            if (nums[m] < target) {
                l = m + 1;
            } else if (nums[m] > target) {
                r = m - 1;
            } else {
                return m;
            }
        }

        return -1;
    }
}
