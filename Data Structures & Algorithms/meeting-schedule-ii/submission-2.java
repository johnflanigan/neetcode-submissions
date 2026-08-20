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
    public int minMeetingRooms(List<Interval> intervals) {
        intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));

        PriorityQueue<Interval> pq = new PriorityQueue<>((i1, i2) -> Integer.compare(i1.end, i2.end));
        int maxRooms = 0;

        for (Interval interval : intervals) {
            while (!pq.isEmpty() && pq.peek().end <= interval.start) {
                pq.remove();
            }

            pq.add(interval);
            maxRooms = Math.max(maxRooms, pq.size());
        }

        return maxRooms;
    }
}
