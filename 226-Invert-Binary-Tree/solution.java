/**
 * 
 * 226. Invert Binary Tree
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
 
// s1: divide and conquer, postorder traverse
// O(n), O(n)

/*
public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        
        // Divide
        // TreeNode temp = root.left;
        // root.left = root.right;
        // root.right = temp;
        
        TreeNode leftNode = invertTree(root.left);
        TreeNode rightNode = invertTree(root.right);
        
        // Conquer
        // TreeNode tempNode = leftNode;
        // leftNode = rightNode;
        // rightNode = tempNode;
        
        root.left = rightNode;
        root.right = leftNode;
        return root;
    }
}
*/

// s2: preorder traverse
// O(n), O(n)

/*
public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}
*/


// s3: use Stack, no recursion
// O(n), O(n)

public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        return root;
    }
}
