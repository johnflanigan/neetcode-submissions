class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int[][] memo = new int[s1.length()][s2.length()];
        return dfs(s1, s2, s3, 0, 0, memo);
    }

    private boolean dfs(String s1, String s2, String s3, int i, int j, int memo[][]) {
        int k = i + j;

        if (i < s1.length() && j < s2.length() && memo[i][j] == -1) {
            return false;
        }

        if (i == s1.length() && j == s2.length() && k == s3.length()) {
            return true;
        }
        if (k >= s3.length()) {
            return false;
        }
        if (i < s1.length() && j >= s2.length() && k < s3.length()) {
            if (s1.charAt(i) == s3.charAt(k)) {
                return dfs(s1, s2, s3, i + 1, j, memo);
            } else {
                return false;
            }
        }
        if (i >= s1.length() && j < s2.length() && k < s3.length()) {
            if (s2.charAt(j) == s3.charAt(k)) {
                return dfs(s1, s2, s3, i, j + 1, memo);
            } else {
                return false;
            }
        }
        if (i >= s1.length() || j >= s2.length() || k >= s3.length()) {
            return false;
        }


        boolean a = false;
        if (s1.charAt(i) == s3.charAt(k)) {
            a = dfs(s1, s2, s3, i + 1, j, memo);
        }
        boolean b = false;
        if (s2.charAt(j) == s3.charAt(k)) {
            b = dfs(s1, s2, s3, i, j + 1, memo);
        }

        boolean result = a || b;
        if (!result) {
            memo[i][j] = -1;
        }
        return result;
    }
}
