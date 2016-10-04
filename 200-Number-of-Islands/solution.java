/**
 * 
 * 200. Number of Islands
 * 2 solutions
 * 
 * 
 */

// s1: union find, HashMap
// O(n * m), O(1)
// failed

/*
public class Solution {
    
    Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
    public int numIslands(char[][] grid) {
        // corner case
        if (grid == null || grid.length == 0) {
            return 0;
        }
        if (grid[0] == null || grid[0].length == 0) {
            return 0;
        }
        
        int m = grid.length;
        int n = grid[0].length;
        
        // 1st traverse, let element point to itself
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                char c = grid[i][j];
                if (c == '1') {
                    hashMap.put(i * n + j, i * n + j);
                }
            }
        }
        
        // 2st traverse, let element first point to left, then right
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                char c = grid[i][j];
                if (c == '1') {
                    if (i > 0 && grid[i - 1][j] == '1') {
                        hashMap.put(i * n + j, (i - 1) * n + j);
                    }
                    if (j > 0 && grid[i][j - 1] == '1') {
                        hashMap.put(i * n + j, i * n + j - 1);
                    }
                }
            }
        }
        
            // 3rd traverse, union find
    for (int i = 0; i < grid.length; i++) {
        for (int j = 0; j < grid[0].length; j++) {
            if (grid[i][j] == '1') {
                union(i * n + j, hashMap.get(i * n + j));
            }
        }
    }
    
     Set<Integer> hashSet = new HashSet<Integer>();
     for (int value: hashMap.values()) {
        hashSet.add(value);
        }
        return hashSet.size();
    }
    
    // O(1) find
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
*/

// s2: use arrayList to traverse every node
// O(n * m) , O(n * m)
// failed

/*
public class Solution {
    public int numIslands(char[][] grid) {
        // corner case
        if (grid == null || grid.length == 0) {
            return 0;
        }
        if (grid[0] == null || grid[0].length == 0) {
            return 0;
        }
        
    
    }
    
    public List<Integer> getList(int x, int y, char[][] grid) {
        int[] dx = {0, 1};
        int[] dy = {1, 0};
    }
}    
*/

// s3: use bfs
// O(n * m), O(n * m)

public class Solution {
    public int numIslands(char[][] grid) {
        // corner case
        if (grid == null || grid.length == 0) {
            return 0;
        }
        if (grid[0] == null || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        
        Queue<Integer> queue;
        Set<Integer> hashSet = new HashSet<Integer>();
        int count = 0;
        // for (int i = 0; i < m * n; i++) {
        //     if (grid[i / n][i % n] == '1') {
        //         if (!hashSet.contains(i)) {
        //             hashSet.add(i);
        //             result++;
        //             queue = new LinkedList<Integer>();
        //             queue.offer(i);
        //             while (!queue.isEmpty()) {
        //                 int num = queue.poll();
        //                 // check right and down
        //                 if (i / n - 1 >= 0 && grid[i / n - 1][i % n] == '1' && hashSet.contains()) {
        //                     queue.offer();
        //                 }
                        
        //                 if (i % n < grid[0].length && grid[i / n][i % n] == '1') {
        //                     queue.offer();
        //                 }
                        
        //             }
        //         }
        //     }
        // }
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    if (!hashSet.contains(change(i, j, grid))) {
                        hashSet.add(change(i, j, grid));
                        queue = new LinkedList<Integer>();
                        count++;
                        queue.offer(change(i, j , grid));
                        while (!queue.isEmpty()) {
                            int num = queue.poll();
                            // row
                            int row = num / n;
                            int col = num % n;
                            for (int k = 0; k < dx.length; k++) {
                                int drow = row + dx[k];
                                int dcol = col + dy[k];
                                if (drow < 0 || drow >= m || dcol < 0 || dcol >= n) {
                                    continue;
                                }
                                if (grid[drow][dcol] == '1' && !hashSet.contains(change(drow, dcol, grid))) {
                                    hashSet.add(change(drow, dcol, grid));
                                    queue.offer(change(drow, dcol, grid));
                                }
                            }
                        }
                    }
                }
            }
        }
        
        return count;
     }
    
    
    public int change(int x, int y, char[][] grid) {
        return x * grid[0].length + y;
    }
}

// s4: use DFS
// O(m * n), O(1)

/*
public class Solution {
    public int numIslands(char[][] grid) {
        // corner case
        if (grid == null || grid.length == 0) {
            return 0;
        }
        if (grid[0] == null || grid[0].length == 0) {
            return 0;
        }
        
        int m = grid.length;
        int n = grid[0].length;
        
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    result++;
                    dfs(i, j, grid);
                }
            }
        }
        return result;
    }
    
    // use dfs to traverse, and change '1' to '0'
    public void dfs(int x, int y, char[][] grid) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
            return;
        }
        
        if (grid[x][y] == '1') {
            grid[x][y] = '0';
            dfs(x - 1, y, grid);
            dfs(x + 1, y, grid);
            dfs(x, y - 1, grid);
            dfs(x, y + 1, grid);
        }
        
    }
}
*/