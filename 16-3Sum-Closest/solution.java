/**
 * 16. 3Sum Closest
 * 
 * 
 */


// s1: brute force
// O(n^3), O(1)
// Time Limit Exceeded

/*
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int min = Integer.MAX_VALUE;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    // min = Math.min(min, Math.abs(nums[i] + nums[j] + nums[k] - target));  
                    if (Math.abs(nums[i] + nums[j] + nums[k] - target) < min) {
                        result = nums[i] + nums[j] + nums[k];
                        min = Math.abs(nums[i] + nums[j] + nums[k] - target);
                    }
                }
            }
        }
        return result; 
    }
}
*/


// s2: HashMap
// 

public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return -1;
        }
        Arrays.sort(nums);
        int best_sum = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 1; i++) {
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (Math.abs(best_sum - target) > Math.abs(sum - target)) {
                    best_sum = sum;
                }
                if (sum < target) {
                    start++;
                } else if (sum == target){
                    return sum;
                } else {
                    end--;
                }
            }
        }
        return best_sum;
    }
}