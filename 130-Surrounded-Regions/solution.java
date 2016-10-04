/**
 * 
 * 130. Surrounded Regions
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
 * 
 * 
 * 
 */

// s1: dfs
// O(n * m), O(n * m)

public class Solution {
    Set<Integer> hashSet = new HashSet<Integer>();
    public void solve(char[][] board) {
        // corner case
        if (board == null || board.length == 0) {
            return;
        }
        if (board[0] == null || board[0].length == 0) {
            return;
        }
        int m = board.length;
        int n = board[0].length;
        
        char[][] map = new char[m][n];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                map[i][j] = board[i][j];
            }
        }
        
        
        // do dfs check
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O' && !hashSet.contains(i * n + j)) {
                    if (dfsCheck(i, j, map)) {
                        dfs(i, j, board);
                    }                
                }
            }
        }
    }
    
    public boolean dfsCheck(int i, int j, char[][] map) {
        int m = map.length;
        int n = map[0].length;
        if (map[i][j] == 'O') {
            hashSet.add(i * n + j);
        }
        
        if (map[i][j] == 'O' && (i == 0 || i == m - 1 || j == 0 || j == n - 1)) {
            return false;
        }
        if (map[i][j] == 'O') {
            map[i][j] = 'X';
            return dfsCheck(i - 1, j, map) && dfsCheck(i, j + 1, map) && dfsCheck(i + 1, j, map) && dfsCheck(i, j - 1, map);
        } else {
            return true;
        }
    }
    
    public void dfs(int i, int j, char[][] board) {
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return;
        }
        
        if (board[i][j] == 'O') {
            board[i][j] = 'X';
        dfs(i - 1, j, board);
        dfs(i + 1, j, board);
        dfs(i, j - 1, board);
        dfs(i, j + 1, board);
        }
    }
}