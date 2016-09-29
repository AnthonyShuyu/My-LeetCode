/**
 * 
 * 179. Largest Number
 * 1 solution
 * 
 */

// s1: brute force, Arrays.sort() and two pointers
// O(n^2), O(n)
// failed

/*
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
        if (nums.length == 1) {
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
*/


// *s2: Arrays.sort(nums, new NumbersComparator());
// O(nlogn), O(n)
// tricky

/*
class NumberComparator implements Comparator<String>{
    public int compare(String s1, String s2) {
        return (s2 + s1).compareTo(s1 + s2);
    }
}


public class Solution {
    public String largestNumber(int[] nums) {
        // corner case
        if (nums == null || nums.length == 0) {
            return "";
        }
        
        String[] strs = new String[nums.length];
        for (int i = 0; i < strs.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        
        Arrays.sort(strs, new NumberComparator());
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
            sb.append(strs[i]);
        }
        
        // return sb.toString();
        int index = 0;
        while (index < sb.length() && sb.charAt(index) == '0') {
            index++;
        }
        
        if (index == sb.length()) {
            return "0";
        }
        return sb.toString();
    }
}
*/


// s2: Arrays.sort(nums, numberComparator)
// O(nlogn), O(n)
// inner class

/*    
public class Solution {
    
    private Comparator<String> numberComparator = new Comparator<String>() {
        @Override
        public int compare(String s1, String s2) {
            return (s2 + s1).compareTo(s1 + s2);
        }
    };

    public String largestNumber(int[] nums) {
        // corner case
        if (nums == null || nums.length == 0) {
            return "";
        }
        
        String[] strs = new String[nums.length];
        for (int i = 0; i < strs.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        
        Arrays.sort(strs, numberComparator);
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
            sb.append(strs[i]);
        }
        
        // return sb.toString();
        int index = 0;
        while (index < sb.length() && sb.charAt(index) == '0') {
            index++;
        }
        
        if (index == sb.length()) {
            return "0";
        }
        return sb.toString();
    }
}

*/


// *s2 modified: Arrays.sort()
// O(nlogn), O(n)
// anonymous method

public class Solution {
    
    // private Comparator<String> numberComparator = new Comparator<String>() {
    //     @Override
    //     public int compare(String s1, String s2) {
    //         return (s2 + s1).compareTo(s1 + s2);
    //     }
    // };

    public String largestNumber(int[] nums) {
        // corner case
        if (nums == null || nums.length == 0) {
            return "";
        }
        
        String[] strs = new String[nums.length];
        for (int i = 0; i < strs.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        
        Arrays.sort(strs, new Comparator<String>() {
                @Override
                public int compare(String s1, String s2) {
                    return (s2 + s1).compareTo(s1 + s2);
                }
            });
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
            sb.append(strs[i]);
        }
        
        // return sb.toString();
        int index = 0;
        while (index < sb.length() && sb.charAt(index) == '0') {
            index++;
        }
        
        if (index == sb.length()) {
            return "0";
        }
        return sb.toString();
    }
}