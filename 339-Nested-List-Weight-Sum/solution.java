/**
 * 
 * 339. Nested List Weight Sum
 * 2 solutions
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
 
 
// s1: dfs, recursion
// O(n), O(1)
public class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        // corner case
        if (nestedList == null || nestedList.size() == 0) {
            return 0;
        }
        int sum = 0;
        int depth = 1;
        sum = sum + helper(nestedList, depth);
        return sum;
    }
    
    public int helper(List<NestedInteger> nestedList, int depth) {
        int result = 0;
        if (nestedList == null || nestedList.size() == 0) {
            return result;
        }
        
        for (NestedInteger ni : nestedList) {
            if (ni.isInteger()) {
                result += depth * ni.getInteger();
            } else {
                result += helper(ni.getList(), depth + 1);
            }
        }
        return result;
    }
}