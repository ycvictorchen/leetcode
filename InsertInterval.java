/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public java.util.List<Interval> insert(java.util.List<Interval> intervals, Interval newInterval) {
        java.util.List<Interval> result = new java.util.ArrayList<Interval>();
        boolean inserted = false;
        for (Interval interval : intervals) {
            if (this.isOverlapped(newInterval, interval)) {
                newInterval.start = Math.min(newInterval.start, interval.start);
                newInterval.end = Math.max(newInterval.end, interval.end);
            }
            else {
                if (!inserted && newInterval.end < interval.start) {
                    result.add(newInterval);
                    inserted = true;
                }
                result.add(interval);
            }
        }
        if (!inserted) {
            result.add(newInterval);
        }
        return result;
    }
    private boolean isOverlapped(Interval i1, Interval i2) {
        return i1.end >= i2.start && i1.start <= i2.end;
    }
}