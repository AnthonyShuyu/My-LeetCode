public class Solution {
    public String addBinary(String a, String b) {
        if (a.length() < b.length()) {
          String temp = a;
          a = b;
          b = temp;
        }

        StringBuilder result = new StringBuilder();
        int pointA = a.length()-1;
        int pointB = b.length()-1;
        int carry = 0;
        while (pointB>=0) {
            int sum = (int)(a.charAt(pointA) - '0') + (int)(b.charAt(pointB) - '0')+ carry;
            result.append(sum%2);
            carry = sum/2;
            pointA --;
            pointB --;
        }

        while (pointA>=0) {
          int sum = (int)(a.charAt(pointA) - '0') + carry;
          result.append(sum%2);
          carry = sum/2;
          pointA --;
        }

        if (carry == 1) {
          result.append(1);
        }

        return result.reverse().toString();
    }
}
