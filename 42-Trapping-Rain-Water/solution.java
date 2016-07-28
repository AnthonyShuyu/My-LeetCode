/**
 * 42. Trapping Rain Water
 * 
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
For example, 
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 */


// s1: brute force, from left to right, find the first descend, then the first ascend, then the second descend
// O(n^2), O(1)
// failed, too complicated to imagine

/*
public class Solution {
    public int trap(int[] height) {
        // corner case
        if (height == null || height.length <= 2) {
            return 0;
        }
        int n = height.length;
        int index = 0;
        int result = 0;
        while (index < n) {
            int i = index;
            while (i < n - 1) {
                if (height[i + 1] >= height[i]) {
                    i++;
                } else {
                    break;
                }
            }
        }
    }
}
*/

// *s2: two pointers
// O(n^2), O(1)

public class Solution {
    public int trap(int[] height) {
        // corner case
        if (height == null || height.length <= 2) {
            return 0;
        }
        int n = height.length;
        int start = 0;
        int end = n - 1;
        int area = 0;
        while (start < end) {
            if (height[start] <= height[end]) {
                int smaller = height[start];
                while (start < end && height[start] <= smaller) {
                    area += smaller - height[start];
                    start++;
                }
            } else {
                int smaller = height[end];
                while (start < end && height[end] <= smaller) {
                    area += smaller - height[end];
                    end--;
                }
            }
        }
        return area;
    }
}