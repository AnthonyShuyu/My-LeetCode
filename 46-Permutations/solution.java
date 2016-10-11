/**
 *
 * 
 * 46. Permutations
 * 
 * 
 */ 

// s1: DFS
// O(2^n * n), O(n * n!)

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        // corner case
        if (nums == null || nums.length == 0) {
            return result;
        }
        
        List<Integer> list = new ArrayList<Integer>();
        int pos = 0;    
        dfs(result, list, nums, pos);
        
        return result;
    }
    
    public void dfs(List<List<Integer>> result, List<Integer> list, int[] nums, int pos) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<Integer>(list));
        }
        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i])) {
                continue;
            }
            list.add(nums[i]);
            dfs(result, list, nums, i);
            list.remove(list.size() - 1);
        }
        
    }
}