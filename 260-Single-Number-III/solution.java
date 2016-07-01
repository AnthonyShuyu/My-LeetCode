/**
 * 260. Single Number III
 * 3 solutions
 * 
 */ 



// s1: brute force
// O(n^2), O(1)


public class Solution {
    public int[] singleNumber(int[] nums) {
        int[] result = new int[2];
        if (nums == null || nums.length == 0) {
            return result;
        }
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count(nums, nums[i]) == 1) {
                result[index] = nums[i];
                index++;
            }
        }
        return result;        
    }
    
    public int count(int[] nums, int val) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (val == nums[i]) {
                result++;
            }                    
        }
        return result;
    }
    
    
    
    
}