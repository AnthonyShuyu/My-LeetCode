/**
 * 43. Multiply Strings
 * 
 * 
 */





public class Solution {
    public String multiply(String num1, String num2) {
        if (num1 == null || num1.length() == 0 || num2 == null || num2.length() == 0) {
            return null;
        }
        long long_num1 = Long.parseLong(num1);
        long long_num2 = Long.parseLong(num2);
        long result = long_num1 * long_num2;
        return String.valueOf(result);
    }
}