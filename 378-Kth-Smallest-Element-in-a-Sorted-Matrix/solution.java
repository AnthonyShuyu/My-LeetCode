/**
 * 
 * 378. Kth Smallest Element in a Sorted Matrix
 * 
 * 
 */

// s1: Arrays.sort() method
// O(n^2), O(n^2)

/*
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
*/


// s2: use a maxHeap
// O(n), O(k)

public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        // corner case      
        if (matrix == null || matrix.length == 0) {
            return -1;
        }
        if (matrix[0] == null || matrix[0].length == 0) {
            return -1;
        }
        
        // implement a maxHeap
        Queue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });
        
        int m = matrix.length;
        int n = matrix[0].length;
        int index = 0;
        for (int i = 0; i < k; i++) {
            pq.offer(matrix[index / n][index % n]);
            index++;
        }
        while (index < m * n) {
            int num = matrix[index /n][index % n];
            if (num < pq.peek()) {
                pq.poll;
                pq.offer(num);
            }
            index++;
        }
        return pq.peek();
    }    
}
