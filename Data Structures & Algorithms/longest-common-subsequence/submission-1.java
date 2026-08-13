class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1.length() == 0 || text2.length() == 0) {
            return 0;
        }
        
        int m = text1.length();
        int n = text2.length();

        int[][] memo = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    if (i > 0 && j > 0) {
                        memo[i][j] = memo[i - 1][j - 1];
                    }
                    memo[i][j]++;
                } else {
                    if (i > 0 && j > 0) {
                        memo[i][j] = Math.max(memo[i - 1][j], memo[i][j - 1]);
                    } else if (i > 0) {
                        memo[i][j] = memo[i - 1][j];
                    } else if (j > 0) {
                        memo[i][j] = memo[i][j - 1];
                    }
                }
            }
        }

        return memo[m - 1][n - 1];
    }
}
