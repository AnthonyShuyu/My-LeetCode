/**
 * 15. 3Sum
 * 
 * 
 */


// s1: hashMap, convert to two sum problem
// O(n^2), O(n^2)

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new List<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        for (int i = 0; i < nums.length - 2; i++) {
            int target = 0 - nums[i];
            for (int j = i + 1; j < nums.length; j++ ) {
            Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
                if (hashMap.containsKey(target - nums[j])) {
                    List<Integer> list = new List<Integer>();
                    list.add(nums[i]);
                    list.add(target - nums[i]);
                    list.add(nums[j]);
                    result.add(list);
                } else {
                    hashMap.put(nums[j], j);
                }
            }
        }
        return result;
    }
}