/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */


// number of airplanes in the sky


// s1: use HashMap
// O(k), O(k), k is the all counts of minutes

public class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        // corner case
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        
        int result = 0;
        Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < intervals.length; i++) {
            Interval interval = intervals[i];
            for (int j = interval.start; j < interval.end; j++) {
                if (hashMap.containsKey(j)) {
                    hashMap.put(j, hashMap.get(j) + 1);    
                } else {
                    hashMap.put(j, 1);
                }
                result = Math.max(result, hashMap.get(j));
            }
        }
        return result;
    }
}