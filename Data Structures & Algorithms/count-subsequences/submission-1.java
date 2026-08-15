class Solution {
    public int numDistinct(String s, String t) {
        Map<Integer, Map<Integer, Integer>> memo = new HashMap<>();

        return dfs(s, t, 0, 0, memo);
    }

    private int dfs(String s, String t, int i, int j, Map<Integer, Map<Integer, Integer>> memo) {        
        if (memo.containsKey(i) && memo.get(i).containsKey(j)) {
            return memo.get(i).get(j);
        }
        if (j >= t.length()) {
            return 1;
        }
        if (i >= s.length()) {
            return 0;
        }

        char c = s.charAt(i);
        
        int result = 0;
        if (s.charAt(i) == t.charAt(j)) {
            result += dfs(s, t, i + 1, j + 1, memo);
        }
        result += dfs(s, t, i + 1, j, memo);

        if (!memo.containsKey(i)) {
            memo.put(i, new HashMap<>());
        }
        memo.get(i).put(j, result);
        return result;
    }
}
