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
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (intervals == null || intervals.size() == 0) {
            return intervals;
        }
        List<Interval> result = new ArrayList<Interval>();
        int n = intervals.size();
        // newInterval compare to the last
        Interval last = intervals.get(n - 1);
        if (last.end < newInterval.start) {
            intervals.add(newInterval);
            return intervals;
        } else if (last.start <= newInterval.start) {
            Interval i1 = new Interval(last.start, last.end > newInterval.end ? last.end : newInterval.end);
            intervals.remove(n - 1);
            intervals.add(i1);
            return intervals;
        }
        
        // newInterval compare to the first
        Interval first = intervals.get(0);
        if (newInterval.end < first.start) {
            intervals.add(0, newInterval);
            return intervals;
        } else if (newInterval.end <= first.end) {
            Interval i2 = new Interval(newInterval.start < first.start ? newInterval.start : first.start, first.end);
            intervals.remove(0);
            intervals.add(0, i2);
            return intervals;
        }
        
        // find where the newInterval's start and end are
        Interval startInterval = null;
        for (int i = 0; i < intervals.size(); i++) {
            if (intervals.get(i).start <= newInterval.start && intervals.get(i).end >= newInterval.start) {
                startInterval = intervals.get(i);               
                break;
            }
        }
        
        Interval endInterval = null;
        for (int i = 0; i < intervals.size(); i++) {
            if (intervals.get(i).start <= newInterval.end && intervals.get(i).end >= newInterval.end) {
                endInterval = intervals.get(i);
                break;
            }
        }
        
        if (startInterval == null && endInterval == null) {
            result.add(newInterval);
            return result;
        } else if (startInterval == null && endInterval != null) {
            int index = intervals.indexOf(endInterval);
            Interval i3 = new Interval(newInterval.start, endInterval.end);
            result.add(i3);
            for (int i = index + 1; i < intervals.size(); i++) {
                result.add(intervals.get(i));
            }
            return result;
        } else if (startInterval != null && endInterval == null) {
            int index = intervals.indexOf(startInterval);
            Interval i4 = new Interval(startInterval.start, newInterval.end);
            for (int i = 0; i < index; i++) {
                result.add(intervals.get(i));
            }
            result.add(i4);
            return result;
        } else {
            int index1 = intervals.indexOf(startInterval);
            int index2 = intervals.indexOf(endInterval);
            Interval i5 = new Interval(startInterval.start, endInterval.end);
            for (int i = 0; i < index1; i++) {
                result.add(intervals.get(i));
            }
            result.add(i5);
            for (int i = index2 + 1; i < intervals.size(); i++) {
                result.add(intervals.get(i));
            }
            return result;
        }
        return result;
    }
}