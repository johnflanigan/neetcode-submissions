class Edge {
    Node next;
    int weight;

    Edge(Node next, int weight) {
        this.next = next;
        this.weight = weight;
    }
}

class Node {
    int val;
    List<Edge> edges = new ArrayList<>();

    Node(int val) {
        this.val = val;
    }
}

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        
        Map<Integer, Integer> dist = new HashMap<>();
        Map<Integer, Node> nodes = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            dist.put(i, Integer.MAX_VALUE);
            nodes.put(i, new Node(i));
        }

        for (int[] time : times) {
            nodes.get(time[0]).edges.add(new Edge(nodes.get(time[1]), time[2]));
        }

        dist.put(k, 0);
        Deque<Node> deque = new LinkedList<>();
        deque.addLast(nodes.get(k));

        while (!deque.isEmpty()) {
            Node node = deque.removeFirst();

            // for each edge
            for (Edge edge : node.edges) {
                int t = dist.get(node.val) + edge.weight;

                // If we found a shorter path to edge.next
                if (t < dist.get(edge.next.val)) {
                    // Add it to deque and update distance 
                    deque.addLast(edge.next);
                    dist.put(edge.next.val, t);
                }
            }
        }

        int min = Integer.MIN_VALUE;
        for (int d : dist.values()) {
            min = Math.max(min, d);
        }

        if (min == Integer.MAX_VALUE) {
            return -1;
        }
        return min;
    }
}
