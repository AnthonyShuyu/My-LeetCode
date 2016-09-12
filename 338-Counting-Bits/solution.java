/**
 * 
 * 338. Counting Bits
 * Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.
 * 
 * 
 */


// s1: brute force
// O(n), O(n)

public class Solution {
    public int[] countBits(int num) {
        if (num < 0) {
            return null;
        }
        int[] result = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            result[i] = countBit(i);
        }
        
        return result;
        
    }
    
    public int countBit(int n) {
        int count = 0;
        while (n != 0) {
            if (n % 2 == 1) {
                count++;
            }
            n /= 2;
        }
        return count;
    }
}