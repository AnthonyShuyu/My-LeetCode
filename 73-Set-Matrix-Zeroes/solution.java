/**
 * 73. Set Matrix Zeroes
 * 
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
 * 
 */
 
 
// s1: brute force, use 2 hashSets to store the row index and column index which has the 0
// O(n^2), O(n)

public class Solution {
    public void setZeroes(int[][] matrix) {
        // corner case
        if (matrix == null || matrix.length == 0) {
            return;
        }
        if (matrix[0] == null || matrix[0].length == 0) {
            return;
        }
        Set<Integer> rowSet = new HashSet<Integer>();
        Set<Integer> columnSet = new HashSet<Integer>();
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == 0) {
                    rowSet.add(i);
                    columnSet.add(j);
                }
            }
        }
        for (int i = 0; i < rowSet.size(); i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[rowSet.get(i)][j] = 0;
            }
        }        
        
        for (int i = 0; i < columnSet.size(); i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[j][columnSet.get(i)] = 0;
            }
        }
    }
}