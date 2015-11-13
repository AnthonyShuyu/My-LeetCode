package TwoSum;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>(2,1.0f);
        for(int i=0;i<nums.length;i++){
            if(hashMap.containsKey(target-nums[i])){
                result[1] = i+1;
                result[0] = hashMap.get(target-nums[i]);
                return result;
            }
            hashMap.put(nums[i],i+1);
        }
        return result;
    }
}
