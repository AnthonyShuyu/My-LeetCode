/**
 * 
 * 58. Length of Last Word
 * 
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
If the last word does not exist, return 0.
 * 
 */

// s1: brute force
// O(n), O(1)

public class Solution {
    public int lengthOfLastWord(String s) {
        // corner case
        if (s == null || s.length() == 0) {
            return 0;
        } 
        int count = 0;
        int index = s.length() - 1;
        while (index >= 0) {
            if (Character.isLetter(s.charAt(index))) {
                break;
            }
            index--;
        }
        if (index < 0) {
            return 0;
        }
        while (index >= 0) {
            if (Character.isLetter(s.charAt(index))) {
                count++;
                index--;
            } else {
                break;
            }
        }
        return count;
    }
}