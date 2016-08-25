/**
 * 
 * 155. Min Stack
 * 
 * 
 */



// s1: use a variable to store the min value
// seem not available, because of the pop operation, the min will have to be stored every time, so I think of using another stack to store every time's min values, maybe not every time, just need to store the smaller one

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
// 

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
            // throw new EmptyStackException();
            return;
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
            // throw new EmptyStackException();
            return -1;
        }
        return stack.peek();
    }
    
    public int getMin() {
        if (minValueStack.isEmpty()) {
            // throw new EmptyStackException();
            return min;
        }
        return minValueStack.peek();
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