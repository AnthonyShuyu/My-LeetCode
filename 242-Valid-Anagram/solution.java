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

/*
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
*/


// s3: HashMap, use 2 HashMaps, and loop traverse them, to see if they are alike
// O(n), O(n)
// easy to think, hard to implement

public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null) {
            return false;
        }    
        Map<Character, Integer> hashMap1 = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            if (hashMap1.containsKey(s.charAt(i))) {
                hashMap1.put(s.charAt(i), hashMap1.get(s.charAt(i)) + 1);
            } else {
                hashMap1.put(s.charAt(i), 1);
            }
        }
        
        Map<Character, Integer> hashMap2 = new HashMap<Character, Integer>();
        for (int i = 0; i < t.length(); i++) {
            if (hashMap2.containsKey(t.charAt(i))) {
                hashMap2.put(t.charAt(i), hashMap2.get(t.charAt(i)) + 1);
            } else {
                hashMap2.put(t.charAt(i), 1);
            }
        }
        
        // loop traverse the two HashMaps to see if they are the same
        if (hashMap1.size() != hashMap2.size()) {
            return false;
        }
        
        for (Map.Entry<Character, Integer> entry: hashMap1.entrySet()) {
            Char c = entry.getKey();
            if (hashMap2.get(entry.getKey()) != entry.getValue()) {
                return false;
            }  
        }
        return true;
    }
}