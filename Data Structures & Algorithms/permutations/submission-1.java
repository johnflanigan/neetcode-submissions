class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        List<Integer> permutation = new ArrayList<>();
        Deque<Integer> available = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            available.addLast(nums[i]);
        }

        dfs(nums, available, permutation, permutations);

        return permutations;
    }

    private void dfs(int[] nums, Deque<Integer> available, List<Integer> permutation, List<List<Integer>> permutations) {
        if (available.isEmpty()) {
            permutations.add(new ArrayList<>(permutation));
            return;
        }

        int num = available.removeFirst();
        int start = num;

        permutation.add(num);
        dfs(nums, available, permutation, permutations);
        permutation.remove(permutation.size() - 1);
        available.addLast(num);

        while (available.peekFirst() != start) {
            num = available.removeFirst();
            permutation.add(num);
            dfs(nums, available, permutation, permutations);
            permutation.remove(permutation.size() - 1);
            available.addLast(num);
        }
    }
}
