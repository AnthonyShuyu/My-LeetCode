/**
 * Contains Duplicate III
 * 3 methods
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


// s2: use HashMap
// O(n), O(n)

/*
public class Solution{
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || k <= 0 || t < 0) {
            return false;
        }
        Map<Long, Long> hashMap = new HashMap<Long, Long>();
        for (int i = 0; i < nums.length; i++) {
            long num = (long)nums[i] - Integer.MIN_VALUE;
            long bucket = num / ((long)t + 1);
            if (hashMap.containsKey(bucket) || (hashMap.containsKey(bucket - 1) && num - hashMap.get(bucket - 1) <= t) 
            || (hashMap.containsKey(bucket + 1) && hashMap.get(bucket + 1) - num <= t)) {
                return true;
            }        
            if (i >= k) {
                long frontBucket = ((long)nums[i - k] - Integer.MIN_VALUE)/ ((long)t + 1);
                hashMap.remove(frontBucket);
            }
            hashMap.put(bucket, num);
        }
        return false;
    }
}
*/



// s3: Balanced Search Tree, use TreeSet
// 


public class Solution{
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || k <= 0 || t < 0) {
            return false;
        }
        TreeSet<Integer> treeSet = new TreeSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            Integer floorNum = treeSet.floor(nums[i] + t);
            Integer ceilNum = treeSet.ceil(nums[i] - t);
            if ((floorNum != null && floorNum >= nums[i]) || (ceilNum != null && ceilNum <= nums[i])) {
                return true;
            }
            if (i >= k) {
                treeSet.remove(nums[i - k]);
            }
            treeSet.add(nums[i]);
        }
    }
}













/*
public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || k <= 0 || t < 0) {
            return false;
        }

        TreeSet<Integer> values = new TreeSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            Integer floor = values.floor(nums[i] + t);
            Integer ceil = values.ceiling(nums[i] - t);
            if ((floor != null && floor >= nums[i])
                    || (ceil != null && ceil <= nums[i])) {
                return true;
            }

            values.add(nums[i]);
            if (i >= k) {
                values.remove(nums[i - k]);
            }
        }
        return false;
    }
}
*/
