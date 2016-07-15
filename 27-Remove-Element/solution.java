/**
 * 
 * 27. Remove Element
 * 
 * 
 */


// s1: move all the val to the end of the nums array, then count the length before val
// O(n), O(1)

/*
public class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index] = nums[i];
                index++; 
            }
        }
        
        while (index < nums.length) {
            nums[index] = val;
            index++;
        }        
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                return i;
            }
        }
        return nums.length;
        
    }
}
*/


// s2: move the last element to the beginning, and use a pointer to count the non-val
// O(n), O(1)
// tricky

public class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int pointer = nums.length - 1;
        int i = 0;
        while (i <= pointer) {
            if (nums[i] == val) {
                nums[i] = nums[pointer];
                pointer--;
            } else {
                i++;
            }
        }
        return pointer + 1;
        
        
    }
    
}