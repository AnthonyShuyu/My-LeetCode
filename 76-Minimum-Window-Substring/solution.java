/**
 * 
 * 76. Minimum Window Substring
 * 
 * 
 */



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