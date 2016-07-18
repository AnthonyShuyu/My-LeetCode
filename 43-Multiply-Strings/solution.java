/**
 * 43. Multiply Strings
 * 
 * 
 */


// *s1: use carry and another array
// O(n^2), O(n)
// tricky


public class Solution {
    public String multiply(String num1, String num2) {
        if (num1 == null || num1.length() == 0 || num2 == null || num2.length() == 0) {
            return null;
        }
        int length1 = num1.length();
        int length2 = num2.length();
        int[] array = new int[length1 + length2 + 1];
        
        for (int i = length1 - 1; i >= 0; i--) {
            int carry = 0;
            for (int j = length2 - 1; j >= 0; j--) {
                int num = carry + array[i + j + 1] + Character.getNumericValue(num1.charAt(i)) * Character.getNumericValue(num2.charAt(j));
                carry = num / 10;
                array[i + j + 1] = num % 10;
            }
        }
        int i = 0;
        while (array[i] == 0 && i < array.length - 1) {
            i++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
        }
        return sb.toString();
    }
}














// s2: Convert String to Int
// O(1), O(1)
// failed

// public class Solution {
//     public String multiply(String num1, String num2) {
//         if (num1 == null || num1.length() == 0 || num2 == null || num2.length() == 0) {
//             return null;
//         }
//         long long_num1 = Long.parseLong(num1);
//         long long_num2 = Long.parseLong(num2);
//         long result = long_num1 * long_num2;
//         return String.valueOf(result);
//     }
// }

/*
public class Solution {
    public String multiply(String num1, String num2) {
        if (num1 == null || num2 == null) {
            return null;
        }
        
        int len1 = num1.length(), len2 = num2.length();
        int len3 = len1 + len2;
        int i, j, product, carry;

        int[] num3 = new int[len3];
        for (i = len1 - 1; i >= 0; i--) {
            carry = 0;
            for (j = len2 - 1; j >= 0; j--) {
                product = carry + num3[i + j + 1] +
                    Character.getNumericValue(num1.charAt(i)) *
                    Character.getNumericValue(num2.charAt(j));
                num3[i + j + 1] = product % 10;
                carry = product / 10;
            }
            num3[i + j + 1] = carry;
        }

        StringBuilder sb = new StringBuilder();
        i = 0;

        while (i < len3 - 1 && num3[i] == 0) {
            i++;
        }

        while (i < len3) {
            sb.append(num3[i++]);
        }

        return sb.toString();
    }
}
*/