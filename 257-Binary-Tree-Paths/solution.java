/**
 * 
 * 
 * 257. Binary Tree Paths
 * Given a binary tree, return all root-to-leaf paths.
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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<String>();
        // corner case
        if (root == null) {
            return result;
        }
        
        List<String> leftList = binaryTreePaths(root.left);
        List<String> rightList = binaryTreePaths(root.right);
        
        if (leftList.size() == 0 && rightList.size() == 0) {
            String string = "" + root.val;
            result.add(string);
        }

        for (String s: leftList) {
            String string = root.val + "->" + s;
            result.add(string);
        }
        
        for (String s: rightList) {
            String string = root.val + "->" + s;
            result.add(string);
        }
        return result;
    }
}
*/


// s2: recursion
// O(n), O(n)

public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<String>();
        // corner case
        if (root == null) {
            return result;
        }
        // TreeNode, path, result
        helper(root, String.valueOf(root.val), result);    
        return result;
    }
    
    public void helper(TreeNode root, String path, List<String> result) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            result.add(path);
        }
        if (root.left != null) {
            result.add(helper(root.left, path + "->" + String.valueOf(root.left), result));
        }
        if (root.right != null) {
            result.add(helper(root.right, path + "->" + String.valueOf(root.right), result));
        }
        
    }
}