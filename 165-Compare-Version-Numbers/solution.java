/**
 * 165. Compare Version Number
 * 
 * 
 */

// s1: string.split() method
// O(n), O(n)
// tricky

public class Solution {
    public int compareVersion(String version1, String version2) {
        if (version1 == null || version2 == null || version1.length() == 0 || version2.length() == 0) {
            return 0;
        }
        String[] strings1 = version1.split("\\.");
        String[] strings2 = version2.split("\\.");
        int max = Math.max(strings1.length, strings2.length);
        for (int i = 0; i < max; i++) {
            int num1, num2;
            if (i < strings1.length) {
                num1 = Integer.valueOf(strings1[i]);
            } else {
                num1 = 0;
            }
            
            if (i < strings2.length) {
                num2 = Integer.valueOf(strings2[i]);
            } else {
                nums2 = 0;
            }
            if (num1 > num2) {
                return 1;
            } else if (num1 < num2) {
                return -1;
            }
        }
        return 0;
    }
}








/*
public class Solution {
    public int compareVersion(String version1, String version2) {
        if (version1 == null || version1.length() == 0 || version2 == null|| version2.length() == 0) {
            return 0;
        }
        
        String[] string1 = version1.split("\\.");
        String[] string2 = version2.split("\\.");
        int n = string1.length < string2.length ? string1.length : string2.length;
        for (int i = 0;i < n; i++) {
            if (Integer.valueOf(string1[i]) < Integer.valueOf(string2[i])) {
                return -1;                
            } else if (Integer.valueOf(string1[i]) > Integer.valueOf(string2[i])) {
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
        
        // int index = 0;
        // int index2 = 0;
        // int flag = 0;
        // while (index < version1.length() && index < version2.length()) {
        //     if (version1.charAt(index2) < version2.charAt(index2)) {
        //       flag = -1; 
        //     } else if (version1.charAt(index2) > version2.charAt(index2)) {
        //         flag = 1;
        //     }
        //     if (version1.charAt(index) == '.' && version2.charAt(index) != '.') {
        //         return 1;
        //     } else if (version1.charAt(index) != '.' && version2.charAt(index) == '.') {
        //         return -1;
        //     } else if (version1.charAt(index) == '.' && version2.charAt(index) == '.'){
        //         if (flag != 0) {
        //             return flag;
        //         } else {
        //             index2 = index + 1;
        //         }
        //     }
        //     index++;
        // }
        
        // if (version1.length() > version2.length()) {
        //     return 1;
        // } else if (version1.length() < version2.length()){
        //     return -1;
        // } else {
        //     return flag;
        // }
    }
}
*/