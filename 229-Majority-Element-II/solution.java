/**
 * 
 * 229. Majority Element II
 * 
 */


// s1: brute force
// O(n^2), O(1)
// time limit exceeded

/*
public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (countNums(nums, nums[i]) > nums.length / 3) {
                if (!result.contains(nums[i])) {
                    result.add(nums[i]);
                }
            }
        }
        return result;
    }
    
    public int countNums(int[] nums, int n) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == n) {
                result++;
            }
        }
        return result;
    }
}
*/


// s2: HashMap
// O(n), O(n)

public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(nums[i])) {
                hashMap.put(nums[i], hashMap.get(nums[i]) + 1);
            } else {
                hashMap.put(nums[i], 1);
            }
            
            if (hashMap.get(nums[i]) > nums.length / 3) {
                if (!result.contains(nums[i])) {
                    result.add(nums[i]);
                }
            }
        }
        return result;        
    }
}