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
        int sum = 0;
        if (root.left != null) {
            sum = root.left + val;
        }
        sum = sum + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
        return sum;
    }
}