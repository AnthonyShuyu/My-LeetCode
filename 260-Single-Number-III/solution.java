/**
 * 260. Single Number III
 * 3 solutions
 * 
 */ 



// s1: brute force
// O(n^2), O(1)

/*
public class Solution {
    public int[] singleNumber(int[] nums) {
        int[] result = new int[2];
        if (nums == null || nums.length == 0) {
            return null;
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

*/


// s2: Arrays.sort()
// O(nlogn), O(1)

public class Solution{
    public int[] singleNumber(int[] nums) {
        int[] result = new int[2];
        if (nums == null || nums.length <= 1) {
            return null;
        }
        int index = 0;
        Arrays.sort(nums);
        if (nums.length == 2) {
            if (nums[0] != nums[1]) {
                return nums;
            } else {
                return null;
            }
        }
        if (nums[0] != nums[1]) {
            result[index] = nums[0];
            index++;
        }
        if (nums[nums.length - 1] != nums[nums.length - 2]) {
            result[index] = nums[nums.length - 1];
            index++;
        }
        
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] != nums[i - 1] && nums[i] != nums[i + 1]) {
                result[index] = nums[i];
                index++;
            }
        }
        return result;
    }
}