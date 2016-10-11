/**
 * 
 * 
 * 47. Permutations II
 * 
 * 
 */


// s1: DFS
// O(n! * n), O(n * n!)

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        // corner case
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        boolean[] isVisited = new boolean[nums.length];
        List<Integer> list = new ArrayList<Integer>();
        dfs(result, list, nums, isVisited);
        return result;
    }
    
    public void dfs(List<List<Integer>> result, List<Integer> list, int[] nums, boolean[] isVisited) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<Integer>(list));
        }
        for (int i = 0; i < nums.length; i++) {
            if (isVisited[i] || (i != 0 && nums[i] == nums[i - 1] && !isVisited[i - 1])) {
                continue;
            }
            isVisited[i] = true;
            list.add(nums[i]);
            dfs(result, list, nums, isVisited);
            list.remove(list.size() - 1);
            isVisited[i] = false;
        }
    }
}