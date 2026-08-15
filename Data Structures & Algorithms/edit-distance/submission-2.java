class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[] dp = new int[n + 1];
        int[] nextDp = new int[n + 1];

        // word2 is exhausted
        for (int j = 0; j <= n; j++) {
            dp[j] = n - j;
        }

        for (int i = m - 1; i >= 0; i--) {
            nextDp = new int[n + 1];
            nextDp[n] = m - i;

            for (int j = n - 1; j >= 0; j--) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    nextDp[j] = dp[j + 1];
                } else {
                    nextDp[j] = 1 + Math.min(nextDp[j + 1], Math.min(dp[j], dp[j + 1]));
                }
            }

            dp = nextDp;
        }

        return dp[0];
    }
}
