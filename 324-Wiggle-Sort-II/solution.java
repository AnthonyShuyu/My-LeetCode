/**
 * 324. Wiggle Sort II
 * 2 solutions
 * 
 */
 
 
// s1: Arrays.sort() and partition using index of middle
// 


 
 
/*
public class Solution {
    public void wiggleSort(int[] nums) {
        int[] copy = Arrays.copyOf(nums, nums.length);
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
                nums[i] = copy[s--];
            } else {
                nums[i] = copy[l--];
            }
        }
    }
}

*/








// s1: Arrays.sort() + new another array 
// failed


public class Solution {
    public void wiggleSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int[] new_nums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            new_nums[i] = nums[i];
        }
        Arrays.sort(new_nums);
        int middle_index = (nums.length % 2 == 0 ? nums.length / 2 : nums.length / 2 + 1);
        int end_index = nums.lenght - 1;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                nums[i] = new_nums[middle_index];
                middle_index--;
            } else {
                nums[i] = new_nums[end_index];
                end_index--;
            }
        }
    }
}


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