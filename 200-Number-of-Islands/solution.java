/**
 * 
 * 200. Number of Islands
 * 
 * 
 * 
 */

// s1: union find, HashMap
// O(n * m), O(1)

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
        
        
        
        
    }
    
    // O(1) find
    public find(int x) {
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