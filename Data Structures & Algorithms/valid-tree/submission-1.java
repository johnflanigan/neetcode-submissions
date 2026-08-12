class Solution {
    public boolean validTree(int n, int[][] edges) {

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int[] edge : edges) {
            if (!map.containsKey(edge[0])) {
                map.put(edge[0], new ArrayList<>());
            }
            if (!map.containsKey(edge[1])) {
                map.put(edge[1], new ArrayList<>());
            }
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }

        Set<Integer> visited = new HashSet<>();
        boolean result = dfs(0, -1, visited, map);

        return result && visited.size() == n;
    }

    private boolean dfs(int curr, int prev, Set<Integer> visited, Map<Integer, List<Integer>> edges) {
        if (visited.contains(curr)) {
            return false;
        }
        visited.add(curr);

        for (int next : edges.getOrDefault(curr, new ArrayList<>())) {
            if (next == prev) {
                continue;
            }
            boolean result = dfs(next, curr, visited, edges);
            if (!result) {
                return false;
            }
        }

        return true;
    }
}
