/**
 * 8. String to Integer (atoi)
 * 
 * Implement atoi to convert a string to an integer.

Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.
 * 
 */

// s1: brute force, clean the data
// O(n), O(1)

/*
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
        

        
        // rule out the string > 2^31 - 1 which is 2147483647 or string < -2^31 which is -2147483648
        
        if (initial == 45) {
            int nonDigit = findNonDigit(str, 1);
            if (nonDigit == 1) {
                return 0;
            }
            String tempStr = str.substring(1, nonDigit);
            if (tempStr.length() > 10) {
                return Integer.MIN_VALUE;
             }
            temp = Long.valueOf(tempStr) * (-1);
            if (temp < -2147483648) {
                return Integer.MIN_VALUE;
            } else {
                return (int)temp;
            }
        } else if (initial == 43) {
            int nonDigit = findNonDigit(str, 1);
            if (nonDigit == 1) {
                return 0;
            }
            String tempStr = str.substring(1, nonDigit);
            if (tempStr.length() > 10) {
                return Integer.MAX_VALUE;
            }
            temp = Long.valueOf(tempStr);
            if (temp > 2147483647) {
                return Integer.MAX_VALUE;
            } else {
                return (int)temp;
            }
        } else {
            int nonDigit = findNonDigit(str, 0);
            if (nonDigit == 0) {
                return 0;
            }
            String tempStr = str.substring(0, nonDigit);
            if (tempStr.length() > 11) {
                return Integer.MAX_VALUE;
            }
            temp = Long.valueOf(tempStr);
            if (temp > 2147483647) {
                return Integer.MAX_VALUE;
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
*/


//s2: use index and num = num * 10 + n
// O(n), O(1)
// tricky

/*
public class Solution {
    public int myAtoi(String str) {
        // corner case
        if (str == null || str.length() == 0) {
            return 0;
        }
        
        int index = 0;
        long num = 0;
        int sign = 1;
        
        str = str.trim();
        
        if (str.charAt(0) == '+') {
            index++;
        } else if (str.charAt(0) == '-') {
            sign = -1;
            index++;
        }
        
        for (int i = index; i < str.length(); i++) {
            if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                break;
            }
            num = num * 10 + (str.charAt(i) - '0');
            if (sign == 1 && num > 2147483647) {
                return Integer.MAX_VALUE;
            }
            if (sign == -1 && num * (-1) < -2147483648) {
                return Integer.MIN_VALUE;
            }
        }
        return sign == 1 ? (int)num : (int)num * (-1);
    }
}
*/


// *s2: use index and num = num * 10 + n, modified
// O(n), O(1)
// tricky


public class Solution {
    public int myAtoi(String str) {
        // corner case
        if (str == null || str.length() == 0) {
            return 0;
        }
        
        int index = 0;
        long num = 0;
        int sign = 1;
        
        str = str.trim();
        
        if (str.charAt(0) == '+') {
            index++;
        } else if (str.charAt(0) == '-') {
            sign = -1;
            index++;
        }
        
        for (int i = index; i < str.length(); i++) {
            if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                break;
            }
            num = num * 10 + (str.charAt(i) - '0');
            if (num > Integer.MAX_VALUE) {
                break;
            }
            // if (sign == 1 && num > 2147483647) {
            //     return Integer.MAX_VALUE;
            // }
            // if (sign == -1 && num * (-1) < -2147483648) {
            //     return Integer.MIN_VALUE;
            // }
        }
        if (num * sign >= Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (num * sign <= Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return num * sign;
    }
}