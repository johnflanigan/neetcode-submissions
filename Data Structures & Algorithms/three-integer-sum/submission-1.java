class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int target = 0 - nums[i];

            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                if (j == i) {
                    j++;
                    continue;
                }
                if (k == i) {
                    k--;
                    continue;
                }

                int sum = nums[j] + nums[k];
                if (sum == target) {
                    List<Integer> trio = new ArrayList<>();
                    trio.add(nums[i]);
                    trio.add(nums[j]);
                    trio.add(nums[k]);
                    result.add(trio);
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }
                } else if (sum < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }

        return result;
    }
}
