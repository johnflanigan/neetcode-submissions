class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = -1;
            }
        }

        // word2 is exhausted
        for (int i = 0; i <= m; i++) {
            dp[i][n] = m - i;;
        }
        // word1 is exhausted
        for (int j = 0; j <= n; j++) {
            dp[m][j] = n - j;
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i][j] = dp[i + 1][j + 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i][j + 1], Math.min(dp[i + 1][j], dp[i + 1][j + 1]));
                }
            }
        }

        return dp[0][0];
    }

    private int dfs(String word1, String word2, int index1, int index2, int[][] memo) {
        if (word1.length() == index1 && word2.length() == index2) {
            return 0;
        }
        if (word1.length() == index1 && index2 < word2.length()) {
            return word2.length() - index2;
        }
        if (word2.length() == index2 && index1 < word1.length()) {
            return word1.length() - index1;
        }

        if (memo[index1][index2] != -1) {
            return memo[index1][index2];
        }

        // deleting a character is equivalent to advancing index 1
        int delete = 1 + dfs(word1, word2, index1 + 1, index2, memo);

        // inserting a character is equivalent to advancing index 2
        int insert = 1 + dfs(word1, word2, index1, index2 + 1, memo);

        // if both characters match, we can advance both indices without an action
        // if they do not match, replacing also advances both indices but incurrs an action
        int replace = dfs(word1, word2, index1 + 1, index2 + 1, memo);
        if (word1.charAt(index1) != word2.charAt(index2)) {
            replace++;
        }

        memo[index1][index2] = Math.min(delete, Math.min(insert, replace));
        return memo[index1][index2];
    }
}
