/**
 * 
 * 11. Container With Most Water
 * 
 * 
 * 
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 * 
 */


// s1: brute force, 
// O(n^2), O(1)
// time limit exceeded


/*
public class Solution {
    public int maxArea(int[] height) {
        // corner case
        if (height == null || height.length == 0) {
            return -1;
        }
        int n = height.length;
        
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int lowest = Math.min(height[i], height[j]);
                max = Math.max(max, lowest * (j - i));
            }
        }
        return max;
    } 
    
    // public int findLowest(int[] height, int i, int j) {
    //     int result = height[i];
    //     for (int k = i + 1; k <= j; k++) {
    //         result = Math.min(height[k], result);
    //     }
    //     return result;
    // }
}
*/

// s2: two pointers
// O(n), O(1)

public class Solution{
    public int maxArea(int[] height) {
        // corner case
        if (height == null || height.length <= 1) {
            return -1;
        }
        int i = 0;
        int j = height.length - 1;
        int result = 0;
        
        while (i < j) {
            int area = Math.min(height[i], height[j]) * (j - i);
            int k = i;
            int l = j;
            while (k < l) {
                if (height[k] <= height[i]) {
                    k++;
                }
            }
            while(k < l) {
                if (height[l] <= height[j]) {
                    l--;
                }
            }
            if (k < l) {
                int left_value = Math.min(height[i],height[l]) * (l - i); 
                int right_value = Math.min(height[j], height[k]) * (j - k);
                result = Math.max(Math.max(Math.max(left_value, right_value), area), result);
            } else {
                result = Math.max(area, result);
            }
            i = k;
            j = l;
        }
        return result;
    }
}