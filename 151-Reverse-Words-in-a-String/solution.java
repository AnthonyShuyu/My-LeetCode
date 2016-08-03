/**
 * 151. Reverse Words in a String
 * 
 * 
 */


// s1: use s.split() and regular expression
// O(n), O(n)

public class Solution {
    public String reverseWords(String s) {
        // corner case
        if (s == null || s.length() == 0) {
            return s;
        }
        String[] strs = s.split(" +");
        String result = "";
        for (int i = strs.length - 1; i >= 0; i--) {
            if (strs[i] != "") {
                result += strs[i] + " ";
            }
        }
        result = result.trim();
        return result;
    }
}