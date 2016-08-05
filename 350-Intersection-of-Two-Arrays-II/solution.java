/**
 * 350. Intersection of Two Arrays II
 * Given two arrays, write a function to compute their intersection.
 * 
 */

// brute force
// O(n^2), O(n)

/*
public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        // corner case
        int[] result = new int[0];
        
        if (nums1 == null || nums1.length == 0) {
            return result;
        }
        if (nums2 == null || nums2.length == 0) {
            return result;
        }
        
        Set<Integer> hashSet = new HashSet<Integer>();
        List<Integer> arrayList = new ArrayList<Integer>();
        for (int i = 0; i < nums1.length; i++) {
            int num = nums1[i];
            for (int j = 0; j < nums2.length; j++) {
                if (num == nums2[j]) {
                    if (!hashSet.contains(j)) {
                        hashSet.add(j);
                        arrayList.add(num);
                        break;
                    }
                }
            }
        }
        // Integer[] result = new Integer[arrayList.size()];
        // return arrayList.toArray(result);
        result = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            result[i] = arrayList.get(i);
        }
        return result;
    }
}
*/


// s2: sort array and use binary search
// O(nlogn), O(n)
// to be continued

/*
public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        // corner case
        int[] result = new int[0];
        if (nums1 == null || nums1.length == 0) {
            return result;
        }
        if (nums2 == null || nums2.length == 0) {
            return result;
        }
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        
        
    }
    
    // binary search
    public int findNum(int n, int nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] )
            
        }
        
    }
}
*/


public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        // corner case
        int[] result = new int[0];
        if (nums1 == null || nums1.length == 0) {
            return result;
        }
        if (nums2 == null || nums2.length == 0) {
            return result;
        }
        // store the nums1 to the hashMap, key and value are num and the occurance of num
        
        Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums1.length; i++) {
            if (hashMap.containsKey(nums1[i])) {
                hashMap.put(nums1[i], hashMap.get(nums1[i]) + 1);
            } else {
                hashMap.put(nums1[i], 1);
            }
        }
        List<Integer> arrayList = new ArrayList<Integer>();
        for (int i = 0; i < nums2.length; i++) {
            if (hashMap.containsKey(nums2[i]) && hashMap.get(nums2[i]) > 0) {
                arrayList.add(nums2[i]);
                hashMap.put(nums2[i], hashMap.get(nums2[i]) - 1);
            }
        }
        result = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            result[i] = arrayList.get(i);
        } 
        return result;
    }
}