/**
 * 204. Count Primes
 * Count the number of prime numbers less than a non-negative number, n.
 * 
 */

// s1: brute force
// O(n), O(1)
// time limit exceeded， Last executed input:499979

/*
public class Solution {
    public int countPrimes(int n) {
        // corner case
        if (n <= 1) {
            return 0;
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime(i)) {
                count++;
            }
        }
        return count;
    }
    public boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
*/

// s2: DP
// O(n), O(n)
// time limit exceeded, last executed input: 499979

public class Solution {
    public int countPrimes(int n) {
        // corner case
        if (n <= 1) {
            return 0;
        }
        int[] result = new int[n];
        for (int i = 2; i <= n; i++) {
            if (isPrime(i - 1)) {
                result[i - 1] = result[i - 2] + 1;
            } else {
                result[i - 1] = result[i - 2];
            }
        }
        return result[n - 1];
    }
    
    public boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}