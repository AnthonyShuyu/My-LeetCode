/**
 * 
 * 94. Binary Tree Inorder Traversal
 * Given a binary tree, return the inorder traversal of its nodes' values.
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

/*
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        
        // corner case
        if (root == null) {
            return result;
        }
        
        List<Integer> leftList = inorderTraversal(root.left);
        List<Integer> rightList = inorderTraversal(root.right);
        
        result.addAll(leftList);
        result.add(root.val);
        result.addAll(rightList);
        return result;
    }
}
*/


// s2: use recursion to traverse
// O(n), O(n)

public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        // corner case
        if (root == null) {
            return result;
        }
        helper(result, root);
        return result;
    }
    
    public void helper(List<Integer> result, TreeNode root) {
        if (root == null) {
            return;
        }
        
        helper(result, root.left);
        result.add(root.val);
        helper(result, root.right);
    }
}