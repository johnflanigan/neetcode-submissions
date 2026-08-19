class Solution {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));

        List<int[]> list = new ArrayList<>();
        if (intervals.length == 0) {
            return list.toArray(new int[0][0]);
        }

        list.add(intervals[0]);

        int i = 1;
        while (i < intervals.length) {
            int[] prev = list.get(list.size() - 1);

            if (prev[1] >= intervals[i][0]) {
                prev[1] = Math.max(prev[1], intervals[i][1]);
            } else {
                list.add(intervals[i]);
            }

            i++;
        }

        return list.toArray(new int[0][0]);
    }
}
