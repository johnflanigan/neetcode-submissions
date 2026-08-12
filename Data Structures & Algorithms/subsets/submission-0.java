class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        int combos = (int) Math.pow(2, nums.length);

        for (int i = 0; i < combos; i++) {

            List<Integer> subset = new ArrayList<>();

            for (int j = 0; j < nums.length; j++) {
                int bit = (i >> j) & 1;
                if (bit == 1) {
                    subset.add(nums[j]);
                }
            }

            result.add(subset);
        }

        return result;
    }
}
