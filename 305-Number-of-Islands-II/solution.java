/**
 * 
 * 305. Number of Islands II
 * 
 * 
 */

// s1: brute force, 200. Number of Islands I
// O(m * n * k), O(m * n * k)
// time limit exceeded

/*
public class Solution {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        // corner case
        List<Integer> result = new ArrayList<Integer>();
        if (positions == null || positions.length == 0 || positions[0] == null || positions[0].length == 0) {
            return result;
        }
        
        result.add(1);
        for (int i = 1; i < positions.length; i++) {
            boolean[][] map = createMap(m, n, positions, i);
            int count = countIslands(map);
            result.add(count);
        }
        return result;
    }
    
    public boolean[][] createMap(int m, int n, int[][] positions, int times) {
        boolean[][] map = new boolean[m][n];
        for (int i = 0; i <= times; i++) {
            map[positions[i][0]][positions[i][1]] = true;
        }
        return map;
    }
    
    public int countIslands(boolean[][] map) {
        int result = 0;
        int m = map.length;
        int n = map[0].length;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j]) {
                    result++;
                    dfs(i, j, map);
                }
            }
        }
        return result;
    }
    
    public void dfs(int i, int j, boolean[][] map) {
        if (i < 0 || i >= map.length || j < 0 || j >= map[0].length) {
            return;
        }
        if (map[i][j]) {
            map[i][j] = false;
            dfs(i - 1, j, map);
            dfs(i + 1, j, map);
            dfs(i, j - 1, map);
            dfs(i, j + 1, map);
        }
    }
}
*/

// s2: union find
// O(k * m * n), O(m * n)

public class Solution {
    Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        // corner case
        List<Integer> result = new ArrayList<Integer>();
        if (positions == null || positions.length == 0 || positions[0] == null || positions[0].length == 0) {
            return result;
        }
        
        int[] nums = new int[positions.length];
        
        
        for (int i = 0; i < nums.length; i++) {
            nums[i] = positions[i][0] * n + positions[i][1];
            hashMap.put(nums[i], nums[i]);
            if (hashMap.containsKey(nums[i] - n)) {
                union(nums[i] - n, nums[i]);
            } else if (hashMap.containsKey(num[i] - 1)) {
                union(nums[i] - 1, nums[i]);
            } else if (hashMap.containsKey(nums[i] + 1)) {
                union(nums[i], nums[i] + 1);
            } else if (hashMap.containsKey(num[i] + n)) {
                union(nums[i], nums[i] + n);
            }
            int count = countIslands(hashMap);
            result.add(count);
        }
        return result;
        
    }    
    
    
    public int countIslands(Map<Integer, Integer> hashMap) {
        Set<Intger> hashSet = new HashSet<Integer>();
        for (int key : hashMap.keySet()) {
            hashSet.add(find(key));
        }
        return hashSet.size();
    }
    
    
    
    public int find(int x) {
        int parent = x;
        while (parent != hashMap.get(parent)) {
            parent = hashMap.get(parent);
        }
        
        int next
        while (x != hashMap.get(x)) {
            next = hashMap.get(x);
            hashMap.put(x, parent);
            x = next;
        }
        return parent;
    }
    
    public void union(int x, int y) {
        int parentX = find(x);
        int parentY = find(y);
        if (parentX != parentY) {
            hashMap.put(parentX, parentY);
        }
    }
}