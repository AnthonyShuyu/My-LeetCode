/**
 * 20. Valid Parentheses
 * 
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 */


// s1: use stack
// O(n), O(n)

public class Solution {
    public boolean isValid(String s) {
        // corner case
        if (s == null || s.length() <= 1) {
            return false;
        }
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
            } else if (s.charAt(i) == ')') {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    if (stack.pop() != '(') {
                        return false;
                    }
                }
            } else if (s.charAt(i) == ']') {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    if (stack.pop() != '[') {
                        return false;
                    }
                }
            } else if (s.charAt(i) == '}') {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    if (stack.pop() != '{') {
                        return false;
                    }
                }
            } else {
                return false;
            }
        }
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
        
    }
}