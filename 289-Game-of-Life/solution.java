/**
 * 289. Game of Life
 * 
 * 
 */


// s1: brute force
// O(m * n)

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
    }
        
    public int countLiveCells(int x, int y, int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int count = 0;
        if (x - 1 >= 0 && y - 1 >= 0 && board[x - 1][y - 1] == 1) {
            count++;
        }
        if (x - 1 >= 0 && board[x - 1][y] == 1) {
            count++;
        }
        if (x - 1 >= 0 && y + 1 <= m - 1 && board[x - 1][y + 1] == 1) {
            count++;
        }
        if (y - 1 >= 0 && board[x][y - 1] == 1) {
            count++;
        }
        if (y + 1 <= m - 1 && board[x][y + 1] == 1) {
            count++;
        }
        if (x + 1 <= n - 1 && y + 1 <= m - 1 && board[x + 1][y + 1] == 1) {
            count++;
        }
        if (x + 1 <= n - 1 && board[x + 1][y] == 1) {
            count++;
        }
        if (x + 1 <= n - 1 && y - 1 >= 0 && board[x + 1][y - 1] == 1)) {
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