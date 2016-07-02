/**
 * 
 * 152. Maximum Product Subarray
 * 1 solution
 * 
 */


// s1: tricky, kind of DP
// O(n), O(n) 

public class Solution{
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] max = new int[n];
        int[] min = new int[n];
        
        max[0] = min[0] = nums[0];
        int result = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            max[i] = min[i] = nums[i];
            if (nums[i] > 0) {
                max[i] = Math.max(max[i], max[i - 1] * nums[i]);
                min[i] = Math.min(min[i], min[i - 1] * nums[i]);
            } else if (nums[i] < 0) {
                max[i] = Math.max(max[i], min[i - 1] * nums[i]);
                min[i] = Math.min(min[i], max[i - 1] * nums[i]);
            }
            result = Math.max(result, max[i]);
        }
        return result;
    }
}



// s2: tricky, two variables, one to remember the best answer
// O(n), O(1)
// failed

/*
public class Solution{
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int min = 1;
        int product = 1;
        
        for (int i = 0; i < nums.length; i++) {
            product *= nums[i];
            max = Math.max(max, product / min);
            min = Math.min(min, product);
        }
        
        return max;
    }
}
*/



// s3: Greedy
// O(n), O(1)
// failed, because negative times negative will get a positive

/*
public class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int product = 1;
        
        for (int i = 0; i < nums.length; i++) {
            product *= nums[i];
            max = Math.max(max, product);
            product = Math.max(product, 0);
        }
        return max;
    }
}
*/