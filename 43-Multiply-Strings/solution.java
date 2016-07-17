/**
 * 43. Multiply Strings
 * 
 * 
 */





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
                    Integer.parseInt(num1.charAt(i)) *
                    Integer.parseInt(num2.charAt(j));
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