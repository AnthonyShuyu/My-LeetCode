/**
 * 
 * 313. Super Ugly Number
 * 
 * 
 */


// s1: brute force, check if a number is super ugly number
// O(n), O(1)

public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        // corner case
        if (primes == null || prime.length == 0) {
            return -1;
        }
        
        int num = 1;
        int count = 0;
        int result = -1;
        
        while (count < n) {
            if (isSuperUglyNumber(num)) {
                count++;
                result = num;
            }
            num++;
        }
                
        return result;
    }
    
    public boolean isSuperUglyNumber(int num, int[] primes) {
        for (int i = 0; i < primes.length; i++) {
            int prime = primes[i];
            while (num % prime == 0) {
                num /= prime;                
            }
        }
        return num == 1;
    }
}