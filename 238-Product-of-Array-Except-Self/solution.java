/**
 * 
 * 238. Product of Array Except Self
 *
 */


// s1: brute force, output[i] equals the products of all the elements divide the nums[i]
// O(n), O(n)
// use division

public class Solution {
    public int[] productExceptSelf(int[] nums) {
        // corner case
        if (nums == null || nums.length == 0) {
            return nums;
        }
        int[] output = new int[nums.length];
        int product = 1;
        for (int i = 0; i < nums.length; i++) {
            product *= nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            output[i] = product / nums[i];
        }
        return output;
    }
}