/**
 * 150. Evaluate Reverse Polish Notation
 * 
 * 
 */

// s1: use a stack, when push into the stack, do the evaluation at the same time
// O(n), O(n)
// Character.isDigit(char)  

/*
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
                // stack.push(convertToInt(tokens[i]));
                stack.push(Integer.valueOf(tokens[i]));
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
                stack.push(n3);
            } else {
                return 0;
            }
        }
        result = stack.peek();
        return result;
    }
    
    public boolean isInteger(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        char c = s.charAt(0);
        int i = 0;
        if (c == '-') {
            i = 1;
        }
        
        if (c == '-' && s.length() == 1) {
            return false;
        }
        
        for (; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }
    
    // public int convertToInt(String s) {
    //     if (s == null || s.length() == 0) {
    //         return -1;
    //     }
    //     int sign = 1;
    //     if (s.charAt(0) == '-') {
    //         sign = -1;
    //     }
    //     String sub;
    //     if (sign == 1) {
    //         sub = s;
    //     } else {
    //         sub = s.substring(1);
    //     }
    //     int n = Integer.valueOf(sub);
    //     if (sign == 1) {
    //         return n;
    //     } else {
    //         return n * (-1);
    //     }
    // }
    
    public boolean isSign(String s) {
        if (s == null || s.length() != 1) {
            return false;
        }
        if (s.charAt(0) == '+' || s.charAt(0) == '-' || s.charAt(0) == '*' || s.charAt(0) == '/') {
            return true;
        } else {
            return false;
        }
    }
}
*/



// s2: assume that the input are all valid
// O(n), O(n)
// s.contains(string)

public class Solution {
    public int evalRPN(String[] tokens) {
        // corner case
        if (tokens == null || tokens.length == 0) {
            return 0;
        }
        
        Stack<Integer> stack = new Stack<Integer>();
        String s = "+-*/";
        for (int i = 0; i < tokens.length; i++) {
            if (!s.contains(tokens[i])) {
                stack.push(Integer.valueOf(tokens[i]));
            } else {
                if (stack.size() < 2) {
                    return 0;
                }
                int n2 = stack.pop();
                int n1 = stack.pop();
                int n3 = 0;
                if (tokens[i].equals("+")) {
                    n3 = n1 + n2;
                } else if (tokens[i].equals("-")) {
                    n3 = n1 - n2;
                } else if (tokens[i].equals("*")) {
                    n3 = n1 * n2;
                } else if (tokens[i].equals("/")) {
                    n3 = n1 / n2;
                }
                stack.push(n3);
            }
        }
        return stack.peek();
    }
}