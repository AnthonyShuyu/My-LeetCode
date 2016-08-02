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
// failed

/*
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
                stack2.push('+');
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
                    if (!stack2.isEmpty()) {
                        char c2 = stack2.pop();
                        if (c2 == '+') {
                             stack1.push(temp);
                        } else {
                            stack1.push(-temp);
                        }
                    }

                }
                num = 0;
            }

        }
        
        int result = 0;
            for (int i : stack1) {
                result += i;
            }
            return result;
    }
}
*/


// *s3: use 1 stack, and do something like 1 - (2 + 3) =   1 - 2 - 3
// O(n), O(n)

public class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        s = s.replace(" ", "");
        
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);  // the parenthesis current belonging sign is positive
        int index = 0;
        int sign = 1;   // the current sign
        int result = 0;
        
        while (index < s.length()) {
            char c = s.charAt(index);
            if (c == '+') {
                sign = 1;
                index++;
            } else if (c == '-') {
                sign = -1;
                index++;
            } else if (c == '(') {          // if meet '(', stack.push the current belong sign, which equals to the current belonging sign * the current sign, and change sign to '+'
                stack.push(sign * stack.peek());
                sign = 1;
                index++;
            } else if (c == ')') {
                stack.pop();
                index++;
            } else if (Character.isDigit(c)) {
                int num = 0;
                while (index < s.length() && Character.isDigit(s.charAt(index))) {
                    num = num * 10 + (int)(s.charAt(index) - '0');
                    index++;
                }
                result += num * sign * stack.peek();
            }
        }
        return result;
        
    }
}
