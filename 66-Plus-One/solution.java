/**
 * 66. Plus One
 * 
 */


// s1: brute force
// 

public class Solution {
    public int[] plusOne(int[] digits) {
        int[] result = null;
        if (digits == null || digits.length == 0) {
            return null;
        }
        int n = digits.length;
        int index = -1;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                index = i;
                break;
            }
        }
        if (index == digits.length - 1) {
            result = new int[n];
            result[n - 1] = digits[n - 1] + 1;
            for (int i = 0; i < n - 1; i++) {
                result[i] = digits[i];
            }
        } else if (index == -1) {
            result = new int[n + 1];
            result[0] = 1;
        } else {
            result = new int[n];
            for (int i = 0; i < index; i++) {
                result[i] = digits[i];
            }
            result[index] = digits[i] + 1;
        }
        return result;
    }
}