/**
 * 
 * 168. Excel Sheet Column Title
 * 
 */


// s1: brute force, math
// O(n), O(1)

public class Solution {
    public String convertToTitle(int n) {
        // corner case
        if (n <= 0) {
            return null;
        }
        int num = n;
        int total = 'z' - 'a' + 1;
        StringBuilder sb = new StringBuilder();
        while ((num - 1) / total != 0) {
            sb.append((char)((num - 1) % total + 'A'));
            num = (num - 1) / total;
        }
        sb.append((char)((num - 1) % total + 'A'));
        return sb.reverse().toString();         
    }
}