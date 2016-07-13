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
        if (s.size() < t.size()) {
            return "";
        }
        for (int i = t.size(); i <= s.size(); i++) {
            for (int j = 0; j <= s.size() - i ; j++) {
                if (checkContains(s.substring(j, j + i), t)) {
                    return s.substring(j, j + i);
                }
            }
        } 
        return "";
    }
    
    public boolean checkContains(String s1, String s2) {
        int[] arr = new int[58]; // 'z' - 'A' + 1
        for (int i = 0; i < s1.size(); i++) {
            arr[(int)s1.charAt(i) - 65] += 1;
        }
        for (int i = 0; i < s2.size(); i++) {
            arr[(int)s2.charAt(i) - 65] -= 1;
            if (arr[(int)s2.charAt(i) - 65] < 0) {
                return false;
            }
        }
        return true;
    }
}