/**
 * 
 * 392. Is Subsequence
 * 
 * 
 */

// s1: two pointers
// O(n)

public class Solution {
    public boolean isSubsequence(String s, String t) {
        // corner case
        if (s == null || t == null) {
            return false;
        }
        if (s.length() == 0) {
            return true;
        }
        
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        
        int index = 0;
        for (int i = 0; i < t.length(); i++) {
            if (tChars[i] == sChars[index]) {
                index++;
                if (index == s.length()) {
                    return true;
                }
            }
        }
        return false;        
    }
}