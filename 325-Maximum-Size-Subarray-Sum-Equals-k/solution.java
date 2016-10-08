/**
 * 
 * 325. Maximum Size Subarray Sum Equals k
 * 
 */


// s1: brute force
// O(n^2), O(1)

/*
public class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        // corner case
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j  = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    max = Math.max(max, j - i + 1);
                }
            }
        }
        return max;
    }
}
*/


// s2: prefix sum: subarray sum equals to the difference betweeen sum of two index from 0
// O(n^2), O(n)
// tircky

public class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        // corner case
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int[] sums = new int[nums.length];
        
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sums[i] = sum;
        }
        
        int max = 0;
        for (int i = 0; i < sums.length; i++) {
            if (sums[i] == k) {
                max = Math.max(i + 1, max);
            }
            for (int j = i + 1; j < sums.length; j++) {
                if (sums[j] - sums[i] == k) {
                    max = Math.max(j - i, max);
                }
            }
        }
        return max;
    }
}
