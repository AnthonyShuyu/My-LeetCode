/**
 * 
 * 
 * 102. Binary Tree Level Order Traversal
 * 4 solutions
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
 
 
// s1: use BFS: Queue
// O(n), O(n)

/*
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        // corner case
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) {
            return result;
        }
        
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<Integer>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.add(list);
        }
        return result;
    }
}


*/

// s2: use dummy node and Queue
// O(n), O(n)

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        // corner case
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) {
            return result;
        }
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        queue.offer(null);
        
        List<Integer> list = new ArrayList<Integer>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                list.add(node.val);
                if (node.left != null) {
                    queue.offer(left);
                }
                if (node.right != null) {
                    queue.offer(right);
                }
            } else {
                if (list.size() == 0) {
                    break;
                }
                queue.offer(null);
                result.add(list);
                list = new ArrayList<Integer>();
            }
        }
        return result;            
    }
}


// s3: use DFS, but not with Stack
// O(n), O(n)

/*
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        // corner case
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) {
            return result;
        }
        
        List<Integer> list = null;
        int max_level = 0;
        while (true) {
            list = new ArrayList();
            int current_level = 0;
            dfs(list, root, max_level, current_level);
            if (list.size() == 0) {
                break;
            }
            result.add(list);
            max_level++;
        }
        return result;
    }
    
    public void dfs(List<Integer> list, TreeNode root, int max_level, int current_level) {
        if (root == null || current_level > max_level) {
            return;
        }
        if (current_level == max_level) {
            list.add(root.val);
            return;
        }
        dfs(list, root.left, max_level, current_level + 1);
        dfs(list, root.right, max_level, current_level + 1);
    }
    
}
*/


/