/**
 * 14. Longest Common Prefix
 * 2 solutions
 */



// s1: brute force, string.charAt() method
// O(n^2), O(n)

/*
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        for (int i = 0; i < strs.length; i++) {
            if (strs[i] == null) {
                return "";
            }
        }
        
        StringBuilder sb = new StringBuilder();
        int min_length = findMinLength(strs);
        for (int i = 0; i < min_length; i++) {
            if (isCommon(strs, i)) {
                sb.append(strs[0].charAt(i));
            } else {
                break;
            }
        }
        return sb.toString();
    }
    
    public boolean isCommon(String[] strs, int index) {
        if (strs[0] == null) {
            return false;
        }
        char c = strs[0].charAt(index);
        for (int i = 1; i < strs.length; i++) {
            if (strs[i].charAt(index) != c) {
                return false;
            }
        }
        return true;
    }
    
    public int findMinLength(String[] strs) {
        if (strs[0] == null) {
            return 0;
        }
        int min_length = strs[0].length();
        for (int i = 1; i < strs.length; i++) {
            min_length = Math.min(min_length, strs[i].length());
        }
        return min_length;
    }
}
*/


// s2: brute force, string.substring();
// O(n^2), O(1)

/*
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
*/

// *s3: compare two String each time
// O(n^2), O(1)
// tricky

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        for (int i = 0; i < strs.length; i++) {
            if (strs[i] == null) {
                return "";
            }
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            while (j < prefix.length() && j < strs[i].length() && prefix.charAt(j) == strs[i].charAt(j)) {
                j++;
            }
            prefix = prefix.substring(0, j);
            if (j == 0) {
                return "";
            }
        }
        return prefix;
    }
}



// failed
/*
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        

        int index = 0;
        while (true) 
        for (int i = 0; i < strs.length; i++) {
            if (strs[i] == null) {
                return "";
            }
            if (index >= strs[i].length()) {
                break; 
            } else if (i > 0 && strs[i].charAt(index) != strs[i - 1].charAt(index)){
                break;
            }

        }
        return strs[0].substring(0, index);
    }
}
*/