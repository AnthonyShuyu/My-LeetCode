/**
 * 84. Largest Rectangle in Histogram
 * 
 * 
 */



// s1: brute force, two level for loops
// O(n^2), O(1)
// time limit exceeded

/*
public class Solution {
    public int largestRectangleArea(int[] heights) {
        // corner case
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int max = 0;
        int min_height = 0;
        for (int i = 0; i < heights.length; i++) {
            min_height = heights[i];
            for (int j = i; j < heights.length; j++) {
                min_height = Math.min(min_height, heights[j]);
                max = Math.max(max, (j - i + 1) * min_height);
            }
        }
        return max;        
    }
}
*/


// s2: two pointers
// O(n^2), O(1)

public class Solution {
    public int largestRectangleArea(int[] heights) {
        // corner case
        if (heights == null || heights.length == 0) {
            return 0;
        }
        
        int start = 0;
        int end = heights.length - 1;
        
        int area = heights[start];
        while (start < end) {
            area = Math.max(area, countArea(start, end, heights));
            System.out.println(area);
            int left = findRightLarger(start, end, heights);

            if (left <= right) {
                area = Math.max(area, countArea(left, right, heights));
            }
            
            int right = findLeftLarger(start, end, heights);
            if (left <= right) {
                area = Math.max(area, countArea(left, right, heights));
            }
            start = left;
            end = right;
            start++;
            end--;
        }
        return area;
    }
    
    public int findRightLarger(int start, int end, int[] heights) {
        for (int i = start + 1; i <= end; i++) {
            if (heights[i] > heights[start]) {
                return i;
            }
        }
        return start;
    }
    
    public int findLeftLarger(int start, int end, int[] heights) {
        for (int i = end - 1; i >= start; i--) {
            if (heights[i] > heights[end]) {
                return i;
            }
        }
        return end;
    } 
    
    public int countArea(int left, int right, int[] heights) {
        int min = heights[left];
        for (int i = left; i <= right; i++) {
            min = Math.min(heights[i], min);
        }
        return (right - left + 1) * min;
    }
}







