/**
 *  Rotate Array
 *  2 methods
 * 
 */


// s1: concatenate 2 "Strings" together and retrive the "substring"
// O(n), O(n)

/**
public class Solution {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0) {
            return;
        }
        k = k % nums.length;
        int[] newNums = new int[nums.length * 2];
        for (int i = 0; i < nums.length; i++) {
            newNums[i] = nums[i];
            newNums[i + nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = newNums[nums.length - k + i];
        }
    }
}
*/


// s2: 3 times reverse
// O(n), O(1)

public class Solution {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0) {
            return;
        }
        k = k % nums.length;
        reverse(nums, 0, nums.length - k - 1);
        reverse(nums, nums.length - k, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
        
    }
    
    public void reverse(int[] nums, int start, int end) {
        if (nums == null || nums.length == 0) {
            return;
        }
        for (int i = start, j = end; i < j; i++, j--) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        
    }
}

