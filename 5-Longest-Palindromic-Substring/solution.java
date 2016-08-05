/**
 * 5. Longest Palindromic Substring
 * 
 * 
 */

// s1: two pointers, start <= end
// O(n^2), O(1)
// time limit exceeded

/*
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
*/

// s2: DP, Let s be the input string, i and j are two indices of the string. Define a 2-dimension array "table" and let table[i][j] denote whether a substring from i to j is palindrome.

// O(n^2), O(n^2)

/*
public class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        int n = s.length();
        boolean[][] results = new boolean[n][n];
        int max_len = 0;
        String result = null;
        
        for (int len = 0; len < n; len++) {
            for (int i = 0; i < n - len; i++) {
                int j = i + len;
                if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || results[i + 1][j - 1])) {
                    results[i][j] = true;
                    if (j - i + 1 > max_len) {
                        max_len = j - i + 1;
                        result = s.substring(i, j + 1);
                    }
                }
            }
        }
        return result;
    }
}
*/


// s3:  Given a center, either one letter or two letter, 
// Find longest palindrome
// O(n^2), O(1)

public class Solution {
    public String longestPalindrome(String s) {
        // corner case
        if (s == null || s.length() <= 1) {
            return s;
        }

        String result = s.substring(0, 1);
        for (int i = 0; i < s.length(); i++) {
            String temp1 = findPalindrome(s, i, i);
            if (temp1.length() > result.length()) {
                result = temp1;
            }
            
            String temp2 = findPalindrome(s, i, i + 1);
            if (temp2.length() > result.length()) {
                result = temp2;
            }
        }
        return result;
    }
    
    public String findPalindrome(String s, int start, int end) {
        while (start >= 0 && end <= s.length() - 1&& s.charAt(start) == s.charAt(end)) {
            start++;
            end--;
        }
        return s.substring(start + 1, end);
    }
}


