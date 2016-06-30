/**
 * Find the Duplicate Number
 * 
 */ 


// s1: brute force
// O(n^2), O(1)

/*
public class Solution {
    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return nums[i];
                }
            }
        }
        return 0;
    }
}
*/



// s2: Arrays.sort()
// O(nlogn), O(1)
// modify the original array

/*
public class Solution{
    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return nums[i];
            }
        }
        return 0;
    }
}
*/



// s3: HashSet
// O(n), O(n)

/*
public class Solution{
    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Set<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashSet.contains(nums[i])) {
                return nums[i];
            } else {
                hashSet.add(nums[i]);
            }
        }
        return 0;
    }
}
*/


// s4: use another array
// O(n), O(n)

public class Solution{
    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max_value = findMax(nums);
        boolean[] array = new boolean[max_value];
        for (int i = 0; i < nums.length; i++) {
            if (array[nums[i]]) {
                return nums[i];
            } else {
                array[nums[i]] = true;
            }
        }
        return 0;                
    }
    public int findMax(int[] nums) {
        int result = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > result) {
                result = nums[i];
            }
        }
        return result;
    }
}
