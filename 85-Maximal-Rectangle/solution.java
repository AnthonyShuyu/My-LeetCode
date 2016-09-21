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
            for (int j = i; j < m * n && j % n >= i % n) {
                for (int k = i; k <= j; k++) {
                    if (matrix[k / n][k % n] == '0') {
                        isRectangle = false;
                        break;
                    }
                }
                if (isRectangle) {
                    max = Math.max(max, j - i + 1);
                } else {
                    isRectangle = true;
                    break;
                }
            } 
        }
        
        return max;
    }
}