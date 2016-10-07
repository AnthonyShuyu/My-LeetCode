/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */

// assume a person can attend both if one's end = another's start 

// s1: sort the intervals and traverse
// O(nlogn), O(1)
 
/*
public class Solution {
    public boolean canAttendMeetings(Interval[] intervals) {
        // corner case
        if (intervals == null || intervals.length == 0) {
            return true;
        }
        
        Arrays.sort(intervals, new Comparator<Interval>() {
                @Override
                public int compare(Interval i1, Interval i2) {
                    return i1.start - i2.start;
                }
            });
        
        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i].end > intervals[i + 1].start) {
                return false;
            }
        }
        return true;
    }
}
*/


// s2: use minHeap
// O(nlogn), O(n)

public class Solution {
    public boolean canAttendMeetings(Interval[] intervals) {
        // corner case
        if (intervals == null || intervals.length == 0) {
            return true;
        }
        
        Arrays.sort(intervals, new Comparator<Interval>() {
                @Override
                public int compare(Interval i1, Interval i2) {
                    return i1.start - i2.start;
                }
            });
        Queue<Integer> queue = new PriorityQueue<Integer>();
        for (int i = 0; i < intervals.length; i++) {
            Interval interval = intervals[i];
            if (!queue.isEmpty() && interval.start >= queue.peek()) {
                queue.poll();
            }
            queue.offer(interval.end);
            if (queue.size() > 1) {
                return false;
            }
        }
        return true;       
    }
}    