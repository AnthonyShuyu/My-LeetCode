/**
 * 341. Flatten Nested List Iterator
 * 
 * 
 */
 
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
 
// s1: use Queue, every time is not empty, poll and offer all the nested elements
// O(n), O(n)
// failed, index out of bounds
 
/* 
public class NestedIterator implements Iterator<Integer> {

    List<NestedInteger> nestedList;
    Queue<NestedInteger> queue; 
    // List<Integer> list = new ArrayList<Integer>();
    Queue<Integer> result = new LinkedList<Integer>();
    
    public NestedIterator(List<NestedInteger> nestedList) {
        this.nestedList = nestedList;
        queue = new LinkedList<NestedInteger>();
        
        for (int i = 0; i < nestedList.size(); i++) {
            queue.offer(nestedList.get(i));
            while (!queue.isEmpty()) {
                NestedInteger ni = queue.poll();
                if (ni.isInteger()) {
                    result.offer(ni.getInteger());
                } else {
                    List<NestedInteger> newNestedList = ni.getList();
                    if (newNestedList != null) {
                        for (int j = 0; j < newNestedList.size(); j++) {
                            queue.offer(newNestedList.get(i));
                        }
                    }
                }
            }
        }
    }

    @Override
    public Integer next() {
        return result.poll();
    }

    @Override
    public boolean hasNext() {
        return result.size() != 0;
    }
}
*/

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
 
// s2: write a function to use recursion
// O(n), O(n)

/*
public class NestedIterator implements Iterator<Integer> {

    // List<NestedInteger> nestedList;
    // Queue<NestedInteger> queue; 
    List<Integer> list = new ArrayList<Integer>();
    int index = 0;
    // Queue<Integer> result = new LinkedList<Integer>();
    
    
    public NestedIterator(List<NestedInteger> nestedList) {
        // this.nestedList = nestedList;
        // queue = new LinkedList<NestedInteger>();
        list = flattenList(nestedList);
    }

    public List<Integer> flattenList(List<NestedInteger> nestedList) {
        List<Integer> temp = new ArrayList<Integer>();
        for (int i = 0; i < nestedList.size(); i++) {
            NestedInteger ni = nestedList.get(i);
            if (ni.isInteger()) {
                temp.add(ni.getInteger());
            } else {
                temp.addAll(flattenList(ni.getList()));
            }
        }
        return temp;
    }
    
    
    @Override
    public Integer next() {
        int nextVal = list.get(index);
        index++;
        return nextVal;
    }

    @Override
    public boolean hasNext() {
        return index < list.size();
    } 
} 
*/


// *s3: use stack (you calm down and will find that you can not use queue but you can use stack instead)
// O(n), O(n)

public class NestedIterator implements Iterator<Integer> {
    
    Stack<NestedInteger> stack;
    
    public NestedIterator(List<NestedInteger> nestedList) {
        // corner case
        if (nestedList == null || nestedList.size() == 0) {
            stack = null;
        }
        stack = new Stack<NestedInteger>();
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            stack.push(nestedList.get(i));
        }
        
    }
    
    @Override 
    public Integer next() {
        return stack.pop().getInteger();
    }
    
    @Override
    public boolean hasNext() {
        if (stack == null || stack.isEmpty()) {
            return false;
        }
        while (stack != null && !stack.isEmpty()) {
            NestedInteger ni = stack.peek();
            if (ni.isInteger()) {
                return true;
            } else {
                stack.pop();
                for (int i = ni.getList().size() - 1; i >= 0; i--) {
                    stack.push(ni.getList().get(i));
                }
            }
        }
    }
}
