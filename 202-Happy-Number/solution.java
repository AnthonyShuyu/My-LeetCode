/**
 * 
 * 202. Happy Number
 * 1 Solution
 * 
 */


// s1: use a hashSet
// O(n), O(n)

public class Solution {
    public boolean isHappy(int n) {
        // corner case
        if (n <= 0) {
            return false;
        }
        
        Set<Integer> hashSet = new HashSet<Integer>();
        while (n != 1) {
            if (hashSet.contains(n)) {
                return false;
            } else {
                hashSet.add(n);
            }
            n = count(n);
        }
        return true;
    }
    
    
    public int count(int n) {
        int result = 0;
        while (n > 0) {
            result += Math.pow(n % 10, 2);
            n = n / 10;
        }
        return result;
    }
}