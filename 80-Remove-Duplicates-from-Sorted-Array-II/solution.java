/**
 * 80. Remove Duplicates from Sorted Array II
 * 
 * 
 */


// s1: use index
// O(n), O(1)

public class Solution {
    public int removeDuplicates(int[] nums) {
        // corner case
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int index = 0;
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[index]) {
                if (i - j >= 2) {
                    nums[index + 1] = nums[j];
                    index += 2;
                    nums[index] = nums[i];
                    j = i;
                } else {
                    index++;
                    nums[index] = nums[i];
                    j = i;
                }
            }  
        }
        if (index < nums.length && nums[index] == nums[index + 1]) {
            return index + 2;
        } else {
            return index + 1;
        }

    }
}