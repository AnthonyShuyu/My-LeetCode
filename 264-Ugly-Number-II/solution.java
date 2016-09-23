/**
 * 264. Ugly Number II
 * 
 * 
 */

// s1: brute force, check from 1, if it is ugly number, add to an arrayList, and stop when the arrayList.size get to n
// O(n), O(n)
// time limit exceeded

/*
public class Solution {
    public int nthUglyNumber(int n) {
        List<Integer> arrayList = new ArrayList<Integer>();
        int num = 1;
        while (arrayList.size() < n) {
            if (isUgly(num)) {
                arrayList.add(num);
            }
            num++;            
        }
        return arrayList.get(arrayList.size() - 1);
    }
    
    public boolean isUgly(int num) {
        // corner case
        if (num <= 0) {
            return false;
        }
        
        while (num % 2 == 0) {
            num /= 2;
        }
        while (num % 3 == 0) {
            num /= 3;
        }
        while (num % 5 == 0) {
            num /= 5;
        }
        return num == 1;
    }
}

*/

// s2: priorityQueue + hashSet
// O(n), O(n)
public class Solution {
    public int nthUglyNumber(int n) {
        Queue<Long> queue = new PriorityQueue<Long>();
        Set<Long> hashSet = new HashSet<Long>();
        queue.offer(1);
        hashSet.add(1);
        int count = 0;
        while (!queue.isEmpty()) {
            int num = queue.poll();
            count++;
            if (count == n) {
                return num;
            }
            if (!hashSet.contains(num * 2)) {
                queue.offer(num * 2);
                hashSet.add(num * 2);
            }
            if (!hashSet.contains(num * 3)) {
                queue.offer(num * 3);
                hashSet.add(num * 3);
            }
            if (!hashSet.contains(num * 5)) {
                queue.offer(num * 5);
                hashSet.add(num * 5);
            }
        }
        return -1;
    }
    
    // public boolean isUgly(int num) {
    //     // corner case
    //     if (num <= 0) {
    //         return false;
    //     }
    //     while (num % 2 == 0) {
    //         num /= 2;
    //     }
    //     while (num % 3 == 0) {
    //         num /= 3;
    //     }
    //     while (num % 5 == 0) {
    //         num /= 5;
    //     }
    //     return num == 1;
    // }
}