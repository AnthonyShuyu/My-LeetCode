/**
 * 
 * 378. Kth Smallest Element in a Sorted Matrix
 * 
 * 
 */

// s1: Arrays.sort() method
// O(n^2), O(n^2)
public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        // corner case
        if (matrix == null || matrix.length == 0) {
            return -1;
        }
        if (matrix[0] == null || matrix[0].length == 0) {
            return -1;
        }
        
        int n = matrix.length;
        int[] array = new int[n * n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                array[n * i + j] = matrix[i][j];
            }
        }
        Arrays.sort(array);
        return array[k - 1];
    }
}



/*

    Queue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
        @Override
		public int compare(int n1, int n2) {
			return n2 - n1;
		}
	});
	
*/	