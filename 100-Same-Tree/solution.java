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