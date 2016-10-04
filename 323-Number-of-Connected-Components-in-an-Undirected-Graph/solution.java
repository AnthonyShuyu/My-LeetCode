/**
 * 
 * 323. Number of Connected Components in an Undirected Graph
 * 1 solution
 * 
 */


// s1: brute force, assume the arrays are in increasing order
// O(m * n), O(1)
// failed, the arrays are not in increasing order

/*
public class Solution {
    public int countComponents(int n, int[][] edges) {
        // corner case
        if (edges == null || edges.length == 0) {
            return -1;
        }
        if (edges[0] == null || edges[0].length == 0) {
            return -1;
        }
        
        int count = 1;
        for (int i = 1; i < edges.length; i++) {
            if (edges[i][0] != edges[i - 1][1]) {
                count++;
            }
        }
        return count;        
    }
}
*/

// s2: union find
// O(n*m), O(n)

public class Solution {
    
    Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
    
    public int countComponents(int n, int[][] edges) {
        // corner case
        if (edges == null || edges.length == 0) {
            return n;
        }
        if (edges[0] == null || edges[0].length == 0) {
            return n;
        }
        
        Set<Integer> hashSet = new HashSet<Integer>();
        
        // first traverse, let the father be themselves
        for (int i = 0; i < edges.length; i++) {
            for (int j = 0; j < 2; j++) {
                if (!hashSet.contains(edges[i][j])) {
                    hashMap.put(edges[i][j], edges[i][j]);
                    hashSet.add(edges[i][j]);
                }  
            }
        }
        
        // second traverse, union the elements
        for (int i = 0; i < edges.length; i++) {
            union(edges[i][0], edges[i][1]);
        }
        
        // get the result
        
        // int count = n - hashSet.size();
        // Set<Integer> countSet = new HashSet<Integer>();
        // for (int key: hashMap.keySet()) {
        //     if (!countSet.contains(find(key))) {
        //         count++;
        //         countSet.add(find(key));
        //     }
        // }
        
        int count = n;
        for (int i = 0; i < n; i++) {
            if (find(edges[i][0]) == find(edges[i][1])) {
                count--;
            }
        }
        return count;
    }
    
    public int find(int x) {
        int parent = x;
        while (parent != hashMap.get(parent)) {
            parent = hashMap.get(parent);
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

