/**
 * 31. Next Permutation
 * 
 */



// s1: brute force
// O(n)

public class Solution {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                int j;
                for (j = nums.length - 1; j > i; j--) {
                    if (nums[j] > nums[i]) {
                        break;
                    }
                }
            }
            swap(nums, i, j);
            reverse(nums, i + 1, nums.length - 1);            
        }
        reverse(nums, 0, nums.length - 1);        
    }
    
    
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public void reverse(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        for (int i = start, j = end; i < j; i++, j--) {
            swap(nums, i, j);
        }
        
    }
}