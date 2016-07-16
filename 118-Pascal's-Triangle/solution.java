/**
 * 118. Pascal's Triangle
 * 2 solutions
 * 
 */


// s1: brute force
// O(n^2), O(n)


/*
public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (numRows <= 0) {
            return result;
        }
        // initaite
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<Integer>();
            for (int j = 0; j < i + 1; j++) {
                list.add(1);                
            }
            result.add(list);
        }
        // set the middle nums
        for (int i = 2; i < numRows; i++) {
            List<Integer> last_list = result.get(i - 1);
            List<Integer> current_list = result.get(i);
            for (int j = 1; j < i; j++) {
                current_list.set(j, last_list.get(j - 1) + last_list.get(j));
            }
        }
        return result;
    }
}

*/


// *s2: brute force optimize, set the array and add to the result at the same time
// O(n^2), O(n)


public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (numRows <= 0) {
            return result;
        }
        // initiate
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        result.add(list);
        
        for (int i = 1; i < numRows; i++) {
            List<Integer> current_list = new ArrayList<Integer>();
            for (int j = 0; j < i + 1; j++) {
                current_list.add(1);
            }
            List<Integer> prev_list = result.get(i - 1);
            current_list.set(0, prev_list.get(0));
            current_list.set(i, prev_list.get(i - 1));
            
            for (int j = 1; j < i; j++) {
                current_list.set(j, prev_list.get(j - 1) + prev_list.get(j));
            }
            result.add(current_list);            
        }
        return result;        
    }
}



