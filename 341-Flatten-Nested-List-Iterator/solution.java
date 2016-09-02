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

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */