/**
 * 84. Largest Rectangle in Histogram
 * 
 * 
 */



// s1: brute force, two level for loops
// O(n^2), O(n)

public class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return -1;
        }
        int max = 0;
        int min_height = 0;
        for (int i = 0; i < heights.length; i++) {
            min_height = heights[i];
            for (int j = i; j < heights.length; j++) {
                min_height = Math.min(min_height, height[j]);
                max = Math.max(max, (j - i + 1) * min_height);
            }
        }
        return max;        
    }
}








