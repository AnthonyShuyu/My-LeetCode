public class Solution {
    public boolean isValidSerialization(String preorder) {
        // corner case
        if (preorder == null || preorder.length() == 0) {
            return false;
        }
        
        char[] chars = preorder.toCharArray();
        
        Stack<Character> stack = new Stack<Character>();
        
        for (int i = 0; i < chars.length; i++) {
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
                char c = chars[i];
                check(stack, c);
                stack.push(c);
            }
        }
        
        return !stack.isEmpty() && stack.size() == 1 && stack.peek() == '#';
    }
    
    public void check(Stack<Character> stack, char c) {
        if (c == '#' && !stack.isEmpty() && stack.peek() == '#') {
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