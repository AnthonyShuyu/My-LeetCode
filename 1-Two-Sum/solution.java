/**
 * 1. Two Sum
 * 2 solutions
 */



// s1: brute force
// O(n^2), O(1)

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        if (nums == null || nums.length == 0) {
            return result;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }
}










// s1: HashMap
// O(n), O(n)

/*
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
*/


// s2: two pointers
// O(nlogn), O(1)

/*
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];  
        if (nums == null || nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] == target) {
                result[0] = left;
                result[1] = right;
                return result;
            } else if (nums[left] + nums[right] < target) {
                left++;
            } else {
                right--;
            }
        }
        return result;
    }
}
*/

