class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            int price = prices[i];
            int profit = price - min;

            min = Math.min(min, price);
            maxProfit = Math.max(profit, maxProfit);
        }

        return maxProfit;
    }
}
