/**
 * 
 * 90. Subsets II
 * 
 * 
 */



// s1: DFS
// O(2^n * n), O(n)

public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // corner case
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        // Arrays.sort(nums);
        List<Integer> list = new ArrayList<Integer>();
        int pos = 0;
        dfs(result, list, nums, pos);
        return result;
    }
    
    public void dfs(List<List<Integer>> result, List<Integer> list, int[] nums, int pos) {
        result.add(new ArrayList<Integer>(list));
        for (int i = pos; i < nums.length; i++) {
            if (i != pos && nums[i] == nums[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            dfs(result, list, nums, i + 1);
            list.remove(list.size() - 1);
        }
    }
}