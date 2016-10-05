/**
 * 
 * 130. Surrounded Regions
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
 * 
 * 
 * 
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
*/

// s3: use union find
// O(m * n), O(m * n)


public class Solution {
    
    Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
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
        
        // first traverse, put element and itself
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    hashMap.put(change(i, j, board), change(i, j, board));
                }
            }
        }
        
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        
        // second traverse, union adjacent elements
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if (isValid(nx, ny, board)) {
                            int index1 = i * n + j;
                            int index2 = nx * n + ny;
                            if (find(index1) != find(index2)) {
                                union(index1, index2);
                            }
                        }
                    }
                }
            }
        }
        
        // use hashSet to store the elements in the 4 sides
        Set<Integer> hashSet = new HashSet<Integer>();
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                hashSet.add(find(i * n));
            }
            if (board[i][n - 1] == 'O') {
                hashSet.add(find(i * n + n - 1));
            }
        }
        
        for (int i = 1; i < n - 1; i++) {
            if (board[0][i] == 'O') {
                hashSet.add(find(i));
            }
            if (board[m - 1][i] == 'O') {
                hashSet.add(find((m - 1) * n + i));
            }
        }        
        
        // third traverse, change 'O' to 'X'
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O' && !hashSet.contains(find(i * n + j))) {
                    board[i][j] = 'X';
                }
            }
        }
        
    }
    
    public boolean isValid(int x, int y, char[][] board) {
        int m = board.length;
        int n = board[0].length;
        if (x >= 0 && x < m && y >= 0 && y < n && board[x][y] == 'O') {
            return true;
        }
        return false;
    }
    
    public int change(int x, int y, char[][] board) {
        int m = board.length;
        int n = board[0].length;
        return x * n + y;
    }
    
    public int find(int x) {
        int parent = x;
        while (parent != hashMap.get(parent)) {
            parent = hashMap.get(parent);
        }
        int next;
        while (x != hashMap.get(x)) {
            next = hashMap.get(x);
            hashMap.put(x, parent);
            x = next;
        }
        return parent;
    }
    
    public void union(int x, int y) {
        int parentX = hashMap.get(x);
        int parentY = hashMap.get(y);
        if (parentX != parentY) {
            hashMap.put(parentX, parentY);
        }
    }
}
