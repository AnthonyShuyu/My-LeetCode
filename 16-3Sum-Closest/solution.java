/**
 * 16. 3Sum Closest
 * 
 * 
 */


// s1: brute force
// O(n^3), O(1)
// Time Limit Exceeded

public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int min = Integer.MAX_VALUE;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    // min = Math.min(min, Math.abs(nums[i] + nums[j] + nums[k] - target));  
                    if (Math.abs(nums[i] + nums[j] + nums[k] - target) < min) {
                        result = nums[i] + nums[j] + nums[k];
                        min = Math.abs(nums[i] + nums[j] + nums[k] - target);
                    }
                }
            }
        }
        return result; 
    }
}