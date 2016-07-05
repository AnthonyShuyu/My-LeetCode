/**
 * 15. 3Sum
 * 
 * 
 */


// s1: hashMap, convert to two sum problem
// O(n^2), O(n^2)

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        if (nums == null || nums.length == 0) {
            return result;
        }
        
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 2; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int target = 0 - nums[i];
            Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
            for (int j = i + 1; j < nums.length; j++ ) {
                if (hashMap.containsKey(target - nums[j])) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[i]);
                    list.add(target - nums[j]);
                    list.add(nums[j]);
                    if (!result.contains(list)) {
                        result.add(list);
                    }
                } else {
                    hashMap.put(nums[j], j);
                }
            }
        }
        return result;
    }
}