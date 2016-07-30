/**
 * 8. String to Integer (atoi)
 * 
 * Implement atoi to convert a string to an integer.

Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.
 * 
 */

// s1: brute force, clean the data
// O(n), O(1)


public class Solution {
    public int myAtoi(String str) {
        // corner case
        if (str == null || str.length() == 0) {
            return str;
        }
        int result = Integer.valueOf(str);
        return result;
    }
}