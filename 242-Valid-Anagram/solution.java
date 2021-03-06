/**
 * 
 * 242. Valid Anagram
 * 3 solutions
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



// *s2: count the characters
// O(n), O(n)
// the most succinct 

public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null) {
            return false;
        }     
        if (s.length() != t.length()) {
            return false;
        }
        
        int[] arr = new int[256];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i)] += 1;
        }
        for (int i = 0; i < t.length(); i++) {
            arr[t.charAt(i)] -= 1;
            if (arr[t.charAt(i)] < 0) {
                return false;
            }
        }
        return true;
    }
}

// s3: HashMap, use one HashMap
// O(n), O(n)

/*
public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        Map<Character, Integer> hashMap = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            if (hashMap.containsKey(s.charAt(i))) {
                hashMap.put(s.charAt(i), hashMap.get(s.charAt(i)) + 1);
            } else {
                hashMap.put(s.charAt(i), 1);
            }
        }
        
        for (int i = 0; i < t.length(); i++) {
            if (!hashMap.containsKey(t.charAt(i))) {
                return false;
            } else {
                hashMap.put(t.charAt(i), hashMap.get(t.charAt(i)) - 1);
                if (hashMap.get(t.charAt(i)) < 0) {
                    return false;
                }
            }
        }
        for (Map.Entry<Character, Integer> entry : hashMap.entrySet()) {
            if (entry.getValue() != 0) {
                return false;
            }
        }
        return true;
    }
}
*/



// s3: HashMap, use 2 HashMaps, and loop traverse them, to see if they are alike ?
// O(n), O(n)
// easy to think, hard to implement, Wrong answer?

/*
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
            if (hashMap2.get(entry.getKey()) != entry.getValue()) {
                return false;
            }  
        }
        return true;
    }
}
 */