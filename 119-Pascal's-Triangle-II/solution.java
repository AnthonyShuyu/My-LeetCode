/**
 * 119. Pascal's Triangle II
 * 2 solutions
 */


// s1: build the Pascal's triangle and return the rowIndex's element of the result
// O(n^2), O(k^2)

/*
public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<Integer>();
        if (rowIndex < 0) {
            return result;
        }
        
        List<List<Integer>> pascal_triangle = getPascalTriangle(rowIndex + 1);
        return pascal_triangle.get(rowIndex);
    }
    
    public List<List<Integer>> getPascalTriangle(int rowIndex) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        // initiate the first level
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        result.add(list);
        for (int i = 1; i < rowIndex; i++) {
            List<Integer> current_list = new ArrayList<Integer>();
            for (int j = 0; j < i + 1; j++) {
                current_list.add(1);
            }
            List<Integer> prev_list = result.get(i - 1);
            for (int j = 1; j < i; j++) {
                current_list.set(j, prev_list.get(j - 1) + prev_list.get(j));
            }
            result.add(current_list);
        }
        return result;
    }
}
*/


// *s2: build the triangle's level one time in one loop level, use only O(k) extra space
// O(n^2), O(k)
// tricky


public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<Integer>();
        if (rowIndex < 0) {
            return result;
        }
        int row = rowIndex + 1;
        result.add(1);
        
        for (int i = 1; i < row; i++) {
            List<Integer> list = new ArrayList<Integer>();
            for (int j = 0; j < i + 1; j++) {
                list.add(-1);
            }
            list.set(0, result.get(0));
            list.set(i, result.get(i - 1));
            for (int j = 1; j < i; j++) {
                list.set(j, result.get(j - 1) + result.get(j));                
            }
            result = list;
        }
        return result;        
    }
}
