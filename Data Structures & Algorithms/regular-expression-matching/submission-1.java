record Pair(int i, int j) {}

class Solution {
    public boolean isMatch(String s, String p) {
        Map<Pair, Boolean> memo = new HashMap<>();

        return dfs(s, p, 0, 0, memo);
    }

    private boolean dfs(String s, String p, int i, int j, Map<Pair, Boolean> memo) {
        if (memo.containsKey(new Pair(i, j))) {
            return memo.get(new Pair(i, j));
        }

        if (s.length() == i) {
            while (j + 1 < p.length() && p.charAt(j + 1) == '*') {
                j += 2;
            }
            return j == p.length();
        }
        if (p.length() == j) {
            memo.put(new Pair(i, j), false);
            return false;
        }

        boolean result;

        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
            // If it a *, we can either choose to use or skip.
            // We do not advance j when using because * can continue to be used.
            if (p.charAt(j) == '.' || s.charAt(i) == p.charAt(j)) {
                result = dfs(s, p, i + 1, j, memo);
                if (result) {
                    return result;
                }
            }
            // We are skipping using. We advance 2 to skip over character and *
            result = dfs(s, p, i, j + 2, memo);
        } else {
            if (p.charAt(j) == '.' || s.charAt(i) == p.charAt(j)) {
                result = dfs(s, p, i + 1, j + 1, memo);
                if (result) {
                    return result;
                }
            } else {
                result = false;
            }
        }

        memo.put(new Pair(i, j), result);
        return result;
    }
}
