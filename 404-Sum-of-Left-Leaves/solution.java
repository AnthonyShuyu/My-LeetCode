/**
 * 
 * 404. Sum of Left Leaves
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
 
// s1: divide and conquer
// O(n), O(n)
public class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        // corner case
        if (root == null) {
            return 0;
        }
        return root.left.val + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }
}