/**
 * 
 * 325. Maximum Size Subarray Sum Equals k
 * 
 */


// s1: brute force
// O(n^2), O(1)

public class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        // corner case
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j  = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    max = Math.max(max, j - i + 1);
                }
            }
        }
        return max;
    }
}