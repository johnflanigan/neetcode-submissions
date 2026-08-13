class Solution {
    public int change(int amount, int[] coins) {

        int[][] memo = new int[coins.length][amount + 1];
        for (int i = 0; i < coins.length; i++) {
            for (int j = 0; j <= amount; j++) {
                memo[i][j] = -1;
            }
        }

        return dfs(amount, coins, 0, 0, memo);
    }

    public int dfs(int amount, int[] coins, int i, int total, int[][] memo) {
        if (total > amount) {
            return 0;
        } else if (total == amount) {
            return 1;
        }

        if (i >= coins.length) {
            return 0;
        }

        if (memo[i][total] != -1) {
            return memo[i][total];
        }



        int result = 0;
        // pick coin. continue checking same coin
        result += dfs(amount, coins, i, total + coins[i], memo);
        // skip coin.
        result += dfs(amount, coins, i + 1, total, memo);

        memo[i][total] = result;
        return memo[i][total];
    }
}
