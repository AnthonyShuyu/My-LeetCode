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
        for (int i = 0; i < num.length - k; i++) {
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
    
    
}