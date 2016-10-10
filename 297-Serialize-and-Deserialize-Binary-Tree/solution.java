/**
 * 
 * 297. Serialize and Deserialize Binary Tree
 * 2 solutions
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
 
// s1: bfs
// O(n), O(n)
// tricky when do deserialize

/*
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        sb.append(root.val);
        queue.offer(root.left);
        queue.offer(root.right);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node != null) {
                    sb.append("," + node.val);
                    queue.offer(node.left);
                    queue.offer(node.right);
                } else {
                    sb.append(",#");
                }
            }
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("")) {
            return null;
        }
        
        String[] strs = data.split(",");
        List<TreeNode> list = new ArrayList<TreeNode>();
        TreeNode root = new TreeNode(Integer.valueOf(strs[0]));
        list.add(root);
        int index = 0;
        boolean isLeft = true;
        for (int i = 1; i < strs.length; i++) {
            if (!strs[i].equals("#")) {
                TreeNode node = new TreeNode(Integer.valueOf(strs[i]));
                if (isLeft) {
                    list.get(index).left = node;
                } else {
                    list.get(index).right = node;
                }
                list.add(node);
            }
            
            if (!isLeft) {
                index++;
            }
            isLeft = !isLeft;            
        }
        
        return root;
    }
}
*/


// s2: use dfs, recursion, divide and conquer
// O(n), O(n)

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        String left = serialize(root.left);
        String right = serialize(root.right);
        sb.append("," + left + "," + right);
        return sb.toString();
    }
    
    public TreeNode deserialize(String data) {
        if (data.equals("null")) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        String[] strs = data.split(",");
        for (int i = 0; i < strs.length; i++) {
            if (strs[i] == "null") {
                queue.offer(null);
            } else {
                queue.offer(new TreeNode(Integer.valueOf(strs[i])));
            }
        }
        helper(queue);        
    }
    
    public TreeNode helper(Queue<TreeNode> queue) {
        TreeNode node = queue.poll();
        if (node == null) {
            return null;
        }
        node.left = helper(queue);
        node.right = helper(queue);
        return node;
    }
}


















/*

class Codec {

    public String serialize(TreeNode root) {
        if (root == null) {
            return "{}";
        }
        ArrayList<TreeNode> queue = new ArrayList<TreeNode>();
        queue.add(root);
        for (int i = 0; i < queue.size(); i++) {
            TreeNode node = queue.get(i);
            if (node == null) {
                continue;
            }
            queue.add(node.left);
            queue.add(node.right);
        }
        
        //Of course we can delete this.
        // while (queue.get(queue.size() - 1) == null) {
        //     queue.remove(queue.size() - 1);
        // }
        
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append(queue.get(0).val);//remember to add .val
        System.out.println(queue.size());
        for (int i = 1; i < queue.size(); i++) {
            if (queue.get(i) == null) {
                sb.append(",#");
            } else {
                sb.append(",");
                sb.append(queue.get(i).val);
            }
        }
        sb.append("}");
        System.out.println(sb.toString());
        return sb.toString(); //sb is not String, we have to transform
    }
    
    public TreeNode deserialize(String data) { //more tricky!
        // if (data.equals("{}")) {
        //     return null;
        // }
        
        if (data.equals("")) {
            return null;
        }
        
        //跳过data第一个元素并放入String数组最快捷语句
        String[] vals = data.substring(1, data.length() - 1).split(",");
        
        //建立ArrayList的用意：记录处理过的结点
        //并按index处理所有结点：和自己的children连接
        ArrayList<TreeNode> queue = new ArrayList<TreeNode>();
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        queue.add(root);
        int index = 0;
        boolean isLeftChild = true;
        for (int i = 1; i < vals.length; i++) {
            if (!vals[i].equals("#")) {
                //vals[i] is a String, so use parseInt()
                TreeNode node = new TreeNode(Integer.parseInt(vals[i]));
                if (isLeftChild) {
                    queue.get(index).left = node;
                } else {
                    queue.get(index).right = node;
                }
                queue.add(node);
            }
            
            //下面先通过isLeftChild判断index，
            //再修改isLeftChild的符号的顺序，十分巧妙
            if (!isLeftChild) {
                index++;
            }
            isLeftChild = !isLeftChild;
        }
        return root;
    }
}
*/

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));