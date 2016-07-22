/**
 * 289. Game of Life
 * 2 solutions
 * 
 * 
 * 
 * when you want O(1) space, think about bit operation
 *  
 */


// s1: brute force, use another array
// O(m * n), O(m * n)


/*
public class Solution {
        public void gameOfLife(int[][] board) {
        // corner case
        if (board == null || board.length == 0) {
            return;
        }
        if (board[0] == null || board[0].length == 0) {
            return;
        }
        
        int[][] newboard = new int[board.length][board[0].length];
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                newboard[i][j] = nextGeneration(board[i][j], countLiveCells(i, j, board));
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = newboard[i][j];
            }
        }
        
        
    }
        
    public int countLiveCells(int x, int y, int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int count = 0;
        if (x - 1 >= 0 && y - 1 >= 0 && board[x - 1][y - 1] == 1) {
            count++;
        }
        if (y - 1 >= 0 && board[x][y - 1] == 1) {
            count++;
        }
        if (x + 1 <= m - 1 && y - 1 >= 0 && board[x + 1][y - 1] == 1) {
            count++;
        }
        if (x - 1 >= 0 && board[x - 1][y] == 1) {
            count++;
        }
        if (x + 1 <= m - 1 && board[x + 1][y] == 1) {
            count++;
        }
        if (x - 1 >= 0 && y + 1 <= n - 1&& board[x - 1][y + 1] == 1) {
            count++;
        }
        if (y + 1 <= n - 1 && board[x][y + 1] == 1) {
            count++;
        }
        if (x + 1 <= m - 1 && y + 1 <= n - 1 && board[x + 1][y + 1] == 1) {
            count++;   
        }
        return count;
    }
    
    public int nextGeneration(int state, int count) {
        if (state == 1 && count < 2) {
            return 0;
        }
        if (state == 1 && (count == 2 || count == 3)) {
            return 1;
        }
        if (state == 1 && count > 3) {
            return 0;
        }
        if (state == 0 && count == 3) {
            return 1;
        }
        return state;        
    }
}
*/


// s2: To do it in place, use the bit operation, the higher bit stores the next generation
// O(m * n), O(1)
// tricky

/*
public class Solution {
    public void gameOfLife(int[][] board) {
        // corner case
        if (board == null || board.length == 0) {
            return;
        }
        if (board[0] == null || board[0].length == 0) {
            return;
        }
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = nextGeneration(board[i][j], countLiveCells(i, j, board));
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = board[i][j] >> 1;
            }
        }
        
        
    }
        
    public int countLiveCells(int x, int y, int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int count = 0;
        if (x - 1 >= 0 && y - 1 >= 0 && (board[x - 1][y - 1] & 1) == 1) {
            count++;
        }
        if (y - 1 >= 0 && (board[x][y - 1] & 1) == 1) {
            count++;
        }
        if (x + 1 <= m - 1 && y - 1 >= 0 && (board[x + 1][y - 1] & 1) == 1) {
            count++;
        }
        if (x - 1 >= 0 && (board[x - 1][y] & 1) == 1) {
            count++;
        }
        if (x + 1 <= m - 1 && (board[x + 1][y] & 1) == 1) {
            count++;
        }
        if (x - 1 >= 0 && y + 1 <= n - 1&& (board[x - 1][y + 1] & 1) == 1) {
            count++;
        }
        if (y + 1 <= n - 1 && (board[x][y + 1] & 1) == 1) {
            count++;
        }
        if (x + 1 <= m - 1 && y + 1 <= n - 1 && (board[x + 1][y + 1] & 1) == 1) {
            count++;   
        }
        return count;
    }
    
    public int nextGeneration(int state, int count) {
        if (state == 1 && count < 2) {
            return state & 1;
        }
        if (state == 1 && (count == 2 || count == 3)) {
            return state | 2;
        }
        if (state == 1 && count > 3) {
            return state & 1;
        }
        if (state == 0 && count == 3) {
            return state | 2;
        }
        return state;        
    }
}
*/


// *s2: simplied s2, use bit operation
// Because we need to solve the problem in place, we can use the higher bit to record the next state. And at the end, shift right a bit to get the next state for each cell.


public class Solution {
    public void gameOfLife(int[][] board) {
        // corner case
        if (board == null || board.length == 0) {
            return;
        }
        if (board[0] == null || board[0].length == 0) {
            return;
        }
        int m = board.length;
        int n = board[0].length;
        
        int[] xArray = {0, -1, -1, -1, 0, 1, 1, 1};
        int[] yArray = {-1, -1, 0, 1, 1, 1, 0, -1};
        
        for(int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int count = 0;
                for (int k = 0; k < 8; k++) {
                    int x = i + xArray[k];
                    int y = j + yArray[k];
                    if (x >= 0 && y >= 0 && x < m && y < n && (board[x][y] & 1) == 1 ) {
                        count += 1;
                    }
                }
                if (count < 2 && board[i][j] == 1) {
                    board[i][j] &= 1;
                }
                if ((count == 2 || count == 3) && board[i][j] == 1) {
                    board[i][j] |= 2;
                }
                if (count >3 && board[i][j] == 1) {
                    board[i][j] &= 1;
                }
                if (count == 3 && board[i][j] == 0) {
                    board[i][j] |= 2;
                }
            }
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = board[i][j] >> 1;
            }
        }
        
    }
}