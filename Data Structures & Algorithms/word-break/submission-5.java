class TrieNode {

    Map<Character, TrieNode> map = new HashMap<>();
    boolean isWord = false;
}

class Solution {

    public boolean wordBreak(String s, List<String> wordDict) {
        TrieNode root = transform(wordDict);

        boolean[] dp = new boolean[s.length()];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = true;
        }

        return wordBreak(s, 0, root, dp);
    }

    private TrieNode transform(List<String> wordDict) {
        TrieNode root = new TrieNode();

        for (String word : wordDict) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (!node.map.containsKey(c)) {
                    node.map.put(c, new TrieNode());
                }
                node = node.map.get(c);
            }
            node.isWord = true;
        }

        return root;
    }

    private boolean wordBreak(String s, int i, TrieNode root, boolean[] dp) {
        if (i == s.length()) {
            return true;
        }

        if (!dp[i]) {
            return false;
        }
        

        TrieNode node = root;
        for (; i < s.length(); i++) {
            char c = s.charAt(i);

            if (node.map.containsKey(c)) {
                node = node.map.get(c);
                if (node.isWord) {
                    boolean result = wordBreak(s, i + 1, root, dp);
                    if (result) {
                        return true;
                    }
                }
            } else {
                dp[i] = false;
                return false;
            }
        }

        return false;
    }
}
