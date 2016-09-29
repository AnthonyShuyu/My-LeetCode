/**
 * 
 * 378. Kth Smallest Element in a Sorted Matrix
 * 3 methods
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
// O(n^2logk), O(k)

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
                pq.poll();
                pq.offer(num);
            }
            index++;
        }
        return pq.peek();
    }    
}
*/



// s3*: use minHeap and Hash matrix
// O(klogk), O(n^2)
// tricky

/*
public class Solution {
    
    // implement a new class called Number
    class Number {
        int x;
        int y;
        int val;
        public Number(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }
    
    public int kthSmallest(int[][] matrix, int k) {
        // corner case
        if (matrix == null || matrix.length == 0) {
            return -1;
        }
        
        if (matrix[0] == null || matrix[0].length == 0) {
            return -1;
        }    
        
        // implement a priorityQueue
        Queue<Number> queue = new PriorityQueue<Number>(new Comparator<Number>(){
            @Override
            public int compare(Number n1, Number n2) {
                return n1.val - n2.val;
            }
        });
          
        // direction triky
        int[] dx = {0, 1};
        int[] dy = {1, 0};
           
        // hash matrix
        boolean[][] hash = new boolean[matrix.length][matrix[0].length];
           
       Number head = new Number(0, 0, matrix[0][0]);
       queue.offer(head);
       hash[0][0] = true;
       
       for (int i = 0; i < k - 1; i++) {
           Number num = queue.poll();
           int x = num.x;
           int y = num.y;
           for (int j = 0; j < 2; j++) {
               int nx = x + dx[j];
               int ny = y + dy[j];
               if (isValid(nx, ny, matrix, hash)) {
                   queue.offer(new Number(nx, ny, matrix[nx][ny]));
                   hash[nx][ny] = true;
               }
           }
       }
       return queue.peek().val;
    }
    
    public boolean isValid(int nx, int ny, int[][] matrix, boolean[][] hash) {
        if (nx < matrix.length && ny < matrix[0].length && !hash[nx][ny]) {
            return true;
        }
        return false;
    }
}        
*/

// s3 again, use minHeap and hash matrix
// O(klogk), O(n^2)
// tricky

public class Solution {
    
    class Number{
        int x;
        int y;
        int val;
        public Number(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }
    
    public int kthSmallest(int[][] matrix, int k) {
        // corner case
        if (matrix == null || matrix.length == 0) {
            return -1;
        }
        if (matrix[0] == null || matrix[0].length == 0) {
            return -1;
        }
        Queue<Number> queue = new PriorityQueue<Number>(new Comparator<Number>() {
                @Override
                public int compare(Number n1, Number n2) {
                    return n1.val - n2.val;
                }
            });
        
        boolean[][] hash = new boolean[matrix.length][matrix[0].length];
        queue.offer(new Number(0, 0, matrix[0][0]));
        hash[0][0] = true;
        
        for (int i = 0; i < k - 1; i++) {
            Number num = queue.poll();
            int x = num.x;
            int y = num.y;
            
            int nx1 = x;
            int ny1 = y + 1;
            if (isValid(nx1, ny1, matrix, hash)) {
                queue.offer(new Number(nx1, ny1, matrix[nx1][ny1]));                
                hash[nx1][ny1] = true;
            }
            
            int nx2 = x + 1;
            int ny2 = y;
            if (isValid(nx2, ny2, matrix, hash)) {
                queue.offer(new Number(nx2, ny2, matrix[nx2][ny2]));
                hash[nx2][ny2] = true;
            }
        }
        return queue.peek().val;
        
    }
    
    public boolean isValid(int nx1, int ny1, int[][] matrix, boolean[][] hash) {
        if (nx1 < matrix.length && ny1 < matrix[0].length && !hash[nx1][ny1]) {
            return true;
        }
        return false;
    }
}
