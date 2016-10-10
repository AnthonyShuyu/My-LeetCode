/**
 * 
 * 297. Serialize and Deserialize Binary Tree
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

/*
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        sb.append(root.val);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                    sb.append(node.left.val);
                } else {
                    sb.append("n");
                }
                
                if (node.right != null) {
                    queue.offer(node.right);
                    sb.append(node.right.val);
                } else {
                    sb.append("n");
                }
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        
    }
}
*/


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
        /*
        while (queue.get(queue.size() - 1) == null) {
            queue.remove(queue.size() - 1);
        }
        */
        
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append(queue.get(0).val);//remember to add .val
        for (int i = 1; i < queue.size(); i++) {
            if (queue.get(i) == null) {
                sb.append(",#");
            } else {
                sb.append(",");
                sb.append(queue.get(i).val);
            }
        }
        sb.append("}");
        return sb.toString(); //sb is not String, we have to transform
    }

    public TreeNode deserialize(String data) { //more tricky!
        if (data.equals("{}")) {
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

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));