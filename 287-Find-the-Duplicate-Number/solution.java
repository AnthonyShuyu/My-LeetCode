/**
 * Find the Duplicate Number
 * 7 methods
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

/*
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
*/


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


// *** s6: two pointers, slow and faster pointers
// O(n), O(1)
// not modify the original array

/*
public class Solution{
    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int slow = nums[0];
        int fast = nums[slow];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        fast = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
*/


/*
The main idea is the same with problem Linked List Cycle II,https://leetcode.com/problems/linked-list-cycle-ii/. Use two pointers the fast and the slow. The fast one goes forward two steps each time, while the slow one goes only step each time. They must meet the same item when slow==fast. In fact, they meet in a circle, the duplicate number must be the entry point of the circle when visiting the array from nums[0]. Next we just need to find the entry point. We use a point(we can use the fast one before) to visit form begining with one step each time, do the same job to slow. When fast==slow, they meet at the entry point of the circle. The easy understood code is as follows.
*/


// s7: binary search
// O(nlogn), O(1)
// not modify the original array


public class Solution{
    public int findDuplicate(int[] nums){
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= mid) {
                    count++;                    
                }
            }
            if (count <= mid) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        return nums[start];
    }
}
