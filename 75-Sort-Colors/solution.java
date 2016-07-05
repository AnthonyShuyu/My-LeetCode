/**
 * 75. Sort Colors
 * 
 * 
 */


// s1: Arrays.sort()
// O(nlogn), O(1)


public class Solution {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        Arrays.sort(nums);
    }
}