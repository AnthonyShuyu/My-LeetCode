/**
 * 274. H-Index
 * 
 */


// s1: HashMap
// O(n), O(n)

public class Solution {
    public int hIndex(int[] citations) {
        // corner case
        if (citations == null || citations.length == 0) {
            return -1;
        }
        
        Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < citations.length; i++) {
            int n = citations[i];
            if (hashMap.contains(n)) {
                hashMap.put(n, hashMap.get(n) + 1);
            } else {
                hashMap.put(n, 1);
            }
        }
        
        Set<Integer> hashSet = new HashSet<Integer>();
        for (int i = 0; i < citations.length; i++) {
            hashSet.add(citations[i]);
        }
        
        int[] nums = new int[hashSet.size()];
        for (int i = 0; i < hashSet.size(); i++) {
            nums[i] = getCount(hashMap, hashSet.get(i));
        }
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        return max;
    }
    
    public int getCount(Map<Integer, Integer> hashMap, int n) {
        int count = 0;
        for (Map.Entry<Integer, Integer> entry: hashMap.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            if (key >= n) {
                count += value;
            }
        }
        if (n == count) {
            return n;
        } else {
            return 0;
        }
    }
}