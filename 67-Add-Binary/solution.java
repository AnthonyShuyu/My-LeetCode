/**
 * 67. Add Binary
 * 2 solutions
 * 
 */


// s1: brute force, use for loop
// O(n), O(n)


/*
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
            c[length3 - index - 1] = 1; 
        }
        int i = 0;
        while (c[i] == 0 && i < length3 - 1) {
            i++;
        }
        while (i < length3) {
            sb.append(c[i]);
            i++;
        }
        
        return sb.toString();
        
    }
}
*/

// s2: use StringBuilder and two pointers
// O(n), O(n)

public class Solution {
    public String addBinary(String a, String b) {
        if (a == null || a.length() == 0 || b == null || b.length() == 0) {
            return null;
        }
        if (a.length() < b.length()) {
            String temp = a;
            a = b;
            b = temp;
        }
        
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        int pointerA = a.length() - 1;
        int pointerB = b.length() - 1;
        
        while (pointerB >= 0) {
            int sum = carry + (int)(a.charAt(pointerA) - '0') + (int)(b.charAt(pointerB) - '0');
            sb.append(sum % 2);
            carry = sum / 2;
            pointerA--;
            pointerB--;
        }
        while (pointerA >= 0) {
            int sum = carry + (int)(a.charAt(pointerA) - '0');
            sb.append(sum % 2);
            carry = sum / 2;
            pointerA--;
        }
        if (carry == 1) {
            sb.append(1);
        } 
        return sb.reverse().toString();
        
    }
}








// s2: use String cancatenate
// O(n), O(n^2)

/*
public class Solution {
    public String addBinary(String a, String b) {
        if(a.length() < b.length()){
            String tmp = a;
            a = b;
            b = tmp;
        }
        
        int pa = a.length()-1;
        int pb = b.length()-1;
        int carries = 0;
        String rst = "";
        
        while(pb >= 0){
            int sum = (int)(a.charAt(pa) - '0') + (int)(b.charAt(pb) - '0') + carries;
            rst = String.valueOf(sum % 2) + rst;
            carries = sum / 2;
            pa --;
            pb --;
        }
        
        while(pa >= 0){
            int sum = (int)(a.charAt(pa) - '0') + carries;
            rst = String.valueOf(sum % 2) + rst;
            carries = sum / 2;
            pa --;
        }       
        
        if (carries == 1)
            rst = "1" + rst;
        return rst;
    }
}
*/