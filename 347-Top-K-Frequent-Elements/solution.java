/**
 * 347. Top K Frequent Elements
 * Given a non-empty array of integers, return the k most frequent elements.
 * 
 */


// s1: HashMap
// O(n), O(n)

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