/**
 *
 * 
 * 46. Permutations
 * 1 solutioin
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
        dfs(result, list, nums);
        return result;
    }
    
    public void dfs(List<List<Integer>> result, List<Integer> list, int[] nums) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<Integer>(list));
        }
        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i])) {
                continue;
            }
            list.add(nums[i]);
            dfs(result, list, nums);
            list.remove(list.size() - 1);
        }
    }
}