record Edge(int i, int j, int dist) {}

class Solution {
    public int minCostConnectPoints(int[][] points) {
        if (points.length <= 1) {
            return 0;
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>((e1, e2) -> Integer.compare(e1.dist, e2.dist));

        for (int i = 0; i < points.length; i++) {
            int[] pointI = points[i]; 
            
            for (int j = 0; j < points.length; j++) {
                if (i == j) {
                    continue;
                }
                int[] pointJ = points[j];
                int dist = Math.abs(pointI[0] - pointJ[0]) + Math.abs(pointI[1] - pointJ[1]);

                pq.add(new Edge(i, j, dist));
            }
        }

        int[] parent = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            parent[i] = i;
        }
        int cost = 0;

        while (!pq.isEmpty()) {
            Edge edge = pq.remove();
            int i = edge.i;
            int j = edge.j;

            if (find(i, parent) != find(j, parent)) {
                union(i, j, parent);
                cost += edge.dist;
            }
        }

        return cost;
    }

    private int find(int i, int[] parent) {
        if (parent[i] == i) {
            return i;
        }
        return find(parent[i], parent);
    }

    private void union(int i, int j, int[] parent) {
        int parentI = find(i, parent);
        int parentJ = find(j, parent);

        parent[parentJ] = parentI;
    }
}
