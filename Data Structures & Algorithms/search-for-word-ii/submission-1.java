class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (int i = 0; i < words.length; i++) {
            trie.addWord(words[i], i);
        }

        List<String> result = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, trie.getRoot(), i, j, result, new HashSet<>(), words);
            }
        }

        return result;
    }

    public void dfs(char[][] board, TrieNode prev, int i, int j, List<String> result, Set<String> visited, String[] words) {
        if (prev.getIsWord()) {
            result.add(words[prev.getIndex()]);
            prev.setIsWord(false);
            prev.setIndex(-1);
        }

        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return;
        }

        String key = "%d-%d".formatted(i, j);
        if (visited.contains(key)) {
            return;
        }
        visited.add(key);

        char c = board[i][j];

        if (!prev.getMap().containsKey(c)) {
            return;
        }
        TrieNode node = prev.getMap().get(c);

        dfs(board, node, i + 1, j, result, new HashSet<>(visited), words);
        dfs(board, node, i - 1, j, result, new HashSet<>(visited), words);
        dfs(board, node, i, j + 1, result, new HashSet<>(visited), words);
        dfs(board, node, i, j - 1, result, new HashSet<>(visited), words);
    }
}

class Trie {

    TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public TrieNode getRoot() {
        return root;
    }

    public void addWord(String word, int index) {
        TrieNode node = root;;

        for (char c : word.toCharArray()) {
            Map<Character, TrieNode> map = node.getMap();
            if (!map.containsKey(c)) {
                map.put(c, new TrieNode());
            }
            node = map.get(c);
        }

        node.setIsWord(true);
        node.setIndex(index);
    }
}

class TrieNode {
    private Map<Character, TrieNode> map;
    private boolean isWord;
    private int index;

    public TrieNode() {
        this.map = new HashMap<>();
        this.isWord = false;
        this.index = -1;
    }

    public Map<Character, TrieNode> getMap() {
        return map;
    }

    public boolean getIsWord() {
        return isWord;
    }

    public void setIsWord(boolean isWord) {
        this.isWord = isWord;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
