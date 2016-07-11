public class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null) {
            return "";
        }
        if (s.length() > t.length()) {
            return "";
        }
        int min_length = s.length() + 1;
        String result = s;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                if (checkContain(s.substring(i, j), t)) {
                    if (j - i < min_length) {
                        min_length = j - i;
                        result = s.substring(i, j);
                    }
                }
            }
        }
        return result;
    }
    
    public boolean checkContain(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        
        int[] arr = new int[58];
        
        for (int i = 0; i < s1.length(); i++) {
            arr[(int)s1.charAt(i)] += 1;
        }
        for (int i = 0; i < s2.length(); i++) {
            arr[(int)s2.charAt(i)] -= 1;
            if (arr[(int)s2.charAt(i)] < 0) {
                return false;
            }
        }
        return true;        
    }
}