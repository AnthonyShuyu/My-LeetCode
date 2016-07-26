/**
 * 54. Spiral Matrix
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 * 
 */

// s1: brute force, one circle after one circle, but stop when only one row or one column left
// O(n^2), O(n)
// tricky

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        // corner case
        if (matrix == null || matrix.length == 0) {
            return result;
        }
        if (matrix[0] == null || matrix[0].length == 0) {
            return result;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        
        int min = Math.min(m, n);
        int circle = (min + 1) / 2;
        for (int k = 0; k < circle; k++) {
            for (int j = k; j < n - k; j++) {
                result.add(matrix[k][j]);
            }
            for (int i = k + 1; i < m - k; i++) {
                result.add(matrix[i][n - 1 - k]);
            }
            // if one row or one column left, break
            if (m - k * 2 == 1 || n - k * 2 == 1) {
                break;
            }
            for (int j = n - 2 - k; j >= k; j--) {
                result.add(matrix[m - 1 - k][j]);
            }
            for (int i = m - 2 - k; i >= k + 1; i--) {
                result.add(matrix[i][k]);
            }
        }
        return result;    
    }
}










// s1: brute force, one loop after one loop
// O(n^2), O(n)
// failed

/*
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        // corner case
        if (matrix == null || matrix.length == 0) {
            return result;
        }
        if (matrix[0] == null || matrix[0].length == 0) {
            return result;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        int min = Math.min(m, n);
        int circle = (min + 1)/ 2 ;
        // if (m == 1 && n == 1) {
        //     result.add(matrix[0][0]);
        // }
        if (m == 1) {
            for (int i = 0; i < n; i++) {
                result.add(matrix[0][i]);
            }
            return result;
        }
        if (n == 1) {
            for (int i = 0; i < m; i++) {
                result.add(matrix[i][0]);
            }
            return result;
        }
        
        
        for (int k = 0; k < circle; k++) {
            for (int j = k; j < n - 1 - k; j++) {
                result.add(matrix[k][j]);
            }
            for (int i = k; i < m - 1 - k; i++) {
                result.add(matrix[i][n - 1 - k]);
            }
            for (int j = n - 1 - k; j > k; j--) {
                result.add(matrix[m - 1 - k][j]);
            }
            for (int i = m - 1 - k; i > k; i--) {
                result.add(matrix[i][k]);
            }
        }
        return result;
        
    }
}
*/