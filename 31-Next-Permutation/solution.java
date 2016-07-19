/**
 * 31. Next Permutation
 * 2 solutions
 * 
 */

// s1: brute force, two pointers
// O(n^2), O(1)

/*
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
                swap(nums, i, j);
                reverse(nums, i + 1, nums.length - 1); 
                return;
            }
           
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
*/


// *s2: brute force, 2 times loop
// O(n), O(n)

public class Solution {
    public void nextPermutation(int[] nums){
        if (nums == null || nums.length == 0) {
            return;
        }
        // find the first increase index
        int index = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                index = i;
                break;
            }            
        }
        if (index == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }
        
        int index2 = index + 1;
        for (int i = nums.length - 1; i > index; i--) {
            if (nums[i] > nums[index]) {
                index2 = i;
                break;
            }
        }
        swap(nums, index, index2);
        reverse(nums, index + 1, nums.length - 1);
        

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
