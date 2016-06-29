/**
 * reverse String
 * 
 */


// s1: String.toCharArray()
// 

public class Solution {
    public String reverseString(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        char[] chars = s.toCharArray();
        return String.valueOf(reverseChars(chars));
    }
    
    public char[] reverseChars(char[] chars) {
        for (int i = 0, j = chars.length - 1; i < j; i++, j--) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
        return chars;
    }
}