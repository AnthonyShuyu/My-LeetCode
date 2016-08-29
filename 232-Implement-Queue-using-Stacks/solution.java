/**
 * 
 * 232. Implement Queue using Stacks
 * 2 methods
 * 
 */


// s1: use 2 stacks, and a convert method
// O(1), O(n)

/*
class MyQueue {
    
    Stack stack1 = new Stack();
    Stack stack2 = new Stack();
    
    // Push element x to the back of queue.
    public void push(int x) {
        stack1.push(x);        
    }

    // Removes the element from in front of queue.
    public void pop() {
        convert(stack1, stack2);
        stack2.pop();
        convert(stack2, stack1);
    }

    // Get the front element.
    public int peek() {
        convert(stack1, stack2);
        int result = (int)stack2.peek();
        //
        // int result = Integer.valueOf(stack2.peek());
        convert(stack2, stack1);
        return result;
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return stack1.isEmpty();
    }
    
    public void convert(Stack stack1, Stack stack2) {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
    }
}
*/

// *s2: use 2 stacks but modified, more flexible
// assume that the stacks' elements are integers
// O(1), O(n)

public class MyQueue {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    public void push(int x) {
        stack1.push(x);
    }
    
    public int pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
    
    public int peek() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }
    
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}