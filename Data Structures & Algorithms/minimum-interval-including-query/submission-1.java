class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Map<Integer, Integer> queryResult = new HashMap<>();

        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));

        int[] sorted = Arrays.copyOf(queries, queries.length);
        Arrays.sort(sorted);

        int i = 0;
        int j = 0;

        // PriorityQueue sorted by end values
        PriorityQueue<int[]> pq = new PriorityQueue<>((i1, i2) -> Integer.compare(i1[1] - i1[0], i2[1] - i2[0]));

        while (j < sorted.length) {

            int query = sorted[j];
            // Add intervals that include this query
            while (i < intervals.length && intervals[i][0] <= query) {
                pq.add(intervals[i]);
                i++;
            }

            // Remove intervals from pq that exclude this query
            while (!pq.isEmpty() && pq.peek()[1] < query) {
                pq.remove();
            }

            // At this point, the top of the queue should be the shortest interval
            if (pq.isEmpty()) {
                queryResult.put(query, -1);
            } else {
                int distance = pq.peek()[1] - pq.peek()[0] + 1;
                queryResult.put(query, distance);
            }
            
            j++;
        }

        int[] result = new int[queries.length];
        for (j = 0; j < queries.length; j++) {
            result[j] = queryResult.get(queries[j]);
        }

        return result;
    }
}
