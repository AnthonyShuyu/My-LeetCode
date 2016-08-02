/**
 * 
 * 227. Basic Calculator II
 * 
 * Implement a basic calculator to evaluate a simple expression string.

The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.
 * 
 */

// s1: use Stack, and use num * 10 + current!!!
// O(n), O(n)
// I first already think about of the thought, but can not realize it using code, need more and more practice

public class Solution {
    public int calculate(String s) {
        // corner case
        if (s == null || s.length() == 0) {
            return 0;
        }
        s = s.trim();
        Stack<Integer> stack = new Stack<Integer>();
        int num = 0;
        int result = 0;
        char sign = '+';
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                continue;
            } 
            if (Character.isDigit(s.charAt(i))) {
                int current_num = s.charAt(i) - '0';
                num = num * 10 + current_num;
            } 
            if (!Character.isDigit(s.charAt(i)) || i == s.length() - 1) {
                if (sign == '+') {
                    stack.push(num);
                } else if (sign == '-') {
                    stack.push(-num);
                } else if (sign == '*') {
                    stack.push(stack.pop() * num);
                } else if (sign == '/') {
                    stack.push(stack.pop() / num);
                }
                sign = s.charAt(i);
                num = 0;
            }
        }
        for (int n : stack) {
            result += n;
        }
        return result;
    }
}