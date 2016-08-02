/**
 * 91. Decode Ways
 * Given an encoded message containing digits, determine the total number of ways to decode it.
 */

// s1: DP
// O(n), O(n)

/*
public class Solution {
    public int numDecodings(String s) {
        // corner case
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.charAt(0) == '0') {
            return 0;
        }
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '0' && s.charAt(i - 1) != '1' && s.charAt(i - 1) != '2') {
                return 0;
            }
        }
        
        int[] result = new int[s.length() + 1];
        result[0] = 1;
        result[1] = 1;
        for (int i = 2; i < s.length() + 1; i++) {
            if (s.charAt(i - 1) != '0' && s.charAt(i - 2) == '0') {
                result[i] = result[i - 1];
            } else if (s.charAt(i - 1) != '0' && s.charAt(i - 2) != '0') {
                int num = Integer.valueOf(s.substring(i - 2, i));
                if (num >= 1 && num <= 26 ) {
                    result[i] = result[i - 1] + result[i - 2];
                } else {
                    result[i] = result[i - 1];
                }
            } else if (s.charAt(i - 1) == '0') {
                if (i == 2) {
                    result[i] = 1;
                } else {
                    result[i] = result[i - 2];
                }
            }
        }
        return result[s.length()];
    }
*/

// s2: DP, more concise than s1
// O(n), O(n)

public class Solution {
    public int numDecodings(String s) {
        // corner case
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int[] result = new int[s.length() + 1];     // ith element represents the contain i elements in the result array
        result[0] = 1;
        result[1] = s.charAt(0) != '0' ? 1 : 0;
        
        for (int i = 2; i < s.length() + 1; i++) {
            if (s.charAt(i) != 0) {
                result[i] = result[i - 1];
            }
            int num = (s.charAt(i - 1) - '0') * 10 + (s.charAt(i) - '0');
            if (num >= 10 && num <= 26) {
                result[i] += result[i - 2];
            }
        }
        return result[s.length()];        
    }
}