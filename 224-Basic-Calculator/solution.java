/**
 * 224. Basic Calculator
 * 
 * 
 */

// s1: use stack, and the num * 10 + current_num
// O(n), O(n)


public class Solution {
    public int calculate(String s) {
        // corner case
        if (s == null || s.length() == 0) {
            return 0;
        }
        s = s.trim();
        Stack<Integer> stack = new Stack<Integer>();
        char sign = '+';
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                continue;
            }
            if (c == '(') {
                stack.push(null);
            }
            if (Character.isDigit(c)) {
                num = num * 10 + (int)(c - '0');
            }
            if (c == '+' || c == '-' || (i == s.length() - 1) && Character.isDigit(c)) {
                if (c == '+') {
                    stack.push(num);
                } else if (c == '-') {
                    stack.push(-num);
                }
                sign = c;
                num = 0;
            } 
            if (c == ')') {
                int temp = 0;
                while(stack.peak() != null) {
                    temp = temp + stack.pop();
                }
                stack.pop();
                stack.push(temp);
            }
        }
        int result = 0;
        for (int i : stack) {
            result += i;
        }
        
        return result;
    }
}