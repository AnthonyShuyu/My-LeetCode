/**
 * 
 * 155. Min Stack
 * 
 * 
 */



// s1: use a variable to store the min value
// failed, because of the pop operation, the min will have to be stored every time, so I think of using another stack to store every time's min values, maybe not every time, just need to store the smaller one

/*
public class MinStack {

    int min = Integer.MAX_VALUE;
    int secondMin = Integer.MAX_VALUE;
    
    Stack<Integer> stack;
    

    // initialize your data structure here. 
    public MinStack() {
        stack = new Stack<Integer>();
    }
    
    public void push(int x) {
        if (x < min) {
            min = x;
            secondMin = min;
        }
        stack.push(x);
    }
    
    public void pop() {
        int val = stack.pop();
        if (val == min) {
            
        }
    }
    
    public int top() {
        
    }
    
    public int getMin() {
        
    }
}
*/

// s2: use 2 stacks and 1 variable
// O(1), O(n)

/*
import java.util.*;

public class MinStack {
    
    Stack<Integer> stack;
    Stack<Integer> minValueStack;
    int min = Integer.MAX_VALUE;
    
    public MinStack() {
        stack = new Stack<Integer>();
        minValueStack = new Stack<Integer>();
    }

    public void push(int x) {
        if (x <= min) {
            min = x;
            minValueStack.push(x);
        }
        stack.push(x);
    }
    
    public void pop() {
        if (stack.isEmpty() || minValueStack.isEmpty()) {
            throw new EmptyStackException();
            // return;
        }
        int val = stack.pop();
        if (val == minValueStack.peek()) {
            minValueStack.pop();
            if (!minValueStack.isEmpty()) {
                min = minValueStack.peek();
            } else {
                min = Integer.MAX_VALUE;
            }
        }
    }
    
    public int top() {
        if (stack.isEmpty()) {
            throw new EmptyStackException();
            // return -1;
        }
        return stack.peek();
    }
    
    public int getMin() {
        if (minValueStack.isEmpty()) {
            throw new EmptyStackException();
            // return min;
        }
        return minValueStack.peek();
    }
}
*/

// s2 again: use 2 stacks and 1 variable
// O(1), O(n)

/*
import java.util.*;

public class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minValueStack;
    int min;
    
    public MinStack() {
        stack = new Stack<Integer>();
        minValueStack = new Stack<Integer>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        stack.push(val);
        if (val <= min) {
            minValueStack.push(val);
            min = val;
        }
    }
    
    public void pop() {
        if (stack.isEmpty() || minValueStack.isEmpty()) {
            throw new EmptyStackException();
        }
        int value = stack.pop();
        if (value == minValueStack.peek()) {
            minValueStack.pop();
        }
        if (minValueStack.isEmpty()) {
            min = Integer.MAX_VALUE;
        } else {
            min = minValueStack.peek();
        }
    }
    
    public int top() {
        if (stack.isEmpty()) {
            throw new EmptyStackException();
        }
        return stack.peek();
    }
    
    public int getMin() {
        if (minValueStack.isEmpty()) {
            throw new EmptyStackException();
        }
        return minValueStack.peek();
    }
    
}
*/


// *s2 modified: just use 2 stacks, one regular stack and one min stack to store the min value on the top of the stack
// O(1), O(n)

import java.util.*;

public class MinStack {
    
    Stack<Integer> stack;
    Stack<Integer> minStack;
    
    public MinStack() {
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }
    
    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }
    
    public void pop() {
        if (stack.isEmpty() || minStack.isEmpty()) {
            throw new EmptyStackException();
        }
        if (stack.pop().equals(minStack.peek())) {
            minStack.pop();
        }
    }
    
    public int top() {
        if (stack.isEmpty()) {
            throw new EmptyStackException();
        }
        return stack.peek();
    }
    
    public int getMin() {
        if (minStack.isEmpty()) {
            throw new EmptyStackException();
        }
        return minStack.peek();
    }
}




/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */