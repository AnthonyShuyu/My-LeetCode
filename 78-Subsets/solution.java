/**
 * 78. Subsets
 * 
 * 
 */



// s1: DFS
// O(2^n * n), O(n)

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        //  corner case
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<Integer>();
        dfs(result, list, nums, 0);
        return result;
    }
    
    
    public void dfs(List<List<Integer>> result, List<Integer> list, int[] nums, int pos) {
        result.add(new ArrayList<Integer>(list));
        
        for (int i = pos; i < nums.length; i++) {
            list.add(nums[i]);
            dfs(result, list, nums, i + 1);
            list.remove(list.size() - 1);
        }
        
    }
}




/*
// s1: DFS
// O(2^n * n), O(n)

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        //  corner case
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        List<Integer> list = new ArrayList<Integer>();
        Arrays.sort(nums);
        helper(result, list, nums, 0);
        return result;
    }
    
    public void helper(List<List<Integer>> result, List<Integer> list, int[] nums, int pos) {
        List<Integer> temp = new ArrayList<Integer>(list);
        result.add(temp);
        
        for (int i = pos; i < nums.length; i++) {
            list.add(nums[i]);
            helper(result, list, nums, i + 1);
            list.remove(list.size() - 1);
        }
        
    }
}

*/