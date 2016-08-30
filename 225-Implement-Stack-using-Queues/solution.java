/**
 * 225. Implement Stack using Queues
 * 
 * Java is pass by value!!! a copy of a reference, may only change the content
 * 
 * 
 */

// s1: use 2 queues, convert from one queue to another every time calls pop() or top()
// Assume that the queue's elements are all integers
// O(1), O(n)

/*
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
                int val = queue2.poll();
                if (!queue2.isEmpty()) {
                    queue1.offer(val);
                } 
            }
        } else if (queue2.isEmpty()) {
            while (!queue1.isEmpty()) {
                int val = queue1.poll();
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
                val = queue2.poll();
                queue1.offer(val);
            }
        } else if (queue2.isEmpty()) {
            while (!queue1.isEmpty()) {
                val = queue1.poll();
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
*/


// *s2: use 2 queues, move method and swap method
// assume the queues' elements are all integers
// O(1), O(n)

public class MyStack {
    
    Queue<Integer> queue1 = new LinkedList<Integer>();
    Queue<Integer> queue2 = new LinkedList<Integer>();
    
    public void push(int x) {
        queue1.offer(x);
    }
    
    public int pop() {
        move();
        int val = queue1.poll();
        swap();
        return val;
    }
    
    public int top() {
        move();
        int val = queue1.poll();
        swap();
        queue1.offer(val);
        return val;
    }
    
    public boolean empty() {
        return queue1.isEmpty();
    }
    
    public void move() {
        while (queue1.size() != 1) {
            queue2.offer(queue1.poll());
        }
    }
    
    public void swap() {
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }
    
}
