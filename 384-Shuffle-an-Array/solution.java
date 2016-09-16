/**
 * 
 *384. Shuffle an Array
 * 
 */

public class Solution {
        
    private int[] nums;
    int[] new_nums = new int[nums.length];
    
    public Solution(int[] nums) {
        this.nums = nums;
        for (int i = 0; i < nums.length; i++) {
            new_nums[i] = nums[i];
        }
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return new_nums[];
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] array = new int[nums.length];
        Set<Integer> hashSet = new HashSet<Integer>();
        Random random = new Random();
        for (int i = 0; i < nums.length; i++) { 
            int n = random.nextInt(nums.length);
            while (!hashSet.contains(n)) {
                array[i] = nums[n];
                hashSet.add(n);
                break;
            }
        }
        return array;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */