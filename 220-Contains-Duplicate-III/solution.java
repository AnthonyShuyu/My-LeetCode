/**
 * Contains Duplicate III
 * 
 */


// s1: brute force, 2 for loops
// O(nk), O(1)
// Time limit exceeded

/*
public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || k <= 0 || t < 0) {
            return false;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j <= i + k && j < nums.length; j++) {
                if (Math.abs((long)nums[i] - (long)nums[j]) <= Integer.MAX_VALUE) {
                    if (Math.abs(nums[i] - nums[j]) <= t) {
                        return true;
                 }
                }
            }
        }
        return false;
    }
}
*/



// s2: use 
// O(n), O(n)

/*
public class Solution{
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || k <= 0 || t < 0) {
            return false;
        }
        
        // Set<Integer> hashSet = new HashSet<Integer>();
        // for (int i = 0; i < nums.length; i++) {
        //     if (i > k) {
        //         hashSet.remove(nums[i - k - 1]);
        //     } 
            
            
        // }
        for (int i = 0; i < nums.length - k; i++) {
            if (checkT(i, i + k, nums, t)) {
                return true;
            }
        }
        return false;        
    }
    
    public boolean checkT(int start, int end, int[] nums, int t) {
        for (int i = start; i <= end; i++) {
            for (int j = i + 1; j <= end; j++) {
                if (Math.abs(nums[i] - nums[j]) <= t) {
                    return true;
                }
            }
        }
        return false;
    }
    
*/


 public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k < 1 || t < 0) return false;
        Map<Long, Long> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            long remappedNum = (long) nums[i] - Integer.MIN_VALUE;
            long bucket = remappedNum / ((long) t + 1);
            if (map.containsKey(bucket)
                    || (map.containsKey(bucket - 1) && remappedNum - map.get(bucket - 1) <= t)
                        || (map.containsKey(bucket + 1) && map.get(bucket + 1) - remappedNum <= t))
                            return true;
            if (map.size() >= k) {
                long lastBucket = ((long) nums[i - k] - Integer.MIN_VALUE) / ((long) t + 1);
                map.remove(lastBucket);
            }
            map.put(bucket, remappedNum);
        }
        return false;
    }
}
    
    
