class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();

        int i = 0;
        while (i < intervals.length && intervals[i][0] < newInterval[0]) {
            list.add(intervals[i]);
            i++;
        }

        if (list.isEmpty()) {
            list.add(newInterval);
        } else {
            int[] prev = list.get(list.size() - 1);
            if (newInterval[0] <= prev[1]) {
                prev[1] = Math.max(newInterval[1], prev[1]);
            } else {
                list.add(newInterval);
            }
        }

        while (i < intervals.length) {
            int[] prev = list.get(list.size() - 1);
            if (prev[1] >= intervals[i][0]) {
                prev[1] = Math.max(intervals[i][1], prev[1]);
            } else {
                list.add(intervals[i]);
            }

            i++;
        }

        return list.toArray(new int[0][0]);
    }
}
