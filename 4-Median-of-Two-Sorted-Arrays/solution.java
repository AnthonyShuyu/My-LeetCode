/**
 * 4. Median of Two Sorted Arrays
 * 3 solutions
 */

// s1: Arrays.sort() to get a new array
// O(nlogn), O(n)

public class Solution{
    public double findMedianSortedArray(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return -1;
        }
        int[] nums3 = new int[nums1.length + nums2.length];
        for (int i = 0; i < nums1.length; i++) {
            nums3[i] = nums1[i];
        }
        
        for (int i = 0; i < nums2.length; i++) {
            nums3[nums1.length + i] = nums2[i];
        }
        
        Arrays.sort(nums3);
        return ((double) nums3[nums3.length / 2] + (double) nums3[(nums3.length - 1) / 2]) / 2;
    }
}











// s2: use 88. Merge Sorted Array
// O(n), O(n)

/*
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return -1;
        }
        
        int m = nums1.length;
        int n = nums2.length;
        int[] nums3 = new int[m + n];
        int index = 0;
        while (m > 0 && n > 0) {
            if (nums1[nums1.length - m] <= nums2[nums2.length - n]) {
                nums3[index] = nums1[nums1.length - m];
                m--;
            } else {
                nums3[index] = nums2[nums2.length - n];
                n--;
            }
            index++;
        }
        
        while (m > 0) {
            nums3[index] = nums1[nums1.length - m];
            m--;
            index++;
        }
        
        while (n > 0) {
            nums3[index] = nums2[nums2.length - n];
            n--;
            index++;
        }
        
        double num1 = nums3[nums3.length / 2];
        double num2 = nums3[(nums3.length - 1) / 2];
        return (num1 + num2) / 2;
    }
}
*/


// 