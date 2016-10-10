/**
 * 
 * 226. Invert Binary Tree
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
 
// s1: divide and conquer
// O(n), O(n)
public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        
        // Divide
        
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        
        
        TreeNode leftNode = invertTree(root.left);
        TreeNode rightNode = invertTree(root.right);
        
        // Conquer
        // TreeNode tempNode = leftNode;
        // leftNode = rightNode;
        // rightNode = tempNode;
        
        // root.left = rightNode;
        // root.right = leftNode;
        return root;
    }
}