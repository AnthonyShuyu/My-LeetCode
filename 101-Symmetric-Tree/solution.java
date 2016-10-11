/**
 * 
 * 
 * 101. Symmetric Tree
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * 3 solutions
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
 
 
// s1: 226. invert binary tree and 100. to see if the two are the same
// O(n), O(n)
// failed, you can not invert the root treeNode first then compare the new to the old, because CBV, the root will change

/*
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        TreeNode node = root;
        return isSameTree(root, invertTree(node));
    }
    
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        
        TreeNode leftNode = invertTree(root.left);
        TreeNode rightNode = invertTree(root.right);
        
        root.left = rightNode;
        root.right = leftNode;
        return root;
    }
    
    
    public boolean isSameTree(TreeNode n1, TreeNode n2) {
        if (n1 == null && n2 == null) {
            return true;
        }
        if (n1 == null || n2 == null) {
            return false;
        }
        
        if (n1.val != n2.val) {
            return false;
        }
        return isSameTree(n1.left, n2.left) && isSameTree(n1.right, n2.right);
    }
}
*/


// s2: invert the root and do serialize
// O(n), O(n)

/*
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        
        String s1 = serializeTree(root);
        invertTree(root);
        String s2 = serializeTree(root);
        
        return s1.equals(s2);
    }
    
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        
        TreeNode leftNode = invertTree(root.left);
        TreeNode rightNode = invertTree(root.right);
        
        root.left = rightNode;
        root.right = leftNode;
        return root;
    }
    
    public String serializeTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        
        queue.offer(root.left);
        queue.offer(root.right);
        
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                sb.append(",#");
            } else {
                sb.append("," + node.val);
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        return sb.toString();
    }
    
}
*/



// s3: don't invert the root, use a queue, level order traverse
// O(n), O(n)

/*
public class Solution {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        List<String> list = null;
        while(!queue.isEmpty()) {
            int size = queue.size();
            list = new ArrayList<String>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node != null) {
                    list.add(String.valueOf(node.val));
                    queue.offer(node.left);
                    queue.offer(node.right);
                } else {
                    list.add("#");
                }
            }
            if (!isPalindrome(list)) {
                return false;
            }
        }
        return true;
    }
    
    public boolean isPalindrome(List<String> list) {
        if (list == null) {
            return false;
        }
        int start = 0;
        int end = list.size() - 1;
        for (int i = start, j = end; i < j; i++, j--) {
            if (!list.get(i).equals(list.get(j))) {
                return false;
            }
        }
        return true;
    }
}
*/



// s4: use dfs, recursion
// O(n), O(n)


public class Solution {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return checkSymmetric(root.left, root.right);
   }
   
   public boolean checkSymmetric(TreeNode node1, TreeNode node2) {
       if (node1 == null && node2 == null) {
           return true;
       }
       if (node1 == null || node2 == null) {
           return false;
       }
       if (node1.val != node2.val) {
           return false;
       }
       return checkSymmetric(node1.left, node2.right) && checkSymmetric(node1.right, node2.left);
   }
}



