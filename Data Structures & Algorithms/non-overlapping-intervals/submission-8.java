class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));

        int[] prev = intervals[0];
        int i = 1;
        int excluded = 0;

        while (i < intervals.length) {
            int[] current = intervals[i];
            // If there is overlap, we need to exclude one of the intervals
            if (current[0] < prev[1]) {
                // We should take the interval that has the earliest end
                if (current[1] < prev[1]) {
                    prev = current;
                }
                excluded++;
            } else {
                prev = current;
            }
            i++;
        }


        return excluded;
    }
}
