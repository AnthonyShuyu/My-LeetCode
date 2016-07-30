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
        
        int index = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                index++;
            } else {
                break;
            }
        }
        str = str.substring(index, str.length());
        
        if (str.length() == 0) {
            return 0;
        }
        
        // rule out the str length equals to 1
        if (str.length() == 1) {
            int num = str.charAt(0);
            if (num >= 48 && num <= 57) {
                return Integer.valueOf(str);
            } else {
                return 0;
            }
        }
        
        
        
        // rule out the initial not digit or '-' or '+'
        int initial = str.charAt(0);
        if (initial != 45 && (initial < 48 || initial > 57) && initial != 43) {
            return 0;
        }
        
        
        // // rule out the index from 1 to str.length() - 1 not equals to digit
        // for (int i = 1; i < str.length(); i++) {
        //     int num = str.charAt(i);
        //     if (num < 48 || num > 57) {
        //         return 0;
        //     }            
        // }
        
        if (str.length() > 11) {
            return 0;
        }
        
        // rule out the string > 2^31 - 1 which is 2147483647 or string < -2^31 which is -2147483648
        
        if (initial == 45) {
            int nonDigit = findNonDigit(str, 1);
            String tempStr = str.substring(1, nonDigit);
            temp = Long.valueOf(tempStr) * (-1);
            if (temp < -2147483648) {
                return 0;
            } else {
                return (int)temp;
            }
        } else if (initial == 43) {
            int nonDigit = findNonDigit(str, 1);
            String tempStr = str.substring(1, nonDigit);
            temp = Long.valueOf(tempStr);
            if (temp > 2147483647) {
                return 0;
            } else {
                return (int)temp;
            }
        } else {
            int nonDigit = findNonDigit(str, 0);
            String tempStr = str.substring(0, nonDigit);
            temp = Long.valueOf(tempStr);
            if (temp > 2147483647) {
                return 0;
            } else {
                return (int)temp;
            }
        }
    }
    
    public int findNonDigit(String s, int index) {
        for (int i = index; i < s.length(); i++) {
            if (s.charAt(i) < 48 || s.charAt(i) > 57) {
                return i;
            }
        }
        return s.length();
    }
}