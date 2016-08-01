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

public class Solution {
    public String countAndSay(int n) {
        // corner case
        if (n <= 0) {
            return null;
        }
        String s = "1";
        for (int i = 0; i < n; i++) {
            s = generateNextString(s);
        }
        return s;
    }
    
    public String generateNextString(String s) {
        StringBuilder sb = new StringBuilder();
        int count;
        int index = 0;
        while (index < s.length()) {
            count = 0;
            int num = s.charAt(index) - '0';
            while ((s.charAt(index) - '0') == num && index < s.length()) {
                index++;
                count++;
            }
            sb.append(count);
            sb.append(num);
        }
        return sb.toString();
    }
}