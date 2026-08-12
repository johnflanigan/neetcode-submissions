class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();

        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<NumAndCount> pq = new PriorityQueue<>((a, b) -> 
            Integer.compare(a.count, b.count)
        );

        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            pq.add(new NumAndCount(entry.getKey(), entry.getValue()));
            if (pq.size() > k) {
                pq.poll();
            }
        }

        int[] result = new int[k];
        int i = 0;
        while (!pq.isEmpty()) {
            result[i] = pq.poll().num;
            i++;
        }

        return result;
    }

    record NumAndCount(int num, int count) {}
}
