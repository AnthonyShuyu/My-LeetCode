/**
 *  57. Insert Interval
 *  1 solution
 */



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
        List<Interval> list = new ArrayList<Interval>();
        if (intervals == null || intervals.size() == 0) {
            list.add(newInterval);
            return list;
        }
        int insertPos = 0;
        for (int i = 0; i < intervals.size(); i++) {
            if (intervals.get(i).start > newInterval.end) {
                list.add(intervals.get(i));
            } else if (intervals.get(i).end < newInterval.start) {
                list.add(intervals.get(i));
                insertPos++;
            } else {
                newInterval.start = Math.min(intervals.get(i).start, newInterval.start);
                newInterval.end = Math.max(intervals.get(i).end, newInterval.end);
            }
        }
        list.add(insertPos, newInterval);
        return list;
    }
}