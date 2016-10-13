public class Solution {
    public boolean isValidSerialization(String preorder) {
        // corner case
        if (preorder == null || preorder.length() == 0) {
            return false;
        }
        
        String[] strs = preorder.trim().split(',');
        
        Stack<String> stack = new Stack<String>();
        
        for (int i = 0; i < strs.length; i++) {
                // if (chars[i] == '#' && !stack.isEmpty() && stack.peek() == '#') {
                //     if (stack.isEmpty()) {
                //         stack.pop();                        
                //     } else {
                //         return false;
                //     }
                    
                //     if (stack.isEmpty()) {
                //         stack.pop();
                //     } else {
                //         return false;
                //     }
                //     stack.push('#');
                // }
                String s = strs[i];
                check(stack, s);
                stack.push(s);
                // System.out.println(stack);
        }
        
        return !stack.isEmpty() && stack.size() == 1 && stack.peek().equals("#");
    }
    
    public void check(Stack<String> stack, String s) {
        if (s.equals("#") && !stack.isEmpty() && stack.peek().equals("#")) {
            stack.pop();
            if (stack.isEmpty()) {
                return;
            } else {
                stack.pop();
                check(stack, c);
            }
        } else {
            return;
        }
    }
}