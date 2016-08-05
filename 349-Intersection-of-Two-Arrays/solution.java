/**
 * 
 * 349. Intersection of Two Arrays
 * Given two arrays, write a function to compute their intersection.
 * 
 * 
 */

// s1: HashSet
// O(n), O(n)
// follow up, to be continued

public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
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
            if (!hashSet.contains(nums1[i])) {
                hashSet.add(nums1[i]);
            }
        }
        for (int i = 0; i < nums2.length; i++) {
            if (hashSet.contains(nums2[i])) {
                if (!arrayList.contains(nums2[i])) {
                    arrayList.add(nums2[i]);
                }
            }
        }
        result = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            result[i] = arrayList.get(i);
        }
        return result;
    }
}