class PrefixTree {

    class Node {

        Map<Character, Node> nodesByChar;
        boolean isWord;

        public Node() {
            this.nodesByChar = new HashMap<>();
            this.isWord = false;
        }
    }

    Node root;

    public PrefixTree() {
         this.root = new Node();
    }

    public void insert(String word) {
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
        Node node = root;
        for (char c : word.toCharArray()) {
            if (node.nodesByChar.containsKey(c)) {
                node = node.nodesByChar.get(c);
            } else {
                return false;
            }
        }
        return node.isWord;
    }

    public boolean startsWith(String prefix) {
        Node node = root;
        for (char c : prefix.toCharArray()) {
            if (node.nodesByChar.containsKey(c)) {
                node = node.nodesByChar.get(c);
            } else {
                return false;
            }
        }
        return true;
    }
}
