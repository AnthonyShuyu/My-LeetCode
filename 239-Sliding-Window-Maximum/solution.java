/**
 * 
 * 239. Sliding Window Maximum
 * 
 * 
 * 
 */


// s1: brute force
// O(n * k), O(n * k)

/*
public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // corner case
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        
        int[] result = new int[nums.length - k + 1];
        int[] array = new int[k];
        
        for (int i = 0; i < nums.length - k + 1; i++) {
            // for (int j = 0; j < k; j++) {
            //     array[j] = nums[i + j];
            // }
            result[i] = getMax(nums, i, i + k - 1);            
        }
        return result;
    }
    
    // public int getMax(int[] array) {
    //     int result = array[0];
    //     for (int i = 0; i < array.length; i++) {
    //         result = Math.max(result, array[i]);
    //     }
    //     return result;
    // }
    
    public int getMax(int[] nums, int start, int end) {
        int result = nums[start];
        for (int i = start; i <= end; i++) {
            result = Math.max(result, nums[i]);
        }
        return result;
    }
}
*/

// s2: use maxHeap, and remove() operation
// O(n * k), O(n)

/*
public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // corner case
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        
        int[] result = new int[nums.length - k + 1];
        // int[] array = new int[k];
        Queue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
                @Override
                public int compare(Integer i1, Integer i2) {
                    return i2 - i1;
                }
            });
        
        for (int i = 0; i < k; i++) {
            queue.offer(nums[i]);
        }
        result[0] = queue.peek();
        for (int i = 1; i < nums.length - k + 1; i++) {
            queue.remove(nums[i - 1]);
            queue.offer(nums[i + k - 1]);
            result[i] = queue.peek();
        }
        return result;
    }
}
*/


// s3: TreeMap ? 
// O(nlogk), O(k)
// to be continued



// s4: Deque
// O(n), O(k)
// tricky,  maintain a decreasing (stack) and at the same time can peek() or poll() from the beginning(queue), so use Deque
// monotonic decreasing deque

public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // corner case
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        
        int[] result = new int[nums.length - k + 1];
        Deque<Integer> queue = new LinkedList<Integer>();
        
        for (int i = 0; i < k; i++) {
            int num = nums[i];
            while (!queue.isEmpty()) {
                if (num >= nums[queue.peekLast()]) {
                    queue.removeLast();
                } else {
                    break;
                }
            }
            queue.addLast(i);
        }
        
        result[0] = nums[queue.peekFirst()];
        for (int i = k; i < nums.length; i++) {
            int num = nums[i];
            // if (queue.size() >= k) {
            //     queue.removeFirst();
            // }
            if (i - k == queue.peekFirst()) {
                queue.removeFirst();
            }
            while (!queue.isEmpty()) {
                if (num >= nums[queue.peekLast()]) {
                    queue.removeLast();
                } else {
                    break;
                }
            }
            queue.addLast(i);
            result[i - k + 1] = nums[queue.peekFirst()];
        }
        return result;
    }
}