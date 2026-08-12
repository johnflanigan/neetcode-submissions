class Solution {
    public int countComponents(int n, int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }

        Set<Integer> visited = new HashSet<>();
        int components = 0;
        // For every node
        for (int i = 0; i < n; i++) {
            // If it has not been visited, perform a search
            if (visited.contains(i)) {
                continue;
            }
            components++;

            Deque<Integer> deque = new LinkedList<>();
            deque.addLast(i);
            while (!deque.isEmpty()) {
                int j = deque.removeFirst();
                List<Integer> adjacent = map.get(j);
                for (int k : adjacent) {
                    if (!visited.contains(k)) {
                        deque.addLast(k);
                        visited.add(k);
                    }
                }
            }
        }

        return components;
    }
}
