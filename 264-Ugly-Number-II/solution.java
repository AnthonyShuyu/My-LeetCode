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
        Queue<Integer> queue = new PriorityQueue<Integer>();
        Set<Integer> hashSet = new HashSet<Integer>();
        queue.offer(1);
        int count = 0;
        while (!queue.isEmpty()) {
            int num = queue.poll();
            if (isUgly(num) && !hashSet.contains(num)) {
                count++;
                hashSet.add(num);
            }
            if (count == n) {
                return num;
            }
            queue.offer(num * 2);    
            queue.offer(num * 3);    
            queue.offer(num * 5);    
        }
        return -1;
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