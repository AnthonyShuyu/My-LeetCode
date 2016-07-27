/**
 * 48. Rotate Image
 * You are given an n x n 2D matrix representing an image.
 * 
 */

// s1: brute force, find the rule
// O(n^2), O(n^2)

public class Solution {
    public void rotate(int[][] matrix) {
        // corner case
        if (matrix == null || matrix.length == 0) {
            return;
        }
        if (matrix[0] == null || matrix[0].length == 0) {
            return;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        if (m != n) {
            return;
        }
        
        int[][] temp = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                temp[j][n - i - 1] = matrix[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = temp[i][j];
            }
        }        
        
        
    }
}