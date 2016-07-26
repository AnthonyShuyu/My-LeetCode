/**
 * 54. Spiral Matrix
 * 
 */

// s1: brute force, one loop after one loop
// O(n^2), O(n)

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
        int circle = min / 2;
        if (circle == 0) {
            result.add(matrix[0]);
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