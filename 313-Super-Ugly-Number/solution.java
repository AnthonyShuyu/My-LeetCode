/**
 * 
 * 313. Super Ugly Number
 * 
 * 
 */


// s1: brute force, check if a number is super ugly number
// O(n), O(1)
// time limit exceeded

/*
public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        // corner case
        if (primes == null || primes.length == 0) {
            return -1;
        }
        
        int num = 1;
        int count = 0;
        int result = -1;
        
        while (count < n) {
            if (isSuperUglyNumber(num, primes)) {
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
*/


// s2: use heap + hashSet
// O(n), O(n)
// time limit exceeded

/*
public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        // corner case
        if (primes == null || primes.length == 0) {
            return -1;
        }
        Queue<Integer> queue = new PriorityQueue<Integer>();
        Set<Integer> hashSet = new HashSet<Integer>();
        
        queue.offer(1);
        hashSet.add(1);
        
        int count = 0;
        int result = 0;
        
    //     while (!queue.isEmpty()) {
    //         int num = queue.poll();
    //         result = num;
    //         count++;
    //         if (count == n) {
    //             break;
    //         }
    //         for (int i = 0; i < primes.length; i++) {
    //             int new_num = num * primes[i];
    //             if (!hashSet.contains(new_num)) {
    //                 queue.offer(new_num);
    //                 hashSet.add(new_num);
    //             }
    //         }
    //     }
    //     return result;
    // }
    
        while (count < n) {
            int num = queue.poll();
            count++;
            result = num;
            for (int i = 0; i < primes.length; i++) {
                int new_num = num * primes[i];
                if (!hashSet.contains(new_num)) {
                    queue.offer(new_num);
                    hashSet.add(new_num);
                }
            }
        }
        return result;
    }
}
*/


// s3: use a array to represent times each primes are used
// O(n^2), O(n)
// tricky

public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        // corner case
        if (primes == null || primes.length == 0) {
            return -1;
        }
        
        int[] times = new int[primes.length];
        int[] nums = new int[n];
        nums[0] = 1;
        
        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            
            for (int j = 0; j < primes.length; j++) {
                min = Math.min(min, nums[times[j]] * primes[j]);
            }
            nums[i] = min;
            
            for (int j = 0; j < primes.length; j++) {
                if (nums[times[j]] * primes[j] == min) {
                    times[j]++;
                }
            }
        }
        return nums[n - 1];       
    }
}