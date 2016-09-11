/**
 * 389. Find the Difference
 * 
 * 
 */






// s1: use an array

public class Solution {
    public char findTheDifference(String s, String t) {
        // corner case
        if (s == null || t == null) {
            return '';
        }
        
        int[] array = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            array[c - '0']++;
        }
        
        for (int i = 0; i < t.length(); t++) {
            char c = t.charAt(i);
            array[c - '0']--;
            if (array[c - '0'] < 0) {
                return c;
            }
        }
        return '';
    }
}