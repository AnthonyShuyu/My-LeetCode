/**
 * 165. Compare Version Number
 * 
 * 
 */


public class Solution {
    public int compareVersion(String version1, String version2) {
        if (version1 == null || version1.length() == 0 || version2 == null|| version2.length() == 0) {
            return 0;
        }
        String[] string1 = version1.split(".");
        String[] string2 = version2.split(".");
        
        int n = string1.length < string2.length ? string1.length : string2.length;
        
        for (int i = 0;i < n; i++) {
            if (Integer.valueOf(string1[i]) < Integer.valueOf(string2[i])) {
                return -1;                
            } else if (Integer.valueOf(string[i]) > Integer.valueOf(string2[i])) {
                return 1;
            }
        }
        if (string1.length < string2.length) {
            return -1;
        } else if (string1.length > string2.length) {
            return 1;
        } else {
            return 0;
        }
        
    }
}