/**
 * 283. Move Zeros
 * 2 solutions
 * 
 */

// *s1: one traverse, when meet not zero, move it to the beginning
// O(n), O(1)
// tricky

/*
public class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }
        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
*/

// s2: brute force, swap elements
// O(n^2), O(1)

public class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                continue;
            } else {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] == 0) {
                        continue;
                    } else {
                        int temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;
                        break;
                    }
                }
            }
        }
    }
}