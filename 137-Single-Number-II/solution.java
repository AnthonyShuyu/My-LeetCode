/**
 * 137. Single Number II
 * 
 * 
 */


// s1: brute force, count how many times each element appears
// O(n^2), O(1)

/*
public class Solution {
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        for (int i = 0; i < nums.length; i++) {
            if (count(nums, nums[i]) != 3) {
                return nums[i];
            }
        }
        return -1;
    }
    
    public int count(int[] nums, int val) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                result++;
            }
        }
        return result;
    }
}
*/

// s3: Arrays.sort()
// O(nlogn), O(1)

public class Solution{
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        Arrays.sort(nums);
        if (nums[0] != nums[1]) {
            return nums[0];
        }
        if (nums[nums.length - 1] != nums[nums.length - 2]) {
            return nums[nums.length - 1];
        }
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] != nums[i - 1] && nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }
        return -1;
    }
}