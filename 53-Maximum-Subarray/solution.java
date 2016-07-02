/**
 * 53. Maximum Subarray
 * 
 * 
 */



// s1: sum of the contiguous array equals to the difference between 2 arrays start from index 0
// O(n), O(1)


public class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        
        int min = 0;
        int sum = 0;
        int result = Integer.MIN_VALUE;
        
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            result = Math.max(result, sum - min);
            min = Math.min(min, sum);
        }
        
        return result;
        
    }
}