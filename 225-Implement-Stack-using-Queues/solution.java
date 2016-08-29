/**
 * 225. Implement Stack using Queues
 * 
 * 
 */

// s1: use 2 queues, convert from one queue to another every time calls pop() or top()
// Assume that the queue's elements are all integers
// O(1), O(n)

class MyStack {
    
    Queue<Integer> queue1 = new LinkedList<Integer>();
    Queue<Integer> queue2 = new LinkedList<Integer>();
    
    // Push element x onto stack.
    public void push(int x) {
        if (queue1.isEmpty()) {
            queue2.offer(x);
        } else {
            queue1.offer(x);
        }
    }

    // Removes the element on top of the stack.
    public void pop() {
        if (queue1.isEmpty()) {
            while (!queue2.isEmpty()) {
                int val = queue2.pop();
                if (!queue2.isEmpty()) {
                    queue1.offer(val);
                } 
            }
        } else if (queue2.isEmpty()) {
            while (!queue1.isEmpty()) {
                int val = queue1.pop();
                if (!queue1.isEmpty()) {
                    queue2.offer(val);
                }
            }
        }
    }

    // Get the top element.
    public int top() {
        int val = 0;
        if (queue1.isEmpty()) {
            while (!queue2.isEmpty()) {
                val = queue2.pop();
                queue1.offer(val);
            }
        } else if (queue2.isEmpty()) {
            while (!queue1.isEmpty()) {
                val = queue1.pop();
                queue2.offer(val);
            }
        }
        return val;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }
    
}