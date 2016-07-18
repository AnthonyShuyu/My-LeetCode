/**
 * 67. Add Binary
 * 
 */



public class Solution {
    public String addBinary(String a, String b) {
        if (a == null || a.length() == 0 || b == null || b.length() == 0) {
            return null;
        }
        int length1 = a.length();
        int length2 = b.length();
        int length3 = length1 + length2;
        int[] c = new int[length3];
        
        int carry = 0;
        int index = 0;
        while (index < length1 && index < length2) {
            int sum = carry + Character.getNumericValue(a.charAt(length1 - index - 1)) + Character.getNumericValue(b.charAt(length2 - index - 1));
            carry = sum / 2;
            c[length3 - index - 1] = sum % 2;
            index++;
        }
        while (index < length1) {
            int sum = carry + Character.getNumericValue(a.charAt(length1 - index - 1));
            carry = sum / 2;
            c[length3 - index - 1] = sum % 2;
            index++;
        }
        
        while (index < length2) {
            int sum = carry + Character.getNumericValue(b.charAt(length2 - index - 1));
            carry = sum / 2;
            c[length3 - index - 1] = sum % 2;
            index++;
        }
        StringBuilder sb = new StringBuilder();
        if (carry == 1) {
            sb.append(1);
        }
        while (index >= 0) {
            sb.append(c[length3 - index]);
            index--;
        }
        return sb.toString();
        
    }
}