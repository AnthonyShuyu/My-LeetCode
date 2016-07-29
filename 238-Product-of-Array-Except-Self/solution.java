/**
 * 
 * 238. Product of Array Except Self
 *
 */

// s1: brute force
// O(n^2), O(n)
// time limit exceeded

/*
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
*/


// s2: brute force, output[i] equals the products of all the elements divide the nums[i]
// O(n), O(n)
// use division, handle the problem of 0

public class Solution {
    public int[] productExceptSelf(int[] nums) {
        // corner case
        if (nums == null || nums.length == 0) {
            return nums;
        }
        int[] output = new int[nums.length];
        int product = 1;
        int index = -1;
        
        // find 0
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                index = i;
                break;
            }
        }
        
        if (index != -1) {
            for (int i = 0; i < nums.length; i++) {
                if (i == index) {
                    continue;
                } else if (i != index && nums[i] == 0) {
                    product = 0;
                    break;
                } else {
                    product *= nums[i];
                }
            }
            output[index] = product;
            return output;
        } else {
            for (int i = 0; i < nums.length; i++) {
                product *= nums[i];
            }
            for (int i = 0; i < nums.length; i++) {
                output[i] = product / nums[i];
            }
            return output;
        }
            
    }
}