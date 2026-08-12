class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((i1, i2) -> Integer.compare(i2, i1));

        for (int stone : stones) {
            pq.add(stone);
        }

        while (pq.size() > 1) {
            int heavy = pq.remove();
            int light = pq.remove();

            if (heavy != light) {
                int stone = heavy - light;
                pq.add(stone);
            }
        }

        if (pq.size() == 1) {
            return pq.remove();
        } else {
            return 0;
        }
    }
}
