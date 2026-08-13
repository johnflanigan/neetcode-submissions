class Solution {
    private static final int BUYING = 0;
    private static final int SELLING = 1;

    public int maxProfit(int[] prices) {
        int[][] memo = new int[prices.length][2];
        for (int i = 0; i < prices.length; i++) {
            memo[i][BUYING] = -1;
            memo[i][SELLING] = -1;
        }

        return dfs(0, BUYING, prices, memo);
    }

    private int dfs(int i, int buying, int[] prices, int[][] memo) {
        if (i >= prices.length) {
            return 0;
        }

        if (memo[i][buying] != -1) {
            return memo[i][buying];
        }

        int skipProfit, actProfit;
        if (buying == BUYING) {
            // We are skipping today.
            skipProfit = dfs(i + 1, BUYING, prices, memo);

            // We are buying at this price.
            actProfit = dfs(i + 1, SELLING, prices, memo) - prices[i];
        } else {
            // We are selling today.
            actProfit = dfs(i + 2, BUYING, prices, memo) + prices[i];
            // We are skipping today.
            skipProfit = dfs(i + 1, SELLING, prices, memo);
        }

        memo[i][buying] = Math.max(skipProfit, actProfit);
        return memo[i][buying];
    }
}
