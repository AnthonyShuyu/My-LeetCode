/**
 * Frist Missing Positive
 * 2 methods
 * 
 */ 


// s1: Arrays.sort(), findMax and findValue sub method
// O(n^2), O(1)
// modify the original array

/*
public class Solution {
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }
        Arrays.sort(nums);
        int max_value = findMax(nums);
        if (max_value <= 0) {
            return 1;
        }
        int result = 1;
        while (result <= max_value) {
            if (!findValue(nums, result)) {
                return result;
            } else {
                result++;
            }
        }
        return result;
    }
    
    public int findMax(int[] nums) {
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > result) {
                result = nums[i];
            }
        }
        return result;
    }
    
    public boolean findValue(int[] nums, int val) {
        for (int i = 0; i < nums.length; i++) {
            if (val == nums[i]) {
                return true;                
            }
        }
        return false;
    }
}
*/



// s2: tricky, A[i] = x, it should be in the slot A[x - 1]
// O(n), O(1)

public class Solution{
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }
        
        // first loop, swap the element and put them in the right slots
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0 && nums[i] != (i + 1) && nums[i] <= nums.length ) {
                int temp = nums[i];
                nums[i] = nums[nums[i] - 1];
                nums[nums[i] - 1] = temp;
            }
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0 && nums[i] != (i + 1)) {
                return i + 1;
            }
        }
        
        return 1;
    }
}



