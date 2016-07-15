/**
 * 14. Longest Common Prefix
 * 
 */


// s1: brute force, string.substring();
// 

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String s = "";
        int min_length = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            if (strs[i] != null) {
                // min_length = Math.min(min_length, strs[i].length());     
                if (strs[i].length() < min_length) {
                    min_length = strs[i].length();
                    s = strs[i];   
                }
            } else {
                return "";
            }
        }
        if (min_length == Integer.MAX_VALUE) {
            return "";
        }
        
        for (int i = 0; i < min_length; i++) {
            for (int j = 0; j < strs.length - 1; j++) {
                if (!strs[j].substring(0, i + 1).equals(strs[j + 1].substring(0, i + 1))) {
                    return strs[j].substring(0, i);
                }
            }
        }
        return s;
    }
}