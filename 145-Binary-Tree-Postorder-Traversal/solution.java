/**
 * 
 * 145. Binary Tree Postorder Traversal
 * Given a binary tree, return the postorder traversal of its nodes' values.
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

/*
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        // corner case
        if (root == null) {
            return result;
        }
        
        List<Integer> leftList = postorderTraversal(root.left);
        List<Integer> rightList = postorderTraversal(root.right);
        
        result.addAll(leftList);
        result.addAll(rightList);
        result.add(root.val);
        
        return result;
    }
}
*/

// s2: use recursion and traverse
// O(n), O(n)

public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
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
        helper(result, root.right);
        result.add(root.val);
    }
    
}