/**
 * 
 * 13. Roman to Integer
 * 1 solution
 * 
 */

// Ask: what is Roman numeral?
// any of the letters representing numbers in the Roman numerical system: I = 1, V = 5, X = 10, L = 50, C = 100, D = 500, M = 1,000. In this system, a letter placed after another of greater value adds (thus XVI or xvi is 16), whereas a letter placed before another of greater value subtracts (thus XC or xc is 90).

// s1: HashMap
// O(n), O(n)

public class Solution {
    public int romanToInt(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> hashMap = new HashMap<Character, Integer>();
        hashMap.put('I', 1);
        hashMap.put('V', 5);
        hashMap.put('X', 10);
        hashMap.put('L', 50);
        hashMap.put('C', 100);
        hashMap.put('D', 500);
        hashMap.put('M', 1000);
        int result = hashMap.get(s.charAt(s.length() - 1));
        
        for (int i = s.length() - 2; i >= 0; i--) {
            if (hashMap.get(s.charAt(i)) < hashMap.get(s.charAt(i + 1))) {
                result -= hashMap.get(s.charAt(i));
            } else {
                result += hashMap.get(s.charAt(i));
            }
        }
        return result;
    }
}