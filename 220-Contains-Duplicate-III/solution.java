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
// O(NlogK), O(n)


/*
This problem requires to maintain a window of size k of the previous values that can be queried for value ranges. The best data structure to do that is Binary Search Tree. As a result maintaining the tree of size k will result in time complexity O(N lg K). In order to check if there exists any value of range abs(nums[i] - nums[j]) to simple queries can be executed both of time complexity O(lg K)

Here is the whole solution using TreeMap.
*/

public class Solution{
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || k <= 0 || t < 0) {
            return false;
        }
        TreeSet<Integer> treeSet = new TreeSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            Integer floorNum = treeSet.floor(nums[i] + t);
            Integer ceilingNum = treeSet.ceiling(nums[i] - t);
            if ((floorNum != null && floorNum >= nums[i]) || (ceilingNum != null && ceilingNum <= nums[i])) {
                return true;
            }
            if (i >= k) {
                treeSet.remove(nums[i - k]);
            }
            treeSet.add(nums[i]);
        }
        return false;
    }
}

