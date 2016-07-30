/**
 * 
 * 6. ZigZag Conversion
 * 
 * 
 * 
 */


// s1: brute force, see the number of nRows * 2 - 2 as one group, find the rule
// O(row * n), O(n)

/*
public class Solution {
    public String convert(String s, int numRows) {
        // corner case
        if (s == null || s.length() == 0) {
            return s;
        }
        if (numRows <= 1) {
            return s;
        }
        
        int m = numRows * 2 - 2;
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < numRows; i++) {
            int j = i;
            int index = 0;
            if (j == 0 || j == numRows - 1) {
                while (j < s.length()) {
                    sb.append(s.charAt(j));
                    j += m;
                }
            } else {
                while (j < s.length()) {
                    if (index % 2 == 0) {
                        sb.append(s.charAt(j));
                        j += (m - i * 2);
                        index++;
                    } else {
                        sb.append(s.charAt(j));
                        j += (i * 2);
                        index++;
                    }
                }
            }
        }
        return sb.toString();
    }
}
*/


// s2: brute force, same thought as s1
// O(numRows * n), O(n)

public class Solution {
    public String convert(String s, int numRows) {
        // corner case
        if (s == null || s.length() < numRows) {
            return s;
        }
        if (numRows <= 1) {
            return s;
        }
        
        int step = numRows * 2 - 2;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            int interval = step - i * 2;
            for (int j = i; j < s.length(); j += step) {
                sb.append(s.charAt(j));
                if (interval > 0 && interval < step && j + interval < s.length()) {
                    sb.append(s.charAt(j + interval));
                }
            }
        }
        return sb.toString();
    }
}