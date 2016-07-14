/**
 * 49. Group Anagrams
 * 
 * 
 */


// s1: brute force
// O(n^3), O(n^2)
// time limit exceeded

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>();
        if (strs == null || strs.length == 0) {
            return result;
        }
        Set<String> hashSet = new HashSet<String>();
        for (int i = 0; i < strs.length; i++) {
            if (!hashSet.contains(strs[i])) {
                List<String> stringList = new ArrayList<String>();
                String s = strs[i];
                stringList.add(s);
                for (int j = i + 1; j < strs.length; j++) {
                    if (isAnagram(s, strs[j])) {
                        stringList.add(strs[j]);
                        hashSet.add(strs[j]);
                    }
                }
                result.add(stringList);
            }
        }
        return result;
    }
    
    public boolean isAnagram(String s, String t) {
        char[] arr = new char[26];
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


