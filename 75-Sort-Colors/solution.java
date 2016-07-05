/**
 * 75. Sort Colors
 * 
 * 
 */


// s1: Arrays.sort()
// O(nlogn), O(1)

/*
public class Solution {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        Arrays.sort(nums);
    }
}
*/


// s2: two pointers
// O(n), O(1)

public class Solution {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        
        // move the 0s to the left
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            if (nums[start] > 0 && nums[end] == 0) {
                swap(nums, start, end);
                start++;
                end--;
            } else if (nums[start] == 0) {
                start++;
            } else if (nums[end] > 0) {
                end--;
            }
        }
        
        // move the 1s to the left
        start = 0;
        end = nums.length - 1;
        while (start < end) {
            if (nums[start] > 1 && nums[end] == 1) {
                swap(nums, start, end);
                start++;
                end--;
            } else if (nums[start] <= 1) {
                start++;
            } else if (nums[end] > 1) {
                end--;
            }
        }
    }
    public void swap(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }
}