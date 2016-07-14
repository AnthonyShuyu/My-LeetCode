/**
 * 
 * 242. Valid Anagram
 * 
 * 
 */


// s1: Arrays.sort()
// O(nlogn), O(n)

public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        Arrays.sort(sArray);
        Arrays.sort(tArray);
        return String.valueOf(sArray).equals(String.valueOf(tArray));
    }
}