/**
 * 38. Count and Say
 * 
 * 
 * The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth sequence.
 * 
 */
 
// s1: brute force
// O(n^2), O(n)

public class Solution {
    public String countAndSay(int n) {
        // corner case
        if (n <= 0) {
            return null;
        }
        String s = "1";
        for (int i = 0; i < n - 1; i++) {
            s = generateNextString(s);
        }
        return s;
    }
    
    /*
    public String generateNextString(String s) {
        StringBuilder sb = new StringBuilder();
        int count;
        int index = 0;
        while (index < s.length()) {
            count = 0;
            int num = s.charAt(index) - '0';
            while ( index < s.length() && (s.charAt(index) - '0') == num ) {
                index++;
                count++;
            }
            sb.append(count);
            sb.append(num);
        }
        return sb.toString();
    }
    */
    public String generateNextString(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        int index = 0;
        while (index < s.length()) {
            count = 1;
            while (index < s.length() - 1 && (s.charAt(index) == s.charAt(index + 1))){
                count++;
                index++;
            }
            sb.append(count);
            sb.append(s.charAt(index));
            index++;
        }
        return sb.toString();
    }
}