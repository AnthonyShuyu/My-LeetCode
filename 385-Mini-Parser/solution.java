/**
 * 
 * 385. Mini Parser
 * Given a nested list of integers represented as a string, implement a parser to deserialize it.
    Each element is either an integer, or a list -- whose elements may also be integers or other lists.
 * 
 * 
 */






/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
 
// s1: use Stack, every time meets a "[", create a new NestedInteger, and push into Stack
// O(n), O(n)

public class Solution {
    public NestedInteger deserialize(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        Stack<NestedInteger> stack = new Stack<NestedInteger>();
        // NestedInteger tempResult = new NestedInteger();
        int index = 0;
        while (index < s.length()) {
            char c = s.charAt(index);
            if (c == '[') {
                NestedInteger ni = new NestedInteger();
                stack.push(ni);
                index++;
            } else if (Character.isDigit(c) || c == '-') {
                int index_end = index;
                while (index_end < s.length()) {
                    char c2 = s.charAt(index_end);
                    if (Character.isDigit(c2) || c2 == '-') {
                        index_end++;
                    } else {
                        break;
                    }
                }
                String subString = s.substring(index, index_end);
                NestedInteger niInteger = new NestedInteger(Integer.valueOf(subString));
                if (!stack.isEmpty()) {
                    NestedInteger temp = stack.peek();
                    temp.add(niInteger);
                } else {
                    stack.push(niInteger);
                }
                index = index_end;
            } else if (c == ',') {
                index++;
            } else if (c == ']') {
                // if (!stack.isEmpty()) {
                    NestedInteger ni = stack.pop();
                    if (!stack.isEmpty()) {
                        NestedInteger temp = stack.peek();
                        temp.add(ni);
                    } else {
                        return ni;
                    }
                // }
                index++;
            }
        }
        return stack.peek();
    }
}