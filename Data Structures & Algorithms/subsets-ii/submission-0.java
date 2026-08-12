class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();

        Arrays.sort(nums);

        dfs(nums, 0, subset, subsets);

        return subsets;
    }

    private void dfs(int[] nums, int i, List<Integer> subset, List<List<Integer>> subsets) {
        if (i >= nums.length) {
            subsets.add(new ArrayList<>(subset));
            return;
        }

        int num = nums[i];
        subset.add(num);
        dfs(nums, i + 1, subset, subsets);

        subset.remove(subset.size() - 1);
        while (i < nums.length && nums[i] == num) {
            i++;
        }
        dfs(nums, i, subset, subsets);
    }
}
