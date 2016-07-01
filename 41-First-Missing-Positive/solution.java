public class Solution {
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }
        Arrays.sort(nums);
        int max_value = findMax(nums);
        if (max_value <= 0) {
            return 1;
        }
        int result = 1;
        while (result <= max_value) {
            if (!findValue(nums, result)) {
                return result;
            } else {
                result++;
            }
        }
        return result;
    }
    
    public int findMax(int[] nums) {
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > result) {
                result = nums[i];
            }
        }
        return result;
    }
    
    public boolean findValue(int[] nums, int val) {
        for (int i = 0; i < nums.length; i++) {
            if (val == nums[i]) {
                return true;                
            }
        }
        return false;
    }
    
}