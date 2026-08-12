class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 1; i <= edges.length; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }

        Set<Integer> visited = new HashSet<>();

        List<Integer> cycleList = dfs(1, -1, map, visited, new ArrayList<>());
        Set<Integer> cycleSet = new HashSet<>(cycleList);

        int[] result = new int[]{-1, -1};
        for (int[] edge : edges) {
            if (cycleSet.contains(edge[0]) && cycleSet.contains(edge[1])) {
                result = edge;
            }
        }

        return result;
    }

    private List<Integer> dfs(int current, int prev, Map<Integer, List<Integer>> map, Set<Integer> visited, List<Integer> steps) {
        if (visited.contains(current)) {
            int index = steps.indexOf(current);
            return steps.subList(index, steps.size());
        }

        visited.add(current);
        steps.add(current);
        for (int adj : map.get(current)) {
            if (adj == prev) {
                continue;
            }
            List<Integer> cycle = dfs(adj, current, map, visited, steps);
            if (!cycle.isEmpty()) {
                return cycle;
            }
        }
        steps.remove(steps.size() - 1);
        visited.remove(current);
        return new ArrayList<>();
    }
}
