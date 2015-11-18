public class Solution {
    public String addBinary(String a, String b) {
        if (a == null || a.isEmpty()) {
          return b;
        }
        if (b == null || b.isEmpty()) {
          return a;
        }
        StringBuilder result = new StringBuilder();
        char[] aArray = a.toCharArray();
        char[] bArray = b.toCharArray();
        int carry = 0;
        int sum = 0;
        int aPoint = aArray.length-1;
        int bPoint = bArray.length-1;
        int aByte = 0;
        int bByte = 0;

        while (aPoint >= 0 || bPoint >= 0 || carry == 1) {
             aByte = (aPoint>=0) ? Character.getNumericValue(aArray[aPoint--]) : 0;
             bByte = (bPoint>=0) ? Character.getNumericValue(bArray[bPoint--]) : 0;
             sum = aByte+bByte+carry;
             result.append(sum%2);
             carry = sum/2;
             //sum = aByte ^ bByte ^ carry;
             //result.append(sum);
             //carry = (aByte+bByte+carry)>=2 ? 1: 0;
        }

        return result.reverse().toString();
    }
}
