/**
 * 
 * 232. Implement Queue using Stacks
 * 
 * 
 */


// s1: use 2 stacks
// O(1), O(n)

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
        int result = stack2.peek();
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