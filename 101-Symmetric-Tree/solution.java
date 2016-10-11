/**
 * 
 * 
 * 101. Symmetric Tree
 * 
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
 
 
// s1: 226. invert binary tree and 100. to see if the two are the same
// O(n), O(n)
// failed, you can not invert the root treeNode first then compare the new to the old, because CBV, the root will change

/*
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        TreeNode node = root;
        return isSameTree(root, invertTree(node));
    }
    
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        
        TreeNode leftNode = invertTree(root.left);
        TreeNode rightNode = invertTree(root.right);
        
        root.left = rightNode;
        root.right = leftNode;
        return root;
    }
    
    
    public boolean isSameTree(TreeNode n1, TreeNode n2) {
        if (n1 == null && n2 == null) {
            return true;
        }
        if (n1 == null || n2 == null) {
            return false;
        }
        
        if (n1.val != n2.val) {
            return false;
        }
        return isSameTree(n1.left, n2.left) && isSameTree(n1.right, n2.right);
    }
}
*/


// s2: invert the root and do serialize
// O(n), O(n)

public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        
        String s1 = serializeTree(root);
        invertTree(root);
        String s2 = serializeTree(root);
        
        return s1.equals(s2);
    }
    
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        
        TreeNode leftNode = invertTree(root.left);
        TreeNode rightNode = invertTree(root.right);
        
        root.left = rightNode;
        root.right = leftNode;
        return root;
    }
    
    public String serializeTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        
        queue.offer(root.left);
        queue.offer(root.right);
        
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                sb.append(",#");
            } else {
                sb.append("," + node.val);
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        return sb.toString();
    }
    
}


// s3: don't invert the root