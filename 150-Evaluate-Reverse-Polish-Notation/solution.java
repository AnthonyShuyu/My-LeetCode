/**
 * 150. Evaluate Reverse Polish Notation
 * 
 * 
 */

// s1: use a stack, when push into the stack, do the evaluation at the same time
// O(n), O(n)

public class Solution {
    public int evalRPN(String[] tokens) {
        // corner case
        if (tokens == null || tokens.length == 0) {
            return 0;
        }
        
        int result = 0;
        
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < tokens.length; i++) {
            if (isInteger(tokens[i])) {
                stack.push(Integer.valueOf(tokens[0]));
            } else if (isSign(tokens[i])) {
                if (stack.size() < 2) {
                    return 0;
                }
                int n2 = stack.pop();
                int n1 = stack.pop();
                int n3 = 0;
                char c = tokens[i].charAt(0);
                if (c == '+') {
                    n3 = n1 + n2;
                } else if (c == '-') {
                    n3 = n1 - n2;
                } else if (c == '*') {
                    n3 = n1 * n2;
                } else if (c == '/') {
                    if (n2 == 0) {
                        return 0;
                    } 
                    n3 = n1 / n2;
                } else {
                    return 0;
                }
                result = n3;
                stack.push(n3);
            } else {
                return 0;
            }
        }
        return result;
    }
    
    public boolean isInteger(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }
    
    public boolean isSign(String s) {
        if (s == null || s.length() != 1) {
            return false;
        }
        if (s.charAt(0) == '+' || s.chatAt(0) == '-' || s.charAt(0) == '*' || s.charAt(0) == '/') {
            return true;
        } else {
            return false;
        }
    }
}