class WordDictionary {

    class Node {
        Map<Character, Node> nodesByChar;
        boolean isWord;

        public Node() {
            this.nodesByChar = new HashMap<>();
            this.isWord = false;
        }
    }

    Node root;

    public WordDictionary() {
        this.root = new Node();
    }

    public void addWord(String word) {
        Node node = root;
        for (char c : word.toCharArray()) {
            if (!node.nodesByChar.containsKey(c)) {
                node.nodesByChar.put(c, new Node());
            }
            node = node.nodesByChar.get(c);
        }
        node.isWord = true;
    }

    public boolean search(String word) {
        return searchHelper(word, root);
    }

    public boolean searchHelper(String word, Node node) {
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            
            if (c == '.') {
                String substring = word.substring(i + 1);
                for (Node wild : node.nodesByChar.values()) {
                    boolean result = searchHelper(substring, wild);
                    if (result) {
                        return true;
                    }
                }
                return false;
            } else {
                if (node.nodesByChar.containsKey(c)) {
                    node = node.nodesByChar.get(c);
                } else {
                    return false;
                }
            }
        }
        return node.isWord;
    }
}
