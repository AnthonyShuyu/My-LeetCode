/**
 * 
 * 152. Maximum Product Subarray
 * 
 */



// s1: tricky, two variables, one to remember the best answer
// O(n), O(1)

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



// s2: Greedy
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