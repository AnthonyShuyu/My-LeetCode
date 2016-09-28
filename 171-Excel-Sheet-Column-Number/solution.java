/**
 * 
 * 171. Excel Sheet Column Number
 * 
 */

// s1: brute force, binary to decimal
// O(n), O(1)
public class Solution {
    public int titleToNumber(String s) {
        // corner case
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int result = 0;
        int index = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            result += Math.pow('Z' - 'A' + 1, index) * (s.charAt(i) - 'A' + 1);
            index++;
        }
        return result;
    }
}