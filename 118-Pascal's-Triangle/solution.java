/**
 * 118. Pascal's Triangle
 * 
 * 
 */


// s1: brute force
// O(n^2), O(n)

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