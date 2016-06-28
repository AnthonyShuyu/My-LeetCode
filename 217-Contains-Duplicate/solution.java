/** Contains Duplicate
*   2 methods
*   ES
*/


// s1: Arrays.sort()
// O(nlogn), O(1)

public class Solution {
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }
}


// s2: HashSet
// O(n), O(n)

/*
public class Solution{
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        Set<Integer> hashSet = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (hashSet.contains(nums[i])) {
                return true;
            } else {
                hashSet.add(nums[i]);
            }
        }
        return false;
    }
}
*/



// s3: brute force, two for loops ?
// O(n^2), O(1)
// Time limit exceeded

/*
public class Solution{
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }
}
*/



/*
// s4: use array ?
// O(n), O(n)

public class Solution {
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int maxNum = findMax(nums);
        maxNum = Math.max(maxNum, nums.length);
        boolean[] array = new boolean[maxNum + 1];
        for (int i = 0; i < nums.length; i++) {
            if (array[nums[i]]) {
                return false;
            } else {
                array[nums[i]] = true;
            }
        }
        return false;
    }
    
    public int findMax(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Integer.MIN_VALUE;
        }
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > result) {
                result = nums[i];
            }
        }
        return result;
    }
}

*/


// s5: use bitwise operation ?
// O(n), O(1)

/*
public class Solution{
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int val = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((val & (1 << nums[i])) > 0) {
                return true;
            } else {
                val = val | (1 << nums[i]);
            }
        }
        return false;
    }
}
*/



