/**
 * Contains Duplicate II
 * 3 methods
 */ 



// s1: brute force
// O(n^2), O(1)
// Time limit exceeded

/*
public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return false;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j] && j - i <= k) {
                    return true;
                }
            }
        }
        return false;
    }
}
*/


// s2: HashSet
// O(n^2), O(n)

/*
public class Solution{
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return false;
        }
        Set<Integer> hashSet = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (hashSet.contains(nums[i]) && isNearby(nums[i], nums, k)) {
                return true;
            } else {
                hashSet.add(nums[i]);
            }
        }
        return false;
    }
    
    public boolean isNearby(int num, int[] nums, int k) {
        List<Integer> arrayList = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == num) {
                arrayList.add(i);
            }
        }
        for (int i = 0; i < arrayList.size() - 1; i++) {
            if (arrayList.get(i + 1) - arrayList.get(i) <= k) {
                return true;
            } 
        }
        return false;
    }
}
*/


// s3: HashMap
// O(n), O(n)

/*
public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return false;
        }
        Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(nums[i]) && (i - hashMap.get(nums[i])) <= k) {
                return true;
            } else {
                hashMap.put(nums[i], i);
            }
        }
        return false;
    }
}
*/


// *s4:another approach to use HashSet, HashSet add() method will return boolean
// O(n), O(n)

public class Solution{
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return false;
        }
        Set<Integer> hashSet = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (!hashSet.add(nums[i])) {
                return true;
            }
            if (i >= k) {
                hashSet.remove(nums[i - k]);
            }

        }
        return false;
    }
}







// s5: anther two for loops
// O(nk), O(1)
// Time limit exceeded

/*
public class Solution{
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return false;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j <= i + k && j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }
}
*/


// s?: Arrays.sort()
// O(nlogn), O(1)

/*
public class Solution{
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return false;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if ()
        }
        
    }
}
*/