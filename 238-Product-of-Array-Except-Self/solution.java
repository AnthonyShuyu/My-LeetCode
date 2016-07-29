/**
 * 
 * 238. Product of Array Except Self
 *
 */

// s1: brute force
// O(n^2), O(n)

public class Solution {
    public int[] productExceptSelf(int[] nums) {
        // corner case
        if (nums == null || nums.length == 0) {
            return nums;
        }
        int[] output = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            output[i] = getProduct(nums, i);
        }
        return output;
    }
    
    public int getProduct(int[] nums, int index) {
        int product = 1;
        for (int i = 0; i < nums.length; i++) {
            if (i == index) {
                continue;
            } else {
                product *= nums[i];
            }
        }
        return product;
    }
}

















// s1: brute force, output[i] equals the products of all the elements divide the nums[i]
// O(n), O(n)
// use division

/*
public class Solution {
    public int[] productExceptSelf(int[] nums) {
        // corner case
        if (nums == null || nums.length == 0) {
            return nums;
        }
        int[] output = new int[nums.length];
        int product = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                product = 0;
                break;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                output[i] = 0;
            } else {
                output[i] = product / nums[i];
            }
        }
        return output;
    }
}
*/