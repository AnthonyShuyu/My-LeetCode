/**
 * 204. Count Primes
 * Count the number of prime numbers less than a non-negative number, n.
 * 
 */

// s1: brute force
// O(n^2), O(1)
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
// O(n^2), O(n)
// time limit exceeded, last executed input: 499979

/*
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
*/


// s3: optimize to Math.sqrt(n), 
   // Loop's ending condition is i * i <= num instead of i <= sqrt(num)
   // to avoid repeatedly calling an expensive function sqrt().

// O(n^(2/3)), O(1)
// time limit exceeded, 1500000

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
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
*/


// s4: use hashSet to store the primes, and for loop to check each prime is or not a factor of n

public class Solution {
    public int countPrimes(int n) {
        // corner case
        if (n <= 2) {
            return 0;
        }
        
        Set<Integer> hashSet = new HashSet<Integer>();
        hashSet.add(2);
        boolean isPrime;
        for (int i = 3; i <= n- 1; i++) {
            isPrime = true;
            for (int num : hashSet) {
                if (i % num == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                hashSet.add(i);
            }
        }
        return hashSet.size();
    }
}