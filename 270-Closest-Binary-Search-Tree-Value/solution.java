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
// to avoid Integer overflow


public class Solution {
    public int closestValue(TreeNode root, double target) {
        // corner case
        if (root == null) {
            return 0;
        }
        
        double min = Double.MAX_VALUE;
        
        int result = root.val;
        
        TreeNode node = root;
        
        while (node != null) {
            double value = node.val;
            
            if (value == target) {
                return value;
            } else if (value > target) {
                // System.out.println(value);
                // System.out.println(value - target);
                if (value - target < min) {
                    result = node.val;
                    min = value - target;
                }
                node = node.left;
            } else {
                if (target - node.val < min) {
                    result = node.val;
                    min = target - value;
                }
                node = node.right;
            }
        }
        return result;
        
    }
}