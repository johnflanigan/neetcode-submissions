class Node {
    String val;
    List<Node> adjacent = new ArrayList<>();

    Node(String val) {
        this.val = val;
    }
}

record Pair(Node node, int steps) {}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        Map<String, Set<String>> lookup = new HashMap<>();
        for (String word : wordList) {
            lookup.put(word, new HashSet<>());
            for (int i = 0; i < word.length(); i++) {
                StringBuilder sb = new StringBuilder(word);
                sb.setCharAt(i, '.');
                lookup.get(word).add(sb.toString());
            }
        }
        lookup.put(beginWord, new HashSet<>());
        for (int i = 0; i < beginWord.length(); i++) {
            StringBuilder sb = new StringBuilder(beginWord);
            sb.setCharAt(i, '.');
            lookup.get(beginWord).add(sb.toString());
        }

        Map<String, Set<String>> inverse = new HashMap<>();
        for (Map.Entry<String, Set<String>> entry : lookup.entrySet()) {
            for (String s : entry.getValue()) {
                if (!inverse.containsKey(s)) {
                    inverse.put(s, new HashSet<>());
                }
                inverse.get(s).add(entry.getKey());
            }
        }

        Map<String, Node> nodes = new HashMap<>();
        nodes.put(beginWord, new Node(beginWord));
        for (String word : wordList) {
            nodes.put(word, new Node(word));
        }

        updateNodes(beginWord, lookup, inverse, nodes);
        for (String word : wordList) {
            updateNodes(word, lookup, inverse, nodes);
        }

        Node root = nodes.get(beginWord);
        int steps = 1;
        Deque<Pair> deque = new LinkedList<>();
        deque.addLast(new Pair(root, steps));
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        while (!deque.isEmpty()) {
            Pair pair = deque.removeFirst();
            if (pair.node.val.equals(endWord)) {
                return pair.steps;
            }

            for (Node adj : pair.node.adjacent) {
                if (!visited.contains(adj.val)) {
                    deque.addLast(new Pair(adj, pair.steps + 1));
                    visited.add(adj.val);
                }
            }
        }

        return 0;
    }

    private void updateNodes(
        String word,
        Map<String, Set<String>> lookup,
        Map<String, Set<String>> inverse,
        Map<String, Node> nodes
    ) {
        Node to = nodes.get(word);
        for (String wordWithDots : lookup.get(word)) {
            for (String match : inverse.get(wordWithDots)) {
                if (match.equals(word)) {
                    continue;
                }
                Node from = nodes.get(match);
                to.adjacent.add(from);
                from.adjacent.add(to);
            }
        }
    }
}
