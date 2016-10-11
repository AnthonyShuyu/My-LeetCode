/**
 * 
 * 387. First Unique Character in a String
 * 
 * 
 * 
 */



// s1: brute force
// O(n^2), O(1)

public class Solution {
    public int firstUniqChar(String s) {
        // corner case
        if (s == null || s.length() == 0) {
            return -1;
        }
        if (s.length() == 1) {
            return 0;
        }
        

        for (int i = 0; i < s.length(); i++) {
            boolean check = true; 
            for (int j = 0; j < s.length(); j++) {
                if (i == j) {
                    continue;
                }
                if (s.charAt(i) == s.charAt(j)) {
                    check = false;
                }
            }
            if (check) {
                return i;
            }
        }
        return -1;
    }
}