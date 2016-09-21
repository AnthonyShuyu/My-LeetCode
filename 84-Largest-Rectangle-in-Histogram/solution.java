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
// failed

/*
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
            
            if (left <= end) {
                area = Math.max(area, countArea(left, end, heights));
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
*/



// s3: two pointers retry
// O(n^2), O(1)
// failed

/*
public class Solution {
    public int largestRectangleArea(int[] heights) {
        // corner case
        if (heights == null || heights.length == 0) {
            return 0;
        }
        
        int start = 0;
        int end = heights.length - 1;
        int max_area = heights[start];
        
        
        while (start <= end) {
            max_area = Math.max(max_area, countArea(start, end, heights));
            if (start + 1 < heights.length && heights[start + 1] > heights[start]) {
                max_area = Math.max(max_area, countArea(start + 1, end, heights));
            }
            start++;
            if (end - 1 >= 0 && heights[end - 1] > heights[end]) {
                max_area = Math.max(max_area, countArea(start, end - 1, heights));
            }
            end--;
        }
        return max_area;
    }
    
    public int countArea(int start, int end, int[] heights) {
        if (start > end) {
            return 0;
        }
        int min_height = heights[start];
        for (int i = start + 1; i <= end; i++) {
            min_height = Math.min(min_height, heights[i]);
        }
        return (end - start + 1) * min_height; 
    }
}
*/


// *s2: use stack to store the increaing heights, to maintain the increasing stack, and find the first left and right ones lower than it
// O(n), O(n)
// tricky

/*
public class Solution {
    public int largestRectangleArea(int[] heights) {
        // corner case
        if (heights == null || heights.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        for (int i = 0; i <= heights.length; i++) {
            int current_height;
            if (i == heights.length) {
                current_height = -1;
            } else {
                current_height = heights[i];
            }
            while (!stack.isEmpty() && current_height <= heights[stack.peek()]) {
                int temp = stack.pop();
                int height = heights[temp];
                int width;
                if (!stack.isEmpty()) {
                    width = i - stack.peek() - 1;
                } else {
                    width = i;
                }
                max = Math.max(max, height * width);
            }
            stack.push(i);
        }
        return max;
    }
}
*/


// s2: stack, retry
// O(n), O(n)
// tricky

/*
public class Solution {
    public int largestRectangleArea(int[] heights) {
        // corner case
        if (heights == null || heights.length == 0) {
            return 0;
        }
        // use a stack to store the increaing height
        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        for (int i = 0; i <= heights.length; i++) {
            int current_height;
            if (i == heights.length) {
                current_height = -1;
            } else {
                current_height = heights[i];
            }
            
            while (!stack.isEmpty() && current_height <= heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width;
                if (stack.isEmpty()) {
                    width = i;
                } else {
                    width = i - stack.peek() - 1;                  
                }
                max = Math.max(max, width * height);
            }
            
            stack.push(i);
        }
        return max;
    }
}

*/


// s2: stack, reretry
// O(n), O(n)
// tricky, to maintain an increasing stack, stack stores the indexes of the heights

public class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        
        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        for (int i = 0; i <= heights.length; i++) {
            int current_height = 0;
            if (i != heights.length) {
                current_height = heights[i];
            }
            
            while (!stack.isEmpty() && current_height <= heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = 0;
                if (stack.isEmpty()) {
                    width = i;
                } else {
                    width = i - stack.peek() - 1;
                }
                max = Math.max(max, height * width);
            }
            stack.push(i);
        }
        return max;
    }    
}




