/**
 * reverse String
 * 3 methods
 */


// s1: String.toCharArray()
// O(n), O(n)

/*
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

*/


// s2: use StringBuilder
// O(n), O(n)

/*
public class Solution{
    public String reverseString(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(s.length() - i - 1));
        }
        return sb.toString();
    }
}
*/


// s3: use StringBuilder reverse()
// O(n), O(n)

public class Solution{
    public String reverseString(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
        
    }
    
}
