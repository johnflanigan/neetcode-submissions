class Solution {
    public int minCostClimbingStairs(int[] cost) {
        
        int[] memo = new int[cost.length + 1];
        int first = cost[0];
        int second = cost[1];

        int current = -1;

        for (int i = 2; i < cost.length; i++) {
            current = cost[i] + Math.min(first, second);

            first = second;
            second = current;
        }

        return Math.min(first, second);
    }
}
