/*
public class Solution {
    // Use quick sort 
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k > nums.length) {
            return Integer.MIN_VALUE;
        }
        k = nums.length - k;
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int index = partition(nums, left, right) ;
            if (index < k) {
                left = index + 1;
            } else if (index > k) {
                right = index - 1;
            } else {
                break;
            }
        }
        return nums[k];
    }
    
    public int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        while (left <= right) {
            while(nums[left] < pivot) {
                left++;
            }
            while(nums[right] > pivot) {
                right--;
            }
            if (left <= right) {
                swap(nums, left, right);
                left++;
                right--;
            }
        }
        return left;        
    }
    
    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
*/


// s1: Arrays.sort() method
// O(nlogn), O(1)

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        // corner case
        if (nums == null || nums.length == 0) {
            return -1;
        }
        // Arrays.sort(nums);
        Arrays.sort(nums, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });
        
        // return nums[nums.length - k];
        return nums[k - 1];
    }
}
