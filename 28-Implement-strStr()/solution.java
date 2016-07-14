/**
 * 28. Implement strStr()
 * 
 */
 
 
// s1: String   substring method
// O(n), O(1)

public class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return -1;
        }
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (haystack.substring(i, i + needle.length()).equals(needle)) {
                 return i;
            }
        }
        return -1;
    }
}

// s2: String.charAt()
// O(n), O(1)

public class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null || haystack.length() < needle.length()) {
            return -1;
        }
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                int index = 1;
                while (index < needle.length()) {
                    if (haystack.charAt(i + index) == needle.charAt(index)) {
                        index++;
                        if (index == needle.length()) {
                            return i;
                        }
                    } else {
                        break;
                    }
                }
            } else {
                continue;
            }
        }
        return -1;
    }
}