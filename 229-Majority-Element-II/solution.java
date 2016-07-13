/**
 * 
 * 229. Majority Element II
 * 
 */


// s1: brute force
// O(n^2), O(1)

public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (countNums(nums, nums[i]) > nums.length / 3) {
                if (!result.contains(nums[i])) {
                    result.add(nums[i]);
                }
            }
        }
        return result;
    }
    
    public int countNums(int[] nums, int n) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == n) {
                result++;
            }
        }
        return result;
    }
}