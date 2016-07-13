/**
 * 169. Majority Element
 * 
 * 
 */



// s1: brute force
// 

public class Solution {
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        for (int i = 0; i < nums.length; i++) {
            if (findTimes(nums, nums[i]) > nums.length / 2) {
                return nums[i];
            }
        }
        return -1;
    }
    
    public int findTimes(int[] nums, int n) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == n) {
                result++;
            }
        }
        return result;
    }
}