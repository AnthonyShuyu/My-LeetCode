/**
 *
 * 203. Remove Linked List Elements
 * 1 solution
 * 
 */
 
 
 
// s1: attention: this is already a sorted array, Arrays.sort() method
// O(n), O(1)

public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // Arrays.sort(nums);
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[index]) {
                index++;
                nums[index] = nums[i];
            }
        }
        return index + 1;
    }
}
 
 
 
 
 
 
 
// s1: Arrays.sort() method
// falied, it needs to remove the elements, not only count the nums

/*
public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        Arrays.sort(nums);
        int result = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != nums[i + 1]) {
                result++;
            }
        }
        return result;
    }
}
*/

// s1: use remove element method
// failed

/*
public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int i = 0;
        int pointer = nums.length - 1;
        while (i + 1 <= pointer) {
            int n = nums[i];
            int j = i + 1;
            while (j <= pointer) {
                if (nums[j] == n) {
                    nums[j] = nums[pointer];
                    pointer--;
                } else {
                    j++;
                }
            }
            i++;
        }
        // Arrays.sort(nums);
        return pointer + 1;
    }
}

*/