/**
 * 
 * 76. Minimum Window Substring
 * 
 * 
 */

// s1: brute force
// O(n^3), O(n^2)
// time limit exceeded 

/*
public class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null) {
            return "";
        }    
        if (s.length() < t.length()) {
            return "";
        }
        for (int i = t.length(); i <= s.length(); i++) {
            for (int j = 0; j <= s.length() - i ; j++) {
                if (checkContains(s.substring(j, j + i), t)) {
                    return s.substring(j, j + i);
                }
            }
        } 
        return "";
    }
    
    public boolean checkContains(String s1, String s2) {
        int[] arr = new int[58]; // 'z' - 'A' + 1
        for (int i = 0; i < s1.length(); i++) {
            arr[(int)s1.charAt(i) - 65] += 1;
        }
        for (int i = 0; i < s2.length(); i++) {
            arr[(int)s2.charAt(i) - 65] -= 1;
            if (arr[(int)s2.charAt(i) - 65] < 0) {
                return false;
            }
        }
        return true;
    }
}
*/


// s2: 
// 


public class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }
        int j = 0;
        String temp = "";
        int min = s.length() + 1;
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            while (j < s.length() && !checkContains(temp, t)) {
                temp = s.substring(i, j + 1);
                j++;
            }
            if (checkContains(temp, t)) {
                if (temp.length() < min) {
                    result = temp;   
                    min = temp.length();
                }
                temp = s.substring(i + 1, j);
            }
        }
        return result;        
    }
    
    public boolean checkContains(String s1, String s2) {
        int[] arr = new int[58]; // 'z' - 'A' + 1
        for (int i = 0; i < s1.length(); i++) {
            arr[(int)s1.charAt(i) - 65] += 1;
        }
        for (int i = 0; i < s2.length(); i++) {
            arr[(int)s2.charAt(i) - 65] -= 1;
            if (arr[(int)s2.charAt(i) - 65] < 0) {
                return false;
            }
        }
        return true;
    }
}
