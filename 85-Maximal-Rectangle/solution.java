/**
 * 
 * 85. Maximal Rectangle
 * 
 * 
 */

// s1: brute force
// O(n^3), O(1)
// time limit exceeded

/*
public class Solution {
    public int maximalRectangle(char[][] matrix) {
        // corner case
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        if (matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        // row is num / n;
        // column is num % n;
        
        boolean isRectangle = true;
        int max = 0;
        
        for (int i = 0; i < m * n; i++) {
            System.out.println("i = " + i);
            for (int j = i; j < m * n ; j++) {
                System.out.println("j = " + j);
                if (j % n < i % n) {
                    continue;
                }
                for (int k = i; k <= j; k++) {
                    if (k % n < i % n || k % n > j % n) {
                        continue;
                    }
                    if (matrix[k / n][k % n] == '0') {
                        isRectangle = false;
                        break;
                    }
                }
                if (isRectangle) {
                    max = Math.max(max, (j / n - i / n + 1) * (j % n - i % n + 1));
                } else {
                    isRectangle = true;
                }
            } 
        }
        
        return max;
    }
}
*/



// s2: use Stack, maintain a increasing Stack
// O(n), O(n)
// failed, you need to do some tranfermation

/*
public class Solution {
    public int maximalRectangle(char[][] matrix) {
        // corner case
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        if (matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        List<Integer> arrayList = new ArrayList<Integer>();
        
        for (int i = 0; i <= m; i++) {
            int current_height = 0;
            if (i != m) {
                current_height = getHeight(i, matrix);
            }
            while (!stack.isEmpty() && current_height <= getHeight(stack.peek(), matrix)) {
                int index = stack.pop();
                int width = 0;
                if (stack.isEmpty()) {
                    width = i;
                } else {
                    width = i - stack.peek() - 1;
                }
                System.out.println("index is: " + index + "i is : " + i);
                int height = countHeight(index, i - 1, matrix);
                System.out.println("i is: " + i + "height is" + height + "width is " + width);
                max = Math.max(max, width * height);
            }
            stack.push(i);
        }
        return max;
    }
    
    public int countHeight(int start, int end, char[][] matrix) {
        if (start == end) {
            return getHeight(start, matrix);
        }
        int result = 0;
        int max_height = 0;
        boolean allOne = true;
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = start; j <= end; j++) {
                if (matrix[j][i] == '0') {
                    allOne = false;
                    max_height = Math.max(max_height, result);
                    result = 0;
                    break;
                }
            }
            if (allOne) {
                result++;
            } else {
                allOne = true;
            }
        }
        max_height = Math.max(max_height, result);
        System.out.println("start is : " + start + "end is :" + end + "result is :" + result);
        return max_height;
    }
    
    public int getHeight(int row, char[][] matrix) {
        int result = 0;
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[row][i] == '1') {
                result++;
            }
        }

        return result;
    }
}
*/


// *s2: use Stack, maintain an increasing Stack
// O(n^2), O(n^2)


public class Solution {
    public int maximalRectangle(char[][] matrix) {
        // corner case
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        if (matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }
        
        // create a 2D matrix to represent the heighs based on the index
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] heights = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    heights[i][j] = (matrix[i][j] == '1' ? 1 : 0);
                } else {
                    heights[i][j] = (matrix[i][j] == '1' ? heights[i - 1][j] + 1 : 0); 
                }
            }
        }
        
        int max = 0;
        for (int i = 0; i < m; i++) {
            Stack<Integer> stack = new Stack<Integer>();
            for (int j = 0; j <= n; j++) {
                int current_height = 0;
                if (j != n) {
                    current_height = heights[i][j];
                }
                while (!stack.isEmpty() && current_height <= heights[i][stack.peek()]) {
                    int height = heights[i][stack.pop()];
                    int width = 0;
                    if (stack.isEmpty()) {
                        width = j;
                    } else {
                        width = j - stack.peek() - 1;
                    }
                    System.out.println("height is : " + height + "width is : " + width);
                    max = Math.max(max, height * width);
                }                
                stack.push(j);
            }
        }
        return max;
        
    }
}