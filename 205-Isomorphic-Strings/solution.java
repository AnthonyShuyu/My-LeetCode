/**
 * 205. Isomorphic Strings
 * 
 * Given two strings s and t, determine if they are isomorphic.
Two strings are isomorphic if the characters in s can be replaced to get t.
 * 
 */

// s1: brute force, map the string to the int[], compare the two int arrays
// O(n), O(n)

/*
public class Solution {
    public boolean isIsomorphic(String s, String t) {
        // corner case
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        
        int[] sArray = toIntArray(s);
        int[] tArray = toIntArray(t);
        
        for (int i = 0; i < sArray.length; i++) {
            if (sArray[i] != tArray[i]) {
                return false;
            }
        }
        return true;
    }
    
    public int[] toIntArray(String s) {
        int[] array = new int[s.length()];
        int num = 0;
        Map<Character, Integer> hashMap = new HashMap<Character, Integer>();
        for (int i = 0;  i< s.length() ; i++ ) {
            if(hashMap.containsKey(s.charAt(i))) {
                array[i] = hashMap.get(s.charAt(i));
            } else {
                num++;
                array[i] = num;
                hashMap.put(s.charAt(i), num);
            }
        }
        return array;
    }
}
*/

// s2: HashMap
// O(n), O(n)

public class Solution {
    public boolean isIsomorphic(String s, String t) {
        // corner case
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        
        Map<Character, Character> hashMap = new HashMap<Character, Character>();
        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            if (hashMap.containsKey(sChar)) {
                if (hashMap.get(sChar) != tChar) {
                    return false;
                }
            } else {
                if (hashMap.containsValue(tChar)) {     // when meet new Schar but has already map to tChar before 
                    return false;
                } 
                hashMap.put(sChar, tChar);  
            }
        }
        return true;
    }
}