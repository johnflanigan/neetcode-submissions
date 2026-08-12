class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();

        dfs(nums, 0, subset, result);

        return result;
    }

    private void dfs(int[] nums, int i, List<Integer> subset, List<List<Integer>> result) {
        if (i >= nums.length) {
            result.add(subset);
            return;
        }

        List<Integer> excluding = new ArrayList<>(subset);
        // result.add(new ArrayList<>(excluding));
        dfs(nums, i + 1, excluding, result);
        
        List<Integer> including = new ArrayList<>(subset);
        including.add(nums[i]);
        // result.add(including);
        dfs(nums, i + 1, including, result);
    }
}
