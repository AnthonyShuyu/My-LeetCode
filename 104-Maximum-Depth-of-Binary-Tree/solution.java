/**
 * 
 * 
 * 104. Maximum Depth of Binary Tree
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
 
// s1: dfs, divide and conquer
// O(n), O(1)

public class Solution {
    public int maxDepth(TreeNode root) {
        // corner case
        if (root == null) {
            return 0;
        }
        
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
        
    }
}