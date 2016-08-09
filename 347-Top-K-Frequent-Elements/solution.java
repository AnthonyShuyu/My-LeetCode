/**
 * 347. Top K Frequent Elements
 * Given a non-empty array of integers, return the k most frequent elements.
 * 
 * 2 solutions
 * 
 */


// s1: HashMap + HashSet
// O(k^2), O(n)

/*
public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        // corner case
        List<Integer> result = new ArrayList<Integer>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        Set<Integer> hashSet = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            hashSet.add(nums[i]);
            if (hashMap.containsKey(nums[i])) {
                hashMap.put(nums[i], hashMap.get(nums[i]) + 1);
            } else {
                hashMap.put(nums[i], 1);
            }
        }
        
        for (int i = 0; i < k; i++) {
            int index = findMax(hashSet, hashMap);
            result.add(index);
            hashMap.remove(index);
        }
        return result;
    }
    
    public int findMax(Set<Integer> hashSet, Map<Integer, Integer> hashMap) {
        int index = 0;
        int max = Integer.MIN_VALUE;
        for (int i : hashSet) {
            if (hashMap.containsKey(i) && hashMap.get(i) > max) {
                max = hashMap.get(i);
                index = i;
            }
        }
        return index;
    }
}
*/


// s2: HashMap + priorityQueue
// O(n), O(n)


public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        // corner case
        List<Integer> result = new ArrayList<Integer>();
        
        if (nums == null || nums.length == 0) {
            return result;
        }
        Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        Queue<Map.Entry<Integer, Integer>> priorityQueue = new PriorityQueue<Map.Entry<Integer, Integer>>(
            new Comparator<Map.Entry<Integer, Integer>>() {
                public int compare(Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2) {
                    return e1.getValue() - e2.getValue();
                }
        });
        
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(nums[i])) {
                hashMap.put(nums[i], hashMap.get(nums[i]) + 1);
            } else {
                hashMap.put(nums[i], 1);
            }
        }
        
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            if (priorityQueue.size() < k) {
                priorityQueue.offer(entry);
            } else {
                if (priorityQueue.peek() < entry.getValue()) {
                    priorityQueue.poll();
                    priorityQueue.offer(entry);
                }
            }
        }
        
        for (Map.Entry<Integer, Integer> entry : priorityQueue) {
            result.add(entry.getKey());
        }
        return result;
    }
}