/**
 * 28. Implement strStr()
 * 
 */
 
 
// s1: String   substring method
// O(n), O(1)

public class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return -1;
        }
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (haystack.substring(i, i + needle.length()).equals(needle)) {
                 return i;
            }
        }
        return -1;
    }
}