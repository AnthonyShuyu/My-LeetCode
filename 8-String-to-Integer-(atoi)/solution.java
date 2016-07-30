/**
 * 8. String to Integer (atoi)
 * 
 * Implement atoi to convert a string to an integer.

Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.
 * 
 */

// s1: brute force, clean the data
// O(n), O(1)


public class Solution {
    public int myAtoi(String str) {
        // corner case
        if (str == null || str.length() == 0) {
            return 0;
        }
        int result = 0;
        long temp = 0;
        if (str.length() == 1) {
            int num = str.charAt(0);
            if (num >= 48 && num <= 57) {
                return num;
            } else {
                return 0;
            }
        }
        // rule out the inital not digit or '-'
        int initial = str.charAt(0);
        if (initial != 45 && (initial < 48 || initial > 57)) {
            return 0;
        }
        
        for (int i = 1; i < str.length(); i++) {
            int num = str.charAt(i);
            if (num < 48 || num > 57) {
                return 0;
            }            
        }
        
        // rule out the string > 2^31 - 1 which is 2147483647 or string < -2^31 which is -2147483648
        
        if (initial == 45) {
            temp = (Long.valueOf(str.substring(1, str.length())) * (-1));
            if (temp < -2147483648) {
                return 0;
            } else {
                return (int)temp;
            }
        } else {
            temp = Long.valueOf(str);
            if (temp > 2147483647) {
                return 0;
            } else {
                return (int)temp;
            }
        }
    }
}