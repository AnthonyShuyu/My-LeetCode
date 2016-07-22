/**
 * 80. Remove Duplicates from Sorted Array II
 * 
 * 
 */


// s1: use index
// O(n), O(1)

public class Solution {
    public int removeDuplicates(int[] nums) {
        // corner case
        // if (nums == null || nums.length == 0) {
        //     return 0;
        // }
        // int index = 0;
        // int j = 0;
        // int count = 0;
        // for (int i = 0; i < nums.length; i++) {
        //     if (nums[i] != nums[index]) {
        //         if (i - j >= 2) {
        //             nums[index + 1] = nums[j];
        //             index += 2;
        //             nums[index] = nums[i];
        //             j = i;
        //             count += 2;
        //         } else {
        //             index++;
        //             nums[index] = nums[i];
        //             j = i;
        //             count += 1;
        //         }
        //     }  
        // }
        
        
        
                if(nums == null)
            return 0;
        int cur = 0;
        int i ,j;
        for(i = 0; i < nums.length;){
            int now = nums[i];
            for( j = i; j < nums.length; j++){
                if(nums[j] != now)
                    break;
                if(j-i < 2)
                    nums[cur++] = now; 
            }
            i = j;
        }
        return cur;
    }

    }
    
    
