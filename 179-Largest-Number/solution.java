/**
 * 
 * 179. Largest Number
 * 
 * 
 */

// s1: brute force, Arrays.sort() and two pointers
// O(n^2), O(n)

public class Solution {
    public String largestNumber(int[] nums) {
        // corner case
        String result = "";
        if (nums == null || nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        int start = 0;
        if (nums[0] == 0) {
            start = 1;
        }
        
        StringBuilder sb = new StringBuilder();
        if (num.length == 1) {
            sb.append(nums[0]);
            return sb.toString();
        }
        
        for (int i = start; i < nums.length - 1; i++) {
            int k = start;
            if (getDigits(nums[i + 1]) > getDigits(nums[i])) {
                for (int j = i; j >= k; j--) {
                    sb.append(nums[j]);
                }
                k = i + 1;
            }
            if (i == nums.length - 2) {
                if (getDigits(nums[i + 1]) > getDigits(nums[i])) {
                    sb.append(nums[i + 1]);
                } else {
                    for (int j = i + 1; j >= k; j--) {
                        sb.append(nums[j]);
                    }
                }
            }
        }
        
        if (start == 1) {
            sb.append(0);
        }
        return sb.toString();
        
    }
    
    public int getDigits(int n) {
        int count = 0;
        int num = n;
        while (num != 0) {
            num /= 10;
            count++;
        }
        return count;
    }
}