/**
 * 205. Isomorphic Strings
 * 
 * 
 */



// s1: brute force, map the string to the int[], compare the two int arrays
// O(n), O(n)

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