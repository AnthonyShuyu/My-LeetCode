/**
 * 274. H-Index
 * 
 */


// s1: Array or HashMap, count from the length of citations to 0, how many >= the number
// O(n), O(n)

/*
public class Solution {
    public int hIndex(int[] citations) {
        // corner case
        if (citations == null || citations.length == 0) {
            return 0;
        }
        
        Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < citations.length; i++) {
            int n = citations[i];
            if (hashMap.containsKey(n)) {
                hashMap.put(n, hashMap.get(n) + 1);
            } else {
                hashMap.put(n, 1);
            }
        }
        
        // Set<Integer> hashSet = new HashSet<Integer>();
        // for (int i = 0; i < citations.length; i++) {
        //     hashSet.add(citations[i]);
        // }
        
        // int[] nums = new int[hashSet.size()];
        // // for (int i = 0; i < hashSet.size(); i++) {
        // //     nums[i] = getCount(hashMap, hashSet.get(i));
        // // }
        // int index = 0;
        // for (int i : hashSet) {
        //     nums[index] = getCount(hashMap, i);
        //     index++;
        // }
        
        // int max = 0;
        // for (int i = 0; i < nums.length; i++) {
        //     max = Math.max(max, nums[i]);
        // }
        // return max;
        int result = citations.length;
        while (result > 0) {
            if (isHIndex(result, citations)) {
                break;              
            }
            result--;
        }
        return result;
    }
    
    // public boolean isHIndex(Map<Integer, Integer> hashMap, int n) {
    //     int count = 0;
    //     for (Map.Entry<Integer, Integer> entry: hashMap.entrySet()) {
    //         int key = entry.getKey();
    //         int value = entry.getValue();
    //         if (key >= n) {
    //             count += value;
    //         }
    //     }
    //     if (n <= count) {
    //         return true;
    //     } else {
    //         return false;
    //     }
    // }
    public boolean isHIndex(int n, int[] citations) {
        int count = 0;
        for (int i = 0; i < citations.length; i++) {
            if (citations[i] >= n) {
                count++;
            }
        }
        if (count >= n) {
            return true;
        } else {
            return false;
        }
    }
    
}
*/

// s2: Arrays.sort()
// O(nlogn), O(1)

public class Solution {
    public int hIndex(int[] citations) {
        // corner case
        if (citations == null || citations.length == 0) {
            return 0;
        }
        Arrays.sort(citations);
        int result = 0;
        for (int i = 0; i < citations.length; i++) {
            int smaller = Maht.min(citations[i], citations.length - i);
            result = Math.max(result, smaller);
        }
        return result;
    }
}
