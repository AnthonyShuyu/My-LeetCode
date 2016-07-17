/**
 * 66. Plus One
 * 
 */

// s1: brute force
// O(n), O(n)

/*
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
            result[index] = digits[index] + 1;
        }
        return result;
    }
}
*/



// *s2: use carry
// O(1), O(1)   
    // The complexity is O(1)
    // f(n) = 9/10 * 1 + 1/10 * O(n-1)
    //  ==>  O(n) =  10 / 9 = 1.1111 = O(1)
// tricky

public class Solution {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return null;
        }
        int carry = 1;
        for (int i = digits.length - 1; i >= 0 && carry == 1; i--) {
            int sum = digits[i] + 1;
            digits[i] = sum % 10;
            carry = sum / 10;
        }
        
        if (carry == 0) {
            return digits;
        } else {
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            return result;
        }
    }
}