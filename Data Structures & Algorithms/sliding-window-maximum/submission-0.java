class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        SortedMap<Integer, Integer> count = new TreeMap<>();

        for (int i = 0; i < k; i++) {
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
        }

        int l = 0;
        int r = k;

        int[] result = new int[nums.length - k + 1];

        while (r < nums.length) {
            result[l] = count.lastKey();

            count.put(nums[l], count.get(nums[l]) - 1);
            if (count.get(nums[l]) == 0) {
                count.remove(nums[l]);
            }
            l++;

            count.put(nums[r], count.getOrDefault(nums[r], 0) + 1);
            r++;
        }

        result[l] = count.lastKey();

        return result;
    }
}
