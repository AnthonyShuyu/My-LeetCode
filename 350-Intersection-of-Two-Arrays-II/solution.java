/**
 * 350. Intersection of Two Arrays II
 * Given two arrays, write a function to compute their intersection.
 * 
 */


// brute force
// O(n^2), O(n)

public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        // corner case
        if (nums1 == null || nums1.length == 0) {
            return null;
        }
        if (nums2 == null || nums2.length == 0) {
            return null;
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
                    }
                }
            }
        }
        return arrayList.toArray();
    }
}