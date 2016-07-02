/**
 * 53. Maximum Subarray
 * 2 solution
 * 
 */


// s1: tricky, sum of the contiguous array equals to the difference between 2 arrays start from index 0
// O(n), O(1)

/*
public class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        int min = 0;
        int sum = 0;
        int result = Integer.MIN_VALUE;
        
        
        // first give the result here to include the only one elment situation
        // don't have to care about the last element if it is the negative, because you have to pick at least element 
        // so if the last element is the negative, you can not include it in the min
        
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            result = Math.max(result, sum - min);  
            min = Math.min(min, sum);   
        }
        return result;
    }
}

*/




// s2: Greedy, when the sum less than 0, clear the sum to 0, start calculat the sum from next element
// O(n), O(1)

public class Solution{
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(max, sum);
            sum = Math.max(sum, 0);
        }
        return max;
    }
    
}