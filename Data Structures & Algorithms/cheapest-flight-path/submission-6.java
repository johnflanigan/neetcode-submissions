class Edge{
    int to;
    int price;

    Edge(int to, int price) {
        this.to = to;
        this.price = price;
    }
}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<Edge>> edges = new HashMap<>();
        for (int i = 0; i < n; i++) {
            edges.put(i, new ArrayList<>());
        }
        for (int[] flight : flights) {
            edges.get(flight[0]).add(new Edge(flight[1], flight[2]));
        }

        // Set<Integer> visited = new HashSet<>();
        Deque<Integer> deque = new LinkedList<>();
        Map<Integer, Integer> minPrices = new HashMap<>();

        minPrices.put(src, 0);
        int steps = 0;
        deque.addLast(src);

        while (!deque.isEmpty() && steps <= k) {
            Deque<Integer> next = new LinkedList<>();
            Map<Integer, Integer> nextMinPrices = new HashMap<>(minPrices);

            while (!deque.isEmpty()) {
                int from = deque.removeFirst();
                int fromPrice = minPrices.get(from);

                for (Edge edge : edges.get(from)) {
                    if (edge.price + fromPrice < nextMinPrices.getOrDefault(edge.to, Integer.MAX_VALUE)) {
                        nextMinPrices.put(edge.to, edge.price + fromPrice);
                        next.add(edge.to);
                    }
                }
            }

            minPrices = nextMinPrices;
            deque = next;
            steps++;
        }

        return minPrices.getOrDefault(dst, -1);
    }
}
