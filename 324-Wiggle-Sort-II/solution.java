/**
 * 324. Wiggle Sort II
 * 
 * 
 */

public class Solution {
    public void wiggleSort(int[] nums) {
        int[] copy = nums.clone();
        Arrays.sort(copy);
        int s;
        if(nums.length % 2 == 0) {
            s = nums.length / 2 - 1;
        } else {
            s = nums.length / 2;
        }
        int l = nums.length - 1;
        for(int i = 0; i < nums.length; i++) {
            if(i % 2 == 0) {
                nums[i] = copy[s—];
            } else {
                nums[i] = copy[l—];
            }
        }
    }
}










// s1: Arrays.sort() + new another array 
// failed

/*

public class Solution {
    public void wiggleSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        Arrays.sort(nums);
        int[] result = new int[nums.length];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                result[index] = nums[i / 2];
            } else {
                result[index] = nums[nums.length - i / 2 - 1];
            }
            index++;
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = result[i];
        }
    }
}
*/


// s1: Arrays.sort() + swap
// failed

/*
public class Solution {
    public void wiggleSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i % 2 == 0) {
                int j = i + 1;
                while (j < nums.length) {
                    if (nums[j] > nums[i]) {
                        swap(nums, i + 1, j);
                        break;
                    } else {
                        j++;
                    }
                }
            } else if (i % 2 == 1) {
                int j = i + 1;
                while (j < nums.length) {
                    if (nums[j] < nums[i]) {
                        swap(nums, i + 1, j);
                        break;
                    } else {
                        j++;
                    }
                }
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
*/