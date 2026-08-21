class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, int[]> startEnd = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (startEnd.containsKey(c)) {
                startEnd.get(c)[1] = i;
            } else {
                startEnd.put(c, new int[]{i, i});
            }
        }

        List<int[]> intervals = new ArrayList<>(startEnd.values());
        intervals.sort((i1, i2) -> Integer.compare(i1[0], i2[0]));

        List<int[]> merged = new ArrayList<>();

        for (int[] interval : intervals) {
            if (merged.isEmpty()) {
                merged.add(interval);
                continue;
            }

            int[] prev = merged.get(merged.size() - 1);
            if (interval[0] < prev[1]) {
                prev[1] = Math.max(prev[1], interval[1]);
            } else {
                merged.add(interval);
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int[] interval : merged) {
            result.add(interval[1] - interval[0] + 1);
        }

        return result;
    }
}
