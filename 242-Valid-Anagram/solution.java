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
        Arrays.sort(s);
        Arrays.sort(t);
        return s.equals(t);
    }
}