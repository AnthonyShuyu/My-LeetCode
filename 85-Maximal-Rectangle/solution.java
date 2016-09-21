/**
 * 
 * 85. Maximal Rectangle
 * 
 * 
 */

// s1: brute force
// O(n^2), O(1)

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
                for (int row = i / n, col = i % n; row <= j / n, col <= j % n; row++, col++) {
                    if (matrix[row][col] == '0') {
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