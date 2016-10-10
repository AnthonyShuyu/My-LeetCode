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

*/



// s3: use 2 queues to compare each time
// O(n), O(n)

public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        
        Queue<TreeNode> q1 = new LinkedList<TreeNode>();
        Queue<TreeNode> q2 = new LinkedList<TreeNode>();
        
        q1.offer(p);
        q2.offer(q);
        
        while (!q1.isEmpty() && !q2.isEmpty()) {
            TreeNode n1 = q1.poll();
            TreeNode n2 = q2.poll();
            
            if (n1.val != n2.val) {
                return false;
            }
            if (n1.left != null) {
                q1.offer(n1.left);
            }
            if (n2.left != null) {
                q2.offer(n2.left);
            }  
            if (q1.size() != q2.size()) {
                return false;
            }            
            if (n1.right != null) {
                q1.offer(n1.right);
            }
            if (n2.right != null) {
                q2.offer(n2.right);
            }
            if (q1.size() != q2.size()) {
                return false;
            }
        }
        return q1.size() == q2.size();
    }
    
    
}