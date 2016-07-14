/**
 * 
 * 242. Valid Anagram
 * 
 * 
 */


// s1: Arrays.sort()
// O(nlogn), O(n)

/*
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
*/


// s2: count the characters
// O(n), O(n)
// tricky

public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[(int)(s.charAt(i) - 'a')] += 1;
        }
        for (int i = 0; i < t.length(); i++) {
            arr[(int)(t.charAt(i) - 'a')] -= 1;
            if (arr[(int)(t.charAt(i) - 'a')] < 0) {
                return false;
            }
        }
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                return false;
            }
        }
        return true;
    }
}

