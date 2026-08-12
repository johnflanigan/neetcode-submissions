class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();

        dfs(n, 0, 0, "", result);

        return result;
    }

    private void dfs(int n, int open, int close, String current, List<String> result) {
        if (close > open) {
            return;
        } 

        if (current.length() >= 2 * n) {
            if (open == close) {
                result.add(current);
            }
            return;
        }

        // Two paths, either add open or close
        dfs(n, open + 1, close, current + "(", result);
        dfs(n, open, close + 1, current + ")", result);
    }
}
