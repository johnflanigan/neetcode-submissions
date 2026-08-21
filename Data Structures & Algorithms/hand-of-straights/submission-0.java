class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        Map<Integer, Integer> count = new HashMap<>();

        for (int card : hand) {
            count.put(card, count.getOrDefault(card, 0) + 1);
        }

        SortedSet<Integer> set = new TreeSet<>(count.keySet());

        while (!set.isEmpty()) {
            int card = set.first();

            for (int i = card; i < groupSize + card; i++) {
                if (!count.containsKey(i)) {
                    return false;
                }

                count.put(i, count.get(i) - 1);
                if (count.get(i) == 0) {
                    count.remove(i);
                    set.remove(i);
                }
            }
        }

        return count.isEmpty();
    }
}
