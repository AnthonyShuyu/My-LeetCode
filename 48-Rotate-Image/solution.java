/**
 * 48. Rotate Image
 * 2 solutions
 * 
 * You are given an n x n 2D matrix representing an image.
 */

// s1: brute force, find the rule
// O(n^2), O(n^2)

/*
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
*/


// s2: exchange the 4 sides, layer by layer
// O(n^2), O(1)

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
        
        int layer = (n + 1) / 2;
        
        for (int i = 0; i < layer; i++) {
            for (int j = i; j < n - 1 - i; j++) {
                int temp = matrix[i][j];  // save top
                matrix[i][j] = matrix[n - 1 - j][i]; // put left to the top
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];  // put bottom to the left
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i]; // put right to the bottom
                matrix[j][n - 1 - i] = temp; // put the saved top to the right
            }
        }
        return;
    }
}