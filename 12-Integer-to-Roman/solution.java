/**
 * 12. Integer to Roman
 * 
 * 
 */

// Ask question: what is roman numeral?
// any of the letters representing numbers in the Roman numerical system: I = 1, V = 5, X = 10, L = 50, C = 100, D = 500, M = 1,000. In this system, a letter placed after another of greater value adds (thus XVI or xvi is 16), whereas a letter placed before another of greater value subtracts (thus XC or xc is 90).




// s1: two arrays
// O(n), O(n)

public class Solution {
    public String intToRoman(int num) {
        if (num < 1 || num >= 4000) {
            return null;
        }
        Map<Integer, String> hashMap = new HashMap<Integer, String>();
        hashMap.put(1000, "M");
        hashMap.put(900, "CM");
        hashMap.put(500, "D");
        hashMap.put(400, "CD");
        hashMap.put(100, "C");
        hashMap.put(90, "XC");
        hashMap.put(50, "L");
        hashMap.put(40, "XL");
        hashMap.put(10, "X");
        hashMap.put(9, "IX");
        hashMap.put(5, "V");
        hashMap.put(4, "IV");
        hashMap.put(1, "I");
        
        int[] nums = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        int index = 0;
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            int times = num / nums[index];
            for (int i = 0; i < times; i++) {
                sb.append(hashMap.get(nums[index]));
            }
            num = times * nums[index];
            index++;
        }
        return sb.toString();
    }
}











// s1: HashMap, StringBuilder
// O(n), O(n)
// failed, not consider all the situations

/*
public class Solution {
    public String intToRoman(int num) {
        if (num < 1 || num >= 4000) {
            return null;
        }
        Map<Character, Integer> hashMap = new HashMap<Character, Integer>();
        hashMap.put('I', 1);
        hashMap.put('V', 5);
        hashMap.put('X', 10);
        hashMap.put('L', 50);
        hashMap.put('C', 100);
        hashMap.put('D', 500);
        hashMap.put('M', 1000);
        
        // how many 'M' ? reduce to 999

        int m = num / hashMap.get('M');
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < m; i++) {
            sb.append("M");
        }
        
        // how many 'D' ? reduce to 499
        int m2 = num - m * hashMap.get('M');
        int d = m2 / 500;
        
        for (int i = 0; i < d; i++) {
            sb.append("D");
        }
        
        // how many 'C'? reduce to 99
        int d2 = m2 - d * hashMap.get('D');
        int c = d2 / 100;
        if (c == 4) {
            sb.append("C");
            sb.append("D");
        } else {
            for (int i = 0; i < c; i++) {
                sb.append("c");                
            }
        }
        
        
        // how many 'L'? reduce to 49
        int c2 = d2 - c * hashMap.get('C');
        int l = c2 / 50;
        for (int i = 0; i < l; i++) {
            sb.append("l");
        }
        
        // how many 'X'? reduce to 9
        int l2 = c2 - l * hashMap.get('L');
        int x = l2 / 10;
        if (x == 4) {
            sb.append("X");
            sb.append("L");
        } else {
            for (int i = 0; i < x; i++) {
                sb.append("X");
            }
        }
        
        // how many V? reduce to 4
        int x2 = l2 - x * hashMap.get('X');
        int v = x2 / 5;
        for (int i = 0; i < v; i++) {
            sb.append("V");
        }
        
        // how many I? reduce to 0, finish
        int v2 = x2 - v * hashMap.get('V');
        if (v2 == 4) {
            sb.append("I");
            sb.append("V");
        } else {
            for (int i = 0; i < v2; i++) {
                sb.append("I");
            }
        }
        
        return sb.toString();
    }
}
*/