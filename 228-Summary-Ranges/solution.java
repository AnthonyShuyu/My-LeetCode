/**
 * 228. Summary Ranges
 * 
 * 
 */



// s1: brute force
// O(n), O(n)

public class Solution {
    public List<String> summaryRanges(int[] nums) {
        // corner case
        List<String> result = new ArrayList<String>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        int index = 0;
        int i = 0;
        while (i < nums.length - 1) {
            i = index;
            while (i < nums.length - 1 && nums[i] + 1 == nums[i + 1]) {
                i++;
            } 
            if (i == index) {
                result.add(String.valueOf(nums[i]));
            } else {
                StringBuilder sb = new StringBuilder();
                sb.add(String.valueOf(nums[index]));
                sb.add("->");
                sb.add(String.valueOf(nums[i]));
                result.add(sb.toString());
            }
            index = i + 1;
        }
        return result;
    }
}