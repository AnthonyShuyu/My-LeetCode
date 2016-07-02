/**
 * 268. Missing Number
 * 
 * 
 */ 


// s1: brute force
// O(n^2), O(1)


public class Solution{
    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        for (int i = 0; i < nums.length + 1; i++) {
            if (!findNum(nums, i)) {
                return i;
            }
        }
        return -1;
    }
    public boolean findNum(int[] nums, int val) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                return true;
            }
        }
        return false;
    }
    
}


// s2: Arrays.sort()
// O(nlogn), O(1)

/*
public class Solution {
    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        Arrays.sort(nums);
        if (nums[0] != 0) {
            return 0;
        }
        
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] + 1 != nums[i + 1]) {
                return nums[i] + 1;
            }
        }
        return nums.length;
    }
}
*/


// s3: tricky, A[i] = x, x should be in the slot A[x]
// O(n), O(1)

/*
public class Solution{
    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i && nums[i] < nums.length) {
                int temp = nums[nums[i]];
                if (temp == nums[i]) {
                    break;
                }
                nums[nums[i]] = nums[i];
                nums[i] = temp;
            }
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return nums.length;
    }
}
*/




