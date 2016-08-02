/**
 * 
 * 125. Valid Palindrome
 * 
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.
 * 
 */


// s1: two pointers
// O(n), O(n)

public class Solution {
    public boolean isPalindrome(String s) {
        // corner case
        if (s == null || s.length() == 0) {
            return true;
        }
        s = s.toLowerCase();
        int start = 0;
        int end = s.length() - 1;
        
        while (start <= end) {
            while (start <= end && !isAlphaNumeric(s.charAt(start))) {
                start++;
            }
            while (start <= end && !isAlphaNumeric(s.charAt(end))) {
                end--;
            }
            if (start <= end) {
                if (s.charAt(start) != s.charAt(end)) {
                    return false;
                } else {
                    start++;
                    end--;
                }
            } 
        }
        return true;
    }
    
    public boolean isAlphaNumeric(char c) {
        if ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z')) {
            return true;
        } else {
            return false;
        }
    }
}