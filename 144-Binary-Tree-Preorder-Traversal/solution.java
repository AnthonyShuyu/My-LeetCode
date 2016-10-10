/**
 * 
 * 
 * 144. Binary Tree Preorder Traversal
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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        // corner case
        if (root == null) {
            return result;
        }
        
        List<Integer> leftList = preorderTraversal(root.left);
        List<Integer> rightList = preorderTraversal(root.right);
        
        result.add(root.val);
        result.addAll(leftList);
        result.addAll(rightList);
        
        return result;
    }
}