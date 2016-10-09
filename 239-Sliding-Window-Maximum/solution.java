/**
 * 
 * 239. Sliding Window Maximum
 * 
 * 
 */


// s1: brute force
// O(n * k * k), O(n * k)

public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // corner case
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        
        int[] result = new int[nums.length - k + 1];
        int[] array = new int[k];
        
        for (int i = 0; i < nums.length - k + 1; i++) {
            for (int j = 0; j < k; j++) {
                array[j] = nums[i + j];
            }
            result[i] = getMax(array);            
        }
        return result;
    }
    
    public int getMax(int[] array) {
        int result = array[0];
        for (int i = 0; i < array.length; i++) {
            result = Math.max(result, array[i]);
        }
        return result;
    }
}