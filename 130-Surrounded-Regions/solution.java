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
// Stack overflow error

/*
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
        int m = board.length;
        int n = board[0].length;
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
*/

// s1: dfs again
// O(m * n), O(m * n)
// tricky, from the edges 'O', change all the adjacent 'O' to 'D', then change back at last
// stack overflow error

/*
public class Solution {
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
        
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                dfs(i, 0, board);
            }
            if (board[i][n - 1] == 'O') {
                dfs(i, n - 1, board);
            }
        }
        
        for (int i = 1; i < n - 1; i++) {
            if (board[0][i] == 'O') {
                dfs(0, i, board);
            }
            if (board[m - 1][i] == 'O') {
                dfs(m - 1, i, board);
            }
        }        
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }
    
    public void dfs(int x, int y, char[][] board) {
        int m = board.length;
        int n = board[0].length;
        if (x >= 0 && x < m && y >= 0 && y < n && board[x][y] == 'O') {
            board[x][y] = 'A';
            dfs(x - 1, y, board);
            dfs(x + 1, y, board);
            dfs(x, y + 1, board);
            dfs(x, y - 1, board);
        }
    }
}    
*/

// s2: bfs, since use dfs will get Stack Overflow error
// O(m * n), O(m * n)

public class Solution {
    public void solve(char[][] board) {
        // corner case
        if (board == null || board.length == 0) {
            return;
        }
        if (board[0] == null || board[0].length == 0) {
            return;
        }
    }
    
        int m = board.length;
        int n = board[0].length;
        
        Queue<Integer> queue = new LinkedList<Integer>();
        
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                queue.offer(change(i, 0, board));
            }
            if (board[i][n - 1] == 'O') {
                queue.offer(change(i, n - 1, board));
            }
        }
        
        for (int i = 1; i < n - 1; i++) {
            if (board[0][i] == 'O') {
                queue.offer(change(0, i , board));
            }
            if (board[m - 1][i] == 'O') {
                queue.offer(change(m - 1, i, board));
            }
        }
        
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        
        
        while (!queue.isEmpty()) {
            int num = queue.poll();
            int x = num / n;
            int y = num % n;
            if (board[x][y] == 'O') {
                board[x][y] = 'A';
                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if (valid(nx, ny, board)) {
                        queue.offer(change(nx, ny, board));
                    }                
                }
            }
        }
        
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
        
    }
    
    public int change(int x, int y, char[][] board) {
        int n = board[0].length;
        return x * n + y;
    }
    
    public boolean valid(int x, int y, char[][] board) {
        int m = board.length;
        int n = board[0].length;
        if (x >= 0 && x < m && y >= 0 && y < n && board[x][y] == 'O') {
            return true;
        }
        return false;
    }
}