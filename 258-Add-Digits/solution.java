/**
 * 258. Add Digits
 * 
 * 
 */


// s1: brute force
// O(n), O(n)
public class Solution {
    public int addDigits(int num) {
        // corner case
        if (num < 0) {
            return -1;
        }
        
        int n = num;
        while (!checkOneDigit(n)) {
            int newNum = 0;
            while (n != 0) {
                newNum += n % 10;
                n /= 10;
            }
            n = newNum;
        }
        return n;
    }
    
    public boolean checkOneDigit(int num) {
        if (num / 10 == 0) {
            return true;
        } else {
            return false;
        }
    }
}