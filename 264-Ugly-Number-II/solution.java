/**
 * 264. Ugly Number II
 * 2 solutions
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

// s2: priorityQueue + hashSet + DP
// O(nlogn), O(n)

/*
public class Solution {
    public int nthUglyNumber(int n) {
        Queue<Integer> queue = new PriorityQueue<Integer>();
        Set<Integer> hashSet = new HashSet<Integer>();
        queue.offer(1);
        hashSet.add(1);
        int count = 0;
        while (!queue.isEmpty()) {
            int num = queue.poll();
            count++;
            if (count == n) {
                return num;
            }
            if (!hashSet.contains(num * 2) && num <= Integer.MAX_VALUE / 2) {
                queue.offer(num * 2);
                hashSet.add(num * 2);
            }
            if (!hashSet.contains(num * 3) && num <= Integer.MAX_VALUE / 3) {
                queue.offer(num * 3);
                hashSet.add(num * 3);
            }
            if (!hashSet.contains(num * 5) && num <= Integer.MAX_VALUE / 5) {
                queue.offer(num * 5);
                hashSet.add(num * 5);
            }
        }
        return -1;
    }
}
*/

// s2 modified: HashSet + priorityQueue
// O(nlogn), O(n)
// Long a;   int b = a.intValue();

public class Solution {
    public int nthUglyNumber(int n) {
        Queue<Long> queue = new PriorityQueue<Long>();
        Set<Long> hashSet = new HashSet<Long>();
        int count = 0;
        queue.offer(Long.valueOf(1));
        hashSet.add(Long.valueOf(1));
        Long result = Long.valueOf(1);
        int[] nums = new int[]{2, 3, 5};
        while (!queue.isEmpty()) {
            long num = queue.poll();
            count++;
            if (count == n) {
                result = num;
                break;
            }
            for (int i = 0; i < 3; i++) {
                if (!hashSet.contains(num * nums[i])) {
                    queue.offer(num * nums[i]);
                    hashSet.add(num * nums[i]);
                }
            }
        }
        return result.intValue();
    }
}



