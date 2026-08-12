/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        
        // Visited tracks original nodes
        Set<Node> visited = new HashSet<>();
        Map<Node, Node> oldToNew = new HashMap<>();
        Deque<Node> deque = new LinkedList<>();

        deque.addLast(node);
        visited.add(node);

        while (!deque.isEmpty()) {
            // Read a node and create a copy if none exists
            Node current = deque.removeFirst();
            if (!oldToNew.containsKey(current)) {
                oldToNew.put(current, new Node(current.val));
            }

            Node copy = oldToNew.get(current);
            List<Node> neighborCopy = new ArrayList<>();

            for (Node adj : current.neighbors) {
                if (!oldToNew.containsKey(adj)) {
                    oldToNew.put(adj, new Node(adj.val));
                }
                neighborCopy.add(oldToNew.get(adj));

                if (!visited.contains(adj)) {
                    visited.add(adj);
                    deque.addLast(adj);
                }
            }
            copy.neighbors = neighborCopy;
        }

        return oldToNew.get(node);

    }
}