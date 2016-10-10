/**
 * 
 * 
 * 270. Closest Binary Search Tree Value
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
 
 
// s1: binary tree
// O(logn), O(n)

public class Solution {
    public int closestValue(TreeNode root, double target) {
        // corner case
        if (root == null) {
            return 0;
        }
        
        int min = Integer.MAX_VALUE();
        int value = root.val;
        
        TreeNode node = root;
        while (node != null) {
            if (node.val == target) {
                return 0;
            } else if (node.val > target) {
                if (node.val - target < min) {
                    value = node.val;
                    min = node.val - target;
                }
                node = node.left;
            } else {
                if (target - node.val < min) {
                    value = node.val;
                    min = target - node.val;
                }
                node = node.right;
            }
        }
        return value;
        
    }
}