class Solution {
    public int maxCoins(int[] nums) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        for (int num : nums) {
            list.add(num);
        }
        list.add(1);

        int[][] dp = new int[list.size()][list.size()];
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                dp[i][j] = -1;
            }
        }

        return dfs(list, 1, list.size() - 2, dp);
    }

    private int dfs(List<Integer> nums, int l, int r, int[][] dp) {
        if (l > r) {
            return 0;
        }
        if (dp[l][r] != -1) {
            return dp[l][r];
        }

        for (int i = l; i <= r; i++) {
            int res = 1;
            res *= nums.get(l - 1);
            res *= nums.get(i);
            res *= nums.get(r + 1);

            res += dfs(nums, l, i - 1, dp);
            res += dfs(nums, i + 1, r, dp);

            dp[l][r] = Math.max(dp[l][r], res);
        }

        return dp[l][r];
    }
}
