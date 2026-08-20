/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));

        Interval prev = null;

        for (Interval interval : intervals) {
            if (prev == null) {
                prev = interval;
                continue;
            }

            if (interval.start < prev.end) {
                return false;
            }
            prev = interval;
        }

        return true;
    }
}
