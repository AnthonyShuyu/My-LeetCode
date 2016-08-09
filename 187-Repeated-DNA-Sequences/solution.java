/**
 * 187. Repeated DNA Sequences
 * 
 * 
 */


// s1: brute force
// O(n^2), O(n)
// time limit exceeded

/*
public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        // corner case
        List<String> result = new ArrayList<String>();
        if (s == null || s.length() <= 10) {
            return result;
        }
        for (int i = 0; i < s.length() - 9; i++) {
            String str = s.substring(i, i + 10);
            for (int j = i + 1; j < s.length() - 9; j++) {
                String str2 = s.substring(j, j + 10);
                if (str.equals(str2)) {
                    if (!result.contains(str)) {
                        result.add(str);
                    }
                    break;
                }
            }
        }
        return result;
    }
}
*/


// s2: HashMap
// O(n), O(n)

/*
public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        // corner case
        List<String> result = new ArrayList<String>();
        if (s == null || s.length() <= 10) {
            return result;
        }
        Map<String, Integer> hashMap = new HashMap<String, Integer>();
        
        for (int i = 0; i < s.length() - 9; i++) {
            String str = s.substring(i, i + 10);
            if (hashMap.containsKey(str)) {
                int index = hashMap.get(str);
                String temp = s.substring(index, index + 10);
                if (!result.contains(temp)) {
                    result.add(temp);
                }
                continue;
            } else {
                hashMap.put(str, i);
            }
        }
        return result;
    }
}
*/


// *s3: use HashSet
// O(n), O(n)

public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        // corner case
        List<String> result = new ArrayList<String>();
        if (s == null || s.length() <= 10) {
            return result;
        }
        Set<String> hashSet = new HashSet<String>();
        for (int i = 0; i < s.length() - 9; i++) {
            String str = s.substring(i, i + 10);
            if (hashSet.contains(str)) {
                if (!result.contains(str)) {
                    result.add(str);
                }
            } else {
                hashSet.add(str);
            }
        }
        return result;
    }
}