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
            return -1;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return nums[i];
                }
            }
        }
        return -1;
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
            return -1;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return nums[i];
            }
        }
        return -1;
    }
}
*/



// s3: HashSet
// O(n), O(n)

/*
public class Solution{
    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        Set<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashSet.contains(nums[i])) {
                return nums[i];
            } else {
                hashSet.add(nums[i]);
            }
        }
        return -1;
    }
}
*/


// s4: use another boolean array ?
// O(n), O(n)

public class Solution{
    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        boolean[] array = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (array[nums[i]]) {
                return nums[i];
            } else {
                array[nums[i]] = true;
            }
        }
        return -1;                
    }
}



// s5: bitwise operation ?
// O(n), O(1)
// not modify the original array
// Wrong answer(bitwise can only have 32 bits?)

/*
public class Solution{
    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int checker = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((checker & (1 << nums[i])) > 0) {
                return nums[i];
            } else {
                checker = checker | (1 << nums[i]);
            }         
        }
        return -1;
    }
}
*/


// s6:
// 

/*
public class Solution{
    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        
        
                
    }
}
*/
