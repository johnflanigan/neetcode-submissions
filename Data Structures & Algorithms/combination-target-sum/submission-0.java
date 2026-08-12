class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> subsets = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();

        dfs(nums, 0, target, 0, subset, subsets);

        return subsets;
    }

    public void dfs(int[] nums, int i, int target, int sum, List<Integer> subset, List<List<Integer>> subsets) {
        if (sum == target) {
            subsets.add(new ArrayList<>(subset));
            return;
        }
        if (sum > target) {
            return;
        }
        if (i >= nums.length) {
            return;
        }

        subset.add(nums[i]);
        dfs(nums, i, target, sum + nums[i], subset, subsets);

        subset.remove(subset.size() - 1);
        dfs(nums, i + 1, target, sum, subset, subsets);
    }
}
