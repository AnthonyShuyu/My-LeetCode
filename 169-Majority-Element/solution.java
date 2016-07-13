/**
 * 169. Majority Element
 * 
 * 
 */



// s1: brute force
// O(n^2), O(1)
// time limit exceeded

/*
public class Solution {
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        for (int i = 0; i < nums.length; i++) {
            if (findTimes(nums, nums[i]) > nums.length / 2) {
                return nums[i];
            }
        }
        return -1;
    }
    
    public int findTimes(int[] nums, int n) {
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

// s2: Arrays.sort()
// O(nlogn), O(1)

/*
public class Solution {
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }        
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
*/


// s3: HashMap & one for loop
// O(n), O(n)


public class Solution {
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }        
        
        Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        /*
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(nums[i]) && hashMap.get(nums[i]) >= nums.length / 2) {
                return nums[i];
            }
            if (hashMap.containsKey(nums[i])){
                hashMap.put(nums[i], hashMap.get(nums[i]) + 1);
            } else {
                hashMap.put(nums[i], 1);
            }
        }
        return nums[0];
        */
        
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.contains(nums[i])) {
                hashMap.put(nums[i], hashMap.get(nums[i]) + 1);
            } else {
                hashMap.put(nums[i], 1);
            }
            
            if (hashMap.get(nums[i]) > nums.length / 2) {
                return nums[i];
            }
        }   
        return -1;
    }
}