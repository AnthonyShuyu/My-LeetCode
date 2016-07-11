/**
 * 
 * 209. Minimum Size Subarray Sum
 * 
 * 
 */



// s1: two pointers
// O(n^2), O(n)

public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int min_length = nums.length + 1; 
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= s) {
                    min_length = Math.min(min_length, j - i + 1);
                    break;
                }
            }
        }
        if (min_length != nums.length + 1) {
            return min_length;
        } else {
            return 0;
        }
        
    }
}