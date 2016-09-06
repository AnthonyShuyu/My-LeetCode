/**
 * 
 * 394. Decode String
 * 
 * 
 */

// s1:use two stacks, one stores numbers, one stores strings
// O(n), O(n)

public class Solution {
    public String decodeString(String s) {
        // corner case
        if (s == null || s.length() == 0) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        Stack<Integer> integerStack = new Stack<Integer>();
        Stack<StringBuilder> sbStack = new Stack<StringBuilder>();
        
        int index = 0;
        while (index < s.length()) {
            char c = s.charAt(index);
            if (Character.isDigit(c)) {
                int index2 = index;
                while (index2 < s.length()) {
                    char c2 = s.charAt(index2);
                    if (Character.isDigit(c2)) {
                        index2++;
                    } else {
                        break;
                    }
                }
                int num = Integer.valueOf(s.substring(index, index2));
                integerStack.push(num);
                index = index2;
            } else if (c == '[') {
                StringBuilder sb = new StringBuilder();
                sbStack.push(sb);
                index++;
            } else if (Character.isLetter(c)) {
                int index3 = index;
                while (index3 < s.length()) {
                    char c3 = s.charAt(index3);
                    if (Character.isLetter(c3)) {
                        index3++;
                    } else {
                        break;
                    }
                }
                String temp = s.substring(index, index3);
                if (sbStack.isEmpty()) {
                    result.append(temp);
                } else {
                    sbStack.peek().append(temp);
                }
                index = index3;
            } else if (c == ']') {
                String s = sbStack.poll().toString();
                int n = integerStack.poll();
                StringBuilder tempsb = new StringBuilder();
                for (int i = 0; i < n; i++) {
                    tempsb.append(s);
                }
                if (sbStack.isEmpty()) {
                    result.append(tempsb);
                } else {
                    sbStack.peek().append(tempsb);
                }
                index++;
            }
        }
        return result.toString();
    }
}