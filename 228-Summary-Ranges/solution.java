/**
 * 228. Summary Ranges
 * 
 * 
 */



// s1: brute force, while loop
// O(n), O(n)

/*
public class Solution {
    public List<String> summaryRanges(int[] nums) {
        // corner case
        List<String> result = new ArrayList<String>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        int index = 0;
        int i = 0;
        if (nums.length == 1) {
            result.add(String.valueOf(nums[i]));
            return result;
        }
        while (i < nums.length - 1) {
            i = index;
            while (i < nums.length - 1 && nums[i] + 1 == nums[i + 1]) {
                i++;
            } 
            if (i == index) {
                result.add(String.valueOf(nums[i]));
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(nums[index]);
                sb.append("->");
                sb.append(nums[i]);
                result.add(sb.toString());
            }
            index = i + 1;
        }
        return result;
    }
}
*/


// *s2: brute force, for loop
// O(n), O(n)

public class Solution {
    public List<String> summaryRanges(int[] nums) {
        // corner case
        List<String> result = new ArrayList<String>();
        if (nums == null || nums.length == 0) {
            return result;
        }        
        
        if (nums.length == 1) {
            result.add(String.valueOf(nums[0]);
            return result;
        }
        
        int index = 0;
        
        for (int i = 0; i < nums.length; i++) {
            index = i;
            while (i < nums.length - 1 && nums[i] + 1 == nums[i + 1]) {
                i++;
            }
            if (index == i) {
                result.add(String.valueOf(nums[i]));
            } else {
                String s = nums[index] + "->" + nums[i];
            }
        }
        return result;
    }
}



