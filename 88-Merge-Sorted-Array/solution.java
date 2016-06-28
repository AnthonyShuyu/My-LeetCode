/**
 * Merge Sorted Array
 * 3 methods
 */


// s1: use Arrays.sort()
// O(nlogn), O(n)

/*
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1 == null) {
            return;
        }
        if (nums2 == null) {
            return;
        }
        
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }
        Arrays.sort(nums1);  
    }
}
*/
// the m and n are not equals to the length of nums1 and nums2


// s2: Compare the end of two arrays instead of comparing the beginning of two arrays because it is demanded to merge
// arrayinto array1, so if comparet the first , will cost T = O(m * n)
// O(n), O(1)

public class Solution{
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1 == null || nums2 == null) {
            return;
        }
        int i = m - 1;
        int j = n - 1;
        int index = m + n - 1;
        
        while (i >= 0 && j >= 0) {
            if (nums1[i] < nums2[j]) {
                nums1[index] = nums2[j];
                j--;
            } else {
                nums1[index] = nums1[i];
                i--;
            }
            index--;
        }
        while (i >= 0) {
            nums1[index] = nums1[i];
            i--;
            index--;
        }
        while (j >= 0) {
            nums1[index] = nums2[j];
            j--;
            index--;
        }
        
                
    }
}





// s3: compare the start elements in 2 arrays each time one by one, use the new array, copy back to nums1 in the end
// O(n), O(n)

/*
public class Solution{
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1 == null) {
            return;
        }
        if (nums2 == null) {
            return;
        }
        int length1 = m;
        int length2 = n;
        
        int[] result = new int[m + n];
        int index = 0;
        while (m > 0 && n > 0) {
            if (nums1[length1 - m] <= nums2[length2 - n]) {
                result[index] = nums1[length1 - m];
                m--;
            } else {
                result[index] = nums2[length2 - n];
                n--;
            }
            index++;
        }
        while (m > 0) {
            result[index] = nums1[length1 - m];
            m--;
            index++;
        }
        while (n > 0) {
            result[index] = nums2[length2 - n];
            n--;
            index++;
        }        
        
        for (int i = 0; i < m + n; i++) {
            nums1[i] = result[i];
        }
    }
}

*/
