/**
 * 
 * 
 * 100. Same Tree
 * Given two binary trees, write a function to check if they are equal or not.
 * 
 * 
 */ 


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
// s1: dfs, recursion, divide and conquer
// O(n), O(1)

/*
public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // corner case
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        
        if (p.val != q.val) {
            return false;
        }
        
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
*/


// s2: serialize a tree to a String, to compare the two Strings
// O(n), O(n)


public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // corner case      
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        
        String s1 = serializeTree(p);
        String s2 = serializeTree(q);
        
        return s1.equals(s2);
    }
    
    public String serializeTree(TreeNode root) {
        
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        
        sb.append(root.val);
        queue.offer(root.left);
        queue.offer(root.right);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node == null) {
                    sb.append(",#");
                } else {
                    sb.append("," + node.val);
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
            }
        }
        return sb.toString();
    }
    
}