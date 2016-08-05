/**
 * 5. Longest Palindromic Substring
 * 
 * 
 */

// s1: two pointers, start <= end
// O(n^2), O(1)
// time limit exceeded

public class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        String result = String.valueOf(s.charAt(0));
        int max_length = 1;
        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length(); j > i; j--) {
                if (j - i <= max_length) {
                    break;
                }
                String substring = s.substring(i, j);
                if (isPalindrome(substring)) {
                    if (substring.length() > max_length) {
                        max_length = substring.length();
                        result = substring;
                    }
                    break;
                }
            }
        }
        return result;
    }
    
    
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        int start = 0;
        int end = s.length() - 1;
        for (int i = start, j = end; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
    
    
}
