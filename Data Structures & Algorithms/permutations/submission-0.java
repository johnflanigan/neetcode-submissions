class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        List<Integer> permutation = new ArrayList<>();
        Set<Integer> selected = new HashSet<>();

        dfs(nums, selected, permutation, permutations);

        return permutations;
    }

    private void dfs(int[] nums, Set<Integer> selected, List<Integer> permutation, List<List<Integer>> permutations) {

        if (selected.size() >= nums.length) {
            permutations.add(new ArrayList<>(permutation));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (selected.contains(num)) {
                continue;
            }

            permutation.add(num);
            selected.add(num);

            dfs(nums, selected, permutation, permutations);

            permutation.remove(permutation.size() - 1);
            selected.remove(num);
        }
    }
}
