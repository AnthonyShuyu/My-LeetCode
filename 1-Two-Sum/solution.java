/**
 * 1. Two Sum
 * 2 solutions
 */


// s1: HashMap
// O(n), O(n)

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        if (nums == null || nums.length == 0) {
            return result;
        }
        Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(target - nums[i])) {
                result[0] = hashMap.get(target - nums[i]);                
                result[1] = i;
                return result;
            } else {
                hashMap.put(nums[i], i);
            }
        }
        return result;
    }
}