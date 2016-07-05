/**
 * 18. 4Sum
 * 
 */


// s1: brute force
// O(n^4), O(n)
// time limit exceeded

/*
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 4) {
            return result;
        }
        
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    for (int l = k + 1; l < nums.length; l++) {
                        if (nums[i] + nums[j] + nums[k] + nums[l] == target) {
                            List<Integer> list = new ArrayList<Integer>();
                            list.add(nums[i]);
                            list.add(nums[j]);
                            list.add(nums[k]);
                            list.add(nums[l]);
                            if (!result.contains(list)) {
                                result.add(list);
                            }
                        }
                    }
                }
            }
        }
        return result;
    }
}
*/



// s2:two pointers, convert to two sum
// O(n^3), O(n)

/*
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 4) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
               int start = j + 1;
               int end = nums.length - 1;
               while (start < end) {
                   int sum = nums[i] + nums[j] + nums[start] + nums[end];
                   if (sum == target) {
                       List<Integer> list = new ArrayList<Integer>();
                       list.add(nums[i]);
                       list.add(nums[j]);
                       list.add(nums[start]);
                       list.add(nums[end]);
                       if (!result.contains(list)) {
                           result.add(list);
                       }
                       start++;
                       end--;
                   } else if (sum < target) {
                       start++;
                   } else {
                       end--;
                   }
               }
            }
        }
        return result;
    }
}
*/


// s3: HashSet(HashMap), convert to two sum
// O(n^3), O(n)
// time limit exceeded

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 4) {
            return result;
        }
        
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                Set<Integer> hashSet = new HashSet<Integer>();
                for (int k = j + 1; k < nums.length; k++) {
                    if (hashSet.contains(target - nums[i] - nums[j] - nums[k])) {
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(target - nums[i] - nums[j] - nums[k]);
                        list.add(nums[k]);
                        if (!result.contains(list)) {
                            result.add(list);
                        }
                    } else {
                        hashSet.add(nums[k]);
                    }
                }
            }
        }
        return result;
    }
}

