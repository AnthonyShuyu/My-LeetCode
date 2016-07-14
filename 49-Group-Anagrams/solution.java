/**
 * 49. Group Anagrams
 * 
 * 
 */


// s1: brute force
// O(n^3), O(n^2)
// time limit exceeded

/*
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
*/



// s2: brute force 2, one for loop, add to the result
// O(n^3), O(n)
// time limit exceeded


/*
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>();
        if (strs == null || strs.length == 0) {
            return result;
        }
        
        for (int i = 0; i < strs.length; i++) {
            boolean checkAnagram = false;
            for (List<String> list : result) {
                if (list.size() > 0 && isAnagram(list.get(0), strs[i])) {
                    list.add(strs[i]);
                    checkAnagram = true;
                }
            }
            if (!checkAnagram) {
                List<String> arrayList = new ArrayList<String>();
                arrayList.add(strs[i]);
                result.add(arrayList);
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
*/


// s3: HashMap, key is the String , value is the ArrayList corresponds to the String
// O(n^2), O(n)

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>();
        if (strs == null || strs.length == 0) {
            return result;
        }
        Map<String, List<String>> hashMap = new HashMap<String, List<String>>();
        for (int i = 0; i < strs.length; i++) {
            char[] charArray = strs[i].toCharArray();
            Arrays.sort(charArray);
            String s = String.valueOf(charArray);
            if (hashMap.containsKey(s)) {
                hashMap.get(s).add(strs[i]);
            } else {
                List<String> arrayList = new ArrayList<String>();
                arrayList.add(strs[i]);
                hashMap.put(s, arrayList);
            }
        }
        result.addAll(hashMap.values());
        return result;
    }
}