/**
 * 151. Reverse Words in a String
 * 2 solutions
 * 
 */


// s1: use s.split() and regular expression
// O(n), O(n)

/*
public class Solution {
    public String reverseWords(String s) {
        // corner case
        if (s == null || s.length() == 0) {
            return s;
        }
        String[] strs = s.split(" +");
        String result = "";
        for (int i = strs.length - 1; i >= 0; i--) {
            if (strs[i] != "") {
                result += strs[i] + " ";
            }
        }
        result = result.trim();
        return result;
    }
}
*/

// s2: use two pointers
// O(n), O(n)


public class Solution {
    public String reverseWords(String s) {
        // corner case
        if (s == null || s.length() == 0) {
            return s;
        }
        int i = 0;
        List<String> arrayList = new ArrayList<String>();
        while (i < s.length()) {
            if (s.charAt(i) == ' ') {
                i++;
                continue;
            } else {
                int j = i;
                while (j < s.length()) {
                    if (s.charAt(j) == ' ') {
                        break;
                    } else {
                        j++;
                    }
                }
                String newString = s.substring(i, j);
                arrayList.add(newString);
                i = j;
            }
        }
        String result = "";
        for (int index = arrayList.size() - 1; index >= 0; index--) {
            result += arrayList.get(index) + " ";
        }
        result = result.trim();
        return result;
    }
}
