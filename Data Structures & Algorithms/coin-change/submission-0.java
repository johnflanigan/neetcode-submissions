class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        
        int[] dp = new int[amount + 1];
        for (int i = 0; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int coin : coins) {
                int diff = i - coin;
                if (diff == 0) {
                    min = 1;
                } else if (diff > 0 && dp[diff] != Integer.MAX_VALUE) {
                    min = Math.min(min, dp[diff] + 1);
                }
            }
            dp[i] = min;
        }

        if (dp[amount] == Integer.MAX_VALUE) {
            return -1;
        }
        return dp[amount];
    }
}
