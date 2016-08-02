/**
 * 224. Basic Calculator
 * 
 * 
 */

// s1: use stack, and the num * 10 + current_num
// O(n), O(n)
// failed, can not use the same exactly method of Basic Calculator II

/*
public class Solution {
    public int calculate(String s) {
        // corner case
        if (s == null || s.length() == 0) {
            return 0;
        }
        s = s.trim();
        Stack<Integer> stack = new Stack<Integer>();
        char sign = '+';
        char sign2 = '+';
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                continue;
            }
            if (c == '(') {
                stack.push(null);
                sign2 = sign;
                sign = '+';
            }
            if (Character.isDigit(c)) {
                num = num * 10 + (int)(c - '0');
            }
            if (c == '+' || c == '-' || c == ')' || (i == s.length() - 1) && Character.isDigit(c)) {
                if (sign == '+') {                  // use sign, not c
                    stack.push(num);
                } else if (sign == '-') {
                    stack.push(-num);
                }
                sign = c;
                num = 0;
            } 
            if (c == ')') {
                int temp = 0;
                while(stack.peek() != null) {
                    temp = temp + stack.pop();
                }
                stack.pop();
                if (sign2 == '-') {
                    stack.push(-temp);
                } else {
                    stack.push(temp);
                }
            }
        }
        int result = 0;
        for (int i : stack) {
            result += i;
        }
        return result;
    }
}
*/

// s2: use 2 stacks, one store digits, one store signs

// This problem can be solved by using a stack. We keep pushing element to the stack, when ')" is met, calculate the expression up to the first "(".
    
// O(n), O(n)

public class Solution {
    public int calculate(String s) {
        // corner case
        if (s == null || s.length() == 0) {
            return 0;
        }
        s = s.trim();
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Character> stack2 = new Stack<Character>();
        int num = 0;
        stack2.push('+');
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                continue;
            }
            if (c == '(') {
                stack1.push(null);
            }
            if (Character.isDigit(c)) {
                num = num * 10 + (int)(c - '0');
            }
            if (c == '+' || c == '-' || c == ')' || i == s.length() - 1) {
                if (!stack2.isEmpty()) {
                    char tempChar = stack2.pop();
                    if (tempChar == '+') {
                        stack1.push(num);
                    }  else {
                        stack1.push(-num);
                    }
                }
                if (c == '+') {
                    stack2.push('+');
                } else if (c == '-') {
                    stack2.push('-');
                } else if (c == ')') {
                    int temp = 0;
                    while (!stack1.isEmpty() && stack1.peek() != null) {
                        temp += stack1.pop();
                    }
                    stack1.pop();
                    stack1.push(temp);
                }
            }
            int result = 0;
            for (int i : stack1) {
                result += i;
            }
            return result;
        }
    }
}