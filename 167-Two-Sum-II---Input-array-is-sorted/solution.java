/**
 * 
 * 167. Two Sum II - Input array is sorted
 * 
 */


// s1: two pointers
// O(n), O(1)

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // corner case
        if (numbers == null || numbers.length == 0) {
            return null;
        }
        int[] result = new int[2];
        int left = 0;
        int right = numbers.length - 1;
        
        while (left < right) {
            int v1 = numbers[left];
            int v2 = numbers[right];
            if (v1 + v2 > target) {
                right--;
            } else if (v1 + v2 < target) {
                left++;
            } else {
                result[0] = left + 1;
                result[1] = right + 1;
                break;
            }
        }
        return result;
    }
}