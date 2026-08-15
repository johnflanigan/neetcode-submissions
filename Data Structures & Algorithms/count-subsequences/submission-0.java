class Solution {
    public int numDistinct(String s, String t) {
        Map<Integer, Map<String, Integer>> memo = new HashMap<>();

        return dfs(s, t, 0, new StringBuilder(), memo);
    }

    private int dfs(String s, String t, int i, StringBuilder sb, Map<Integer, Map<String, Integer>> memo) {        
        String subsequence = sb.toString();
        if (memo.containsKey(i) && memo.get(i).containsKey(subsequence)) {
            return memo.get(i).get(subsequence);
        }
        if (subsequence.length() > t.length()) {
            return 0;
        }
        if (t.equals(subsequence)) {
            return 1;
        }
        if (i >= s.length()) {
            return 0;
        }


        char c = s.charAt(i);
        int result = 0;
        

        sb.append(c);
        result += dfs(s, t, i + 1, sb, memo);
        sb.deleteCharAt(sb.length() - 1);

        result += dfs(s, t, i + 1, sb, memo);

        if (!memo.containsKey(i)) {
            memo.put(i, new HashMap<>());
        }
        memo.get(i).put(subsequence, result);
        return result;
    }
}
