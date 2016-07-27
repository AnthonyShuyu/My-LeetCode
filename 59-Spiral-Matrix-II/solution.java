/**
 * 59. Spiral Matrix II
 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 * 
 */

// s1: brute force, assign the value to the array one circle after one circle
// O(n^2), O(n)

public class Solution {
    public int[][] generateMatrix(int n) {
        // corner case
        if (n < 0) {
            return null;
        }
        int[][] matrix = new int[n][n];
        int m = n * n;
        
        int circle = (n + 1) / 2;
        int num = 1;
        
        for (int k = 0; k < circle; k++) {
            for (int i = k; i < n - k; i++) {
                matrix[k][i] = num;
                num++;
            }
            for (int j = k + 1; j < n - k; j++) {
                matrix[j][n - 1 - k] = num;
                num++;
            }
            
            for (int i = n - 2 - k; i >= k; i--) {
                matrix[n - 1 - k][i] = num;
                num++;
            }
            for (int j = n - 2 - k; j >= k + 1; j--) {
                matrix[j][k] = num;
                num++;
            }
        }
        
        return matrix;
        
        
    }
}